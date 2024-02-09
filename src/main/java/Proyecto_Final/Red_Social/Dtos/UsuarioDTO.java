package Proyecto_Final.Red_Social.Dtos;

import java.util.Calendar;
import java.util.Objects;

public class UsuarioDTO {

	//Atributos
	private long idUsuario;
	private String nombreUsuario;
	private String emailUsuario;
	private String contraseñaUsuario;
	private String contraseñaUsuario2;
	private int telefonoUsuario;
	private long idAcceso;
	private String token;
	private Calendar expiracionToken;
	public Boolean admin=true;
	
	//Constructores
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsuarioDTO(long idUsuario, String nombreUsuario, String emailUsuario, String contraseñaUsuario,
			String contraseñaUsuario2, int telefonoUsuario, long idAcceso, String token, Calendar expiracionToken,
			Boolean admin) 
	{
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.emailUsuario = emailUsuario;
		this.contraseñaUsuario = contraseñaUsuario;
		this.contraseñaUsuario2 = contraseñaUsuario2;
		this.telefonoUsuario = telefonoUsuario;
		this.idAcceso = idAcceso;
		this.token = token;
		this.expiracionToken = expiracionToken;
		this.admin = admin;
	}

	//Getters & Setters
	public boolean isAdmin() {
	    return admin != null && admin;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
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
	public String getContraseñaUsuario2() {
		return contraseñaUsuario2;
	}
	public void setContraseñaUsuario2(String contraseñaUsuario2) {
		this.contraseñaUsuario2 = contraseñaUsuario2;
	}
	public int getTelefonoUsuario() {
		return telefonoUsuario;
	}
	public void setTelefonoUsuario(int telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}
	public long getIdAcceso() {
		return idAcceso;
	}
	public void setIdAcceso(long idAcceso) {
		this.idAcceso = idAcceso;
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
	@Override
	public int hashCode() {
		return Objects.hash(admin, contraseñaUsuario, contraseñaUsuario2, emailUsuario, expiracionToken, idAcceso,
				idUsuario, nombreUsuario, telefonoUsuario, token);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDTO other = (UsuarioDTO) obj;
		return Objects.equals(admin, other.admin) && Objects.equals(contraseñaUsuario, other.contraseñaUsuario)
				&& Objects.equals(contraseñaUsuario2, other.contraseñaUsuario2)
				&& Objects.equals(emailUsuario, other.emailUsuario)
				&& Objects.equals(expiracionToken, other.expiracionToken) && idAcceso == other.idAcceso
				&& idUsuario == other.idUsuario && Objects.equals(nombreUsuario, other.nombreUsuario)
				&& telefonoUsuario == other.telefonoUsuario && Objects.equals(token, other.token);
	}
	@Override
	public String toString() {
		return "UsuarioDto [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", emailUsuario="
				+ emailUsuario + ", contraseñaUsuario=" + contraseñaUsuario + ", contraseñaUsuario2="
				+ contraseñaUsuario2 + ", telefonoUsuario=" + telefonoUsuario + ", idAcceso=" + idAcceso + ", token="
				+ token + ", expiracionToken=" + expiracionToken + ", admin=" + admin + "]";
	}
}
