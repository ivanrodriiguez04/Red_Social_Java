package Proyecto_Final.Red_Social.Daos;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="publicaciones",schema="proyecto_final")
public class Publicaciones {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_publicacion", nullable = false)
	private long id_Publicacion;
	@Column(name = "fch_alta_publicacion", nullable = true, updatable = false)
	private String fch_Alta_Publicacion;
	//Constructores
	public Publicaciones(long id_Publicacion, String fch_Alta_Publicacion) {
		super();
		this.id_Publicacion = id_Publicacion;
		this.fch_Alta_Publicacion = fch_Alta_Publicacion;
	}
	public Publicaciones() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Metodos
	@Override
	public int hashCode() {
		return Objects.hash(fch_Alta_Publicacion, id_Publicacion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicaciones other = (Publicaciones) obj;
		return Objects.equals(fch_Alta_Publicacion, other.fch_Alta_Publicacion)
				&& id_Publicacion == other.id_Publicacion;
	}
	@Override
	public String toString() {
		return "Publicaciones [id_Publicacion=" + id_Publicacion + ", fch_Alta_Publicacion=" + fch_Alta_Publicacion
				+ "]";
	}
	
}
