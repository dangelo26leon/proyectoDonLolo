/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_object;

import conf.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Sala;

/**
 *
 * @author leonv
 */
public class salaDAO {
    
    private Connection con;  // Conexión a la base de datos
    private PreparedStatement ps;  // Sentencia SQL preparada
    private ResultSet rs;  // Resultados de la consulta
    private final conexion cn = new conexion();  // Objeto para la conexión a la base de datos

    
    public boolean registrarSala(Sala sala) {
        String sql = "INSERT INTO sala(nombre, mesa) VALUES (?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sala.getNombre());
            ps.setInt(2, sala.getMesa());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar sala: " + e.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }
    
    
    public List<Sala> listarSalas() {
        List<Sala> lista = new ArrayList<>();
        String sql = "SELECT * FROM sala";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sala sala = new Sala();
                sala.setId_sala(rs.getInt("id_sala"));
                sala.setNombre(rs.getString("nombre"));
                sala.setMesa(rs.getInt("mesa"));
                lista.add(sala);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar salas: " + e.toString());
        } finally {
            cerrarConexion();
        }
        return lista;
    }
    
    
    public boolean eliminarSala(int id_sala) {
        String sql = "DELETE FROM sala WHERE id_sala = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_sala);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar sala: " + e.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }
    
    
    
    public boolean modificarSala(Sala sala) {
        String sql = "UPDATE sala SET nombre = ?, mesa = ? WHERE id_sala = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sala.getNombre());
            ps.setInt(2, sala.getMesa());
            ps.setInt(3, sala.getId_sala());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar sala: " + e.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }
    
    
    private void cerrarConexion() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.toString());
        }
    }
}
