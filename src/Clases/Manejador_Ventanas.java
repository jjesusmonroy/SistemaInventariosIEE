/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.Administracion;
import Interfaces.Almacen;
import Interfaces.Director_Depto;
import Interfaces.General;
import Interfaces.Informatica;
import Interfaces.Presidencia;
import basededatos.BDD;

/**
 *
 * @author Cherne
 */
public class Manejador_Ventanas {
    
    
    public void getVentanaPrincipal(String usuario){
        switch(usuario){
            case "Administracion":{
                Administracion administracion = new Administracion();
                administracion.setVisible(true);                        
                break;   
            }
            case "Almacen":{
                Almacen almacen = new Almacen();
                almacen.setVisible(true);
                break;   
            }
                
            case "Director_Depto":{
                Director_Depto director = new Director_Depto();
                director.setVisible(true);
                break;
            }
             
            case "General":{
                General general = new General();
                general.setVisible(true);
                break;
            }
             
            case "Informatica":{
                Informatica informatica = new Informatica();
                informatica.setVisible(true);
                break;
            }
             
            case "Presidencia":{
                Presidencia presidencia = new Presidencia();
                presidencia.setVisible(true);
                break;
            }

        }
        
    }
    
    public String getTipoUsuario(String nombre_usuario){
        BDD bd = new BDD();
        String query =  "SELECT u.nombre_usuario FROM usuarios u\n" +
                        "INNER JOIN personal p\n" +
                        "ON u.id_personal= p.id_personal\n" +
                        "WHERE p.nombre_personal = "+nombre_usuario+";";
        
        String resultado[][] = bd.obtenerConsultas(query);
        
        return resultado[0][0];
    
    }
    
    
    
}
