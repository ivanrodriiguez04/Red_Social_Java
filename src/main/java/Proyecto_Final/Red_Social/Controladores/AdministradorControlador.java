package Proyecto_Final.Red_Social.Controladores;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Proyecto_Final.Red_Social.Daos.Usuario;
import Proyecto_Final.Red_Social.Dtos.UsuarioDTO;
import Proyecto_Final.Red_Social.Servicios.UsuarioInterfaz;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdministradorControlador {
	@Autowired
	private UsuarioInterfaz usuarioServicio;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/privada/administracion")
	public String listadoUsuarios(Model model, HttpServletRequest request) {
		List<UsuarioDTO> usuarios = usuarioServicio.buscarTodos();
		System.out.println(usuarios);
		model.addAttribute("usuarios", usuarios);
		
		if (request.isUserInRole("ROLE_3") || request.isUserInRole("ROLE_4")) {
			return "administracion";
		}
		return "redirect:/privada/index";
	}
	
	@GetMapping("/privada/eliminar/{id}")
	public String eliminarUsuario(@PathVariable Long id, Model model, HttpServletRequest request) {
		Usuario usuario = usuarioServicio.buscarPorId(id);
		List<UsuarioDTO> usuarios = usuarioServicio.buscarTodos();
		System.out.println(usuario);
		if (request.isUserInRole("ROLE_4") && usuario.getRol().equals("ROLE_4")) {
			model.addAttribute("noSePuedeEliminar", "No se puede eliminar a un admin");
			model.addAttribute("usuarios", usuarios);
			return "adminstracion";
		}

		if (request.isUserInRole("ROLE_1")) {
			return "redirect:/privada/index";	
		}
		else if (request.isUserInRole("ROLE_3") || request.isUserInRole("ROLE_4")) {
			usuarioServicio.eliminar(id);				
		}
		
		return "redirect:/privada/administracion";

	}
	
	@GetMapping("/privada/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model, HttpServletRequest request) {
	 	Usuario usuarioDAO = usuarioServicio.buscarPorId(id);
	 	UsuarioToDtoInterfaz it = new UsuarioToDtoImplementacion();
	 	UsuarioDTO usuarioDTO = it.usuarioToDto(usuarioDAO);
	 	System.out.println(usuarioDTO.isCuentaConfirmada());
	 	// Comprobar si el usuario es superAdmin
	 	if (request.isUserInRole("ROLE_1")) {
			return "redirect:/privada/index";	
		}
	 	if ("ROLE_4".equals(usuarioDAO.getRol())) {
			// Si el usuario es superadmin, no permitir cambiar el rol
			model.addAttribute("noSePuedeCambiarRol", "No se puede cambiar el rol del superadmin.");
			return "administracion";
	 	} else {
            model.addAttribute("usuarioDTO", usuarioDTO);
            return "edicionAdmin";
        }
    }

 @PostMapping("/guardarEdicion")
 public String guardarEdicion(@ModelAttribute("usuarioDTO") UsuarioDTO usuarioDTO) {
	 
	 // Obtener el usuario existente de la base de datoS

     Usuario usuarioExistente = usuarioServicio.buscarPorId(usuarioDTO.getIdUsuario());

     // Mantener la contraseña existente si no se proporciona una nueva contraseña
     if (StringUtils.isEmpty(usuarioDTO.getContraseñaUsuario())) {
         usuarioDTO.setContraseñaUsuario(usuarioExistente.getContraseñaUsuario());
     } else {
         // La contraseña se ha proporcionado en texto plano, cifrarla antes de actualizarla
         usuarioDTO.setContraseñaUsuario(passwordEncoder.encode(usuarioDTO.getContraseñaUsuario()));
     }
     // Mantener el boolean de cuenta confirmada
     if (!usuarioDTO.isCuentaConfirmada()) {
    	    usuarioDTO.setCuentaConfirmada(usuarioExistente.isCuentaConfirmada());
    	}
  
     // Guardar el usuario actualizado en la base de datos
     usuarioServicio.actualizarUsuario(usuarioDTO);

     return "redirect:/privada/index";
 }
}
