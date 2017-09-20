package jrr.aula.model.entity;

import jrr.aula.model.base.BaseEntity;

public class UsuarioImg extends BaseEntity {
    
    private byte[] img;

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
