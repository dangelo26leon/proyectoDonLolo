
package controlador;

import data_access_object.salaDAO;
import java.util.List;
import modelo.Sala;
import vista.frmPolleria;

public class salaControlador {
    private frmPolleria vista;
    private salaDAO data_access_object;
    
    public salaControlador(frmPolleria vista) {
        this.vista = vista;
        this.data_access_object = new salaDAO();
        this.vista.setControlador(this);
    }
    
    public void agregarSala(String nombre, int mesas) {
        Sala sala = new Sala();
        sala.setNombre(nombre); 
        sala.setMesa(mesas);    
        boolean insercionExitosa = data_access_object.registrarSala(sala);
    }
    
    public void cargarSalas() {
        List<Sala> salas = data_access_object.listarSalas();
    }
    
    public void actualizarSala(int id_sala, String nombre, int mesas) {
        Sala sala = new Sala(id_sala, nombre, mesas); 
        boolean actualizacionExitosa = data_access_object.modificarSala(sala); 
    }
    
    public void eliminarSala(int id_sala) {
        boolean eliminacionExitosa = data_access_object.eliminarSala(id_sala);
    }
    
    public void buscarSalaPorId(int id_sala) {
        List<Sala> salas = data_access_object.listarSalas();
        Sala salaEncontrada = salas.stream()
                                   .filter(s -> s.getId_sala() == id_sala)
                                   .findFirst()
                                   .orElse(null);
    }
}
