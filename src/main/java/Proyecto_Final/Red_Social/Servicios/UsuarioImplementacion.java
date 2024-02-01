package Proyecto_Final.Red_Social.Servicios;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
	/*
	@Autowired
	private UsuarioToDto toDto;
*/
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	/*
	@Autowired
	private EmailServicio emailServicio;
	*/
	
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

}
