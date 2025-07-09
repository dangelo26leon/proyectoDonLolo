/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author leonv
 */
public class Administrador extends Persona {

    public Administrador() {
    }

    public Administrador(int id_empleado, String nombre, String apellido, String correo, int celular, int dni, String genero, String direccion, String pass, String rol) {
        super(id_empleado, nombre, apellido, correo, celular, dni, genero, direccion, pass, rol);
    }
    
}
