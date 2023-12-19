package jlorenzolimon.org.formulariorepintado.Controller;

import jakarta.servlet.http.HttpSession;
import jlorenzolimon.org.formulariorepintado.model.Usuario;
import jlorenzolimon.org.formulariorepintado.service.ServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sesion")
public class ControladorSesiones {
    @Autowired
    ServicioImpl mi_servicio;
    @GetMapping("paso1")
    public String paso1Get(HttpSession sesion) {
        sesion.setAttribute("paso", 1);
        return "Sesion/Usuario";
    }
    @PostMapping("paso1")
    public String paso1Post(HttpSession sesion,@RequestParam String nombre,Usuario usuario) {
        if (mi_servicio.devuelveCredenciales().containsKey(nombre)) {
            usuario.setNombre(nombre);
            sesion.setAttribute("Usuario", usuario);
            return "redirect:/sesion/paso2";
        }else
            return "redirect:/sesion/paso1";
    }
    @GetMapping("paso2")
    public String paso2Get(HttpSession sesion) {
        sesion.setAttribute("paso", (int)sesion.getAttribute("paso") + 1);
        return "Sesion/Clave";
    }
    @PostMapping("paso2")
    public String paso2Post(HttpSession sesion,@RequestParam String clave) {
        Usuario usuario = (Usuario)sesion.getAttribute("Usuario");
        if (mi_servicio.devuelveCredenciales().get(usuario.getNombre()).equals(clave)) {
            usuario.setClave(clave);
            sesion.setAttribute("Usuario", usuario);
            return "redirect:/sesion/paso3";
        }else
            return "redirect:/sesion/paso2";
    }
    @GetMapping("paso3")
    public String paso3Get(HttpSession sesion, Model model) {
        model.addAttribute("nombre",sesion.getAttribute("Usuario"));
        return "Sesion/Sesion";
    }
}
