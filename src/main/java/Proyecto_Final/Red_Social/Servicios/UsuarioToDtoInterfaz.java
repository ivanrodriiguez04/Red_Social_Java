package Proyecto_Final.Red_Social.Servicios;

import java.util.List;

import Proyecto_Final.Red_Social.Daos.Usuario;
import Proyecto_Final.Red_Social.Dtos.UsuarioDto;

public interface UsuarioToDtoInterfaz {
	/**
	 * Método que convierte campo a campo un objeto entidad Usuario a usuarioDTO
	 * @param u El usuario a transformar
	 * @return El DTO del usuario
	 */
	public UsuarioDto usuarioToDto(Usuario u);
	
	/**
	 * Metodo que convierte todos los objetos entidad usuario DAO a una lista UsuarioDTO 
	 * @param listaUsuario
	 * @return
	 */
	public List<UsuarioDto> listaUsuarioToDto(List<Usuario> listaUsuario);

}
