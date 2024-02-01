package Proyecto_Final.Red_Social.Servicios;

import Proyecto_Final.Red_Social.Daos.Usuario;
import Proyecto_Final.Red_Social.Dtos.UsuarioDto;

public interface UsuarioInterfaz {
	/**
	 * Se registra a un usuario antes comprobando si ya se encuentra en la BBDD registrado el usuario
	 * @param userDTO El usuario a registrar
	 * @return El usuario registrado
	 */
	public UsuarioDto registrar(UsuarioDto userDTO);
	/**
	 * Busca a un usuario por su dirección de email registrada
	 * @param email del usario que se quiere encontrar
	 * @return El usuario buscado
	 */
	public Usuario buscarPorEmail(String email);

}
