/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

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
    /*public int getMax(String [][] obtener){
        int x=Integer.parseInt(obtener[0][0]);
        for(String a[]:obtener){
            for(String b:a){
                if(x<Integer.parseInt(b))
                    x=Integer.parseInt(b);
            }
        }
        return x;          
            
    }*/
    public int getMax(String [][] obtener){
        int x=Integer.parseInt(obtener[0][0]);
        for(String a[]:obtener){
            for(String b:a){
                x=x<Integer.parseInt(b)?Integer.parseInt(b):x;
            }
        }
        return x;          
            
    }
}
