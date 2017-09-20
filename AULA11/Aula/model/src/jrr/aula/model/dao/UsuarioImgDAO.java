package jrr.aula.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import jrr.aula.model.base.BaseDAO;
import jrr.aula.model.entity.UsuarioImg;

public class UsuarioImgDAO implements BaseDAO<UsuarioImg> {

    @Override
    public void create(Connection conn, UsuarioImg entity) throws Exception {
        String sql = "INSERT INTO usuario_img(usuario_fk, img) VALUES (?, ?);";
        PreparedStatement ps = conn.prepareStatement(sql);

        int i = 0;

        ps.setLong(++i, entity.getId());
        ps.setBytes(++i, entity.getImg());

        ps.execute();
        ps.close();
    }

    @Override
    public UsuarioImg readById(Connection conn, Long id) throws Exception {
        String sql = "SELECT usuario_fk, img FROM usuario_img WHERE usuario_fk=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);

        ResultSet rs = ps.executeQuery();

        UsuarioImg usuarioImg  = null;
        if (rs.next()) {
            usuarioImg = new UsuarioImg();
            usuarioImg.setId(rs.getLong("usuario_fk"));
            usuarioImg.setImg(rs.getBytes("img"));
        }
        rs.close();
        ps.close();
        return usuarioImg;
    }

    @Override
    public List<UsuarioImg> readByCriteria(Connection conn, Map<Long, Object> criteria, Long limit, Long offset) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long countByCriteria(Connection conn, Map<Long, Object> criteria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Connection conn, UsuarioImg entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Connection conn, Long id) throws Exception {
        String sql = "DELETE FROM usuario_img WHERE usuario_fk=?;";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

    @Override
    public String applyCriteria(Map<Long, Object> criteria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
