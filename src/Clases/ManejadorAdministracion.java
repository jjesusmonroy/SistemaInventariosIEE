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
public class ManejadorAdministracion {
    
    private Connection conexion;
    private ConexionBase db;
    
   public ManejadorAdministracion(){
        db= new ConexionBase();
    }
    
   public DefaultTableModel AutorizadasPorPresidente(){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Codigo:");
            table.addColumn("Viatico Para:");
            table.addColumn("Fecha Salida:");
            table.addColumn("Fecha Retorno:");
            table.addColumn("Lugar:");
            table.addColumn("Requiere Vehiculo");
            table.addColumn("Fecha Emision:");
            
        
            
            
            
            //sql
            String sql ="select id_solicitud,concat(per.nombre,' ',per.apellido_pa,' ',per.apellido_ma),fecha_salida,fecha_retorno,s.lugar,incluivehi,s.fecha_emision from personal per, solicitud s where s.personal_id_personal=per.id_personal and estado_solicitud='AUTORIZADA';";
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
            System.out.printf("Error getTabla personal SQL");
            Logger.getLogger(ManejadorAdministracion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }
   
   
   }
  
  
   
   public boolean ViaticoAsignaMonto(String cantidadAsig,String idSolicitud,String informe){
        
        conexion=db.getConexion();
        
        
        
        //sin vehiculo        
        
        try {
            Statement st = conexion.createStatement();
            String sql=  "INSERT INTO `dbis`.`viatico` (`cantidad_asig`, `solicitud_id_solicitud`, `informa`, `fecha_aproba`) VALUES ('"+cantidadAsig+"', '"+idSolicitud+"', '"+informe+"', curdate());";



            st.executeUpdate(sql);

            conexion.close();
        } //try  
        catch (SQLException ex) {
            Logger.getLogger(PeticionManejador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
        
        
        
    }
  
   
   
   public boolean atualizaEstadoVehiculo(String id){
         conexion = db.getConexion();

         try {

            Statement st = conexion.createStatement();
            String sql = "update producto set status_producto='ocupado' where id_producto=(select v.id_producto from vehiculo v where num_unidad="+id+")";

            st.executeUpdate(sql);
            conexion.close();

        } //try  
        catch (SQLException ex) {
            Logger.getLogger(ManejadorAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

        return true;
        
        
        
        
    }
   
   
   
   
   public boolean atualizaEstadoSolicitud(String id){
         conexion = db.getConexion();

         try {

            Statement st = conexion.createStatement();
            String sql = "UPDATE `dbis`.`solicitud` SET `estado_solicitud`='VIATICO' WHERE `id_solicitud`='"+id+"';";
            st.executeUpdate(sql);
            conexion.close();

        } //try  
        catch (SQLException ex) {
            Logger.getLogger(ManejadorAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

        return true;
        
        
        
        
    }
    public DefaultTableModel ViaticoSolicitud(String idSoli){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Candidad Asignada:");
            table.addColumn("Se Entrego Informe:");
            table.addColumn("Fecha de Emision:");
             //sql
            String sql ="select cantidad_asig,informa,fecha_aproba from viatico where solicitud_id_solicitud="+idSoli+";";
            Connection c = db.getConexion();
            Statement st = c.createStatement();
            Object datos[] = new Object[3];
            ResultSet rs = st.executeQuery(sql);

            //llenar tabla
            while (rs.next()) {
                datos[0] = rs.getObject(1);
                datos[1] = rs.getObject(2);
                datos[2] = rs.getObject(3);
              
                
                
              
                
                
                table.addRow(datos);
           }

            c.close();
        } catch (SQLException ex) {
            System.out.printf("Error getTabla personal SQL");
            Logger.getLogger(ManejadorAdministracion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }
   
   
   }
    
    public DefaultTableModel VerViaticos(){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Folio asignado:");
            table.addColumn("Cantidad asignada:");
            table.addColumn("Fecha de aprobacion");
            table.addColumn("Vehiculo");
             //sql
            String sql ="SELECT id_viatico,cantidad_asig,fecha_aproba, v.num_unidad from viatico,vehiculo v where v.id_vehiculo=vehiculo_id_vehiculo;";
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
            System.out.printf("Error getTabla personal SQL");
            Logger.getLogger(ManejadorAdministracion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }
   
   
   }
    
    
    
   public boolean ViaticoHacer(String cantidad,String idVehi,String idSoli,int tipo){// tipo 0== sin vehiculo tipo==1 con vehiculo
        
        conexion=db.getConexion();
                    
        //sin vehiculo        
        
        try {
            if(tipo==1){
            Statement st = conexion.createStatement();
            String sql=  "INSERT INTO `dbis`.`viatico` (`cantidad_asig`, `solicitud_id_solicitud`, `informa`, `fecha_aproba`, `vehiculo_id_vehiculo`) VALUES ('"+cantidad+"', '"+idSoli+"', 'no', curdate(), '"+idVehi+"');";




            st.executeUpdate(sql);

            conexion.close();
            }if(tipo==0){
                 Statement st = conexion.createStatement();
            String sql=  "INSERT INTO `dbis`.`viatico` (`cantidad_asig`,`informa`, `fecha_aproba`, `solicitud_id_solicitud`) VALUES ('"+cantidad+",'no', curdate(),'"+idSoli+"');";



            st.executeUpdate(sql);
            }
        } //try  
        catch (SQLException ex) {
            Logger.getLogger(ManejadorAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
        
        
        
    }
   
   
   public boolean ViaticoHacerSin(String cantidad,String idSoli){// tipo 0== sin vehiculo tipo==1 con vehiculo
        
        conexion=db.getConexion();
         try{           
        //sin vehiculo        
       
                 Statement st = conexion.createStatement();
            String sql=  "INSERT INTO `dbis`.`viatico` (`cantidad_asig`,`informa`, `fecha_aproba`, `solicitud_id_solicitud`) VALUES ('"+cantidad+"','no', curdate(),'"+idSoli+"');";



            st.executeUpdate(sql);
           
        
         }catch (SQLException ex) {
            Logger.getLogger(ManejadorAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
        
        
        
    }
   
   
   
   //INSERT INTO `viaticos`.`viatico` (`cantidad_asig`, `solicitud_id_solicitud`, `informa`, `fecha_aproba`) VALUES ('218', '1', 'no', '2018-09-09');

   
   public String idVehiculo(String inde){
        
        String id="";
        
        try {
            
            String sql = "select id_vehiculo from vehiculo where num_unidad='"+inde+"';";

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
   
    
    
   
   
   
   
   public String SolicitudEschofer(String inde){
        
        String id="";
        
        try {
            
            String sql = "select chofer from solicitud where id_solicitud="+inde+";";

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
   
    //select id_vehiculo from vehiculo where numero_unidad='001';
    
    
}
