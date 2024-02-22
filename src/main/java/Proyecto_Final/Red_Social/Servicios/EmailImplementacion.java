package Proyecto_Final.Red_Social.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailImplementacion implements EmailInterfaz {

	@Autowired
	private JavaMailSender javaMailSender;	
	

	@Override
	public void enviarEmailRecuperacion(String emailDestino, String nombreUsuario, String token) {

		   try {
	            MimeMessage mensaje = javaMailSender.createMimeMessage();
	            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true, "UTF-8");

	            helper.setFrom("ivanrodriiguez04@gmail.com"); //AQUI VA EL EMAIL DEL .PROPERTIES
	            helper.setTo(emailDestino);
	            helper.setSubject("RESTABLECER CONTRASEÑA");

	            String urlDominio = "http://localhost:8080";
	            String urlDeRecuperacion = String.format("%s/auth/recuperar?token=%s", urlDominio, token);

	            String cuerpoMensaje = String.format(
	    				"﻿<!DOCTYPE html> <html lang='es'> <body> <div style='width: 600px; padding: 20px; border: 2px solid #ff9900; border-radius: 12px; font-family: Sans-serif'> <h1 style='color:#192255'>Restablecer contraseña<b style='color:#ff9900'> Biblioteca app</b></h1> <p style='margin-bottom:25px'>Estimado/a&nbsp;<b>%s</b>:</p> <p style='margin-bottom:25px'>Recibiste este correo porque se solicitó un restablecimiento de contraseña para tu cuenta. Haz clic en el botón que aparece a continuación para cambiar tu contraseña.</p> <a style='padding: 10px 15px; border-radius: 20px; background-color: #285845; color: white; text-decoration: none' href='%s' target='_blank'>Cambiar contraseña</a> <p style='margin-top:25px'>Si no solicitaste este restablecimiento de contraseña, puedes ignorar este correo de forma segura.</p> <p>Gracias por utilizar nuestros servicios.</p> </div> </body> </html>",
	                nombreUsuario, urlDeRecuperacion);

	            helper.setText(cuerpoMensaje, true);

	            javaMailSender.send(mensaje);

	        } catch (MailException me) {
	            System.out.println("[Error EmailServicioImpl - enviarEmailRecuperacion()] Ha ocurrido un error al enviar el email! " + me.getMessage());
	        } catch (MessagingException e) {
	            System.out.println("[Error EmailServicioImpl - enviarEmailRecuperacion()] Ha ocurrido un error al enviar el email! " + e.getMessage());
	        }	
		

	}
	@Override
    public void enviarEmailConfirmacion(String emailDestino, String nombreUsuario, String token) {
        try {
            MimeMessage mensaje = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true, "UTF-8");

            helper.setFrom("ivanrodriiguez04@gmail.com");
            helper.setTo(emailDestino);
            helper.setSubject("Confirmación de cuenta");

            String urlDominio = "http://localhost:8080";
            String urlDeConfirmacion = String.format("%s/auth/confirmacionCorreo?token=%s", urlDominio, token);

            String cuerpoMensaje = String.format(
                "﻿<!DOCTYPE html> "
                + "<html lang='es'> "
                + "<body> "
                + "<div style='width: 600px; padding: 20px; border: 2px solid black; border-radius: 13px; background-color: #fff; font-family: Sans-serif;'>"
                + "<h1 style='color:rgb(192, 192, 192)'>Confirmar cuenta - <b style='color:#285845; text-decoration: underline'>La Revista</b></h1>"
                + "<p style='margin-bottom:25px'>Estimad@&nbsp;<b>%s</b>:</p> <p style='margin-bottom:25px'>"
                + "Bienvenid@ al Periodico La Revista. Para confirmar tu cuenta, haga click en el botón:</p>"
                + " <a style='padding: 10px 15px; border-radius: 10px; background-color: #5993d3; color: white; text-decoration: none' href='%s' target='_blank'>Confirmar cuenta</a>"
                + " <p style='margin-top:25px'>¡Ahora somos uno más!.</p> </div> </body> </html>",
                nombreUsuario, urlDeConfirmacion);

            helper.setText(cuerpoMensaje, true);

            javaMailSender.send(mensaje);

        } catch (MailException me) {
            System.out.println("[Error EmailServicioImpl - enviarEmailConfirmacion()] Ha ocurrido un error al enviar el email! " + me.getMessage());
        } catch (MessagingException e) {
            System.out.println("[Error EmailServicioImpl - enviarEmailConfirmacion()] Ha ocurrido un error al enviar el email! " + e.getMessage());
        }
    }

}
