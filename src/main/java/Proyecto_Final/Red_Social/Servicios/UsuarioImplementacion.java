package Proyecto_Final.Red_Social.Servicios;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;

import Proyecto_Final.Red_Social.Daos.Usuario;
import Proyecto_Final.Red_Social.Dtos.UsuarioDTO;
import Proyecto_Final.Red_Social.Repositorios.usuarioRepositorio;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioImplementacion implements UsuarioInterfaz {
	@Autowired
	private usuarioRepositorio repositorio;
	@Autowired
	private UsuarioToDaoInterfaz toDao;
	
	@Autowired
	private UsuarioToDtoInterfaz toDto;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private EmailInterfaz emailInterfaz;
	
	
	public UsuarioDTO registrar(UsuarioDTO userDto) {
		try {
			// Comprueba si ya existe un usuario con el email que quiere registrar
			Usuario usuarioDaoByEmail = repositorio.findFirstByEmailUsuario(userDto.getEmailUsuario());

			if (usuarioDaoByEmail != null) { 
				return null; // Si no es null es que ya está registrado
			}


			// Si llega a esta línea es que no existe el usuario con el email 
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
				fechaExpiracion.add(Calendar.MINUTE, 3);
				// Actualizar el usuario con el nuevo token y la fecha de expiración
				usuarioExistente.setToken(token);
				usuarioExistente.setExpiracionToken(fechaExpiracion);

				//Actualizar el usuario en la base de datos
				repositorio.save(usuarioExistente);

				//Enviar el correo de recuperación
				String nombreUsuario = usuarioExistente.getNombreCompletoUsuario();
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
	public boolean modificarContraseñaConToken(UsuarioDTO usuario) {
		Usuario usuarioExistente = repositorio.findByToken(usuario.getToken());
		
		if(usuarioExistente != null) {
			String nuevaContraseña = passwordEncoder.encode(usuarioExistente.getContraseñaUsuario());
			usuarioExistente.setContraseñaUsuario(nuevaContraseña);
			repositorio.save(usuarioExistente);
			
			return true;
		}
		
		return false;
	}

	@Override
	public UsuarioDTO obtenerUsuarioPorToken(String token) {
		Usuario usuarioExistente = repositorio.findByToken(token);
		
		if(usuarioExistente != null) {
			return toDto.usuarioToDto(usuarioExistente);
		} else {
			System.out.println("No existe el usuario con el token "+token);
			return null;
		}
	}

	@Override
	public Usuario eliminar(long id) {
		try {
			Usuario usuario = repositorio.findById(id).orElse(null);
			if (usuario != null) {
				repositorio.delete(usuario);
				System.out.println("Borrado con exito");
			}
			return usuario;
		} catch (Exception e) {
			System.out.println("[IMPL-Usu][eliminar] " + e.getMessage());
			return null;
		}
	}

	@Override
	public void actualizarUsuario(UsuarioDTO usuarioDTO) {
		try {
			// Convierte el DTO a entidad DAO
			Usuario usuarioDao = toDao.usuarioToDao(usuarioDTO);
			// Actualiza la información en la base de datos
			Usuario usuarioActualizado = repositorio.save(usuarioDao);
			// Actualiza el DTO con la información de la base de datos
			UsuarioDTO usuarioDtoActualizado = toDto.usuarioToDto(usuarioActualizado);

		} catch (IllegalArgumentException iae) {
			System.out.println("[IMPL-Usu][actualizarUsuario] " + iae.getMessage());
		} catch (Exception e) {
			System.out.println("[IMPL-Usu][actualizarUsuario] " + e.getMessage());
		}
		
	}

	@Override
	public UsuarioDTO buscarDtoPorId(Long id) {
		// TODO Auto-generated method stub
		try {
			Usuario usuarioDao = repositorio.findById(id).orElse(null);
			if (usuarioDao != null) {
				return toDto.usuarioToDto(usuarioDao);
			}
		} catch (Exception e) {
			System.out.println("[IMPL-Usu][buscarDtoPorId] " + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean estaLaCuentaConfirmada(String email) {
		try {
			Usuario usuarioExistente = repositorio.findFirstByEmailUsuario(email);
			if (usuarioExistente != null && usuarioExistente.isCuentaConfirmada()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("[Error ImplementacionUsuario - estaLaCuentaConfirmada()] Error al comprobar si la cuenta ya ha sido confirmada" + e.getMessage());
		}	
		return false;
	}

	@Override
	public boolean confirmarCuenta(String token) {
		try {
			Usuario usuarioExistente = repositorio.findByToken(token);

			if (usuarioExistente != null && !usuarioExistente.isCuentaConfirmada()) {
				// Entra en esta condición si el usuario existe y su cuenta no se ha confirmado
				usuarioExistente.setCuentaConfirmada(true);
				usuarioExistente.setToken(null);
				repositorio.save(usuarioExistente);

				return true;
			} else {
				System.out.println("La cuenta no existe o ya está confirmada");
				return false;
			}
		} catch (IllegalArgumentException iae) {
			System.out.println("[Error ImplementacionUsuario - confirmarCuenta()] Error al confirmar la cuenta " + iae.getMessage());
			return false;
		} catch (PersistenceException e) {
			System.out.println("[Error ImplementacionUsuario - confirmarCuenta()] Error de persistencia al confirmar la cuenta" + e.getMessage());
			return false;
		}
	}
	@Override
	public List<UsuarioDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Usuario buscarPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
