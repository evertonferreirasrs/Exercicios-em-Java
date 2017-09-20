package jrr.aula.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jrr.aula.model.entity.Usuario;
import jrr.aula.model.entity.UsuarioImg;
import jrr.aula.model.service.UsuarioImgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioImgController {

    @RequestMapping(value = "/img", method = RequestMethod.GET)
    public ModelAndView get(HttpSession session) {
        ModelAndView mv = new ModelAndView("usuario/img");

        return mv;
    }

    @RequestMapping(value = "/img", method = RequestMethod.POST)
    public ModelAndView post(HttpSession session, MultipartFile file) throws Exception {
        ModelAndView mv = new ModelAndView("usuario/img");
        Usuario usuario = (Usuario)session.getAttribute("usuarioLogado");
        
        UsuarioImgService service = new UsuarioImgService();
        UsuarioImg usuarioImg = new UsuarioImg();
        usuarioImg.setId(usuario.getId());
        usuarioImg.setImg(file.getBytes());
        
        service.set(usuarioImg);
        //System.out.println("Tamanho do arquivo:" + file.getSize());
        return mv;
    }
    
    @RequestMapping(value = "/img.jpg", method = RequestMethod.GET)
    public void get(HttpSession session, HttpServletResponse response) throws Exception{
        Usuario usuario = (Usuario)session.getAttribute("usuarioLogado");
        UsuarioImgService service = new UsuarioImgService();
        UsuarioImg usuarioImg = service.get(usuario.getId());
        
        response.setContentType("image/jpg");
        response.setContentLength(usuarioImg.getImg().length);
        response.getOutputStream().write(usuarioImg.getImg());
        response.flushBuffer();
    }
    
    @RequestMapping(value = "usuario/{id}/img.jpg", method = RequestMethod.GET)
    public void getImg(HttpServletResponse response, @PathVariable Long id) throws Exception{
        UsuarioImgService service = new UsuarioImgService();
        UsuarioImg usuarioImg = service.get(id);
        
        response.setContentType("image/jpg");
        response.setContentLength(usuarioImg.getImg().length);
        response.getOutputStream().write(usuarioImg.getImg());
        response.flushBuffer();
    }

}
