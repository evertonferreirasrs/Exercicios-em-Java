package helloworld.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculadoraController {
    
    @RequestMapping(value = "/Somar", method = RequestMethod.GET)
    public ModelAndView getSomar(){ 
        ModelAndView mv = new ModelAndView("calculadora/form");
        mv.addObject("operacao", "Somar");
        return mv;
    }
    @RequestMapping(value = "/Somar", method = RequestMethod.POST)
    public ModelAndView postSomar(Double n1, Double n2, HttpSession session){
        Double resultado = n1 + n2;
        
        List<String> calculoList = (List<String>) session.getAttribute("calculoList");
        if (calculoList == null){
            calculoList = new ArrayList<>();
            session.setAttribute("calculoList", calculoList);
        }
        calculoList.add(0, n1+" + "+n2+" = "+ resultado);
        
        ModelAndView mv = new ModelAndView("calculadora/form");
        mv.addObject("n1", n1);
        mv.addObject("n2", n2);
        mv.addObject("operacao", "Somar");
        mv.addObject("resultado", resultado);
        return mv;
    }
    
    @RequestMapping(value = "/Limpar", method = RequestMethod.GET)
    public ModelAndView limpar(String back, HttpSession session){
        List<String> calculoList = (List<String>) session.getAttribute("calculoList");
        if (calculoList != null) {
            calculoList.clear();
        }
        
        ModelAndView mv = new ModelAndView("redirect:/" + back);
        return mv;
    }
    
}
