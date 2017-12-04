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
public class SolictudesManejador {
   private Connection conexion;
    private ConexionBase db;
    

    
   public SolictudesManejador(){
        db=new ConexionBase();
        
        
    }
    
   
   public boolean atualizaEstadoPeticion(String id){
         conexion = db.getConexion();

         try {

            Statement st = conexion.createStatement();
            String sql = "UPDATE `dbis`.`peticion` SET `estado_p`='solicitada' WHERE `folio`='"+id+"';";
            st.executeUpdate(sql);
            conexion.close();

        } //try  
        catch (SQLException ex) {
            Logger.getLogger(PersonalManejador.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

        return true;
        
        
        
        
    }
    
        
        
        
        
    
   
   
   public String[] InformacionUsuario(String folioId){
        
        
        String id[]=new String[3];
        
        try {
            
            String sql = "select concat(per.nombre,' ',per.apellido_pa,' ',per.apellido_ma)nombre, r.puesto, a.area from peticion e,area a, puesto r,personal per,usuario u where "
                    + "u.personal_id_personal=id_personal and puesto_id_puesto=id_puesto and area_id_area=id_area and e.usuario_id_usuario=u.id_usuario and e.folio="+folioId+";";

            conexion = db.getConexion(); //obtenemos conexion 
            Statement st = conexion.createStatement(); //crear obteno de consulta
            ResultSet resultados = st.executeQuery(sql); //ejecutar consulta
            //vemos si encontro coincidencias
            if (resultados.next()) {
                
                id[0]= resultados.getObject(1).toString();
                id[1]= resultados.getObject(2).toString();
                id[2]=resultados.getObject(3).toString();
            }

            conexion.close();
        } //esAdministrador
        catch (SQLException ex) {
            Logger.getLogger(LoginManejador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return id;
        

       
    }
//    select concat(per.nombre,' ',per.apellido_pa,' ',per.apellido_ma)nombre, r.puesto, a.area from area a, puesto r,personal per,usuario u where personal_id_personal=id_personal and puesto_id_puesto=id_puesto and area_id_area=id_area and id_usuario=1
 

   public boolean NuevaSolicitudSinVe(String fechaSalida,String necesita,String lugar,String actividad,String perno,String fechaLlegada,String idFolio,String idUsuario,String idPersona){
        
        conexion=db.getConexion();
        
        
        
        //sin vehiculo        
        
        try {
            Statement st = conexion.createStatement();
            String sql= "INSERT INTO `dbis`.`solicitud` (`fecha_salida`, `fecha_emision`, `lugar`, `actividad`, `pernotado`, `estado_solicitud`, `fecha_retorno`, `usuario_id_usuario`, `peticion_folio`,`incluivehi`,`personal_id_personal`,`chofer`) "
                    + "VALUES ('"+fechaSalida+"', curdate(), '"+lugar+"', '"+actividad+"', '"+perno+"', 'EN REVISION', '"+fechaLlegada+"', '"+idUsuario+"', '"+idFolio+"','"+"NO"+"','"+idPersona+"');";
//            String sql = "INSERT INTO `viaticos`.`peticion` "
//                    + "(`fecha_ini`, `actividad_rea`, `lugar_destino`, `vehiculo_inclui`,"
//                    + " `personal_id_personal`, `usuario_id_usuario`) VALUES ('"+fechaSalida+"', '"+actividad+"', '"+lugar+"', '"+necesita+"', '"+idPersona+"', '"+idUsuario+"');";



            st.executeUpdate(sql);

            conexion.close();
        } //try  
        catch (SQLException ex) {
            Logger.getLogger(SolictudesManejador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
        
        
        
    }

   
   
   
   
   
public boolean NuevaSolicitud(String fechaSalida,String lugar,String actividad,String pernoto,String fechaLlegada,String usuario,String necesario,String id_per,String chofe){
        
        conexion=db.getConexion();
        
        
        
        //sin vehiculo        
        
        try {
            Statement st = conexion.createStatement();
            String sql= "INSERT INTO `dbis`.`solicitud` (`fecha_salida`, `fecha_emision`, `lugar`, `actividad`, `pernotado`, `estado_solicitud`, `fecha_retorno`, `usuario_id_usuario`, `incluivehi`, `personal_id_personal`, `chofer`)"+
                    " VALUES ('"+fechaSalida+"', curdate(), '"+lugar+"', '"+actividad+"', '"+pernoto+"', 'EN REVISION', '"+fechaLlegada+"', '"+usuario+"', '"+necesario+"', '"+id_per+"', '"+chofe+"');";

            st.executeUpdate(sql);

            conexion.close();
        } //try  
        catch (SQLException ex) {
            Logger.getLogger(SolictudesManejador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
        
        
        
    }

public boolean NuevaSolicitudConVehiculo(String fechaSalida,String necesita,String lugar,String actividad,String perno,String fechaLlegada,String idFolio,String idUsuario,String idPersona,String cho){
        
        conexion=db.getConexion();
        
        
        
        //sin vehiculo        
        
        try {
            Statement st = conexion.createStatement();
            String sql= "INSERT INTO `dbis`.`solicitud` (`fecha_salida`, `fecha_emision`, `lugar`, `actividad`, `pernotado`, `estado_solicitud`, `fecha_retorno`, `usuario_id_usuario`, `peticion_folio`,`incluivehi`,`personal_id_personal`,`chofer`) "
                    + "VALUES ('"+fechaSalida+"', curdate(), '"+lugar+"', '"+actividad+"', '"+perno+"', 'EN REVISION', '"+fechaLlegada+"', '"+idUsuario+"', '"+idFolio+"','"+"SI"+"','"+idPersona+"','"+cho+"')";
//            String sql = "INSERT INTO `viaticos`.`peticion` "
//                    + "(`fecha_ini`, `actividad_rea`, `lugar_destino`, `vehiculo_inclui`,"
//                    + " `personal_id_personal`, `usuario_id_usuario`) VALUES ('"+fechaSalida+"', '"+actividad+"', '"+lugar+"', '"+necesita+"', '"+idPersona+"', '"+idUsuario+"');";



            st.executeUpdate(sql);

            conexion.close();
        } //try  
        catch (SQLException ex) {
            Logger.getLogger(PeticionManejador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
        
        
        
    }

public DefaultTableModel Solicitudes(){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Vaticos Para:");
            table.addColumn("Puesto");
            table.addColumn("Area");
            table.addColumn("Fecha Salida");
            table.addColumn("Destino");
            table.addColumn("Folio");
            
            
            //sql
            String sql = "select concat(per.nombre,' ',per.apellido_pa,' ',per.apellido_ma)nombre, r.puesto,a.area,s.fecha_salida,s.lugar,s.id_solicitud from personal per,puesto r,area a,solicitud s where s.personal_id_personal=per.id_personal and puesto_id_puesto=r.id_puesto and r.area_id_area=a.id_area order by id_solicitud;";
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
            System.out.printf("Error getTabla Cliente SQL");
            Logger.getLogger(SolictudesManejador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }

        
    }
public String RetornoEstado(String folioId){
        
        String estado="";
        
        try {
            
            String sql = "SELECT estado_solicitud from solicitud where id_solicitud="+folioId+"";

            conexion = db.getConexion(); //obtenemos conexion 
            Statement st = conexion.createStatement(); //crear obteno de consulta
            ResultSet resultados = st.executeQuery(sql); //ejecutar consulta
            //vemos si encontro coincidencias
            if (resultados.next()) {
                
                estado=resultados.getObject(1).toString();
            }

            conexion.close();
        } //esAdministrador
        catch (SQLException ex) {
            Logger.getLogger(LoginManejador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return estado;
        

       
    }
public DefaultTableModel MisSolicitudesEnvidas(String id){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Folio");
            table.addColumn("Fecha de salida");
            table.addColumn("Fecha de retorno");
            table.addColumn("Estado de solicitud");
            table.addColumn("Pernotando");
            table.addColumn("Fecha de enviado");
            
            
//select s.peticion_folio,s.fecha_salida,s.fecha_retorno,s.estado_solicitud,s.pernotado,s.fecha_emision from solicitud s where usuario_id_usuario=1 ;
            //sql
            String sql = "select s.id_solicitud,s.fecha_salida,s.fecha_retorno,s.estado_solicitud,s.pernotado,s.fecha_emision from solicitud s where usuario_id_usuario='"+id+"';";
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
            System.out.printf("Error getTabla Cliente SQL");
            Logger.getLogger(SolictudesManejador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }

        
    }

public String idPersonaCascada(String folio){
        
        String id="";
        
        try {
            
            String sql = "SELECT personal_id_personal from peticion where folio="+folio+";";

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
            Logger.getLogger(SolictudesManejador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return id;
        

       
    }

public String notificacion(String folio){
        
        String id="";
        
        try {
            
            String sql = "select observaciones from solicitud where peticion_folio="+folio+";";

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
            Logger.getLogger(SolictudesManejador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return id;
        

       
    }

public DefaultTableModel infoPersonal(String folio){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Area:");
            table.addColumn("Puesto");
            table.addColumn("Rfc");
            table.addColumn("Codigo Identificado");
            
            
            
//
            //sql
            String sql = "select a.area,p.puesto,per.rfc,per.id_personal from area a,puesto p,personal per,peticion n where n.personal_id_personal=per.id_personal and per.puesto_id_puesto=p.id_puesto and p.area_id_area=a.id_area and folio="+folio+";";
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
            Logger.getLogger(SolictudesManejador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }

        
    }
//select observaciones from solicitud where peticion_folio=29;







   
}
