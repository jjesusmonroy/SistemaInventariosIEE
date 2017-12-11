/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tepic
 */
public class ManejadorVehiculos {
   private Connection conexion;
    private ConexionBase db;
    
    
    public ManejadorVehiculos(){
        db= new ConexionBase();
    }
    
    
    
     public DefaultTableModel VerVehiculos(){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Numero Unidad");
            table.addColumn("Tipo");
            table.addColumn("Color");
            table.addColumn("Estado Vehiculo");
            table.addColumn("Kilometraje Actual");
            table.addColumn("No.Motor");
            table.addColumn("No.Placa");
            
            
            //select numero_unidad,tipo,color,estado_vehiculo,kilometraje,no_motor,placa_vehiculo from vehiculo
            //sql
            String sql = "select v.id_vehiculo,v.tipo_vehiculo,p.color_producto,p.status_producto,v.km_vehiculo,v.no_motor,v.placa_vehiculo from producto p inner join vehiculo v on p.id_producto=v.id_producto;";
            Connection c = db.getConexion();
            Statement st = c.createStatement();
            Object datos[] = new Object[7];
            ResultSet rs = st.executeQuery(sql);

            //llenar tabla
            while (rs.next()) {
                datos[0] = rs.getObject(1);
                datos[1] = rs.getObject(2);
                datos[2] = rs.getObject(3);
                datos[3] = rs.getObject(4);
                datos[4] = rs.getObject(5);
                datos[5] = rs.getObject(6);
                datos[6] = rs.getObject(7);
                
                table.addRow(datos);
           }

            c.close();
        } catch (SQLException ex) {
            System.out.printf("Error getTabla Cliente SQL");
            Logger.getLogger(ManejadorVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }

        
    }
     
     
      public DefaultTableModel VerVehiculosDiponibles(){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
           table.addColumn("Codigo Unidad");
            table.addColumn("Numero Unidad");
            table.addColumn("Tipo");
            table.addColumn("Color");
            table.addColumn("Estado Vehiculo");
            table.addColumn("Kilometraje Actual");
            table.addColumn("No.Motor");
            table.addColumn("No.Placa");
            
            
            //select numero_unidad,tipo,color,estado_vehiculo,kilometraje,no_motor,placa_vehiculo from vehiculo
            //sql
            String sql = "select v.id_vehiculo,v.num_unidad,v.tipo_vehiculo,p.color_producto,p.status_producto,v.km_vehiculo,v.no_motor,v.placa_vehiculo from producto p inner join vehiculo v on p.id_producto=v.id_producto where p.status_producto='Disponible';";
            Connection c = db.getConexion();
            Statement st = c.createStatement();
            Object datos[] = new Object[8];
            ResultSet rs = st.executeQuery(sql);

            //llenar tabla
            while (rs.next()) {
                datos[0] = rs.getObject(1);
                datos[1] = rs.getObject(2);
                datos[2] = rs.getObject(3);
                datos[3] = rs.getObject(4);
                datos[4] = rs.getObject(5);
                datos[5] = rs.getObject(6);
                datos[6] = rs.getObject(7);
                datos[7] = rs.getObject(8);
                
                table.addRow(datos);
           }

            c.close();
        } catch (SQLException ex) {
            System.out.printf("Error getTabla Cliente SQL");
            Logger.getLogger(ManejadorVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }
      }
     
     public String idVehiculo(String inde){
        
        String id="";
        
        try {
            
            String sql = "select id_vehiculo from vehiculo where numero_unidad='"+inde+"';";

            conexion = db.getConexion(); //obtenemos conexion 
            Statement st = conexion.createStatement(); //crear obteno de consulta
            ResultSet resultados = st.executeQuery(sql); //ejecutar consulta
            //vemos si encontro coincidencias
            if (resultados.next()) {
                
                id=resultados.getObject(1).toString();
            }

            conexion.close();
        } //esAdministrador
        catch (SQLException ex) {
            Logger.getLogger(ManejadorAdministracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return id;
        

       
    }
     
     
     
     
     
      public boolean atualizaEstadoVehiculo(String id,int tipo){
         conexion = db.getConexion();

         try {
            if(tipo==0){
            Statement st = conexion.createStatement();
            String sql = "update producto set status_producto='ocupado' where id_producto=(select v.id_producto from vehiculo v where num_unidad="+id+")";
            st.executeUpdate(sql);
            conexion.close();
            }if(tipo==1){
                Statement st = conexion.createStatement();
            String sql ="update producto set status_producto='disponible' where id_producto=(select v.id_producto from vehiculo v where num_unidad="+id+")";
            st.executeUpdate(sql);
            conexion.close();
            }
        } //try  
        catch (SQLException ex) {
            Logger.getLogger(ManejadorVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

        return true;
        
        
        
        
    }
      
      
      
      public int NumeroVehiculosTerminados(){
        
        int num=0;
        
        try {
            
            String sql = "select count(v.vehiculo_id_vehiculo) from vehiculo vehi,producto p, solicitud s,viatico v where vehi.id_vehiculo=v.vehiculo_id_vehiculo and v.solicitud_id_solicitud=s.id_solicitud and vehi.id_producto=p.id_producto and p.status_producto='ocupado' and s.fecha_retorno< curdate();";

            conexion = db.getConexion(); //obtenemos conexion 
            Statement st = conexion.createStatement(); //crear obteno de consulta
            ResultSet resultados = st.executeQuery(sql); //ejecutar consulta
            //vemos si encontro coincidencias
            if (resultados.next()) {
                
                num=Integer.parseInt(resultados.getObject(1).toString());
            }

            conexion.close();
        } //esAdministrador
        catch (SQLException ex) {
            Logger.getLogger(ManejadorAdministracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return num;
    }//numero de vehiculos vencidos
      
      
      
      public String[] VehiculosVencidos(int numero){
        
        String[] arreglo= new String[numero];
        
        try {
            
            String sql = "select v.vehiculo_id_vehiculo from vehiculo vehi,producto p, solicitud s,viatico v where vehi.id_vehiculo=v.vehiculo_id_vehiculo and v.solicitud_id_solicitud=s.id_solicitud and vehi.id_producto=p.id_producto and p.status_producto='ocupado' and s.fecha_retorno< curdate();";

            conexion = db.getConexion(); //obtenemos conexion 
            Statement st = conexion.createStatement(); //crear obteno de consulta
            ResultSet resultados = st.executeQuery(sql); //ejecutar consulta
            //vemos si encontro coincidencias
            while(resultados.next()) {
                

            for(int i=0;i<numero;i++){
            arreglo[i]=resultados.getString(i+1);
            }

                
            }

            conexion.close();
        } //esAdministrador
        catch (SQLException ex) {
            Logger.getLogger(ManejadorAdministracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return arreglo;
        

       
    }/// retorno un arreglo de todos los vahiculos vencidos
      
      
      
      public boolean atualizaTodosLosVencidos(String[] id){//todos los vencidos
         conexion = db.getConexion();

         try {
            for(int i=0;i<id.length;i++){
            Statement st = conexion.createStatement();
            String sql = "update producto set status_producto='disponible' where id_producto=(select v.id_producto from vehiculo v where v.id_vehiculo="+id[i]+")";
            st.executeUpdate(sql);
            conexion.close();
            }
        } //try  
        catch (SQLException ex) {
            Logger.getLogger(ManejadorVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

        return true;
        
        
        
        
    }
      
      
      
      
       
      //select v.vehiculo_id_vehiculo from solicitud s,viatico v where v.solicitud_id_solicitud=s.id_solicitud and s.fecha_retorno< curdate();


     
    //UPDATE `viaticos`.`vehiculo` SET `estado_vehiculo`='mantenimiento' WHERE `id_vehiculo`='3';

    //select count(v.vehiculo_id_vehiculo) from solicitud s,viatico v where v.solicitud_id_solicitud=s.id_solicitud and s.fecha_retorno< curdate();
    
    
 //   select numero_unidad,tipo,color,estado_vehiculo,kilometraje,no_motor,placa_vehiculo from vehiculo
    
    
    
    
}
