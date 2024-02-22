package Proyecto_Final.Red_Social.Servicios;

import java.util.List;

import Proyecto_Final.Red_Social.Daos.Usuario;
import Proyecto_Final.Red_Social.Dtos.UsuarioDTO;

public interface UsuarioToDaoInterfaz {
	/**
	 * Metodo que convierte campo a campo un objeto UsuarioDTO a DAO
	 * @param ausuarioDTO el objeto usuarioDTO
	 * @return Usuario convertido a DAO
	 */
	public Usuario usuarioToDao(UsuarioDTO usuarioDto);
	
	/**
	 * Metodo que convierte toda una lista de objetos UsuarioDTO a lista de DAOs
	 * @param listaUsuarioDTO lista cargadas de objetos usuarioDTO
	 * @return Lista de usuarios DAO
	 */
	public List<Usuario> listUsuarioToDao(List<UsuarioDTO>listaUsuarioDTO);
}
