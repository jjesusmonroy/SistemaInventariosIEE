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
    
    
    public void getVentanaPrincipal(String[][] usuario){
        switch(usuario[0][0]){
            case "Administracion":{
                Administracion administracion = new Administracion();
                administracion.id_usuario=Integer.parseInt(usuario[0][1]);
                administracion.id_personal=Integer.parseInt(usuario[0][2]);
                administracion.id_modulo=Integer.parseInt(usuario[0][3]);
                administracion.id_permiso=Integer.parseInt(usuario[0][4]);
                administracion.alta=Integer.parseInt(usuario[0][5]);
                administracion.baja=Integer.parseInt(usuario[0][6]);
                administracion.buscar=Integer.parseInt(usuario[0][7]);
                administracion.modificar=Integer.parseInt(usuario[0][8]);
                administracion.usuarios=Integer.parseInt(usuario[0][9]);
                administracion.setVisible(true);                        
                break;   
            }
            case "Almacen":{
                Almacen almacen = new Almacen();
                almacen.id_usuario=Integer.parseInt(usuario[0][1]);
                almacen.id_personal=Integer.parseInt(usuario[0][2]);
                almacen.id_modulo=Integer.parseInt(usuario[0][3]);
                almacen.id_permiso=Integer.parseInt(usuario[0][4]);
                almacen.alta=Integer.parseInt(usuario[0][5]);
                almacen.baja=Integer.parseInt(usuario[0][6]);
                almacen.buscar=Integer.parseInt(usuario[0][7]);
                almacen.modificar=Integer.parseInt(usuario[0][8]);
                almacen.usuarios=Integer.parseInt(usuario[0][9]);
                almacen.setVisible(true);
                break;   
            }
                
            case "Director_Depto":{
                Director_Depto director = new Director_Depto();
                director.id_usuario=Integer.parseInt(usuario[0][1]);
                director.id_personal=Integer.parseInt(usuario[0][2]);
                director.id_modulo=Integer.parseInt(usuario[0][3]);
                director.id_permiso=Integer.parseInt(usuario[0][4]);
                director.alta=Integer.parseInt(usuario[0][5]);
                director.baja=Integer.parseInt(usuario[0][6]);
                director.buscar=Integer.parseInt(usuario[0][7]);
                director.modificar=Integer.parseInt(usuario[0][8]);
                director.usuarios=Integer.parseInt(usuario[0][9]);
                director.setVisible(true);
                break;
            }
             
            case "General":{
                General general = new General();
                general.id_usuario=Integer.parseInt(usuario[0][1]);
                general.id_personal=Integer.parseInt(usuario[0][2]);
                general.id_modulo=Integer.parseInt(usuario[0][3]);
                general.id_permiso=Integer.parseInt(usuario[0][4]);                
                general.alta=Integer.parseInt(usuario[0][5]);
                general.baja=Integer.parseInt(usuario[0][6]);
                general.buscar=Integer.parseInt(usuario[0][7]);
                general.modificar=Integer.parseInt(usuario[0][8]);
                general.usuarios=Integer.parseInt(usuario[0][9]);
                general.setVisible(true);
                break;
            }
             
            case "Informatica":{
                Informatica informatica = new Informatica();
                informatica.id_usuario=Integer.parseInt(usuario[0][1]);
                informatica.id_personal=Integer.parseInt(usuario[0][2]);
                informatica.id_modulo=Integer.parseInt(usuario[0][3]);
                informatica.id_permiso=Integer.parseInt(usuario[0][4]);
                informatica.alta=Integer.parseInt(usuario[0][5]);
                informatica.baja=Integer.parseInt(usuario[0][6]);
                informatica.buscar=Integer.parseInt(usuario[0][7]);
                informatica.modificar=Integer.parseInt(usuario[0][8]);
                informatica.usuarios=Integer.parseInt(usuario[0][9]);
                informatica.setVisible(true);
                break;
            }
             
            case "Presidencia":{
                Presidencia presidencia = new Presidencia();
                presidencia.id_usuario=Integer.parseInt(usuario[0][1]);
                presidencia.id_personal=Integer.parseInt(usuario[0][2]);
                presidencia.id_modulo=Integer.parseInt(usuario[0][3]);
                presidencia.id_permiso=Integer.parseInt(usuario[0][4]);
                presidencia.alta=Integer.parseInt(usuario[0][5]);
                presidencia.baja=Integer.parseInt(usuario[0][6]);
                presidencia.buscar=Integer.parseInt(usuario[0][7]);
                presidencia.modificar=Integer.parseInt(usuario[0][8]);
                presidencia.usuarios=Integer.parseInt(usuario[0][9]);
                presidencia.setVisible(true);
                break;
            }

        }
        
    }
    
    public String[][] getModulo(String nombre_usuario){
        BDD bd = new BDD();
        String query =  "SELECT m._nombre_modulo,\n" +
                        "	pm.id_usuario,pm.id_personal,pm.id_modulo,pm.id_permiso,\n" +
                        "    p.alta_perrmiso,p.baja_permiso,p.consulta_permiso,\n" +
                        "    p.modificar_permiso,p.administrar_usuario_permiso \n" +
                        "    FROM modulos m\n" +
                        "INNER JOIN permisos_modulos pm\n" +
                        "ON m.id_modulo = pm.id_modulo\n" +
                        "INNER JOIN usuarios u\n" +
                        "ON u.id_usuario= pm.id_usuario AND u.id_personal = pm.id_personal\n" +
                        "INNER JOIN permisos p\n" +
                        "ON p.id_permiso = pm.id_permiso\n" +
                        "WHERE u.nombre_usuario = "+nombre_usuario+";";        
        return bd.obtenerConsultas(query);
        
    
    }
    
    
    
}
