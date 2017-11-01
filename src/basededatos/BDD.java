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
    
    
    //metodo para validar inicio de sesion de login
    public String[] validarInicio(String usuario){
            BDD b = new BDD();
            String [] a = new String[2];
            ResultSet myRs = b.connection("select * from usuarios where nombre_usuario = '"+usuario+"'");
        try{
            /*
            //1. Conectarse a la base de datos
            Connection myConn = DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/dbis","root","root");
            //2. Crear una declaracion
            Statement myStmt = myConn.createStatement();
            //3. Codigo en SQL
            ResultSet myRs = myStmt.executeQuery("select * from usuarios where nombre_usuario = '"+usuario+"'");
            //4. Resultado */
            while(myRs.next()){
            a[0]=myRs.getString("nombre_usuario");
            a[1]=myRs.getString("password_usuario");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }   
    
    public String [][] obtenerProductos(){
        BDD b = new BDD();
        ResultSet resul = b.connection("select * from producto");
        String [][] datos = new String [b.noregistros(b.connection("select * from producto"))][16]; 
                // el metodo noregistros te regresa la cantidad de registros que encuentra
                // del query que se le ha pasado como parametro
            
            int counter =0;
            try{while(resul.next()){
                for(int i=0; i<16;i++){
                    datos[counter][i]=resul.getString(i);
                }
                counter ++; 
                return datos;
            }
            }catch(Exception e){
                System.out.println(e);
            }   
        return datos;
    }
    private ResultSet connection(String query){
        ResultSet a=null;
        try{
            Connection con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/dbis","root","root");
            Statement st = con.createStatement();
            a=st.executeQuery(query);
        }catch(Exception e){
            System.out.println(e);
        }
        return a;
    }
    
    
    private int noregistros(ResultSet r){
        
        int contador=0;
        
        try{while(r.next()){
            contador++;
        }
        }catch(Exception e){
            contador = 0;
        }
        return contador;
    }
}
