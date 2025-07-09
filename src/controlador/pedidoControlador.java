
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Pedido;

public class pedidoControlador {
    private List<Pedido> pedidos;
    
    public pedidoControlador(){
        this.pedidos = new ArrayList<>();
    }
    
    public boolean agregarPedido(Pedido pedido){
        return pedidos.add(pedido);
    }
    
    public boolean eliminarPedido(int id) {
        Pedido pedido = buscarPedidoPorId(id); 
        if (pedido != null) {
            return pedidos.remove(pedido); 
        }
        return false; 
    }
    
    public boolean actualizarPedido(Pedido pedidoActualizado){
        Pedido pedido = buscarPedidoPorId(pedidoActualizado.getId());
        if (pedido != null){
            pedido.setId_sala(pedidoActualizado.getId_sala());
            pedido.setNum_mesa(pedidoActualizado.getNum_mesa());
            pedido.setFecha(pedidoActualizado.getFecha());
            pedido.setTotal(pedidoActualizado.getTotal());
            pedido.setSala(pedidoActualizado.getSala());
            pedido.setUsuario(pedidoActualizado.getUsuario());
            pedido.setEstado(pedidoActualizado.getEstado());
            return true;
        }
        return false;
    }
    
    public Pedido buscarPedidoPorId(int id){
        for (Pedido pedido : pedidos){
            if (pedido.getId() == id){
                return pedido;
            }
        }
        return null;
    }
    
    public List<Pedido> obtenerPedidos(){
        return pedidos;
    }
    
    public List<Pedido> obtenerPedidosPorEstado(String estado) {
        List<Pedido> pedidosPorEstado = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado().equalsIgnoreCase(estado)) {
                pedidosPorEstado.add(pedido); 
            }
        }
        return pedidosPorEstado;
    }
    
    public List<Pedido> obtenerPedidosPorSala(String sala) {
        List<Pedido> pedidosPorSala = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getSala().equalsIgnoreCase(sala)) {
                pedidosPorSala.add(pedido); // Agrega el pedido si coincide con la sala
            }
        }
        return pedidosPorSala;
    }
    
    public List<Pedido> obtenerPedidosPorFecha(String fecha) {
        List<Pedido> pedidosPorFecha = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getFecha().equalsIgnoreCase(fecha)) {
                pedidosPorFecha.add(pedido); // Agrega el pedido si coincide con la fecha
            }
        }
        return pedidosPorFecha;
    }
}
