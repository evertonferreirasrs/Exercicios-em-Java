package jrr.aula.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jrr.aula.model.entity.Administrador;
import jrr.aula.model.service.AdministradorService;

public class Main {

    public static void main(String[] args) throws Exception {

        Administrador administrador = new Administrador();
        administrador.setEmail("admin@gmail.com");
        administrador.setNome("Administrador");
        administrador.setSenhaAsPlainText("123456");
        
        AdministradorService s = new AdministradorService();
        s.create(administrador);
        
//        Map<Long,Object> criteria = new HashMap<>();
//        AdministradorService s = new AdministradorService();
//        List<Administrador> lista = s.readByCriteria(criteria, null, null);
        

    }

}
