package jrr.aula.controller;

import javax.servlet.http.HttpSession;
import jrr.aula.model.entity.Usuario;
import jrr.aula.model.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String email, String senha, HttpSession session) throws Exception {
        ModelAndView mv = null;
        UsuarioService service = new UsuarioService();
        Usuario usuario = service.login(email, senha);
        if (usuario != null) {
            session.setAttribute("usuarioLogado", usuario);
            mv = new ModelAndView("redirect:/categorias");
        } else {
            mv = new ModelAndView("redirect:/");
        }
        return mv;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("redirect:/");
        session.removeAttribute("usuarioLogado");
        return mv;
    }

}
