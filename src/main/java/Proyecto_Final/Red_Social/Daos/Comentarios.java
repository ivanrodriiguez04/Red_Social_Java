package Proyecto_Final.Red_Social.Daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="comentarios", schema="proyecto_final")
public class Comentarios {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_comentario", nullable=false)
	private long id_Comentario;
	
	@Column(name="desc_comentario",nullable=true,length=500)
	private String desc_Comentario;
	
	@Column(name="fch_alta_comentario",nullable=true,updatable=false)
	private String fch_Alta_Comentario;
	
	@ManyToMany(mappedBy="usuarioComentario")
	public List<Usuario> comentarioUsuario=new ArrayList<>();
	
	//Constructores

	public Comentarios() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comentarios(long id_Comentario, String desc_Comentario, String fch_Alta_Comentario,
			List<Usuario> comentarioUsuario) {
		super();
		this.id_Comentario = id_Comentario;
		this.desc_Comentario = desc_Comentario;
		this.fch_Alta_Comentario = fch_Alta_Comentario;
		this.comentarioUsuario = comentarioUsuario;
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
		Comentarios other = (Comentarios) obj;
		return Objects.equals(comentarioUsuario, other.comentarioUsuario)
				&& Objects.equals(desc_Comentario, other.desc_Comentario)
				&& Objects.equals(fch_Alta_Comentario, other.fch_Alta_Comentario) && id_Comentario == other.id_Comentario;
	}
	
	@Override
	public String toString() {
		return "Comentarios [id_Comentario=" + id_Comentario + ", desc_Comentario=" + desc_Comentario
				+ ", fch_Alta_Comentario=" + fch_Alta_Comentario + ", comentarioUsuario=" + comentarioUsuario + "]";
	}
	
}
