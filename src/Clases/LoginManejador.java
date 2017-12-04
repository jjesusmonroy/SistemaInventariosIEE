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

/**
 *
 * @author tepic
 */
public class LoginManejador {
     private Connection conexion;
    private ConexionBase db;
    
    
    public LoginManejador(){
        db=new ConexionBase();
    }
    public boolean valida(String usuario,String contra){
        
      boolean res=false;
        try {
            
            String sql = "Select * from usuario where usuario COLLATE utf8_bin='"+usuario+"' and pass COLLATE utf8_bin='"+contra+"'";
            conexion = db.getConexion(); //obtenemos conexion 
            Statement st = conexion.createStatement(); //crear obteno de consulta
            ResultSet resultados = st.executeQuery(sql); //ejecutar consulta
            //vemos si encontro coincidencias
            if (resultados.next()) {
                
                res = true;
            }

            conexion.close();
        } //esAdministrador
        catch (SQLException ex) {
            Logger.getLogger(LoginManejador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return res;
    }   
     
    public String nombreUsuario(String nombreCmpo){
         String completoNombre="";
        try {
            
            String sql = "select CONCAT(p.nombre,' ',p.apellido_pa,' ',apellido_ma)from personal p,usuario u where personal_id_personal=p.id_personal and usuario='"+nombreCmpo+"';";
            conexion = db.getConexion(); //obtenemos conexion 
            Statement st = conexion.createStatement(); //crear obteno de consulta
            ResultSet resultados = st.executeQuery(sql); //ejecutar consulta
            //vemos si encontro coincidencias
            if (resultados.next()) {
                
                completoNombre= resultados.getObject(1).toString();
            }

            conexion.close();
        } //esAdministrador
        catch (SQLException ex) {
            Logger.getLogger(LoginManejador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return completoNombre;
        
        
        
    }//retorna nombre completo del usuario logiado
        
     
    
    public String idVentana(String usuario){
        
        String idPuesto="";
        try {
            
            String sql ="select  p.puesto  from personal, puesto p,usuario r where puesto_id_puesto=id_puesto and personal_id_personal=id_personal and r.usuario='"+usuario+"'";
            conexion = db.getConexion(); //obtenemos conexion 
            Statement st = conexion.createStatement(); //crear obteno de consulta
            ResultSet resultados = st.executeQuery(sql); //ejecutar consulta
            //vemos si encontro coincidencias
            if (resultados.next()) {
                
                idPuesto= resultados.getObject(1).toString();
            }

            conexion.close();
        } //esAdministrador
        catch (SQLException ex) {
            Logger.getLogger(LoginManejador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return idPuesto;
        
        
        
    }//retorna id puesto
    
    
    public String idUsuario(String usuario){
        
        String idUsuario="";
        try {
            
            String sql = "select id_usuario from usuario "
                    + "where usuario='"+usuario+"'";
            conexion = db.getConexion(); //obtenemos conexion 
            Statement st = conexion.createStatement(); //crear obteno de consulta
            ResultSet resultados = st.executeQuery(sql); //ejecutar consulta
            //vemos si encontro coincidencias
            if (resultados.next()) {
                
                idUsuario= resultados.getObject(1).toString();
            }

            conexion.close();
        } //esAdministrador
        catch (SQLException ex) {
            Logger.getLogger(LoginManejador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Conexion a la Base de Datos");
        }

        return idUsuario;
        
        
        
    }//retorna id puesto
    
    }
    
    
    
    
        
        //select id_puesto from puesto pu,usuario u, personal pe where puesto_id_puesto=personal_id_personal and id_puesto=puesto_id_puesto and u.usuario='Hector';
        
    

