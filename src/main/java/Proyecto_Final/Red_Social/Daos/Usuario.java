package Proyecto_Final.Red_Social.Daos;
import java.util.Calendar;
import java.util.Objects;

import jakarta.persistence.*;
@Entity
@Table(name = "usuarios", schema = "proyecto_final_usuario")
public class Usuario {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario",nullable=false)
	private long id_Usuario;
	@Column(name = "nombre_usuario", nullable = false, length = 70)
	private String nombreUsuario;
	@Column(name = "email_usuario", nullable = false, unique = true, length = 100)
	private String emailUsuario;
	@Column(name = "contraseña_usuario", nullable = false, length = 100)
	private String contraseñaUsuario;
	@Column(name="telefono_Usuario",nullable=false,length=9)
	private int telefonoUsuario;
	@Column(name = "fch_alta_usuario", nullable = true, updatable = false)
	private Calendar fchAltaUsuario ;
	@Column(name = "fch_baja_usuario", nullable = true, updatable = false)
	private Calendar fchBajaUsuario;
	@Column(name = "token_recuperacion", nullable = true, length = 100)
	private String token;
	@Column(name = "expiracion_token", nullable = true, length = 100)
	private Calendar expiracionToken;
	@Column(name = "admin", nullable = false)
	public Boolean admin = true;
	
	//Constructores
	
	public Usuario(long id_Usuario, String nombreUsuario, String emailUsuario, String contraseñaUsuario,
			int telefonoUsuario, Calendar fchAltaUsuario, Calendar fchBajaUsuario, String token,
			Calendar expiracionToken, Boolean admin) {
		super();
		this.id_Usuario = id_Usuario;
		this.nombreUsuario = nombreUsuario;
		this.emailUsuario = emailUsuario;
		this.contraseñaUsuario = contraseñaUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.fchAltaUsuario = fchAltaUsuario;
		this.fchBajaUsuario = fchBajaUsuario;
		this.token = token;
		this.expiracionToken = expiracionToken;
		this.admin = admin;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Getters & Setters
	public long getId_Usuario() {
		return id_Usuario;
	}
	public void setId_Usuario(long id_Usuario) {
		this.id_Usuario = id_Usuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	public String getContraseñaUsuario() {
		return contraseñaUsuario;
	}
	public void setContraseñaUsuario(String contraseñaUsuario) {
		this.contraseñaUsuario = contraseñaUsuario;
	}
	public Calendar getFchAltaUsuario() {
		return fchAltaUsuario;
	}
	public int getTelefonoUsuario() {
		return telefonoUsuario;
	}
	public void setTelefonoUsuario(int telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}
	public void setFchAltaUsuario(Calendar fchAltaUsuario) {
		this.fchAltaUsuario = fchAltaUsuario;
	}
	public Calendar getFchBajaUsuario() {
		return fchBajaUsuario;
	}
	public void setFchBajaUsuario(Calendar fchBajaUsuario) {
		this.fchBajaUsuario = fchBajaUsuario;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Calendar getExpiracionToken() {
		return expiracionToken;
	}
	public void setExpiracionToken(Calendar expiracionToken) {
		this.expiracionToken = expiracionToken;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	//Metodos
	
	public boolean isAdmin() {
		
	    return admin != null && admin;
	}
	@Override
	public int hashCode() {
		return Objects.hash(admin, contraseñaUsuario, emailUsuario, expiracionToken, fchAltaUsuario, fchBajaUsuario,
				id_Usuario, nombreUsuario, telefonoUsuario, token);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(admin, other.admin) && Objects.equals(contraseñaUsuario, other.contraseñaUsuario)
				&& Objects.equals(emailUsuario, other.emailUsuario)
				&& Objects.equals(expiracionToken, other.expiracionToken)
				&& Objects.equals(fchAltaUsuario, other.fchAltaUsuario)
				&& Objects.equals(fchBajaUsuario, other.fchBajaUsuario) && id_Usuario == other.id_Usuario
				&& Objects.equals(nombreUsuario, other.nombreUsuario) && telefonoUsuario == other.telefonoUsuario
				&& Objects.equals(token, other.token);
	}
	@Override
	public String toString() {
		return "Usuario [id_Usuario=" + id_Usuario + ", nombreUsuario=" + nombreUsuario + ", emailUsuario="
				+ emailUsuario + ", contraseñaUsuario=" + contraseñaUsuario + ", telefonoUsuario=" + telefonoUsuario
				+ ", fchAltaUsuario=" + fchAltaUsuario + ", fchBajaUsuario=" + fchBajaUsuario + ", token=" + token
				+ ", expiracionToken=" + expiracionToken + ", admin=" + admin + "]";
	}
}
