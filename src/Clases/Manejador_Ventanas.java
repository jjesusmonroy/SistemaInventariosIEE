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
        String query = "select m._nombre_modulo,p.nombre,p.apellido_pa,p.apellido_ma,per.alta_permiso,"
                + "per.baja_permiso,per.consulta_permiso,per.modificar_permiso,per.administrar_usuario_permiso,"
                + "u.id_usuario from usuario u "
                + "inner join personal p on u.personal_id_personal=p.id_personal "
                + "inner join permisos_modulos pm on u.id_usuario=pm.usuario_id_usuario "
                + "inner join modulos m on pm.modulos_id_modulo=m.id_modulo "
                + "inner join permisos per on pm.permisos_id_permiso=per.id_permiso "
                + "where u.usuario='"+nombre_usuario+"';";

        
        return bd.obtenerConsultas(query);
    
    }
   
   
   
}
