package com.co.DTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Carlos Hernández
 * Clase encargada de almacenar los datos basicos y necesarios del producto para la exportación
 */
public class ProductoDTO {
     private String nombre;
    private int cantidad;
    private double peso;
    private String ciudadOrigen;
    private String ciudadDestino;
    public static final Map<String, String> MAPACIUDADES = new HashMap<>();
    
    // Variable temporal de lista de articulos para mostrar en la Interfas grafica.
    public static final List<String> PRODUCTOS = new ArrayList<>();
    
    static{
        MAPACIUDADES.put("USA", "Estados Unidos");
        MAPACIUDADES.put("ES", "España");
        MAPACIUDADES.put("ITALIA", "Italia");
        MAPACIUDADES.put("FRANCIA", "Francia");
        MAPACIUDADES.put("ALEMANIA", "Alemania");
        
        PRODUCTOS.add("Orquidea");
        PRODUCTOS.add("Girasol");
        PRODUCTOS.add("Rosa");
        PRODUCTOS.add("Hortensia");
        PRODUCTOS.add("Tulipan");
        PRODUCTOS.add("Lavanda");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }
}
