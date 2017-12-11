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
public class MandejadorInforme {
    
    private Connection conexion;
    private ConexionBase db;
    
    
    public MandejadorInforme(){
        db=new ConexionBase();
        
        
    }
    
     public boolean AtualizaViaticoInforme(String id,String id_informe){
         conexion = db.getConexion();

         try {

            Statement st = conexion.createStatement();
            String sql = "UPDATE `dbis`.`viatico` SET `informa`='si', `informe_id_informe`='"+id_informe+"' WHERE `id_viatico`='"+id+"'";

            st.executeUpdate(sql);
            conexion.close();

        } //try  
        catch (SQLException ex) {
            Logger.getLogger(ManejadorAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

        return true;
        
        
        
        
    }
    
    //INSERT INTO `dbis`.`informe` (`id_informe`, `informe`, `fecha_informe`) VALUES ('3', 'hhbhgb', 'jhjh');
     
     
     
      public boolean NuevoInforme(String id,String informe,String id_empleado){// tipo 0== sin vehiculo tipo==1 con vehiculo
        
        conexion=db.getConexion();
         try{           
        //sin vehiculo        
       
                 Statement st = conexion.createStatement();
            String sql=  "INSERT INTO `dbis`.`informe` (`id_informe`, `informe`, `fecha_informe`,`personal_id_personal`) VALUES ('"+id+"', '"+informe+"', curdate(),'"+id_empleado+"');";
     
//INSERT INTO `dbis`.`informe` (`id_informe`, `informe`, `fecha_informe`, `personal_id_personal`) VALUES ('6', 'eee', '45', '1');



            st.executeUpdate(sql);
           
        
         }catch (SQLException ex) {
            Logger.getLogger(ManejadorAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
        
        
        
    }
    
      
      public String Id_informe(){
        
        String id="";
        
        try {
            
            String sql = "select max(id_informe)+1 from informe;";

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
      
      
      
      
      public String Id_informe2(){
        
        String id="";
        
        try {
            
            String sql = "select max(id_informe) from informe;";

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
      
      
      
      
      
      
      
       public DefaultTableModel VerInformesPorArea(String area){
        
        
         DefaultTableModel table = new DefaultTableModel();

        try {
           table.addColumn("Nombre Empleado");
            table.addColumn("Puesto");
            table.addColumn("Folio Viatico");
            table.addColumn("Informe");
            table.addColumn("Fecha De Envio");
            table.addColumn("Lugar Que Visito:");
            table.addColumn("Actividad:");
            table.addColumn("Fecha Inicial:");
            table.addColumn("fecha Fin:");
            
            
            
            
            //select numero_unidad,tipo,color,estado_vehiculo,kilometraje,no_motor,placa_vehiculo from vehiculo
            //sql
            String sql = "select concat(per.nombre,' ',per.apellido_pa,' ',per.apellido_ma),p.puesto,v.id_viatico,i.informe,i.fecha_informe,s.lugar,s.actividad,s.fecha_salida,s.fecha_retorno from solicitud s,viatico v, informe i,personal per, area a, puesto p\n" +
"where s.id_solicitud=v.solicitud_id_solicitud and i.personal_id_personal=per.id_personal and per.puesto_id_puesto=p.id_puesto and p.area_id_area=a.id_area and v.informe_id_informe=i.id_informe and a.id_area="+area+";";
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
            System.out.printf("Error getTabla Cliente SQL");
            Logger.getLogger(ManejadorVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }
      }
      
}




