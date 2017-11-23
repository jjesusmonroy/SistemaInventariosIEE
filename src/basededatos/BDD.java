/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;


import Clases.MetodosG;
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
        MetodosG m = new MetodosG();
        String query = "select m._nombre_modulo,p.nombre_personal,p.apellido_pat_personal,p.apellido_mat_personal,per.alta_perrmiso,per.baja_permiso,per.consulta_permiso,per.modificar_permiso,per.administrar_usuario_permiso,u.id_usuario from usuarios u inner join personal p on u.id_personal=p.id_personal inner join permisos_modulos pm on u.id_personal=pm.id_personal and u.id_usuario=pm.id_usuario inner join modulos m on pm.id_modulo=m.id_modulo inner join permisos per on pm.id_permiso=per.id_permiso where u.nombre_usuario='jjesusmonroy'";
        String [][] a = b.obtenerConsultas(query);
        //int a = b.noregistros(query);
        System.out.println(a[0][0]+"\n"+
                a[0][1]+"\n"+
                a[0][2]+"\n"+
                a[0][3]+"\n"+
                a[0][4]+"\n"+
                a[0][5]+"\n"+
                a[0][6]+"\n"+
                a[0][7]+"\n"+
                a[0][8]+"\n"+
                a[0][9]+"\n");
    }
    //metodo para validar inicio de sesion de login
    public String[] validarInicio(String usuario){
            BDD b = new BDD();
            String [] a = new String[2];
            ResultSet myRs = b.connection("select * from usuarios where nombre_usuario = '"+usuario+"'");
        try{
            while(myRs.next()){
            a[0]=myRs.getString("nombre_usuario");
            a[1]=myRs.getString("contraseña_usuario");
            }
        }
        catch(Exception e){
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
        }catch(Exception e ){System.out.println("Error en m columnCounter c BDD\n"+e.getMessage());}
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
                resul.close();
            }catch(SQLException e){
                System.out.println("Error en m obtener consultas c BDD \n"+e.getMessage());
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
    
    public void execute(String query){
        try{
            
            Connection con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/dbis","root","root");       
            Statement st = con.createStatement();
            st.executeUpdate(query);
            st.close();
        }catch(Exception e){
            System.out.println("error m execute c BDD \n"+e.getMessage());
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
            
            Connection con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/dbis","root","root");       
            Statement st = con.createStatement();
            st.executeUpdate(insertar);
            st.close();
        }catch(Exception e){
            System.out.println("error en m insertar c BDD\n"+e.getMessage());
        }
    }
    
    public String []  convertir2d1d(String [][] array){
        String [] a = new String [array.length];
        for(int i=0; i<array.length; i++){
            a[i]=array[i][0];
        }
        return a;
    }
    
    private int noregistros(String query){
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
        }catch(SQLException e){}
        return resultado;
    }
    
    
}
