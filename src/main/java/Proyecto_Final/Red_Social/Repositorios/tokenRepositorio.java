package Proyecto_Final.Red_Social.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import Proyecto_Final.Red_Social.Daos.Token;

public interface tokenRepositorio extends JpaRepository<Token,Long> {
	/**
	 * Busca un usuario por su token de recuperación.
	 * @param token de recuperacion del usuario que se le estableció cuando se inicio el proceso de recuperacion
	 * @return el usuario buscado por el token
	 */
	public Token findByToken(String token);
}
