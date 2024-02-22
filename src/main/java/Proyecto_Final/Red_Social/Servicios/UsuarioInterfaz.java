package Proyecto_Final.Red_Social.Servicios;

import java.util.List;

import Proyecto_Final.Red_Social.Daos.Usuario;
import Proyecto_Final.Red_Social.Dtos.TokenDTO;
import Proyecto_Final.Red_Social.Dtos.UsuarioDTO;

public interface UsuarioInterfaz {
	
	/**
	 * Se registra a un usuario antes comprobando si ya se encuentra en la BBDD registrado el usuario
	 * @param userDTO El usuario a registrar
	 * @return El usuario registrado
	 */
	public UsuarioDTO registrar(UsuarioDTO userDTO);
	
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
	public boolean modificarContraseñaConToken(TokenDTO token);
	
	/**
	 * Busca un usuario por su token de recuperación.
	 * @param token que identifica al usuario recibió un correo con la url y dicho token
	 * @return el usuario buscado
	 */
	public UsuarioDTO obtenerUsuarioPorToken(String token);

	/**
	 * Busca a un usuario por su identificador asignado en la bbdd
	 * @param id del usuario a buscar
	 * @return El usuario buscado
	 */
	public Usuario buscarPorId(long id);
	/**
	 * Busca todos los usuarios registrados
	 * @return la lista de todos los usuariosDTO
	 */
	public List<UsuarioDTO> buscarTodos();
	/**
	 * Elimina un usuario por su identificador
	 * @param id del usuario
	 * @return el usuario eliminado o null si no existe
	 */
	public Usuario eliminar(long id);
	
	
	public void actualizarUsuario(UsuarioDTO usuarioDTO);
	/**
     * Método para buscar un usuario por ID.
     * @param id Identificador del usuario.
     * @return El DTO del usuario encontrado o null si no existe.
     */
	
    public UsuarioDTO buscarDtoPorId(Long id);
    
    /**
	 * Comprueba si el usuario existe y si su cuenta ha sido confirmada
	 * @param email El email del usuario
	 * @return true si el usuario existe y su cuenta ha sido confirmada, false en caso contrario
	 */
	public boolean estaLaCuentaConfirmada(String email);

	boolean confirmarCuenta(String token);
}
