/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import java.sql.*;
/**
 *
 * @author pasto
 */
public class BDD{

    public BDD() {
    }
    
    
    
    public static void main(String [] args){
        
        try{
            
            //1. Conectarse a la base de datos
            Connection myConn = DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/dbis","root","root");
            
            //2. Crear una declaracion
            Statement myStmt = myConn.createStatement();
            
            //3. Codigo en SQL
            ResultSet myRs = myStmt.executeQuery("select * from usuarios where nombre_usuario = 'jjesusmonroy'");
            //4. Resultado
            while (myRs.next()){
                System.out.println(myRs.getString("nombre_usuario")+ ", " + myRs.getString("contraseña_usuario"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    //metodo para validar inicio de sesion de login
    public String[] validarInicio(String usuario){
        
            String [] a = new String[2];
        try{
            //1. Conectarse a la base de datos
            Connection myConn = DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/dbis","root","root");
            //2. Crear una declaracion
            Statement myStmt = myConn.createStatement();
            //3. Codigo en SQL
            ResultSet myRs = myStmt.executeQuery("select * from usuarios where nombre_usuario = '"+usuario+"'");
            //4. Resultado
            while(myRs.next()){
            a[0]=myRs.getString("nombre_usuario");
            a[1]=myRs.getString("password_usuario");
            }
            myConn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }   
    
}
