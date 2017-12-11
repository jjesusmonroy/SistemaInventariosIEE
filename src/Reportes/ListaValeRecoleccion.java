/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

/**
 *
 * @author Gutiérrez
 */
public class ListaValeRecoleccion {
    private String id;
    private String folio;
    private String nombre;
    private String marca;

    public ListaValeRecoleccion(String id, String folio, String nombre, String marca) {
        this.id = id;
        this.folio = folio;
        this.nombre = nombre;
        this.marca = marca;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
     
    
}
