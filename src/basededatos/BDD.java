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
        
        String [][] datos = b.obtenerConsultas("select id_producto,id_categoria,"
                + "nombre_producto,marca_producto,modelo_producto,stock_producto,"
                + "status_producto from producto");
        
        System.out.println(datos[0][6]);
        
        
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
        String [] columnNames = b.columnNames(query);
        ResultSet resul = b.connection(query);
        int columnas = b.columnCounter(query);
        int renglones = b.noregistros(b.connection(query));
        String [][] datos = new String [renglones][columnas]; 
                // el metodo noregistros te regresa la cantidad de registros que encuentra
                // del query que se le ha pasado como parametro
            
            
            try{while(resul.next()){
                for(int j=0; j<renglones;j++){
                    for(int i=0; i<columnas; i++){
                        if(!b.needColumnNames(query)){
                        datos[j][i]=resul.getString(i+1);
                        }
                        else datos[j][i]=resul.getString(columnNames[i]);
                    }
                }
                
            }
            }catch(Exception e){
                System.out.println(e);
            }   
        return datos;
    }
    
    public ResultSet connection(String query){
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
    private boolean needColumnNames(String query){
        if(query.substring(7,8).equals("*"))return false;
        else return true;
    }
    private String[] columnNames(String query){
        String c = query.substring(7);
        String []d = c.split(" from");
        String e = d[0];
        String []f = e.split(",");
        return f;
    }
}
