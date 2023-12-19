package jlorenzolimon.org.formulariorepintado.Controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jlorenzolimon.org.formulariorepintado.model.Usuario;
import jlorenzolimon.org.formulariorepintado.service.ServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import static java.lang.Integer.parseInt;
@Controller
@RequestMapping("cookies")
public class ControladorCookies {
    @Autowired
    ServicioImpl mi_servicio;

    @GetMapping(value = "manejo-cookie")
    @ResponseBody
    public String manejoCookie(Model model,
                               HttpServletResponse respuestaHttp,
                               @CookieValue(name = "contador", defaultValue = "1") String contenido) {
        int num;
        try {
            if (!contenido.equals("0")) {
                num = parseInt(contenido);
                num++;
                contenido = String.valueOf(num);
            }
        } catch (Exception e) {
            return "Error con las Cookies";
        }
        Cookie miCookie = new Cookie("contador", contenido);
//        miCookie.setMaxAge(10);
        miCookie.setPath("/formulario/");
        respuestaHttp.addCookie(miCookie);
        return "El valor de la cookie es " + contenido;
    }


    @GetMapping("login")
    public String login() {
        return "Cookies/Usuario";
    }

    @PostMapping(value = "Usuario")
    public String Usuario(Model modelo, @RequestParam String nombre) {
        if (!mi_servicio.devuelveCredenciales().containsKey(nombre)) {
            return "Cookies/Usuario";
        } else {
            modelo.addAttribute("nombre", nombre);
            return "Cookies/Clave";
        }
    }


    @PostMapping(value = "Clave")
    public String clave(Model modelo,
                        HttpServletResponse respuestaHttp,
                        @RequestParam String passw,
                        @RequestParam String nombre,
                        @CookieValue(name = "sesion") String sesiones, Usuario usuario) {
        if (!mi_servicio.devuelveCredenciales().containsValue(passw)) {
            return "Cookies/Clave";
        } else {
            if (sesiones == null) {
                usuario = new Usuario(nombre, passw);
                modelo.addAttribute("sesion", iniciosDeSesion(usuario, respuestaHttp));
            }
            return "Cookies/Sesion";
        }
    }

    public String iniciosDeSesion(Usuario usuario, HttpServletResponse respuestaHttp) {
        String contenidoCookie = "";
        contenidoCookie += usuario.toString() + "#";
        Cookie miCookie = new Cookie("sesion", contenidoCookie);
        respuestaHttp.addCookie(miCookie);
        return contenidoCookie;
    }
}