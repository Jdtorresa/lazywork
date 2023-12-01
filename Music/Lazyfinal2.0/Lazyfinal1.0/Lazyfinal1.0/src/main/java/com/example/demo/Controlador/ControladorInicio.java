package com.example.demo.Controlador;

import com.example.demo.Entidad.Usuario;
import com.example.demo.Servicio.ServicioUsuarioback;
import com.example.demo.Servicio.usuarioServicio;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorInicio {

    private final usuarioServicio userServicio;
    private final ServicioUsuarioback usuarioBackService;

    public ControladorInicio(ServicioUsuarioback usuarioBackService, usuarioServicio userServicio) {
        this.usuarioBackService = usuarioBackService;
        this.userServicio = userServicio;
    }

    @GetMapping("/inicio")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            Usuario user = this.userServicio.getCrearUsuario(principal.getClaims());
            model.addAttribute("user", user);
            if ("Usuario".equals(user.getRol())) {
                return "redirect:/GestionAdmin.html";
            } else {
                return "redirect:/GestionTecnicos.html";
            }
        } else {
            return "redirect:/";
        }
    }
    @PostMapping("/inicio")
    public String login(@RequestParam String role, @RequestParam String email, Model model) {
        // Lógica de autenticación aquí...

        model.addAttribute("email", email);
        model.addAttribute("role", role);

        // Redirecciona al usuario según el rol
        if ("Administrador".equals(role)) {
            return "redirect:/GestionUsuarios.html";
        } else if ("Tecnico".equals(role)) {
            return "redirect:/GestionTecnicos.html";
        } else {
            return "redirect:/"; // Redirige a la página principal por defecto
        }
    }


}
