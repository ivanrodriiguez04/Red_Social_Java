package Proyecto_Final.Red_Social.Servicios;

import java.util.List;

import Proyecto_Final.Red_Social.Daos.Comentarios;
import Proyecto_Final.Red_Social.Dtos.ComentariosDTO;

public interface ComentarioToDtoInterfaz {
ComentariosDTO comentarioToDto(Comentarios comentarios);
	
	public List<ComentariosDTO> listaComentariosToDto(List<Comentarios> listaComentarios);
}
