package jrr.aula.model.entity;

import jrr.aula.model.base.BaseEntity;

public class Categoria extends BaseEntity{
    
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}