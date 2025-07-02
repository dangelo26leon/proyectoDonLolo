/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Login; // Importa la clase Login
import conf.conexion; // Importa tu clase de conexión

/**
 *
 * @author leonv
 */
public class loginDAO {
    
    // Crear una instancia de tu clase de conexión
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexion cn = new conexion(); // Instancia de la clase conexion

    /**
     * Método para validar las credenciales de un usuario.
     * @param log Objeto Login que contiene el correo y la contraseña.
     * @return Un objeto Login si las credenciales son válidas, de lo contrario, null.
     */
    public Login log(String correo, String password) { // Modificado para aceptar correo y password directamente
        Login l = new Login();
        String sql = "SELECT * FROM empleados WHERE correo = ? AND password = ?"; // Consulta SQL para verificar credenciales
        try {
            con = cn.getConnection(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql); // Preparar la consulta SQL
            ps.setString(1, correo); // Establecer el correo en el primer parámetro
            ps.setString(2, password); // Establecer la contraseña en el segundo parámetro
            rs = ps.executeQuery(); // Ejecutar la consulta

            if (rs.next()) { // Si se encuentra un registro
                // Llenar el objeto Login con los datos obtenidos de la base de datos
                l.setId(rs.getInt("id_empleado"));
                l.setNombre(rs.getString("nombre"));
                l.setApellido(rs.getString("apellido"));
                l.setCorreo(rs.getString("correo"));
                l.setCelular(rs.getInt("celular"));
                l.setDni(rs.getInt("dni"));
                l.setGenero(rs.getString("genero"));
                l.setDireccion(rs.getString("direccion"));
                l.setPassword(rs.getString("password"));
                l.setRol(rs.getString("rol"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString()); // Imprimir cualquier error de SQL
        } finally {
            // Cerrar recursos para evitar fugas de memoria y conexiones
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return l; // Retornar el objeto Login (si se encontró, estará lleno; de lo contrario, sus atributos serán nulos/valores por defecto)
    }
    
}
