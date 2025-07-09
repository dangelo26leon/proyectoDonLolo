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
import modelo.Producto;

/**
 *
 * @author leonv
 */
public class productoDAO {
    
    private Connection con;
    private final conexion cn = new conexion();
    private PreparedStatement ps;
    private ResultSet rs;
    
    
    
    public boolean registrar(Producto producto) {
        String sql = "INSERT INTO producto (nom_producto, tipoPlato, descripcion, precio) VALUES (?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNom_producto());
            ps.setString(2, producto.getTipoPlato());
            ps.setString(3, producto.getDescripcion());
            ps.setDouble(4, producto.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }
    
    
    
    public List<Producto> listar(String valor) {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE nom_producto LIKE ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + valor + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNom_producto(rs.getString("nom_producto"));
                producto.setTipoPlato(rs.getString("tipoPlato"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                lista.add(producto);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            cerrarConexion();
        }
        return lista;
    }
    
    
    public boolean eliminar(int id_producto) {
        String sql = "DELETE FROM producto WHERE id_producto = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_producto);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }
    
    
    
    public boolean modificar(Producto producto) {
        String sql = "UPDATE producto SET nom_producto=?, tipoPlato=?, descripcion=?, precio=? WHERE id_producto=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNom_producto());
            ps.setString(2, producto.getTipoPlato());
            ps.setString(3, producto.getDescripcion());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getId_producto());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
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
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    
}
