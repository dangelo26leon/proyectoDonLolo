/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    
    private Connection con;
    
    
    public Connection getConnection() {
        try {
            // URL de conexión a la base de datos "cevicheria" en el servidor local
            String myBD = "jdbc:mysql://localhost:3306/polleria?serverTimezone=UTC";
            // Establecer la conexión utilizando el controlador JDBC para MySQL
            con = DriverManager.getConnection(myBD, "root", "dangelo");
            return con;  // Retornar la conexión establecida
        } catch (SQLException e) {
            // Si ocurre un error, imprimir el mensaje de error
            System.out.println(e.toString());
        }
        return null;  // Retornar null si la conexión falla
    }
}
