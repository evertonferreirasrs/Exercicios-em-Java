package jrr.aula.controller;

import java.util.List;
import jrr.aula.model.entity.Categoria;
import jrr.aula.model.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoriaController {
    
    @RequestMapping(value = "/categorias/nova", method = RequestMethod.GET)
    public ModelAndView getCategoriaForm(){
        ModelAndView mv = new ModelAndView();
        return mv;
    }
    
    @RequestMapping(value = "/categorias/nova", method = RequestMethod.POST )
    public ModelAndView postCategoriaForm(){
        ModelAndView mv = new ModelAndView();
        return mv;
    }
    
    @RequestMapping(value = "/categorias", method = RequestMethod.GET)
    public ModelAndView getCategoriaList() throws Exception{
        CategoriaService s = new CategoriaService();
        
        Categoria categoria = new Categoria();
        categoria.setNome("Jogos");
        s.create(categoria);
        
        categoria = new Categoria();
        categoria.setNome("Filmes");
        s.create(categoria);
        
        categoria = new Categoria();
        categoria.setNome("Livros");
        s.create(categoria);        
        
        List<Categoria> categoriaList = s.readByCriteria(null);
        
        ModelAndView mv = new ModelAndView("categoria/list");
        mv.addObject("categoriaList", categoriaList);
        return mv;
    }
    
}
