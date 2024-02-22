package Proyecto_Final.Red_Social.Dtos;

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
	 //Constructores
	public UsuarioDTO(long idUsuario, String nombreCompletoUsuario, String nombreCuentaUsuario, String emailUsuario,
			String contraseñaUsuario, String contraseñaUsuario2, int telefonoUsuario, long idAcceso,
			 String rol, boolean cuentaConfirmada) {
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
	}
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
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
	//Metodos
	public boolean isAdmin() {
		return "admin".equals(getRol());
	}
	@Override
	public int hashCode() {
		return Objects.hash(contraseñaUsuario, contraseñaUsuario2, cuentaConfirmada, emailUsuario,
				idAcceso, idUsuario, nombreCompletoUsuario, nombreCuentaUsuario, rol, telefonoUsuario);
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
				&& idAcceso == other.idAcceso
				&& idUsuario == other.idUsuario && Objects.equals(nombreCompletoUsuario, other.nombreCompletoUsuario)
				&& Objects.equals(nombreCuentaUsuario, other.nombreCuentaUsuario) && Objects.equals(rol, other.rol)
				&& telefonoUsuario == other.telefonoUsuario ;
	}
	@Override
	public String toString() {
		return "UsuarioDTO [idUsuario=" + idUsuario + ", nombreCompletoUsuario=" + nombreCompletoUsuario
				+ ", nombreCuentaUsuario=" + nombreCuentaUsuario + ", emailUsuario=" + emailUsuario
				+ ", contraseñaUsuario=" + contraseñaUsuario + ", contraseñaUsuario2=" + contraseñaUsuario2
				+ ", telefonoUsuario=" + telefonoUsuario + ", idAcceso=" + idAcceso 
				+", rol=" + rol + ", cuentaConfirmada=" + cuentaConfirmada
				+ "]";
	}
}