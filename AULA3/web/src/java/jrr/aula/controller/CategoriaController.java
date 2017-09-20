package jrr.aula.controller;

import java.util.List;
import jrr.aula.model.entity.Categoria;
import jrr.aula.model.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoriaController {

    @RequestMapping(value = "/categorias/novo", method = RequestMethod.GET)
    public ModelAndView getCategoriaForm() {
        ModelAndView mv = new ModelAndView("categoria/form");
        return mv;
    }

    @RequestMapping(value = "/categorias/novo", method = RequestMethod.POST)
    public ModelAndView postCategoriaForm(String nome) throws Exception {
        Categoria categoria = new Categoria();
        categoria.setNome(nome);

        CategoriaService s = new CategoriaService();
        s.create(categoria);

        return new ModelAndView("redirect:/categorias");
    }

    @RequestMapping(value = "/categorias", method = RequestMethod.GET)
    public ModelAndView getCategoriaList() throws Exception {
        CategoriaService s = new CategoriaService();
        List<Categoria> categoriaList = s.readByCriteria(null);
        ModelAndView mv = new ModelAndView("categoria/list");
        mv.addObject("categoriaList", categoriaList);
        return mv;
    }
    
    @RequestMapping(value = "/categorias/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Long id) throws Exception{
        CategoriaService s = new CategoriaService();
        s.delete(id);
        ModelAndView mv = new ModelAndView("redirect:/categorias");    
        return mv;
    }
    
    @RequestMapping(value = "/categorias/{id}/editar", method = RequestMethod.GET)
    public ModelAndView getCategoriaForm(@PathVariable Long id) throws Exception{
        CategoriaService s = new CategoriaService();
        Categoria categoria = s.readById(id);
        ModelAndView mv = new ModelAndView("/categoria/form");
        mv.addObject("categoria", categoria);
        return mv;
    }
    
    @RequestMapping(value = "/categorias/{id}/editar", method = RequestMethod.POST)
    public ModelAndView getCategoriaForm(@PathVariable Long id, String nome) throws Exception{
        Categoria categoria = new Categoria();
        categoria.setId(id);
        categoria.setNome(nome);
        CategoriaService s = new CategoriaService();
        s.update(categoria);
        
        return new ModelAndView("redirect:/categorias");
    }
    
}
