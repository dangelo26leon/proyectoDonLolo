/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author leonv
 */
public class Sala {
    
    private int id_sala;
    private String nombre;
    private int mesa;
    
    public Sala(){
        
    }

    public Sala(int id_sala, String nombre, int mesa) {
        this.id_sala = id_sala;
        this.nombre = nombre;
        this.mesa = mesa;
    }
    
    //Getters and Setters

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
    
}
