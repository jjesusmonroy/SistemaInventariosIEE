/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pasto
 */
public class MetodosG {
    
    public MetodosG() {
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
    public String datetojDateChooser(String a){
        String [] fecha = a.split("-");
        String jdate="";
        switch(fecha[1]){
            case "01": jdate= "Jan "+fecha[2]+", "+fecha[0];
            break;
            case "02": jdate="Jan "+fecha[2]+", "+fecha[0];
            break;
            case "03": jdate= "Jan "+fecha[2]+", "+fecha[0];
            break;
            case "04": jdate= "Jan "+fecha[2]+", "+fecha[0];
            break;
            case "05": jdate= "Jan "+fecha[2]+", "+fecha[0];
            break;
            case "06": jdate= "Jan "+fecha[2]+", "+fecha[0];
            break;
            case "07": jdate= "Jan "+fecha[2]+", "+fecha[0];
            break;
            case "08": jdate= "Jan "+fecha[2]+", "+fecha[0];
            break;
            case "09": jdate= "Jan "+fecha[2]+", "+fecha[0];
            break;
            case "10": jdate= "Jan "+fecha[2]+", "+fecha[0];
            break;
            case "11": jdate= "Jan "+fecha[2]+", "+fecha[0];
            break;
            case "12": jdate= "Jan "+fecha[2]+", "+fecha[0];
            break;
        }
        return jdate;
    }
}
