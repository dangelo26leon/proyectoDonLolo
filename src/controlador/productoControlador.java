
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

public class productoControlador {
    private List<Producto> productos;
    
    public productoControlador(){
        this.productos = new ArrayList<>();
    }
    
    public boolean agregarProducto(Producto producto){
        return productos.add(producto);
    }
    
    public boolean eliminarProducto(int id_producto) {
        Producto producto = buscarProductoPorId(id_producto);
        if (producto != null) {
            return productos.remove(producto); 
        }
        return false; 
    }
    
    public boolean actualizarProducto(Producto productoActualizado) {
        Producto producto = buscarProductoPorId(productoActualizado.getId_producto());
        if (producto != null) {
            producto.setNom_producto(productoActualizado.getNom_producto());
            producto.setTipoPlato(productoActualizado.getTipoPlato());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setDescripcion(productoActualizado.getDescripcion());
            return true; 
        }
        return false;
    }
    
    public Producto buscarProductoPorId(int id_producto) {
        for (Producto producto : productos) {
            if (producto.getId_producto() == id_producto) {
                return producto; 
            }
        }
        return null; 
    }
    
    public List<Producto> obtenerProductos(){
        return productos;
    }
    
    public List<Producto> buscarProductoPorNombre(String nombre) {
        List<Producto> productosEncontrados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getNom_producto().toLowerCase().contains(nombre.toLowerCase())){
                productosEncontrados.add(producto);
            }
        }
        return productosEncontrados;
    }
    
    public List<Producto> obtenerProductosPorTipo(String tipoPlato) {
        List<Producto> productosPorTipo = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getTipoPlato().equalsIgnoreCase(tipoPlato)) {
                productosPorTipo.add(producto);
            }
        }
        return productosPorTipo;
    }
}
