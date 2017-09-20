package jrr.aula.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{
    
    private List<Produto> produtoList;

    public Cliente() {
        produtoList = new ArrayList<>();
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }
    
}