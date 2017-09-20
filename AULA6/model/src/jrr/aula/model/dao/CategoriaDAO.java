package jrr.aula.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jrr.aula.model.base.BaseDAO;
import jrr.aula.model.entity.Categoria;

public class CategoriaDAO implements BaseDAO<Categoria> {

    @Override
    public void create(Connection conn, Categoria entity) throws Exception {
        String sql = "INSERT INTO categoria(nome) VALUES (?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, entity.getNome());
        ResultSet rs =  ps.executeQuery();
        if(rs.next()){
            entity.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    @Override
    public Categoria readById(Connection conn, Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categoria> readByCriteria(Connection conn, Map<Long, Object> criteria) throws Exception {
        String sql = "SELECT id, nome FROM categoria;";
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        List<Categoria> categoriaList = new ArrayList<>();
        while (rs.next()) {
            Categoria categoria = new Categoria();
            categoria.setId(rs.getLong("id"));
            categoria.setNome(rs.getString("nome"));
            categoriaList.add(categoria);
        }
        rs.close();
        s.close();
        return categoriaList;
    }

    @Override
    public void update(Connection conn, Categoria entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Connection conn, Long id) throws Exception {
        String sql = "DELETE FROM categoria WHERE id?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        
        ps.execute();
        ps.close();      
    }

}
