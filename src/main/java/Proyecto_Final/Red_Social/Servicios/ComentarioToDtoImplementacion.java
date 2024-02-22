package Proyecto_Final.Red_Social.Servicios;

import java.util.ArrayList;
import java.util.List;

import Proyecto_Final.Red_Social.Daos.Comentarios;
import Proyecto_Final.Red_Social.Dtos.ComentariosDTO;

public class ComentarioToDtoImplementacion implements ComentarioToDtoInterfaz {

	@Override
	public ComentariosDTO comentarioToDto(Comentarios comentarios) {
		ComentariosDTO comentariosDTO = new ComentariosDTO();
	    comentariosDTO.setId_Comentario(comentarios.getId_Comentario());
	    comentariosDTO.setDesc_Comentario(comentarios.getDesc_Comentario());
	    comentariosDTO.setFch_Alta_Comentario(comentarios.getFch_Alta_Comentario());
	    comentariosDTO.setComentarioUsuario(comentarios.getComentarioUsuario());
	    // Si necesitas mapear las relaciones con otras entidades, aquí lo harías
	    
	    return comentariosDTO;
	}

	@Override
	public List<ComentariosDTO> listaComentariosToDto(List<Comentarios> listaComentarios) {
try {
			
			List<ComentariosDTO> listaDto = new ArrayList<>();
			for (Comentarios u : listaComentarios) {
				listaDto.add(this.comentarioToDto(u));
			}
			return listaDto;

		} catch (Exception e) {
			System.out.println(
					"\n[ERROR UsuarioToDtoImpl - listauUsuarioToDto()] - Error al convertir lista de usuario DAO a lista de usuarioDTO (return null): "
							+ e);
		}
		return null;
	}

}
