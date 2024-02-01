package Proyecto_Final.Red_Social.Servicios;

import org.springframework.stereotype.Service;

import Proyecto_Final.Red_Social.Daos.Usuario;
import Proyecto_Final.Red_Social.Dtos.UsuarioDto;
@Service
public class UsuarioToDaoImplementacion implements UsuarioToDaoInterfaz {

	@Override
	public Usuario usuarioToDao(UsuarioDto usuarioDto) {
		Usuario usuarioDao = new Usuario();

		try {
			usuarioDao.setNombreUsuario(usuarioDto.getNombreUsuario());
			usuarioDao.setEmailUsuario(usuarioDto.getEmailUsuario());
			usuarioDao.setContraseñaUsuario(usuarioDto.getContraseñaUsuario());
			
			return usuarioDao;

		} catch (Exception e) {
			System.out.println(
					"\n[ERROR UsuarioToDaoImpl - toUsuarioDao()] - Al convertir usuarioDTO a usuarioDAO (return null): "
							+ e);
			return null;
		}

	}
}
