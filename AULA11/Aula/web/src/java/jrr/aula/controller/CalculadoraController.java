package jrr.aula.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController
public class CalculadoraController {
    
    @RequestMapping(value = "/calculadora", method = RequestMethod.GET)
    public  ModelAndView getForm(){
        ModelAndView mv = new ModelAndView("calculadora");
        
        return mv;            
    }
    
    @RequestMapping(value = "/somar", method = RequestMethod.GET)
    public  Long somar(Long n1, Long n2){        
        return n1 + n2;            
    }
    
}
