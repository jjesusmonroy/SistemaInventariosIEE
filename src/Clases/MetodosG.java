/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author pasto
 */
public class MetodosG {
    
    public MetodosG() {
    }
    
    public String jtextfield(JTextField e){
        if(!e.getText().equals(""))return e.getText();
        else return null;
    }
    public String jtextarea(JTextArea e){
        if(!e.getText().equals(""))return e.getText();
        else return null;
    }
    
    public String []  selecCat(String [][] array){
        String [] a = new String [array.length+1];
        a[0]="Seleccione una categoria...";
        for(int i=1; i<array.length; i++){
            a[i]=array[i][0];
        }
        return a;
    }
    public String ignoreCase(String string){
        return string.toLowerCase();
    }
    public int getMax(String [][] obtener){
        if(obtener.length==0){return 1;}
        int x=Integer.parseInt(obtener[0][0]);
        for(String a[]:obtener){
            for(String b:a){
                x=x<Integer.parseInt(b)?Integer.parseInt(b):x;
            }
        }
        return x+1;          
            
    }
    public String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    public boolean checkAnotherID(String [][] obtener){
        int x = Integer.parseInt(obtener[0][0]);
        for(String a[]:obtener){
            for(String b:a){
                if(x==Integer.parseInt(b))return false;
            }
        }
        return true;
    }
    
    public boolean exists(String p, String[][] a){
        boolean bandera=false;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                if(p.equals(a[i][j].toLowerCase()))bandera=true;
            }
        }
        return bandera;
    }
}
