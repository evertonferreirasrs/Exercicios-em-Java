package jrr.aula.model.service;

import java.sql.Connection;
import jrr.aula.model.ConnectionManager;
import jrr.aula.model.base.service.BaseUsuarioImgService;
import jrr.aula.model.dao.UsuarioImgDAO;
import jrr.aula.model.entity.UsuarioImg;

public class UsuarioImgService implements BaseUsuarioImgService{

    @Override
    public void set(UsuarioImg usuarioImg) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioImgDAO dao = new UsuarioImgDAO();
            dao.delete(conn, usuarioImg.getId());
            dao.create(conn, usuarioImg);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    @Override
    public UsuarioImg get(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        UsuarioImg usuarioImg = null;
        try {
            UsuarioImgDAO dao = new UsuarioImgDAO();
            usuarioImg = dao.readById(conn, id);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
        return usuarioImg;
    }
    
}
