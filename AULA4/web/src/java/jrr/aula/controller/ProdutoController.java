package jrr.aula.controller;

import java.util.List;
import jrr.aula.model.entity.Categoria;
import jrr.aula.model.entity.Produto;
import jrr.aula.model.service.CategoriaService;
import jrr.aula.model.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutoController {
    
    @RequestMapping(value = "/produtos/novo", method = RequestMethod.GET)
    public ModelAndView getProdutoForm() throws Exception {
        ModelAndView mv = new ModelAndView("produto/form");
        
        CategoriaService categoriaService = new CategoriaService();
        List<Categoria> categoriaList = categoriaService.readByCriteria(null);
        mv.addObject("categoriaList", categoriaList);
        
        
        return mv;
    }
    
    @RequestMapping(value = "/produtos/novo", method = RequestMethod.POST)
    public ModelAndView postProdutoForm(String nome, Double preco, Long categoria) throws Exception {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);
        
        CategoriaService categoriaService = new CategoriaService();
        produto.setCategoria(categoriaService.readById(categoria));

        ProdutoService p = new ProdutoService();
        p.create(produto);

        return new ModelAndView("redirect:/produtos");
    }
    
    
    
    
}
