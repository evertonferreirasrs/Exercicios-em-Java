package jrr.aula.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jrr.aula.model.entity.Cliente;
import jrr.aula.model.entity.Usuario;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AAInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean shallPass = false;
        String uri = request.getRequestURI();
        String context = "/web";
        //Resources
        if (uri.startsWith(context + "/resources")) {
            shallPass = true;
        }
        //URLs Livres
        if (uri.equals(context + "/")) {
            shallPass = true;
        }
        if (uri.startsWith(context + "/login")) {
            shallPass = true;
        }
        if (uri.startsWith(context + "/calculadora")) {
            shallPass = true;
        }
        if (uri.startsWith(context + "/somar")) {
            shallPass = true;
        }

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        if (usuario != null) {
            shallPass = true;
            if (usuario instanceof Cliente) {
                if (uri.startsWith(context + "/categorias/novo")) {
                    shallPass = false;
                }
            }
        }

        if (!shallPass) {
            response.sendRedirect(context + "/");
        }

        return shallPass;
    }

}
