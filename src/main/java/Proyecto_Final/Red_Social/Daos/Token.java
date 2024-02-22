package Proyecto_Final.Red_Social.Daos;

import java.util.Calendar;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "token", schema = "proyecto_final")
public class Token {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_token",nullable=false)
	private long id_Token;
	@Column(name = "token_recuperacion", nullable = true, length = 100)
	private String token;
	@Column(name = "expiracion_token", nullable = true, length = 100)
	private Calendar expiracionToken;
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="id_Usuario")
	private Usuario usuario;
	//Constructores
	public Token(String token, Calendar expiracionToken, Usuario usuario) {
		super();
		this.token = token;
		this.expiracionToken = expiracionToken;
		this.usuario = usuario;
	}
	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Getters & Setters
	public long getId_Token() {
		return id_Token;
	}
	public void setId_Token(long id_Token) {
		this.id_Token = id_Token;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
