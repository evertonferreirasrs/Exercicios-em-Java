package jrr.aula.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jrr.aula.model.base.service.BaseCategoriaService;
import jrr.aula.model.entity.Categoria;

public class CategoriaService implements BaseCategoriaService {

    //Isso só existe no mock
    private static List<Categoria> categoriaList = new ArrayList<Categoria>();
    private static Long categoriaIdSequence = 0L;
    //

    @Override
    public void create(Categoria entity) throws Exception {
        entity.setId(++categoriaIdSequence);
        categoriaList.add(entity);
    }

    @Override
    public Categoria readById(Long id) throws Exception {
        Categoria categoria = null;
        
        for (Categoria aux: categoriaList) {
            if(aux.getId().equals(id)){
                categoria = aux;
                break;
            }
        }
        return categoria;
    }

    @Override
    public List<Categoria> readByCriteria(Map<Long, Object> criteria) throws Exception {
        return categoriaList;
    }

    @Override
    public void update(Categoria entity) throws Exception {
        Categoria categoria = readById(entity.getId());
        if(categoria!=null){
            categoria.setNome(entity.getNome());
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        Categoria categoria = readById(id);
        if(categoria != null){
            categoriaList.remove(categoria);
        }
    }

}
