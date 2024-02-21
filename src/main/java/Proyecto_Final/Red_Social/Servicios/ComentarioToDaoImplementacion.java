/*package Proyecto_Final.Red_Social.Servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import Proyecto_Final.Red_Social.Daos.Comentarios;
import Proyecto_Final.Red_Social.Dtos.ComentariosDTO;

@Service
public class ComentarioToDaoImplementacion implements ComentarioToDaoInterfaz {
	@Override
	public Comentarios comentarioToDao(ComentariosDTO comentariosDTO) {
		 if (comentariosDTO == null) {
	            return null;
	        }
	        
	        Comentarios comentario = new Comentarios();
	        comentario.setId_Comentario(comentariosDTO.getId_Comentario());
	        comentario.setDesc_Comentario(comentariosDTO.getDesc_Comentario());
	        System.out.println(comentariosDTO.getDesc_Comentario());
	        comentario.setFch_Alta_Comentario(comentariosDTO.getDesc_Comentario());

	        if (comentariosDTO.getComentarioUsuario() != null) {
	            comentario.setComentarioUsuario(comentariosDTO.getComentarioUsuario());
	        } else {
	            // Si es null, inicializarla como una lista vacía
	            comentario.setComentarioUsuario(new ArrayList<>());
	            System.out.println("Inicializada la lista de usuuarios");
	        }
	        // Si necesitas mapear las relaciones con otras entidades, aquí lo harías
	        
	        return comentario;
	}
}*/
