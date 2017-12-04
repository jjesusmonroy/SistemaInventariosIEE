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
public class ManejadorPresidencia {
    private Connection conexion;
    private ConexionBase db;
    
    public ManejadorPresidencia(){
        db=new ConexionBase();
    }
    
    public DefaultTableModel SolicitudesPendientes(){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Viatico Para:");
            table.addColumn("Fecha Salida:");
            table.addColumn("Fecha Retorno:");
            table.addColumn("Enviada fecha:");
            table.addColumn("Lugar:");
            table.addColumn("Actividad:");
            table.addColumn("Pernota:");
            table.addColumn("No.Solicitud:");
        
            
            
            
            //sql
            String sql ="select concat(per.nombre,' ',per.apellido_pa,' ',per.apellido_ma),s.fecha_salida,s.fecha_retorno,s.fecha_emision,s.lugar,s.actividad,s.pernotado,s.id_solicitud from solicitud s, personal per where estado_solicitud='EN REVISION'and s.personal_id_personal=per.id_personal;";
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
            System.out.printf("Error getTabla personal SQL");
            Logger.getLogger(ManejadorPresidencia.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }

        
    }
    
   public DefaultTableModel InfoEmpleado(String id){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Area:");
            table.addColumn("Puesto:");
            table.addColumn("Domicilio:");
            table.addColumn("Telefono:");
            table.addColumn("Curp:");
            table.addColumn("Rfc:");
            
        
            
            
            
            //sql
            String sql ="select a.area,p.puesto,d.domicilio,d.telefono,d.curp,d.rfc from area a,puesto p,personal d where p.id_puesto=d.puesto_id_puesto and p.area_id_area=a.id_area and d.id_personal="+id+";";
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
                
              
                
                
                table.addRow(datos);
           }

            c.close();
        } catch (SQLException ex) {
            System.out.printf("Error getTabla personal SQL");
            Logger.getLogger(ManejadorPresidencia.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }
    

   }

  public String id_persona(String id_solicitud){
        
        
        String id="";
        try {
            
            String sql = "select personal_id_personal from solicitud where id_solicitud="+id_solicitud+";";
            conexion = db.getConexion(); //obtenemos conexion 
            Statement st = conexion.createStatement(); //crear obteno de consulta
            ResultSet resultados = st.executeQuery(sql); //ejecutar consulta
            //vemos si encontro coincidencias
            if (resultados.next()) {
                
                id= resultados.getObject(1).toString();
            }

            conexion.close();
        } //esAdministrador
        catch (SQLException ex) {
            Logger.getLogger(ManejadorPresidencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return id;
        

       
    }
  
  public  DefaultTableModel Autorizadas(){
      
      
       
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Viatico Para:");
            table.addColumn("Fecha Salida:");
            table.addColumn("Fecha Retorno:");
            table.addColumn("Enviada fecha:");
            table.addColumn("Lugar:");
            table.addColumn("Actividad:");
            table.addColumn("Pernota:");
            table.addColumn("Folio de peticion:");
        
            
            
            
            //sql
            String sql ="select concat(per.nombre,' ',per.apellido_pa,' ',per.apellido_ma),s.fecha_salida,s.fecha_retorno,s.fecha_emision,s.lugar,s.actividad,s.pernotado,s.id_solicitud from solicitud s, personal per where estado_solicitud='AUTORIZADA' and s.personal_id_personal=per.id_personal;";
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
            System.out.printf("Error getTabla personal SQL");
            Logger.getLogger(ManejadorPresidencia.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }

      
      
      
      
      
      
  }

     
    
   public String infoSecre(String idSoli){
        
        
        String id="";
        try {
            
            String sql = "select usuario_id_usuario from solicitud where id_solicitud="+idSoli+";";
            conexion = db.getConexion(); //obtenemos conexion 
            Statement st = conexion.createStatement(); //crear obteno de consulta
            ResultSet resultados = st.executeQuery(sql); //ejecutar consulta
            //vemos si encontro coincidencias
            if (resultados.next()) {
                
                id= resultados.getObject(1).toString();
            }

            conexion.close();
        } //esAdministrador
        catch (SQLException ex) {
            Logger.getLogger(ManejadorPresidencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return id;
        

       
    }

   public String idSolicitud(String folio){
        
        
        String id="";
        try {
            
            String sql = "SELECT id_solicitud from solicitud where peticion_folio="+folio+";";
            conexion = db.getConexion(); //obtenemos conexion 
            Statement st = conexion.createStatement(); //crear obteno de consulta
            ResultSet resultados = st.executeQuery(sql); //ejecutar consulta
            //vemos si encontro coincidencias
            if (resultados.next()) {
                
                id= resultados.getObject(1).toString();
            }

            conexion.close();
        } //esAdministrador
        catch (SQLException ex) {
            Logger.getLogger(ManejadorPresidencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return id;
        

       
    }
   
  //UPDATE `viaticos`.`solicitud` SET `observaciones`='FALTA DE RECURSOS' WHERE `id_solicitud`='23';
   
   
   public boolean atualizaObservacion(String id,String mensaje){// tipo==1 NO AUTORIZA
         conexion = db.getConexion();

         try {

            Statement st = conexion.createStatement();
            
           String sql = "UPDATE `viaticos`.`solicitud` SET `observaciones`='"+mensaje+"' WHERE `id_solicitud`='"+id+"';";
            st.executeUpdate(sql);
            conexion.close();
            
        } //try  
        catch (SQLException ex) {
            Logger.getLogger(ManejadorPresidencia.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

        return true;
        
        
        
        
    }

   public boolean atualizaEstadoSolicitud(String id,int tipo){// tipo==1 NO AUTORIZA
         conexion = db.getConexion();

         try {

            Statement st = conexion.createStatement();
            if(tipo==0){
            String sql = "UPDATE `dbis`.`solicitud` SET `estado_solicitud`='AUTORIZADA' WHERE `id_solicitud`='"+id+"';";
            st.executeUpdate(sql);
            conexion.close();
            }
            if(tipo==1){
                String sql = "UPDATE `dbis`.`solicitud` SET `estado_solicitud`='NO AUTORIZADA' WHERE `id_solicitud`='"+id+"';";
            st.executeUpdate(sql);
            conexion.close();
            }
        } //try  
        catch (SQLException ex) {
            Logger.getLogger(ManejadorPresidencia.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

        return true;
        
        
        
        
    }
   
   
   
   
   
  
  //SELECT concat(per.nombre,' ',per.apellido_pa,' ',per.apellido_ma), p.puesto,a.area from personal per,puesto p,area a,usuario u 
//where per.id_personal=u.personal_id_personal and per.puesto_id_puesto=p.id_puesto and p.area_id_area=a.id_area and u.id_usuario=4;
}
