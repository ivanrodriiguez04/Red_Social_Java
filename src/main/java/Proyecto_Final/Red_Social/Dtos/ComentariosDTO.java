package Proyecto_Final.Red_Social.Dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Proyecto_Final.Red_Social.Daos.Usuario;

public class ComentariosDTO 
{
	//Atributos
	private long id_Comentario;
	private String desc_Comentario;
	private String fch_Alta_Comentario;
	public List<Usuario> comentarioUsuario;
	//Constructores
	public ComentariosDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ComentariosDTO(long id_Comentario, String desc_Comentario, String fch_Alta_Comentario,
			List<Usuario> comentarioUsuario) {
		super();
		this.id_Comentario = id_Comentario;
		this.desc_Comentario = desc_Comentario;
		this.fch_Alta_Comentario = fch_Alta_Comentario;
		this.comentarioUsuario = new ArrayList<>();
	}
	
	//Getters & Setters
	public long getId_Comentario() {
		return id_Comentario;
	}
	public void setId_Comentario(long id_Comentario) {
		this.id_Comentario = id_Comentario;
	}
	public String getDesc_Comentario() {
		return desc_Comentario;
	}
	public void setDesc_Comentario(String desc_Comentario) {
		this.desc_Comentario = desc_Comentario;
	}
	public String getFch_Alta_Comentario() {
		return fch_Alta_Comentario;
	}
	public void setFch_Alta_Comentario(String fch_Alta_Comentario) {
		this.fch_Alta_Comentario = fch_Alta_Comentario;
	}
	public List<Usuario> getComentarioUsuario() {
		return comentarioUsuario;
	}
	public void setComentarioUsuario(List<Usuario> comentarioUsuario) {
		this.comentarioUsuario = comentarioUsuario;
	}
	
	//Metodos
	@Override
	public int hashCode() {
		return Objects.hash(comentarioUsuario, desc_Comentario, fch_Alta_Comentario, id_Comentario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComentariosDTO other = (ComentariosDTO) obj;
		return Objects.equals(comentarioUsuario, other.comentarioUsuario)
				&& Objects.equals(desc_Comentario, other.desc_Comentario)
				&& Objects.equals(fch_Alta_Comentario, other.fch_Alta_Comentario) && id_Comentario == other.id_Comentario;
	}
	@Override
	public String toString() {
		return "ComentariosDTO [id_Comentario=" + id_Comentario + ", desc_Comentario=" + desc_Comentario
				+ ", fch_Alta_Comentario=" + fch_Alta_Comentario + ", comentarioUsuario=" + comentarioUsuario + "]";
	}
	
}
