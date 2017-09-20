package jrr.aula.model.base.service;

import jrr.aula.model.entity.Usuario;

public interface BaseUsuarioService {

    public Usuario login(String email, String senha) throws Exception;

}