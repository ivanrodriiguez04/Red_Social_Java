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
	
	/**
	 * Inicia el proceso de recuperacion (generando token y vencimiento) con el email del usuario 
	 * @param emailUsuario El email del usuario a recuperar la contraseña
	 * @return true si el proceso se ha iniciado correctamente, false en caso contrario
	 */
	public boolean iniciarResetPassConEmail(String emailUsuario);
	
	/**
	 * Establece la nueva contraseña del usuario con el token
	 * @param usuario El usuario al que se le establecera la nueva contraseña
	 * @return true si el proceso se ha realizado correctamente, false en caso contrario
	 */
	public boolean modificarContraseñaConToken(UsuarioDto usuario);
	
	/**
	 * Busca un usuario por su token de recuperación.
	 * @param token que identifica al usuario recibió un correo con la url y dicho token
	 * @return el usuario buscado
	 */
	public UsuarioDto obtenerUsuarioPorToken(String token);


}
