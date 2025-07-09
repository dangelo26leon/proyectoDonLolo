/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_object;

import modelo.Pedido;
import conf.conexion;
import modelo.DetallePedido;
import modelo.Sala;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author leonv
 */
public class pedidoDAO {
    private Connection con;
    private conexion cn = new conexion(); // Conexión a la base de datos

    
    public int obtenerUltimoIdPedido() {
        int id = 0;
        String sql = "SELECT MAX(id_pedido) FROM pedido";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo el último ID de pedido: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return id;
    }

    
    public int verificarEstadoPedido(int mesa, int idSala) {
        int idPedido = 0;
        String sql = "SELECT id_pedido FROM pedido WHERE num_mesa = ? AND id_sala = ? AND estado = ?";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mesa);
            ps.setInt(2, idSala);
            ps.setString(3, "PENDIENTE");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idPedido = rs.getInt("id_pedido");
            }
        } catch (SQLException e) {
            System.out.println("Error verificando el estado del pedido: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return idPedido;
    }

    
    public boolean verificarEstadoDetallePedido(int idPedido) {
        boolean existePendiente = false;
        String sql = "SELECT id FROM detalle_pedido WHERE id_pedido = ? AND estado = ?";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);  // ID del pedido
            ps.setString(2, "EN PROCESO"); // Estado a verificar
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existePendiente = true; // Si hay un registro, devuelve true
            }
        } catch (SQLException e) {
            System.out.println("Error verificando el estado de detalle_pedido: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return existePendiente;
    }

  
    public boolean actualizarEstado(int id_pedido) {
        String sql = "UPDATE pedido SET estado = ? WHERE id_pedido = ?";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "FINALIZADO");
            ps.setInt(2, id_pedido);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el estado: " + e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e.toString());
            }
        }
    }

    
    public int registrarPedido(Pedido pedido) {
        String sql = "INSERT INTO pedido (id_sala, num_mesa, total, usuario) VALUES (?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getId_sala());
            ps.setInt(2, pedido.getNum_mesa());
            ps.setDouble(3, pedido.getTotal());
            ps.setString(4, pedido.getUsuario());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error registrando el pedido: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return 1;
    }

   
    public boolean verificarDetallesRealizados(int id_pedido) {
        String sql = "SELECT COUNT(*) FROM detalle_pedido WHERE id_pedido = ? AND estado != 'REALIZADO'";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_pedido);
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Error al verificar detalles del pedido: " + e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e.toString());
            }
        }
    }

    
    public int registrarDetallePedido(DetallePedido detalle) {
        String sql = "INSERT INTO detalle_pedido (nombre, tipoPlato, precio, cantidad, comentario, id_pedido) VALUES (?, ?, ?, ?, ?, ?)";
        int resultado = 0; // Indicador de éxito
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, detalle.getNombre());
            ps.setString(2, detalle.getTipoPlato());
            ps.setDouble(3, detalle.getPrecio());
            ps.setInt(4, detalle.getCantidad());
            ps.setString(5, detalle.getComentario());
            ps.setInt(6, detalle.getId_pedido());
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error registrando el detalle del pedido: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e.getMessage());
            }
        }
        return resultado;
    }

    
    public List<DetallePedido> obtenerDetallesPedido(int idPedido) {
        List<DetallePedido> listaDetalles = new ArrayList<>();
        String sql = "SELECT * FROM detalle_pedido WHERE id_pedido = ?";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido); // Establece el ID del pedido como parámetro
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DetallePedido detalle = new DetallePedido();
                detalle.setId_detallepedido(rs.getInt("id"));
                detalle.setNombre(rs.getString("nombre"));
                detalle.setTipoPlato(rs.getString("tipoPlato"));
                detalle.setPrecio(rs.getDouble("precio"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setComentario(rs.getString("comentario"));
                detalle.setId_pedido(rs.getInt("id_pedido"));
                detalle.setEstado(rs.getString("estado"));

                listaDetalles.add(detalle);
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo detalles del pedido: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e.getMessage());
            }
        }
        return listaDetalles;
    }

    
    public Pedido obtenerPedido(int idPedido) {
        Pedido pedido = null;
        String sql = "SELECT p.id_pedido, p.fecha, p.total, p.estado, p.usuario, p.id_sala, p.num_mesa, s.nombre AS sala "
                + "FROM pedido p "
                + "INNER JOIN sala s ON p.id_sala = s.id_sala "
                + "WHERE p.id_pedido = ?";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pedido = new Pedido();
                pedido.setId(rs.getInt("id_pedido"));
                pedido.setFecha(rs.getString("fecha"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setEstado(rs.getString("estado"));
                pedido.setUsuario(rs.getString("usuario"));
                pedido.setId_sala(rs.getInt("id_sala"));
                pedido.setNum_mesa(rs.getInt("num_mesa"));
                pedido.setSala(rs.getString("sala"));
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo el pedido: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return pedido;
    }

    
    public boolean finalizarPedido(int idPedido) {
        String sql = "UPDATE pedido SET estado = 'FINALIZADO' WHERE id_pedido = ?";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error finalizando el pedido: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return false;
    }

   
    public boolean cambiarEstadoDetalle(int idDetalle, String nuevoEstado) {
        String sql = "UPDATE detalle_pedido SET estado = ? WHERE id = ?";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevoEstado); // Estado nuevo ("REALIZADO")
            ps.setInt(2, idDetalle);      // ID del detalle_pedido
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error cambiando el estado del detalle_pedido: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return false;
    }

    
    public List<Pedido> listarPedidos() {
        List<Pedido> listaPedidos = new ArrayList<>();
        String sql = "SELECT p.id_pedido, p.fecha, p.total, p.estado, p.usuario, s.nombre AS sala, p.num_mesa, p.id_sala "
                + "FROM pedido p "
                + "INNER JOIN sala s ON p.id_sala = s.id_sala ORDER BY p.fecha DESC";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id_pedido"));
                pedido.setFecha(rs.getString("fecha"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setEstado(rs.getString("estado"));
                pedido.setUsuario(rs.getString("usuario"));
                pedido.setSala(rs.getString("sala"));
                pedido.setNum_mesa(rs.getInt("num_mesa"));
                pedido.setId_sala(rs.getInt("id_sala"));
                listaPedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println("Error listando los pedidos: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return listaPedidos;
    }

    
    public List<DetallePedido> listarDetallesPedido() {
        List<DetallePedido> listaDetalles = new ArrayList<>();
        String sql = "SELECT dp.id, dp.nombre, dp.tipoPlato, dp.precio, dp.cantidad, dp.comentario, dp.id_pedido, dp.estado "
                + "FROM detalle_pedido dp ORDER BY dp.id ASC";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetallePedido detalle = new DetallePedido();
                detalle.setId_detallepedido(rs.getInt("id"));
                detalle.setNombre(rs.getString("nombre"));
                detalle.setTipoPlato(rs.getString("tipoPlato"));
                detalle.setPrecio(rs.getDouble("precio"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setComentario(rs.getString("comentario"));
                detalle.setId_pedido(rs.getInt("id_pedido"));
                detalle.setEstado(rs.getString("estado"));
                listaDetalles.add(detalle);
            }
        } catch (SQLException e) {
            System.out.println("Error listando los detalles de pedido: " + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return listaDetalles;
    }

   
    public boolean actualizarEstadoPedido(int idPedido, String estado) {
        String sql = "UPDATE pedido SET estado = ? WHERE id_pedido = ?";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, idPedido);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error actualizando el estado del pedido: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return false;
    }
    
}
