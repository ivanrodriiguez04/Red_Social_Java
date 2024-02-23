package Proyecto_Final.Red_Social.Daos;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
	@Column(name = "nombre_completo_usuario", nullable = false, length = 50)
	private String nombreCompletoUsuario;
	@Column(name = "nombre_cuenta_usuario", nullable = false, length = 50)
	private String nombreCuentaUsuario;
	@Column(name = "email_usuario", nullable = false, unique = true, length = 50)
	private String emailUsuario;
	@Column(name = "contraseña_usuario", nullable = false, length = 100)
	private String contraseñaUsuario;
	@Column(name="telefono_Usuario",nullable=false,length=9)
	private int telefonoUsuario;
	@Column(name = "fch_alta_usuario", nullable = true, updatable = false)
	private Calendar fchAltaUsuario ;
	@Column(name = "fch_baja_usuario", nullable = true, updatable = false)
	private Calendar fchBajaUsuario;
	@Column(name = "rol", nullable = false)
	public String rol = "usuario";
	@Column(name="cuenta_confirmada",nullable=false,columnDefinition="boolean default false")
	private boolean cuentaConfirmada;
	@Column(name = "token_recuperacion", nullable = true, length = 100)
	private String token;
	@Column(name = "expiracion_token", nullable = true, length = 100)
	private Calendar expiracionToken;
	@OneToMany
	@JoinTable(name = "usuario_comentarios", schema = "proyecto_final",
	   joinColumns = @JoinColumn(name = "id_usuario"), 
	   inverseJoinColumns = @JoinColumn(name = "id_comentario"))
	private List<Comentarios> usuarioComentario = new ArrayList<>();
	
	//Constructores
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(long id_Usuario, String nombreCompletoUsuario, String nombreCuentaUsuario, String emailUsuario,
			String contraseñaUsuario, int telefonoUsuario, Calendar fchAltaUsuario, Calendar fchBajaUsuario, String rol,
			boolean cuentaConfirmada, String token, Calendar expiracionToken, List<Comentarios> usuarioComentario) {
		super();
		this.id_Usuario = id_Usuario;
		this.nombreCompletoUsuario = nombreCompletoUsuario;
		this.nombreCuentaUsuario = nombreCuentaUsuario;
		this.emailUsuario = emailUsuario;
		this.contraseñaUsuario = contraseñaUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.fchAltaUsuario = fchAltaUsuario;
		this.fchBajaUsuario = fchBajaUsuario;
		this.rol = rol;
		this.cuentaConfirmada = cuentaConfirmada;
		this.token = token;
		this.expiracionToken = expiracionToken;
		this.usuarioComentario = usuarioComentario;
	}
	
	//Getters & Setters
	public long getId_Usuario() {
		return id_Usuario;
	}
	public void setId_Usuario(long id_Usuario) {
		this.id_Usuario = id_Usuario;
	}
	public String getNombreCompletoUsuario() {
		return nombreCompletoUsuario;
	}
	public void setNombreCompletoUsuario(String nombreCompletoUsuario) {
		this.nombreCompletoUsuario = nombreCompletoUsuario;
	}
	public String getNombreCuentaUsuario() {
		return nombreCuentaUsuario;
	}
	public void setNombreCuentaUsuario(String nombreCuentaUsuario) {
		this.nombreCuentaUsuario = nombreCuentaUsuario;
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
	public int getTelefonoUsuario() {
		return telefonoUsuario;
	}
	public void setTelefonoUsuario(int telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}
	public Calendar getFchAltaUsuario() {
		return fchAltaUsuario;
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
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public boolean isCuentaConfirmada() {
		return cuentaConfirmada;
	}
	public void setCuentaConfirmada(boolean cuentaConfirmada) {
		this.cuentaConfirmada = cuentaConfirmada;
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
	public List<Comentarios> getUsuarioComentario() {
		return usuarioComentario;
	}
	public void setUsuarioComentario(List<Comentarios> usuarioComentario) {
		this.usuarioComentario = usuarioComentario;
	}

	//Metodos
	public boolean isAdmin() {
		if(getRol() == "admin")
			return true;
		else
			return false;
	}
	@Override
	public int hashCode() {
		return Objects.hash(contraseñaUsuario, cuentaConfirmada, emailUsuario, expiracionToken, fchAltaUsuario,
				fchBajaUsuario, id_Usuario, nombreCompletoUsuario, nombreCuentaUsuario, rol, telefonoUsuario, token,
				usuarioComentario);
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
		return Objects.equals(contraseñaUsuario, other.contraseñaUsuario) && cuentaConfirmada == other.cuentaConfirmada
				&& Objects.equals(emailUsuario, other.emailUsuario)
				&& Objects.equals(expiracionToken, other.expiracionToken)
				&& Objects.equals(fchAltaUsuario, other.fchAltaUsuario)
				&& Objects.equals(fchBajaUsuario, other.fchBajaUsuario) && id_Usuario == other.id_Usuario
				&& Objects.equals(nombreCompletoUsuario, other.nombreCompletoUsuario)
				&& Objects.equals(nombreCuentaUsuario, other.nombreCuentaUsuario) && Objects.equals(rol, other.rol)
				&& telefonoUsuario == other.telefonoUsuario && Objects.equals(token, other.token)
				&& Objects.equals(usuarioComentario, other.usuarioComentario);
	}
	@Override
	public String toString() {
		return "Usuario [id_Usuario=" + id_Usuario + ", nombreCompletoUsuario=" + nombreCompletoUsuario
				+ ", nombreCuentaUsuario=" + nombreCuentaUsuario + ", emailUsuario=" + emailUsuario
				+ ", contraseñaUsuario=" + contraseñaUsuario + ", telefonoUsuario=" + telefonoUsuario
				+ ", fchAltaUsuario=" + fchAltaUsuario + ", fchBajaUsuario=" + fchBajaUsuario + ", rol=" + rol
				+ ", cuentaConfirmada=" + cuentaConfirmada + ", token=" + token + ", expiracionToken=" + expiracionToken
				+ ", usuarioComentario=" + usuarioComentario + "]";
	}
}
