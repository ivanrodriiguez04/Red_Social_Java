package Proyecto_Final.Red_Social.Dtos;

import java.util.Calendar;
import java.util.Objects;

public class UsuarioDto {

	//Atributos
	private long idUsuario;
	private String nombreUsuario;
	private String emailUsuario;
	private String contraseñaUsuario;
	private String contraseñaUsuario2;
	private long idAcceso;
	private String token;

	private Calendar expiracionToken;
	public Boolean admin=true;
	//Constructores
	public UsuarioDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioDto(long idUsuario, String nombreUsuario, String emailUsuario, String contraseñaUsuario,
			String contraseñaUsuario2, long idAcceso,String token, Calendar expiracionToken, Boolean admin) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.emailUsuario = emailUsuario;
		this.contraseñaUsuario = contraseñaUsuario;
		this.contraseñaUsuario2 = contraseñaUsuario2;
		this.idAcceso = idAcceso;
		this.token=token;
		this.expiracionToken = expiracionToken;
		this.admin = admin;
	}


	//Getters & Setters
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
	public String toString() {
		return "UsuarioDto [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", emailUsuario="
				+ emailUsuario + ", contraseñaUsuario=" + contraseñaUsuario + ", contraseñaUsuario2="
				+ contraseñaUsuario2 + ", idAcceso=" + idAcceso + ", token=" + token + ", expiracionToken="
				+ expiracionToken + ", admin=" + admin + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(admin, contraseñaUsuario, contraseñaUsuario2, emailUsuario, expiracionToken, idAcceso,
				idUsuario, nombreUsuario, token);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDto other = (UsuarioDto) obj;
		return Objects.equals(admin, other.admin) && Objects.equals(contraseñaUsuario, other.contraseñaUsuario)
				&& Objects.equals(contraseñaUsuario2, other.contraseñaUsuario2)
				&& Objects.equals(emailUsuario, other.emailUsuario)
				&& Objects.equals(expiracionToken, other.expiracionToken) && idAcceso == other.idAcceso
				&& idUsuario == other.idUsuario && Objects.equals(nombreUsuario, other.nombreUsuario)
				&& Objects.equals(token, other.token);
	}
	
}
