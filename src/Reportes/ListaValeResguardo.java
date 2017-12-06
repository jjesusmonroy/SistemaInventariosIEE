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
public class ListaValeResguardo {
    private String folio;
    private String nombre;
    private String marca;
    private String modelo;

    public ListaValeResguardo(String folio, String nombre, String marca, String modelo) {
        this.folio = folio;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    
}
