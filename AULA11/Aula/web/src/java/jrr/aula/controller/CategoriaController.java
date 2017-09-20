package jrr.aula.controller;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import jrr.aula.constraint.AppConstraints;
import jrr.aula.model.ConnectionManager;
import jrr.aula.model.criteria.CategoriaCriteria;
import jrr.aula.model.entity.Categoria;
import jrr.aula.model.service.CategoriaService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
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
    
    @RequestMapping(value = "/categorias/relatorio", method = RequestMethod.GET)
    public ModelAndView getCategoriaRelatorioForm() {
        ModelAndView mv = new ModelAndView("categoria/relatorioform");
        return mv;
    }
    
    @RequestMapping(value = "/categorias/relatorio", method = RequestMethod.POST)
    public void postCategoriaRelatorioForm(HttpServletResponse response)throws Exception {
        
        //Arquivo do relatorio
        InputStream is = getClass().getResourceAsStream("/jrr/aula/report/reportCategorias.jasper");
        //Connection
        Connection conn = ConnectionManager.getInstance().getConnection();
        //Parameters
        Map parameter = new HashMap();
        
        JasperPrint print = JasperFillManager.fillReport(is, parameter, conn);
        
        byte[] pdf = JasperExportManager.exportReportToPdf(print);
        
        response.setContentType("application/pdf");
        response.setContentLength(pdf.length);
        response.getOutputStream().write(pdf);
        response.flushBuffer();
        
        conn.close();
    }

    @RequestMapping(value = "/categorias/novo", method = RequestMethod.POST)
    public ModelAndView postCategoriaForm(String nome) throws Exception {
        ModelAndView mv;
        Map<String, Object> fields = new HashMap<>();
        fields.put("nome", nome);
        CategoriaService s = new CategoriaService();
        Map<String, String> errors = s.validate(fields);
        if (errors.isEmpty()) {
            Categoria categoria = new Categoria();
            categoria.setNome(nome);
            s.create(categoria);
            mv = new ModelAndView("redirect:/categorias");
        } else {
            mv = new ModelAndView("categoria/form");
            mv.addObject("errors", errors);
            mv.addObject("nome", nome);
        }
        return mv;
    }

    @RequestMapping(value = "/categorias", method = RequestMethod.GET)
    public ModelAndView getCategoriaList(String nome, Long produtos, Long limit, Long offset) throws Exception {
        ModelAndView mv;
        if (limit != null && offset != null) {
            Map<Long, Object> criteria = new HashMap<>();
            criteria.put(CategoriaCriteria.NOME_ILIKE, nome);
            criteria.put(CategoriaCriteria.PRODUTOS_GE, produtos);

            CategoriaService s = new CategoriaService();
            List<Categoria> categoriaList = s.readByCriteria(criteria, limit, offset);
            Long count = s.countByCriteria(criteria);
            
            mv = new ModelAndView("categoria/list");
            mv.addObject("nome", nome);
            mv.addObject("produtos", produtos);
            mv.addObject("categoriaList", categoriaList);
            mv.addObject("count", count);
            mv.addObject("limit", limit);
            mv.addObject("offset", offset);
        } else {
            String redirect = "redirect:/categorias?limit=" + AppConstraints.DEFAULT_PAGE_SIZE + "&offset=0";
            if (nome != null && !nome.isEmpty()) {
                redirect += "&nome=" + nome;
            }
            if (produtos != null && produtos > 0) {
                redirect += "&produtos=" + produtos;
            }
            mv = new ModelAndView(redirect);
        }
        return mv;
    }

    @RequestMapping(value = "/categorias/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Long id) throws Exception {
        CategoriaService s = new CategoriaService();
        s.delete(id);
        ModelAndView mv = new ModelAndView("redirect:/categorias");
        return mv;
    }

    @RequestMapping(value = "/categorias/{id}/editar", method = RequestMethod.GET)
    public ModelAndView getCategoriaForm(@PathVariable Long id) throws Exception {
        CategoriaService s = new CategoriaService();
        Categoria categoria = s.readById(id);
        ModelAndView mv = new ModelAndView("/categoria/form");
        mv.addObject("categoria", categoria);
        return mv;
    }

    @RequestMapping(value = "/categorias/{id}/editar", method = RequestMethod.POST)
    public ModelAndView postCategoriaForm(@PathVariable Long id, String nome) throws Exception {
        Categoria categoria = new Categoria();
        categoria.setId(id);
        categoria.setNome(nome);
        CategoriaService s = new CategoriaService();
        s.update(categoria);
        return new ModelAndView("redirect:/categorias");
    }

}
