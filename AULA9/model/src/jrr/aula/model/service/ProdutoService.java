package jrr.aula.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jrr.aula.model.base.service.BaseProdutoService;
import jrr.aula.model.entity.Produto;

public class ProdutoService implements BaseProdutoService {

    //Isso só existe no mock
    private static List<Produto> produtoList = new ArrayList<Produto>();
    private static Long produtoIdSequence = 0L;
    //

    @Override
    public void create(Produto entity) throws Exception {
        entity.setId(++produtoIdSequence);
        produtoList.add(entity);
    }

    @Override
    public Produto readById(Long id) throws Exception {
        Produto produto = null;
        for (Produto aux : produtoList) {
            if (aux.getId().equals(id)) {
                produto = aux;
                break;
            }
        }
        return produto;
    }

    @Override
    public List<Produto> readByCriteria(Map<Long, Object> criteria, Long limit, Long offset) throws Exception {
        return produtoList;
    }

    @Override
    public void update(Produto entity) throws Exception {
        Produto produto = readById(entity.getId());
        if (produto != null) {
            produto.setNome(entity.getNome());
            produto.setPreco(entity.getPreco());
            produto.setCategoria(entity.getCategoria());
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        Produto produto = readById(id);
        if (produto != null) {
            produtoList.remove(produto);
        }
    }
}