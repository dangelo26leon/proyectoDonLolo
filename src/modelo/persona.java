/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author leonv
 */
public class Persona {
    /**
     * El ID único del empleado o persona
     */
    private int id_empleado;

    /**
     * El nombre de la persona
     */
    private String nombre;

    /**
     * El apellido de la persona
     */
    private String apellido;

    /**
     * El correo electrónico de la persona
     */
    private String correo;

    /**
     * El número de celular de la persona
     */
    private int celular;

    /**
     * El DNI de la persona
     */
    private int dni;

    /**
     * El género de la persona
     */
    private String genero;

    /**
     * La dirección de la persona
     */
    private String direccion;

    /**
     * La contraseña para acceder al sistema
     */
    private String pass;

    /**
     * El rol de la persona (por ejemplo, "Administrador", "Empleado")
     */
    private String rol;

    /**
     * Constructor vacío de la clase Persona. Inicializa un objeto Persona sin
     * valores predeterminados.
     */
    public Persona() {
    }

    /**
     * Constructor de la clase Persona con parámetros. Inicializa un objeto
     * Persona con los valores proporcionados.
     *
     * @param id_empleado El ID único del empleado o persona.
     * @param nombre El nombre de la persona.
     * @param apellido El apellido de la persona.
     * @param correo El correo electrónico de la persona.
     * @param celular El número de celular de la persona.
     * @param dni El DNI de la persona.
     * @param genero El género de la persona.
     * @param direccion La dirección de la persona.
     * @param pass La contraseña de la persona.
     * @param rol El rol de la persona (por ejemplo, "Administrador",
     * "Empleado").
     */
    public Persona(int id_empleado, String nombre, String apellido, String correo, int celular, int dni, String genero, String direccion, String pass, String rol) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.dni = dni;
        this.genero = genero;
        this.direccion = direccion;
        this.pass = pass;
        this.rol = rol;
    }

    /**
     * Obtiene el ID único del empleado o persona.
     *
     * @return El ID del empleado o persona.
     */
    public int getId_empleado() {
        return id_empleado;
    }

    /**
     * Establece el ID único del empleado o persona.
     *
     * @param id_empleado El nuevo ID del empleado o persona.
     */
    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido de la persona.
     *
     * @return El apellido de la persona.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido de la persona.
     *
     * @param apellido El nuevo apellido de la persona.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el correo electrónico de la persona.
     *
     * @return El correo electrónico de la persona.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico de la persona.
     *
     * @param correo El nuevo correo electrónico de la persona.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el número de celular de la persona.
     *
     * @return El número de celular de la persona.
     */
    public int getCelular() {
        return celular;
    }

    /**
     * Establece el número de celular de la persona.
     *
     * @param celular El nuevo número de celular de la persona.
     */
    public void setCelular(int celular) {
        this.celular = celular;
    }

    /**
     * Obtiene el DNI de la persona.
     *
     * @return El DNI de la persona.
     */
    public int getDni() {
        return dni;
    }

    /**
     * Establece el DNI de la persona.
     *
     * @param dni El nuevo DNI de la persona.
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el género de la persona.
     *
     * @return El género de la persona.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género de la persona.
     *
     * @param genero El nuevo género de la persona.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la dirección de la persona.
     *
     * @return La dirección de la persona.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección de la persona.
     *
     * @param direccion La nueva dirección de la persona.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la contraseña de la persona.
     *
     * @return La contraseña de la persona.
     */
    public String getPass() {
        return pass;
    }

    /**
     * Establece la contraseña de la persona.
     *
     * @param pass La nueva contraseña de la persona.
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Obtiene el rol de la persona.
     *
     * @return El rol de la persona (por ejemplo, "Administrador", "Empleado").
     */
    public String getRol() {
        return rol;
    }

    /**
     * Establece el rol de la persona.
     *
     * @param rol El nuevo rol de la persona.
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
