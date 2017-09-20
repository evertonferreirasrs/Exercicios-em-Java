package jrr.aula.model;

import java.util.List;
import jrr.aula.model.entity.Categoria;
import jrr.aula.model.service.CategoriaService;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        CategoriaService s = new CategoriaService();

        Categoria categoria = new Categoria();
        categoria.setNome("Jogos");
        s.create(categoria);

        List<Categoria> categoriaList = s.readByCriteria(null);        
        for(Categoria aux : categoriaList){
            System.out.println(aux.getId()+" - "+ aux.getNome());
        }
    
    }
    
}
