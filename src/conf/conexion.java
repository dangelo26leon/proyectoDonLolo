/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    
    private Connection conexion;
    
    
    public Connection getConnection() {
        try {
            // URL de conexión a la base de datos "cevicheria" en el servidor local
            String myBD = "";
            // Establecer la conexión utilizando el controlador JDBC para MySQL
            conexion = DriverManager.getConnection(myBD, "root", "");
            return conexion;  // Retornar la conexión establecida
        } catch (SQLException e) {
            // Si ocurre un error, imprimir el mensaje de error
            System.out.println(e.toString());
        }
        return null;  // Retornar null si la conexión falla
    }
}
