/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;


import Clases.MetodosG;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pasto
 */
public class BDD{

    public boolean verificacionInsert;
    Connection con;
    public BDD() {
        con=null;
        verificacionInsert=true;
    }
    
    public static void main (String [] args){
        BDD b = new BDD();
        MetodosG m = new MetodosG();
        String [][] a = b.obtenerConsultas("select * from producto");
    }
    //metodo para validar inicio de sesion de login
    public String[] validarInicio(String usuario){
            BDD b = new BDD();
            String [] a = new String[2];
            ResultSet myRs = b.connection("select * from usuario where usuario = '"+usuario+"'");
        try{
            while(myRs.next()){
            a[0]=myRs.getString("usuario");
            a[1]=myRs.getString("pass");
            }
        }
        catch(SQLException e){
            System.out.println("Error en m validarInicio c BDD\n"+e.getMessage());
        }
        return a;
    }   
    
    private int columnCounter(String query){
        BDD b = new BDD();
        int columnas=0;
        ResultSet resul = b.connection(query);
        try{ResultSetMetaData rsmd = resul.getMetaData();
             columnas = rsmd.getColumnCount();
        }catch(SQLException e ){System.out.println("Error en m columnCounter c BDD\n"+e.getMessage());}
        return columnas;        
    }
    public String[][]  obtenerConsultas(String query){
        BDD b = new BDD();
        String [] columnNames = b.columnNames(query);
        ResultSet resul = b.connection(query);        
        int columnas = b.columnCounter(query);
        int renglones = b.noregistros(query);
        String [][] datos = new String [renglones][columnas]; 
            try{
                int aux=0;
                while(resul.next()){
                
                    for(int i=0; i<columnas; i++){
                        if(!b.needColumnNames(query)){
                        datos[aux][i]=resul.getString(i+1);
                        }
                        else datos[aux][i]=resul.getString(columnNames[i]);
                    }
                if(aux<renglones)aux++;   
            }
            }catch(SQLException e){
                System.out.println("Error en m obtener consultas c BDD \n"+e.getMessage());
            }finally{
            try {
                if(resul!=null)resul.close();
                if(con!=null)con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        return datos;
    }
    
    public ResultSet connection(String query){
        ResultSet a=null;
        try{
            con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/dbis","root","root");
            Statement st = con.createStatement();
            a=st.executeQuery(query);
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            
        }
        return a;
    }
    
    public void execute(String query){
        try{
            
            con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/dbis","root","root");       
            try (Statement st = con.createStatement()) {
                st.executeUpdate(query);
            }
        }catch(SQLException e){
            System.out.println("error m execute c BDD \n"+e.getMessage());
        }finally{
            if(con!=null)try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void insertar(String tabla, String [] elementos){
        String insertar="insert into "+ tabla+" values (";
        for(int i=0; i<elementos.length;i++){
            if(i==elementos.length-1){
                if(elementos[i]==null){insertar+="null";}
                else insertar+="'"+elementos[i]+"'";}
            else {
                if(elementos[i]==null){insertar+="null,";}
                else insertar+="'"+elementos[i]+"',";}
        }
        insertar+=")";
        try{
            
            con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/dbis","root","root");       
            try (Statement st = con.createStatement()) {
                st.executeUpdate(insertar);
            }
        }catch(SQLException e){
            verificacionInsert=false;
            System.out.println("error en m insertar c BDD\n"+e.getMessage());
        }finally{
            if(con!=null)try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public String []  convertir2d1d(String [][] array){
        String [] a = new String [array.length];
        for(int i=0; i<array.length; i++){
            a[i]=array[i][0];
        }
        return a;
    }
    
    public int noregistros(String query){
        BDD b = new BDD();
        int renglones=0;
        ResultSet resul = b.connection(query);
        try{
            resul.last();
            renglones = resul.getRow();
        }catch(SQLException e){
            System.out.println("Error en m noregistros c BDD \n"+e.getMessage());
        }
        return renglones;
    }
    private boolean needColumnNames(String query){
        return !query.substring(7,8).equals("*");
    }
    private String[] columnNames(String query){
        String c = query.substring(7);
        String []d = c.split(" from");
        String e = d[0];
        String []f = e.split(",");
        return f;
    }
    public int getId(String query){
        BDD b = new BDD();
        int id =0; 
        ResultSet rs = b.connection(query);
        try{
            while(rs.next()){
            id = Integer.parseInt(rs.getString(1)); }
        }catch(NumberFormatException | SQLException e){
            System.out.println("Error en metodo getId de BDD");
        }finally{
            try {
                if(rs!=null)rs.close();
                if(con!=null)con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;
    }
    
    public String getOne(String query){
        BDD b = new BDD();
        String resultado="";
        ResultSet rs = b.connection(query);
        try{    
            while(rs.next()){
                resultado=rs.getString(1);
            }
        }catch(SQLException e){}finally{
            try {
                if(rs!=null)rs.close();
                if(con!=null)con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
    
    
}
