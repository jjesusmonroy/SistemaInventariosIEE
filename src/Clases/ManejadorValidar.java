/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tepic
 */
public class ManejadorValidar {
    
    
    
    
    
     public boolean validaFechaMenor(String fechaSeleccion,String fechaSalida){
        boolean valido=false;
        try {
            Date fechaActual = new Date();
            SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
            String fecha1=formateador.format(fechaSalida);
            Date fechaDate1 = formateador.parse(fechaSeleccion);
            Date fechaDate2 = formateador.parse(fecha1);
            if ( fechaDate1.before(fechaDate2) ){
    valido=false;
    }else{
     if ( fechaDate2.before(fechaDate1) ){
      valido=true;
     }else{
      valido=false;
     } 
    }
  
         
        } catch (ParseException ex) {
            Logger.getLogger(ManejadorValidar.class.getName()).log(Level.SEVERE, null, ex);
        }
   
 return valido;

}
    
    
}
