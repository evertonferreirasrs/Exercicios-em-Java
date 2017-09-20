package jrr.aula.model.base.service;

import jrr.aula.model.entity.UsuarioImg;

public interface BaseUsuarioImgService {
    
    public void set (UsuarioImg usuarioImg) throws Exception;
    
    public UsuarioImg get (Long id) throws Exception;
}
