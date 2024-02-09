package Proyecto_Final.Red_Social.Servicios;

import java.util.List;

import Proyecto_Final.Red_Social.Daos.Usuario;
import Proyecto_Final.Red_Social.Dtos.UsuarioDTO;

public interface UsuarioToDtoInterfaz {
	/**
	 * Método que convierte campo a campo un objeto entidad Usuario a usuarioDTO
	 * @param u El usuario a transformar
	 * @return El DTO del usuario
	 */
	public UsuarioDTO usuarioToDto(Usuario u);
	
	/**
	 * Metodo que convierte todos los objetos entidad usuario DAO a una lista UsuarioDTO 
	 * @param listaUsuario
	 * @return
	 */
	public List<UsuarioDTO> listaUsuarioToDto(List<Usuario> listaUsuario);

}
