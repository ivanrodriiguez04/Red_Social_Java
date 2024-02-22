package Proyecto_Final.Red_Social.Dtos;

import java.util.Calendar;

public class TokenDTO {
	//Atributos
	private String token;
	private Calendar expiracionToken;
	//Constructores
	public TokenDTO(String token, Calendar expiracionToken) {
		super();
		this.token = token;
		this.expiracionToken = expiracionToken;
	}
	public TokenDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Getters & Setters
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
	
}
