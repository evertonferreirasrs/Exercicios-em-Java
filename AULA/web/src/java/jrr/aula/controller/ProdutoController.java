package jrr.aula.controller;

import java.math.BigDecimal;
import java.util.List;
import jrr.aula.model.entity.Categoria;
import jrr.aula.model.entity.Produto;
import jrr.aula.model.service.CategoriaService;
import jrr.aula.model.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutoController {

    @RequestMapping(value = "/produtos/novo", method = RequestMethod.GET)
    public ModelAndView getProdutoForm() throws Exception {
        ModelAndView mv = new ModelAndView("produto/form");

        CategoriaService categoriaService = new CategoriaService();
        List<Categoria> categoriaList = categoriaService.readByCriteria(null,0L,0L);
        mv.addObject("categoriaList", categoriaList);

        return mv;
    }

    @RequestMapping(value = "/produtos/novo", method = RequestMethod.POST)
    public ModelAndView postProdutoForm(String nome, BigDecimal preco, Long categoria) throws Exception {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);

        CategoriaService categoriaService = new CategoriaService();
        produto.setCategoria(categoriaService.readById(categoria));

        ProdutoService s = new ProdutoService();
        s.create(produto);

        return new ModelAndView("redirect:/produtos");
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public ModelAndView getProdutosList() throws Exception {
        ProdutoService s = new ProdutoService();
        List<Produto> produtoList = s.readByCriteria(null, 0L, 0L);
        ModelAndView mv = new ModelAndView("produto/list");
        mv.addObject("produtoList", produtoList);
        return mv;
    }

    @RequestMapping(value = "/produtos/{id}/editar", method = RequestMethod.GET)
    public ModelAndView getProdutoForm(@PathVariable Long id) throws Exception {
        ProdutoService s = new ProdutoService();
        Produto produto = s.readById(id);
        ModelAndView mv = new ModelAndView("/produto/form");
        mv.addObject("produto", produto);

        CategoriaService categoriaService = new CategoriaService();
        List<Categoria> categoriaList = categoriaService.readByCriteria(null, 0L,0L);
        mv.addObject("categoriaList", categoriaList);

        return mv;
    }

    @RequestMapping(value = "/produtos/{id}/editar", method = RequestMethod.POST)
    public ModelAndView postProdutoForm(@PathVariable Long id, String nome, BigDecimal preco, Long categoria) throws Exception {

        Produto produto = new Produto();
        produto.setId(id);
        produto.setNome(nome);
        produto.setPreco(preco);

        CategoriaService categoriaService = new CategoriaService();
        produto.setCategoria(categoriaService.readById(categoria));

        ProdutoService produtoService = new ProdutoService();
        produtoService.update(produto);

        return new ModelAndView("redirect:/produtos");
    }

    @RequestMapping(value = "/produtos/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Long id) throws Exception {
        ProdutoService s = new ProdutoService();
        s.delete(id);
        ModelAndView mv = new ModelAndView("redirect:/produtos");
        return mv;
    }

}
