package Proyecto_Final.Red_Social.Servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import Proyecto_Final.Red_Social.Daos.Usuario;
import Proyecto_Final.Red_Social.Dtos.UsuarioDto;
@Service
public class UsuarioToDtoImplementacion implements UsuarioToDtoInterfaz {

	@Override
	public UsuarioDto usuarioToDto(Usuario u) {
		try {
			UsuarioDto dto = new UsuarioDto();
			dto.setNombreUsuario(u.getNombreUsuario());
			dto.setEmailUsuario(u.getEmailUsuario());
			dto.setTelefonoUsuario(u.getTelefonoUsuario());
			dto.setContraseñaUsuario(u.getContraseñaUsuario());
			dto.setToken(u.getToken());
			dto.setExpiracionToken(u.getExpiracionToken());
			dto.setAdmin(u.getAdmin());
			return dto;
		} catch (Exception e) {
			System.out.println(
					"\n[ERROR UsuarioToDtoImpl - usuarioToDto()] - Error al convertir usuario DAO a usuarioDTO (return null): "
							+ e);
			return null;
		}
	}

	@Override
	public List<UsuarioDto> listaUsuarioToDto(List<Usuario> listaUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
