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
            
        Administracion administracion = new Administracion(resulSet[0][0],resulSet[0][1]+" "+resulSet[0][2]+" "+resulSet[0][3],Integer.parseInt(resulSet[0][4]),Integer.parseInt(resulSet[0][5]),Integer.parseInt(resulSet[0][6]),Integer.parseInt(resulSet[0][7]),Integer.parseInt(resulSet[0][8]),Integer.parseInt(resulSet[0][9]),Integer.parseInt(resulSet[0][10]));
        administracion.setVisible(true);                        
       
        
    }
    
    public String[][] getModulo(String nombre_usuario){

        BDD bd = new BDD();
        String query = "select are.area,pe.nombre,pe.apellido_pa,pe.apellido_ma," +
            "per.alta_permiso,per.baja_permiso,per.consulta_permiso,per.modificar_permiso,per.administrar_usuario_permiso,per.solicitar_producto_permiso,per.aprobar_solicitud_producto_permiso," +
            "usu.id_usuario" +
            " from usuario usu" +
            " inner join personal pe" +
            " on usu.personal_id_personal = pe.id_personal" +
            " inner join puesto pue" +
            " on pe.puesto_id_puesto = pue.id_puesto" +
            " inner join area are" +
            " on pue.area_id_area = are.id_area" +
            " inner join usuarios_permisos up" +
            " on usu.id_usuario = up.usuario_id_usuario" +
            " inner join permisos per" +
            " on up.permisos_id_permiso = per.id_permiso" +
            " where usu.usuario='"+nombre_usuario+"';";
        return bd.obtenerConsultas(query);
    
    }
   
   
   
}
