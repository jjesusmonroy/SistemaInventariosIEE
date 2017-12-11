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
    
    
    
    
    
     
   
     
     public int numDias(String fe,Date fecha) throws ParseException{
    
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
 
		Date fechaInicial=fecha;
		Date fechaFinal=dateFormat.parse(fe);
 
		int dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000)+1;
 
		return dias;      
}
     
     
     
    
}
