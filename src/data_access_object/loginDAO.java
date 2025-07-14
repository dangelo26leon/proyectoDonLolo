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
import modelo.Login;

/**
 *
 * @author leonv
 */
public class loginDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private conexion cn = new conexion(); // Conexión a la base de datos

    
    public Login log(String correo, String pass) {
        Login l = new Login();
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND password = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Si se encuentra el usuario, se asignan sus valores
                l.setId(rs.getInt("id"));
                l.setNombre(rs.getString("nombre"));
                l.setApellido(rs.getString("apellido"));
                l.setCorreo(rs.getString("correo"));
                l.setCelular(rs.getInt("celular"));
                l.setDni(rs.getInt("dni"));
                l.setGenero(rs.getString("genero"));
                l.setDireccion(rs.getString("direccion"));
                l.setPass(rs.getString("password"));
                l.setRol(rs.getString("rol"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l; // Retorna el objeto login con los datos del usuario autenticado
    }

    
    public boolean Registrar(Login reg) {
        String sql = "INSERT INTO usuarios (nombre, apellido, correo, celular, dni, genero, direccion, password, rol) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getNombre());
            ps.setString(2, reg.getApellido());
            ps.setString(3, reg.getCorreo());
            ps.setInt(4, reg.getCelular());
            ps.setInt(5, reg.getDni());
            ps.setString(6, reg.getGenero());
            ps.setString(7, reg.getDireccion());
            ps.setString(8, reg.getPass());
            ps.setString(9, reg.getRol());
            ps.execute(); // Ejecuta la inserción en la base de datos
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    
    public List<Login> ListarUsuarios() {
        List<Login> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Login lg = new Login();
                lg.setId(rs.getInt("id"));
                lg.setNombre(rs.getString("nombre"));
                lg.setApellido(rs.getString("apellido"));
                lg.setCorreo(rs.getString("correo"));
                lg.setPass(rs.getString("password"));
                lg.setCelular(rs.getInt("celular"));
                lg.setDni(rs.getInt("dni"));
                lg.setGenero(rs.getString("genero"));
                lg.setDireccion(rs.getString("direccion"));
                lg.setRol(rs.getString("rol"));
                lista.add(lg); // Agrega cada usuario a la lista
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista; // Retorna la lista de usuarios
    }

    
    public List<Login> listar(String valor) {
        List<Login> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios WHERE nombre LIKE ?"; // Consulta SQL para buscar usuarios por nombre
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + valor + "%"); // Usa LIKE para buscar coincidencias parciales
            rs = ps.executeQuery();

            while (rs.next()) {
                Login lg = new Login();
                lg.setId(rs.getInt("id"));
                lg.setNombre(rs.getString("nombre"));
                lg.setApellido(rs.getString("apellido"));
                lg.setCorreo(rs.getString("correo"));
                lg.setPass(rs.getString("password"));
                lg.setCelular(rs.getInt("celular"));
                lg.setDni(rs.getInt("dni"));
                lg.setGenero(rs.getString("genero"));
                lg.setDireccion(rs.getString("direccion"));
                lg.setRol(rs.getString("rol"));
                lista.add(lg); // Agrega cada usuario a la lista
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (con != null) con.close(); // Cierra la conexión a la base de datos
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        return lista; // Retorna la lista de usuarios encontrados
    }

    public boolean EditarUsuario(Login usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, correo = ?, celular = ?, dni = ?, genero = ?, direccion = ?, password = ?, rol = ? WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setInt(4, usuario.getCelular());
            ps.setInt(5, usuario.getDni());
            ps.setString(6, usuario.getGenero());
            ps.setString(7, usuario.getDireccion());
            ps.setString(8, usuario.getPass());
            ps.setString(9, usuario.getRol());
            ps.setInt(10, usuario.getId());
            return ps.executeUpdate() > 0; // Devuelve true si se actualizó al menos un registro
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean EliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0; // Devuelve true si se eliminó al menos un registro
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
}
