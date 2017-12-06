/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gutiérrez
 */
public class ManejadorAsignacion {
    private Connection conexion;
    private ConexionBase db;

    public ManejadorAsignacion() {
        db=new ConexionBase();
    }
    
    public boolean actualizaStock(int[] stockn,int[] id){
        conexion = db.getConexion();
        for(int i = 0;i<=id.length-1;i++){
            try {
                Statement st = conexion.createStatement();
                String sql = "UPDATE `dbis`.`producto` SET `stock_producto`='"+stockn[i]+"' WHERE `id_producto`='"+id[i]+"';";
                st.executeUpdate(sql);
                conexion.close();
            }  
            catch (SQLException ex) {
                Logger.getLogger(PersonalManejador.class.getName()).log(Level.SEVERE, null, ex);
                return false;

            }
        }
        return true;
    }
    
    public boolean actualizaDisponible(int[] id){
        conexion = db.getConexion();
        for(int i = 0;i<=id.length-1;i++){
            try {
                Statement st = conexion.createStatement();
                String sql = "UPDATE `dbis`.`producto` SET `status_producto`='No Disponible' WHERE `id_producto`='"+id+"';";
                st.executeUpdate(sql);
                conexion.close();
            }  
            catch (SQLException ex) {
                Logger.getLogger(PersonalManejador.class.getName()).log(Level.SEVERE, null, ex);
                return false;

            }
        }
        return true;
    }
    
    
    
}
