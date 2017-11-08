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

    public static void main (String [] args){
        BDD b = new BDD();
        //int a = b.prueba();
        //System.out.println(a+"");
        
        //String [][]a = b.obtenerConsultas("select * from producto");
        //String [][] c = b.obtenerConsultas("select id_producto, id_categoria, "
         //       + "nombre_producto, marca_producto,modelo_producto, stock_producto, "
         //       + "status_producto from producto");
        //System.out.println(c[0][6]);
    }
    
    
    //metodo para validar inicio de sesion de login
    public String[] validarInicio(String usuario){
            BDD b = new BDD();
            String [] a = new String[2];
            ResultSet myRs = b.connection("select * from usuarios where nombre_usuario = '"+usuario+"'");
        try{
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
    
    private int columnCounter(String query){
        BDD b = new BDD();
        int a=0;
        ResultSet resul = b.connection(query);
        try{            
            while(resul.next()){
                for(int i=1;i<20;i++){
                    String aux = resul.getString(i);
                    if(resul.wasNull() || !resul.wasNull()){
                        a++;
                    }
                }
            }
        }catch(Exception e){
            return a;
        }
        
        return a;
    }
    public String [][]  obtenerConsultas(String query){
        BDD b = new BDD();
        ResultSet resul = b.connection(query);
        String [][] datos = new String [b.noregistros(b.connection(query))][b.columnCounter(query)]; 
                // el metodo noregistros te regresa la cantidad de registros que encuentra
                // del query que se le ha pasado como parametro
            
            int counter =0;
            try{while(resul.next()){
                for(int i=0; i<16;i++){
                    datos[counter][i]=resul.getString(i+1);
                }
                counter ++; 
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
