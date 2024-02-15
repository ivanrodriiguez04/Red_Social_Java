package Proyecto_Final.Red_Social.Servicios;

import Proyecto_Final.Red_Social.Daos.Comentarios;
import Proyecto_Final.Red_Social.Dtos.ComentariosDTO;

public interface ComentarioToDaoInterfaz {
	/**
	 * Metodo que convierte campo a campo un objeto UsuarioDTO a DAO
	 * @param ausuarioDTO el objeto usuarioDTO
	 * @return Usuario convertido a DAO
	 */
	public Comentarios comentarioToDao(ComentariosDTO comentariosDTO);
}
