package Proyecto_Final.Red_Social.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import Proyecto_Final.Red_Social.Daos.Usuario;

public interface usuarioRepositorio extends JpaRepository<Usuario,Long> {

	/**
	 * Busca al primer usuario que tiene la dirección de correo electrónico especificada
	 * @param email La dirección de correo electrónico del usuario a buscar.
	 * @return El primer usuario encontrado con la dirección de correo electrónico
	 *         especificada o null en caso contrario.
	 */
	public Usuario findFirstByEmailUsuario(String email);
	
	/**
	 * Busca un usuario por su token de recuperación.
	 * @param token de recuperacion del usuario que se le estableció cuando se inicio el proceso de recuperacion
	 * @return el usuario buscado por el token
	 */
	public Usuario findByToken(String token);
}
