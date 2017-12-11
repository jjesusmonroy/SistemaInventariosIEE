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

//select a.id_area from  area a,personal per, puesto p where per.puesto_id_puesto=p.id_puesto and p.area_id_area=a.id_area and per.id_personal=5;
public class ManejadorUsuario {
    
    private Connection conexion;
    private ConexionBase db;
    
    
    public ManejadorUsuario(){
        db= new ConexionBase();
    }
    
    public DefaultTableModel MisViaticosxUsuario(String id_persona){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Folio:");
            table.addColumn("Fecha De Aprobacion:");
            table.addColumn("No.Vehiculo:");
            table.addColumn("Km Por Recorrer:");
            table.addColumn("Lugar:");
            table.addColumn("Fecha De Salida:");
            table.addColumn("Fecha De Retorno:");
            
            
            //select numero_unidad,tipo,color,estado_vehiculo,kilometraje,no_motor,placa_vehiculo from vehiculo
            //sql
            String sql = "select v.id_viatico,v.fecha_aproba,vehi.num_unidad,km_consumido,s.lugar,s.fecha_salida,s.fecha_retorno from viatico v,solicitud s, personal p,vehiculo vehi where v.solicitud_id_solicitud=s.id_solicitud and v.vehiculo_id_vehiculo=vehi.id_vehiculo and s.personal_id_personal=p.id_personal and p.id_personal="+id_persona+";";
            conexion = db.getConexion(); //obtenemos conexion 
            Statement st = conexion.createStatement(); //crear obteno de consulta
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

            conexion.close();
        } catch (SQLException ex) {
            System.out.printf("Error getTabla Cliente SQL");
            Logger.getLogger(ManejadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }

        
    }
    
    public String idPersonaUsuario(String idUsuario){
        
        String id="";
        
        try {
            
            String sql = "select id_personal from personal l,usuario h where h.personal_id_personal=l.id_personal and id_usuario="+idUsuario+";";

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
            Logger.getLogger(ManejadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return id;
        

       
    }
    
    
    public String idViatico(String idPersona){
        
        String id="";
        
        try {
            
            String sql = "select id_viatico from viatico a,solicitud d where a.solicitud_id_solicitud=d.id_solicitud and d.personal_id_personal="+idPersona+";";

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
            Logger.getLogger(ManejadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return id;
        

       
    }
    
    public DefaultTableModel VehiculoViatico(String idViatico){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Numero de unidad:");
            table.addColumn("No.Placa:");
            table.addColumn("Tipo:");
            table.addColumn("Kilometreaje:");
            
            
            
            //select numero_unidad,tipo,color,estado_vehiculo,kilometraje,no_motor,placa_vehiculo from vehiculo
            //sql
            String sql = "select v.num_unidad,v.placa_vehiculo,v.tipo_vehiculo,v.km_vehiculo from viatico h,vehiculo v where vehiculo_id_vehiculo=id_vehiculo and id_viatico="+idViatico+";";
            Connection c = db.getConexion();
            Statement st = c.createStatement();
            Object datos[] = new Object[4];
            ResultSet rs = st.executeQuery(sql);
            
            

            //llenar tabla
            while (rs.next()) {
                datos[0] = rs.getObject(1);
                datos[1] = rs.getObject(2);
                datos[2] = rs.getObject(3);
                datos[3] = rs.getObject(4);
                
                
                table.addRow(datos);
           }

            c.close();
        } catch (SQLException ex) {
            System.out.printf("Error getTabla Cliente SQL");
            Logger.getLogger(ManejadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        } 
    
    
    
    
//    select id_viatico from viatico a,solicitud d where a.solicitud_id_solicitud=d.id_solicitud and d.personal_id_personal=3;
//    
    
    
}


public String[] Monto(String idViatico){
        
        String id[]=new String[1];
        
        try {
            
            String sql = "select cantidad_asig,monto_des from viatico where id_viatico="+idViatico+";";

            conexion = db.getConexion(); //obtenemos conexion 
            Statement st = conexion.createStatement(); //crear obteno de consulta
            ResultSet resultados = st.executeQuery(sql); //ejecutar consulta
            id= new String[2];
//vemos si encontro coincidencias
            if (resultados.next()) {
                
                id[0]=resultados.getObject(1).toString();
                id[1]=resultados.getObject(2).toString();
            }

            conexion.close();
        } //esAdministrador
        catch (SQLException ex) {
            Logger.getLogger(ManejadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return id;
        

       
    }


public DefaultTableModel ViaticosTerminados(String idd){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Folio:");
            table.addColumn("Fecha Salida:");
            table.addColumn("Fecha Llegada");
            table.addColumn("Actividad Realizada");
            table.addColumn("Informe Entregado");
           
            
            
            //select numero_unidad,tipo,color,estado_vehiculo,kilometraje,no_motor,placa_vehiculo from vehiculo
            //sql
            String sql = "SELECT v.id_viatico, s.fecha_salida,s.fecha_retorno,s.actividad,v.informa from viatico v, solicitud s,personal per where v.solicitud_id_solicitud=s.id_solicitud and per.id_personal="+idd+" and informa='NO' and fecha_retorno<curdate();";
            Connection c = db.getConexion();
            Statement st = c.createStatement();
            Object datos[] = new Object[5];
            ResultSet rs = st.executeQuery(sql);
            
            

            //llenar tabla
            while (rs.next()) {
                datos[0] = rs.getObject(1);
                datos[1] = rs.getObject(2);
                datos[2] = rs.getObject(3);
                datos[3] = rs.getObject(4);
                datos[4] = rs.getObject(5);
                
                
                table.addRow(datos);
           }

            c.close();
        } catch (SQLException ex) {
            System.out.printf("Error getTabla Cliente SQL");
            Logger.getLogger(ManejadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }

        
    }

 public DefaultTableModel ViaticosParaObservacion(String idPersona){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Folio Viatico");
            table.addColumn("Cantidad Asig");
            table.addColumn("No.Vehiculo");
            table.addColumn("Kilometreaje Consumido");
            table.addColumn("Lugar Destino");
            table.addColumn("Realizado en la Fecha");
            
            
            
            
            //select numero_unidad,tipo,color,estado_vehiculo,kilometraje,no_motor,placa_vehiculo from vehiculo
            //sql
            String sql = "select v.id_viatico, cantidad_asig,vehi.num_unidad,km_consumido,s.lugar,s.fecha_salida from viatico v,solicitud s, personal p,vehiculo vehi where v.solicitud_id_solicitud=s.id_solicitud and vehi.id_vehiculo=v.vehiculo_id_vehiculo and p.id_personal="+idPersona+";";
            Connection c = db.getConexion();
            Statement st = c.createStatement();
            Object datos[] = new Object[6];
            ResultSet rs = st.executeQuery(sql);
            
            

            //llenar tabla
            while (rs.next()) {
                datos[0] = rs.getObject(1);
                datos[1] = rs.getObject(2);
                datos[2] = rs.getObject(3);
                datos[3] = rs.getObject(4);
                datos[4] = rs.getObject(5);
                datos[5] = rs.getObject(6);
                 ;
           
                
                
                table.addRow(datos);
           }

            c.close();
        } catch (SQLException ex) {
            System.out.printf("Error getTabla Cliente SQL");
            Logger.getLogger(ManejadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        } 
    
    
    
    
//    select id_viatico from viatico a,solicitud d where a.solicitud_id_solicitud=d.id_solicitud and d.personal_id_personal=3;
//    
    
    
}


public String AreaPersonal(String idPersona){
        
        String id="";
        
        try {
            
            String sql = "select a.id_area from  area a,personal per, puesto p where per.puesto_id_puesto=p.id_puesto and p.area_id_area=a.id_area and per.id_personal="+idPersona+";";

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
            Logger.getLogger(ManejadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return id;
        

       
    }



}

//select a.id_area from  area a,personal per, puesto p where per.puesto_id_puesto=p.id_puesto and p.area_id_area=a.id_area and per.id_personal=5;

//select v.id_viatico, cantidad_asig,vehi.num_unidad,km_consumido,s.lugar,s.fecha_salida from viatico v,solicitud s, personal p,vehiculo vehi where v.solicitud_id_solicitud=s.id_solicitud and vehi.id_vehiculo=v.vehiculo_id_vehiculo and p.id_personal=5;



//SELECT v.id_viatico, s.fecha_salida,s.fecha_retorno,s.actividad,v.informa from viatico v, solicitud s,personal per where v.solicitud_id_solicitud=s.id_solicitud and per.id_personal=5 and fecha_retorno<curdate();