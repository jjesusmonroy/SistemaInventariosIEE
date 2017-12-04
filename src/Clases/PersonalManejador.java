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
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tepic
 */
public class PersonalManejador {
    private Connection conexion;
    private ConexionBase db;
    public PersonalManejador(){
       db=new ConexionBase();
    }
    
    
    public DefaultTableModel MisPeticiones(String idUsu){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Folio:");
            table.addColumn("Fecha Salida:");
            table.addColumn("Actividad:");
            table.addColumn("Lugar:");
            table.addColumn("Nombre Empleado:");
            table.addColumn("Con Vehiculo:");
            table.addColumn("Fecha peticion");
        
            
            
            
            //sql
            String sql = "select p.folio, p.fecha_ini,p.actividad_rea,p.lugar_destino, concat(per.nombre,' ',per.apellido_pa,' ',per.apellido_ma)nombre,p.vehiculo_inclui,fecha_emision" +
                    " from peticion p, personal per "+
            "where personal_id_personal=per.id_personal and usuario_id_usuario="+idUsu+"";
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
            Logger.getLogger(PersonalManejador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }

        
    }
    
    public DefaultTableModel Busquedas(String idUsu,int tipo,String cadena){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Folio:");
            table.addColumn("Fecha Salida:");
            table.addColumn("Actividad:");
            table.addColumn("Lugar:");
            table.addColumn("Nombre Empleado:");
            table.addColumn("Con Vehiculo:");
            table.addColumn("Fecha peticion");
        String sql="";
            
            //tipo 1== folio
            //tipo 2== fecha and fecha_emision like "%2017-11-21%";
            //tipo 3== personal and nombre like '%jose%';
          
            
            //sqlif
            
            if(tipo==1){
            sql = "select p.folio, p.fecha_ini,p.actividad_rea,p.lugar_destino, concat(per.nombre,' ',per.apellido_pa,' ',per.apellido_ma)nombre,p.vehiculo_inclui,fecha_emision" +
                    " from peticion p, personal per "+
            "where personal_id_personal=per.id_personal and usuario_id_usuario="+idUsu+" and folio="+cadena+";";
            }
            
            if(tipo==2){
            sql = "select p.folio, p.fecha_ini,p.actividad_rea,p.lugar_destino, concat(per.nombre,' ',per.apellido_pa,' ',per.apellido_ma)nombre,p.vehiculo_inclui,fecha_emision" +
                    " from peticion p, personal per "+
            "where personal_id_personal=per.id_personal and usuario_id_usuario="+idUsu+" and fecha_emision like '%"+cadena+"'%";
            }
            if(tipo==3){
            sql = "select p.folio, p.fecha_ini,p.actividad_rea,p.lugar_destino, concat(per.nombre,' ',per.apellido_pa,' ',per.apellido_ma)nombre,p.vehiculo_inclui,fecha_emision" +
                    " from peticion p, personal per "+
            "where personal_id_personal=per.id_personal and usuario_id_usuario="+idUsu+" and nombre like '%"+cadena+"%'";
            }
            
            
            
            
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
            Logger.getLogger(PersonalManejador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }
    
    }
    public void comboPersonal(JComboBox combo) {
        
        
        try{
           //sql      
            String sql = "select concat(nombre,' ',apellido_pa,' ',apellido_ma)nombre from personal;";
            
            Connection c = db.getConexion();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                
           
                combo.addItem(rs.getString("nombre"));
            }
            
            
            //campo = rs.getObject(1).toString();
            
            c.close();
        } catch (SQLException ex) {
            System.out.printf("Error getTabla Inventario SQL");
            Logger.getLogger(PersonalManejador.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public String id_persona(String nombreCombo){
        
        
        String id="";
        try {
            
            String sql = "select id_personal nombre from personal where concat(nombre,' ',apellido_pa,' ',apellido_ma)='"+nombreCombo+"'";
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
            Logger.getLogger(LoginManejador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return id;
        

       
    }
    
    public DefaultTableModel VerPeticiones(){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Folio");
            table.addColumn("Fecha Salida");
            table.addColumn("Actividad");
            table.addColumn("Lugar");
            table.addColumn("Necesita Vehiculo");
            table.addColumn("Nombre Empleado ");
            table.addColumn("Fecha Peticion");
            table.addColumn("Puesto Procedencia");
            table.addColumn("Area Procediencia");
            
            
            
            
            //sql
            String sql = "select p.folio, p.fecha_ini,p.actividad_rea,p.lugar_destino,p.vehiculo_inclui, concat(per.nombre,' ',per.apellido_pa,' ',per.apellido_ma)nombre,fecha_emision, m.puesto, h.area from peticion p, personal per,puesto m,area h where p.personal_id_personal=per.id_personal and m.area_id_area=id_area and m.id_puesto=per.puesto_id_puesto and p.estado_p ='no solicitada';";
            Connection c = db.getConexion();
            Statement st = c.createStatement();
            Object datos[] = new Object[9];
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
                datos[8] = rs.getObject(9);
                
              
                
                
                table.addRow(datos);
           }

            c.close();
        } catch (SQLException ex) {
            System.out.printf("Error getTabla personal SQL");
            Logger.getLogger(PeticionManejador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }

        
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
    
    
    public DefaultTableModel Empleados(){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Codigo");
            table.addColumn("Nombre Completo");
            table.addColumn("Puesto");
            table.addColumn("Area");
            table.addColumn("RFC");
            
        
            
            
            
            //sql
            String sql ="SELECT per.id_personal, concat(per.nombre,' ',per.apellido_pa,' ',per.apellido_ma),l.puesto,a.area,per.rfc from personal per,puesto l,area a where per.puesto_id_puesto=l.id_puesto and l.area_id_area=a.id_area;";
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
            System.out.printf("Error getTabla personal SQL");
            Logger.getLogger(PersonalManejador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }

        
    }
    
    
    
    
    
    
    
    
      
}
