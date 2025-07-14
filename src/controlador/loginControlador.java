
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Login;


public class loginControlador {
    private List<Login> usuarios;
    
    public loginControlador(){
        this.usuarios = new ArrayList<>();
    }
    
    public boolean agregarUsuario(Login usuario){
        for(Login u : usuarios){
            if(u.getCorreo().equals(usuario.getCorreo())){
                return false;
            }
        }
        return usuarios.add(usuario);
    }
    
    public boolean eliminarUsuario(int id){
        Login usuario = buscarUsuarioPorId(id);
        if (usuario != null){
            return usuarios.remove(usuario);
        }
        return false;
    }
    
    public boolean actualizarUsuario(Login usuarioActualizado){
        Login usuario = buscarUsuarioPorId(usuarioActualizado.getId());
        if (usuario != null){
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setApellido(usuarioActualizado.getApellido());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            usuario.setCelular(usuarioActualizado.getCelular());
            usuario.setCelular(usuarioActualizado.getCelular());
            usuario.setDni(usuarioActualizado.getDni());
            usuario.setGenero(usuarioActualizado.getGenero());
            usuario.setDireccion(usuarioActualizado.getDireccion());
            usuario.setPass(usuarioActualizado.getPass());
            usuario.setRol(usuarioActualizado.getRol());
            return true;
        }
        return false;
    }
    
    public Login buscarUsuarioPorId(int id){
        for (Login usuario : usuarios){
            if(usuario.getId() == id){
                return usuario;
            }
        }
        return null;
    }
    
    public List<Login> obtenerUsuarios(){
        return usuarios;
    }
    
    public boolean verificarLogin(String correo, String password){
        for (Login usuario : usuarios){
            if (usuario.getCorreo().equals(correo) && usuario.getPass().equals(password)){
                return true;
            }
        }
        return false;
    }
    
    public List<Login> obtenerUsuariosPorRol(String rol) {
        List<Login> usuariosPorRol = new ArrayList<>();
        for (Login usuario : usuarios) {
            if (usuario.getRol().equalsIgnoreCase(rol)) {
                usuariosPorRol.add(usuario);
            }
        }
        return usuariosPorRol;
    }
}
