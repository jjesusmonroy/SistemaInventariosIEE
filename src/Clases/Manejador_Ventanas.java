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
    
    
    public void getVentanaPrincipal(String resulSet[][]){
            
        Administracion administracion = new Administracion(resulSet[0][0],resulSet[0][1]+" "+resulSet[0][2]+" "+resulSet[0][3],Integer.parseInt(resulSet[0][4]),Integer.parseInt(resulSet[0][5]),Integer.parseInt(resulSet[0][6]),Integer.parseInt(resulSet[0][7]),Integer.parseInt(resulSet[0][8]));
                
        administracion.setVisible(true);                        
       
        
    }
    
    public String[][] getModulo(String nombre_usuario){

        BDD bd = new BDD();
        String query =  "SELECT m._nombre_modulo,p.nombre_personal,p.apellido_pat_personal,"
                + "p.apellido_mat_personal,per.alta_perrmiso,per.baja_permiso,per.consulta_permiso,"
                + "per.modificar_permiso,per.administrar_usuario_permiso,u.id_usuario FROM usuarios u\n" +
" INNER JOIN personal p\n" +
" ON u.id_personal = p.id_personal\n" +
" INNER JOIN permisos_modulos pm\n" +
" ON u.id_personal= pm.id_personal AND u.id_usuario = pm.id_usuario\n" +
" INNER JOIN modulos m\n" +
" ON m.id_modulo = pm.id_modulo\n" +
" INNER JOIN permisos per\n" +
" ON per.id_permiso = pm.id_permiso\n" +
" WHERE u.nombre_usuario = '"+nombre_usuario+"'\n" +
" LIMIT 1;";

        
        return bd.obtenerConsultas(query);
    
    }
   
   
   
}
