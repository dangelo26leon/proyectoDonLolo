/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author leonv
 */
public class Producto {
    
    /*ID del producto*/
    private int id_producto;
    
    /*Nombre del producto*/
    private String nom_producto;
    
    /*Tipo de plato*/
    private String tipoPlato;
    
    /*El precio del producto*/
    private double precio;
            
    /*Pequeña descripción del plato*/
    private String descripcion;
    
    
    public Producto(){
        
    }

    public Producto(int id_producto, String nombre_producto, String categoria, double precio, String descripcion) {
        this.id_producto = id_producto;
        this.nom_producto = nom_producto;
        this.tipoPlato = tipoPlato;
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

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public String getTipoPlato() {
        return tipoPlato;
    }

    public void setTipoPlato(String tipoPlato) {
        this.tipoPlato = tipoPlato;
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
