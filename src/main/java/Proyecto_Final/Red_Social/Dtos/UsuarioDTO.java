package Proyecto_Final.Red_Social.Dtos;

import java.util.Calendar;
import java.util.Objects;

public class UsuarioDTO {

	//Atributos
	private long idUsuario;
	private String nombreCompletoUsuario;
	private String nombreCuentaUsuario;
	private String emailUsuario;
	private String contraseñaUsuario;
	private String contraseñaUsuario2;
	private int telefonoUsuario;
	private long idAcceso;
	private String rol="usuario";
	private boolean cuentaConfirmada;
	private String token;
	private Calendar expiracionToken;
	 //Constructores
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsuarioDTO(long idUsuario, String nombreCompletoUsuario, String nombreCuentaUsuario, String emailUsuario,
			String contraseñaUsuario, String contraseñaUsuario2, int telefonoUsuario, long idAcceso, String rol,
			boolean cuentaConfirmada, String token, Calendar expiracionToken) {
		super();
		this.idUsuario = idUsuario;
		this.nombreCompletoUsuario = nombreCompletoUsuario;
		this.nombreCuentaUsuario = nombreCuentaUsuario;
		this.emailUsuario = emailUsuario;
		this.contraseñaUsuario = contraseñaUsuario;
		this.contraseñaUsuario2 = contraseñaUsuario2;
		this.telefonoUsuario = telefonoUsuario;
		this.idAcceso = idAcceso;
		this.rol = rol;
		this.cuentaConfirmada = cuentaConfirmada;
		this.token = token;
		this.expiracionToken = expiracionToken;
	}
	//Getters & Setters
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
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
	//Metodos
	public boolean isAdmin() {
		return "admin".equals(getRol());
	}
	@Override
	public int hashCode() {
		return Objects.hash(contraseñaUsuario, contraseñaUsuario2, cuentaConfirmada, emailUsuario, expiracionToken,
				idAcceso, idUsuario, nombreCompletoUsuario, nombreCuentaUsuario, rol, telefonoUsuario, token);
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
		return Objects.equals(contraseñaUsuario, other.contraseñaUsuario)
				&& Objects.equals(contraseñaUsuario2, other.contraseñaUsuario2)
				&& cuentaConfirmada == other.cuentaConfirmada && Objects.equals(emailUsuario, other.emailUsuario)
				&& Objects.equals(expiracionToken, other.expiracionToken) && idAcceso == other.idAcceso
				&& idUsuario == other.idUsuario && Objects.equals(nombreCompletoUsuario, other.nombreCompletoUsuario)
				&& Objects.equals(nombreCuentaUsuario, other.nombreCuentaUsuario) && Objects.equals(rol, other.rol)
				&& telefonoUsuario == other.telefonoUsuario && Objects.equals(token, other.token);
	}
	@Override
	public String toString() {
		return "UsuarioDTO [idUsuario=" + idUsuario + ", nombreCompletoUsuario=" + nombreCompletoUsuario
				+ ", nombreCuentaUsuario=" + nombreCuentaUsuario + ", emailUsuario=" + emailUsuario
				+ ", contraseñaUsuario=" + contraseñaUsuario + ", contraseñaUsuario2=" + contraseñaUsuario2
				+ ", telefonoUsuario=" + telefonoUsuario + ", idAcceso=" + idAcceso + ", rol=" + rol
				+ ", cuentaConfirmada=" + cuentaConfirmada + ", token=" + token + ", expiracionToken=" + expiracionToken
				+ "]";
	}
	
}