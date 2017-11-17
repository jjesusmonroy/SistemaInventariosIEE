package Clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BetsySanchez
 */
public class Validaciones {
    public boolean estaVacio(String texto){
        if(texto.length()==0){
           return true;
        }
        return false;
    }
    public boolean soloNumeros(String num){
        if(num.length()==0){
           return true;
        }
        boolean v=onlyNumbers(num);
        if(v!=true){
            return true;
        }
        return false;
    }
    
    public boolean onlyNumbers(String cad){
        int num;
        try{
            num=Integer.parseInt(cad);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean soloLetras(String cad){
        if(cad.length()==0){
           return true;
        }
        for(int i=0;i<cad.length();i++){
            if((cad.charAt(i)<'a'||cad.charAt(i)>'z')&&(cad.charAt(i)<'A'||cad.charAt(i)>'Z')){
                return true;
            }
        }
        return false;
    }
    public boolean soloDineros(String num){
        if(num.length()==0){
           return true;
        }
        boolean v=onlyDineros(num);
        if(v!=true){
            return true;
        }
        return false;
    }
    
    public boolean onlyDineros(String cad){
        float num=0;
        try{
            num=Float.parseFloat(cad);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}