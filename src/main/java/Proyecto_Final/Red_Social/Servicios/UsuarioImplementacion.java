package Proyecto_Final.Red_Social.Servicios;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;

import Proyecto_Final.Red_Social.Daos.Usuario;
import Proyecto_Final.Red_Social.Dtos.UsuarioDto;
import Proyecto_Final.Red_Social.Repositorios.UsuarioRepositorio;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioImplementacion implements UsuarioInterfaz {
	@Autowired
	private UsuarioRepositorio repositorio;

	@Autowired
	private UsuarioToDaoInterfaz toDao;
	
	@Autowired
	private UsuarioToDtoInterfaz toDto;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private EmailInterfaz emailInterfaz;
	
	
	public UsuarioDto registrar(UsuarioDto userDto) {
		try {
			// Comprueba si ya existe un usuario con el email que quiere registrar
			Usuario usuarioDaoByEmail = repositorio.findFirstByEmailUsuario(userDto.getEmailUsuario());

			if (usuarioDaoByEmail != null) { 
				return null; // Si no es null es que ya está registrado
			}


			// Si llega a esta línea es que no existe el usuario con el email y el dni a registrar
			userDto.setContraseñaUsuario(passwordEncoder.encode(userDto.getContraseñaUsuario()));
			Usuario usuarioDao = toDao.usuarioToDao(userDto);
			usuarioDao.setFchAltaUsuario(Calendar.getInstance());
			repositorio.save(usuarioDao);

			return userDto;
		} catch (IllegalArgumentException iae) {
			System.out.println("[Error UsuarioServicioImpl - registrar() ]" + iae.getMessage());	
		} catch (Exception e) {
			System.out.println("[Error UsuarioServicioImpl - registrar() ]" + e.getMessage());
		}
		return null;
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		return repositorio.findFirstByEmailUsuario(email);
	}

	@Override
	public boolean iniciarResetPassConEmail(String emailUsuario) {
		try {
			Usuario usuarioExistente = repositorio.findFirstByEmailUsuario(emailUsuario);
	
			if (usuarioExistente != null) {
				// Generar el token y establece la fecha de expiración
				String token = passwordEncoder.encode(RandomStringUtils.random(30));
				Calendar fechaExpiracion = Calendar.getInstance();
				fechaExpiracion.add(Calendar.MINUTE, 10);
				// Actualizar el usuario con el nuevo token y la fecha de expiración
				usuarioExistente.setToken(token);
				usuarioExistente.setExpiracionToken(fechaExpiracion);

				//Actualizar el usuario en la base de datos
				repositorio.save(usuarioExistente);

				//Enviar el correo de recuperación
				String nombreUsuario = usuarioExistente.getNombreUsuario();
				emailInterfaz.enviarEmailRecuperacion(emailUsuario, nombreUsuario, token);
				
				return true;

			} else {
				System.out.println("[Error iniciarRecuperacionConEmail() ]El usuario con email "+ emailUsuario +" no existe");
				return false;		}
		} catch (IllegalArgumentException iae) {
			System.out.println("[Error UsuarioServicioImpl - registrar() ]" + iae.getMessage());
			return false;
		}  catch (Exception e) {	
			System.out.println("[Error UsuarioServicioImpl - iniciarRecuperacionConEmail()]"+ e.getMessage());
			return false;
		}
	}

	@Override
	public boolean modificarContraseñaConToken(UsuarioDto usuario) {
		Usuario usuarioExistente = repositorio.findByToken(usuario.getToken());
		
		if(usuarioExistente != null) {
			String nuevaContraseña = passwordEncoder.encode(usuario.getContraseñaUsuario());
			usuarioExistente.setContraseñaUsuario(nuevaContraseña);
			usuarioExistente.setToken(null); //Se setea a null para invalidar el token ya consumido al cambiar de password
			repositorio.save(usuarioExistente);
			
			return true;
		}
		
		return false;
	}

	@Override
	public UsuarioDto obtenerUsuarioPorToken(String token) {
		Usuario usuarioExistente = repositorio.findByToken(token);
		
		if(usuarioExistente != null) {
			UsuarioDto usuario = toDto.usuarioToDto(usuarioExistente);
			return usuario;
		} else {
			System.out.println("No existe el usuario con el token "+token);
			return null;
		}
	}

}
