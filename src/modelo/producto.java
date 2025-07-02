/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author leonv
 */
public class producto {
    
    /*ID del producto*/
    private int id_producto;
    
    /*Nombre del producto*/
    private String nombre_producto;
    
    /*Tipo de plato*/
    private String categoria;
    
    /*El precio del producto*/
    private double precio;
            
    /*Pequeña descripción del plato*/
    private String descripcion;
    
    
    public producto(){
        
    }

    public producto(int id_producto, String nombre_producto, String categoria, double precio, String descripcion) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.categoria = categoria;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    
    //Getters and Setters

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
    
    
    
    
    
}
