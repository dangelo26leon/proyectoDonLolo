/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author leonv
 */
public class DetallePedido {
    
    private int id_detallepedido;
    private String nombre;
    private double precio;
    private int cantidad;
    private String comentario;
    private int id_pedido;
    private String tipoPlato;
    private String estado;
    
    public DetallePedido(){
    }

    public DetallePedido(int id_detallepedido, String nombre, double precio, int cantidad, String comentario, int id_pedido, String tipoPlato, String estado) {
        this.id_detallepedido = id_detallepedido;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.comentario = comentario;
        this.id_pedido = id_pedido;
        this.tipoPlato = tipoPlato;
        this.estado = estado;
    }
    
    
    

  
    
}
