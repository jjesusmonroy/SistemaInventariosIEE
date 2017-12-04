/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author tepi
 */

public class ConexionBase {
    
    private static final String usuario = "root";
    private static String contra = "root";
    private static String servidor="localhost";
    private static String database="dbis";
    private Connection con;
    public ConexionBase(){
        con = null;
    }

    
    public Connection getConexion() {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://192.168.1.663306/basedata",usuario, contra);
            con = DriverManager.getConnection("jdbc:mysql://"+servidor+"/"+database,usuario, contra);
            System.out.println("Conexion Correcta");
         } catch (SQLException ex) {
           // throw new SQLException(ex);
             System.err.println("No Hay Conexion a la Base de Datos");
         } catch (ClassNotFoundException ex) {
            //throw new ClassCastException(ex.getMessage());
            System.err.println( "No Hay Conexion a la Base de Datos 1");
           
         }finally{
             
             return con;
         }
    }//conexion
    
    public boolean hayConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"+servidor+"/"+database,usuario, contra);
            
            System.out.println("Conexion Correcta");
         } catch (SQLException ex) {
           // throw new SQLException(ex);
             System.err.println("No Hay Conexion a la Base de Datos");
             return false;
         } catch (ClassNotFoundException ex) {
            //throw new ClassCastException(ex.getMessage());
            System.err.println( "No Hay Conexion a la Base de Datos 1");
            return false;
           
         }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return true;
    }
    
    public static String getUsuario() {
        return usuario;
    }

    public static String getServidor() {
        return servidor;
    }

    public static String getDatabase() {
        return database;
    }

    public static void setContra(String contra) {
        ConexionBase.contra = contra;
    }

    public static void setServidor(String servidor) {
        ConexionBase.servidor = servidor;
    }

    public static void setDatabase(String database) {
        ConexionBase.database = database;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    
    
    
}//ConexionLogin

