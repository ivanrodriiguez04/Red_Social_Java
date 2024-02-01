package Proyecto_Final.Red_Social.Servicios;

import Proyecto_Final.Red_Social.Daos.Usuario;
import Proyecto_Final.Red_Social.Dtos.UsuarioDto;

public interface UsuarioToDaoInterfaz {
	/**
	 * Metodo que convierte campo a campo un objeto UsuarioDTO a DAO
	 * @param ausuarioDTO el objeto usuarioDTO
	 * @return Usuario convertido a DAO
	 */
	public Usuario usuarioToDao(UsuarioDto usuarioDto);
}
