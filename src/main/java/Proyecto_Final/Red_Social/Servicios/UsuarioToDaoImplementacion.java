package Proyecto_Final.Red_Social.Servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Proyecto_Final.Red_Social.Daos.Usuario;
import Proyecto_Final.Red_Social.Dtos.UsuarioDTO;
@Service
public class UsuarioToDaoImplementacion implements UsuarioToDaoInterfaz {

	@Override
	public Usuario usuarioToDao(UsuarioDTO usuarioDto) {
		Usuario usuarioDao = new Usuario();

		try {
			usuarioDao.setNombreCompletoUsuario(usuarioDto.getNombreCompletoUsuario());
			usuarioDao.setNombreCuentaUsuario(usuarioDto.getNombreCuentaUsuario());
			usuarioDao.setEmailUsuario(usuarioDto.getEmailUsuario());
			usuarioDao.setTelefonoUsuario(usuarioDto.getTelefonoUsuario());
			usuarioDao.setContraseñaUsuario(usuarioDto.getContraseñaUsuario());
			usuarioDao.setRol(usuarioDto.getRol());
			usuarioDao.setCuentaConfirmada(usuarioDto.isCuentaConfirmada());
			
			return usuarioDao;
		} 
		catch (Exception e) {
			System.out.println(
					"\n[ERROR UsuarioToDaoImpl - toUsuarioDao()] - Al convertir usuarioDTO a usuarioDAO (return null): "
							+ e);
			return null;
		}
	}
	
	@Override
	public List<Usuario> listUsuarioToDao(List<UsuarioDTO> listaUsuarioDTO) {

		List<Usuario> listaUsuarioDao = new ArrayList<>();

		try {
			for (UsuarioDTO usuarioDTO : listaUsuarioDTO) {
				listaUsuarioDao.add(usuarioToDao(usuarioDTO));
			}

			return listaUsuarioDao;
		}
		catch (Exception e) {
			System.out.println(
					"\n[ERROR UsuarioToDaoImpl - toListUsuarioDao()] - Al convertir lista de usuarioDTO a lista de usuarioDAO (return null): "
							+ e);
		}
		return null;
	}
}
