 package Proyecto_Final.Red_Social.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Proyecto_Final.Red_Social.Servicios.UsuarioInterfaz;
import Proyecto_Final.Red_Social.Daos.*;
import Proyecto_Final.Red_Social.Dtos.UsuarioDTO;

@Controller
public class LoginControlador {
	@Autowired
	private UsuarioInterfaz usuarioServicio;

	
	@GetMapping("/")
	public String loginc(Model model) {
		// Se agrega un nuevo objeto UsuarioDTO al modelo para el formulario de login
		model.addAttribute("usuarioDto", new UsuarioDTO());
		return "login";
	}
	/**
	 * Gestiona la solicitud HTTP GET para /auth/login y muestra la página de inicio de sesión
	 * @param model Modelo que se utiliza para enviar un usuarioDTO vacio a la vista.
	 * @return La vista de inicio de sesión (login.html).
	 */
	@GetMapping("/auth/login")
	public String login(Model model) {
		// Se agrega un nuevo objeto UsuarioDTO al modelo para el formulario de login
		model.addAttribute("usuarioDto", new UsuarioDTO());
		return "login";
	}

	/**
	 * Gestiona la solicitud HTTP GET para mostrar la página de registro.
	 * @param model Modelo que se utiliza para enviar un usuarioDTO vacio a la vista.
	 * @return La vista de registro de usuario (registrar.html).
	 */
	@GetMapping("/auth/registrar")
	public String registrarGet(Model model) {
		model.addAttribute("usuarioDto", new UsuarioDTO());
		return "registro";
	}

	/**
	 * Procesa la solicitud HTTP POST para registro de un nuevo usuario.
	 * @param  usuarioDTO El objeto UsuarioDTO que recibe en el modelo y contiene los
	 *         datos del nuevo usuario.
	 * @return La vista de inicio de sesión (login.html) si fue exitoso el registro; 
	 * 		   de lo contrario, la vista de registro de usuario (registro.html).
	 */
	@PostMapping("/auth/registrar")
	public String registrarPost(@ModelAttribute UsuarioDTO usuarioDTO, Model model) {

		UsuarioDTO nuevoUsuario = usuarioServicio.registrar(usuarioDTO);
		
		if (nuevoUsuario != null && nuevoUsuario.getEmailUsuario() != null) {
			// Si el usuario y el DNI no son null es que el registro se completo correctamente
			model.addAttribute("mensajeRegistroExitoso", "Registro del nuevo usuario OK");
			return "login";
		} else {
			// Se verifica si el DNI ya existe para mostrar error personalizado en la vista
			if (usuarioDTO.getEmailUsuario() == null) {
				model.addAttribute("mensajeErrorMail", "Ya existe un usuario con ese email");
				return "registro";
			}
		}
		return "registro";
	}

	/**
	 * Gestiona la solicitud HTTP GET para llevar a la página de home una vez logeado con exito.
	 * @return La vista de home.html
	 */
	@GetMapping("/privada/home")
	public String loginCorrecto(Model model, Authentication authentication) {
		Usuario usuario = usuarioServicio.buscarPorEmail(authentication.getName());
		String nombreUsuario = usuario.getNombreCuentaUsuario();
		model.addAttribute("nombreUsuario", nombreUsuario);
		// Agregar información sobre si el usuario es administrador al modelo
	    model.addAttribute("isAdmin", usuario.getRol());
		return "home";
	}
	
	 @GetMapping("/auth/confirmacionCorreo")
	    public String confirmarCuenta(Model model, @RequestParam("token") String token) {
	        try {
	            boolean confirmacionExitosa = usuarioServicio.confirmarCuenta(token);

	            if (confirmacionExitosa) {
	                model.addAttribute("cuentaVerificada", "Su dirección de correo ha sido confirmada correctamente");
	            } else {
	                model.addAttribute("cuentaNoVerificada", "Error al confirmar su email");
	            }

	            return "login";
	        } catch (Exception e) {
	            model.addAttribute("error", "Error al procesar la solicitud. Por favor, inténtelo de nuevo.");
	            return "login";
	        }
	    }
}
