package jrr.aula.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jrr.aula.model.base.BaseDAO;
import jrr.aula.model.criteria.CategoriaCriteria;
import jrr.aula.model.entity.Categoria;

public class CategoriaDAO implements BaseDAO<Categoria> {

    @Override
    public void create(Connection conn, Categoria entity) throws Exception {
        String sql = "INSERT INTO categoria(nome) VALUES (?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, entity.getNome());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entity.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    @Override
    public Categoria readById(Connection conn, Long id) throws Exception {
        String sql = "SELECT id, nome FROM categoria WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        Categoria categoria = null;
        if (rs.next()) {
            categoria = new Categoria();
            categoria.setId(rs.getLong("id"));
            categoria.setNome(rs.getString("nome"));
        }
        rs.close();
        ps.close();
        return categoria;
    }

    @Override
    public List<Categoria> readByCriteria(Connection conn, Map<Long, Object> criteria, Long limit, Long offset) throws Exception {
        String sql = "SELECT id, nome FROM categoria WHERE 1=1";

        sql += applyCriteria(criteria);

        if (limit != null && limit > 0) {
            sql += " limit " + limit;
        }
        if (offset != null && offset >= 0) {
            sql += " offset " + offset;
        }

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        List<Categoria> categoriaList = new ArrayList<>();
        while (rs.next()) {
            Categoria categoria = new Categoria();
            categoria.setId(rs.getLong("id"));
            categoria.setNome(rs.getString("nome"));
            categoriaList.add(categoria);
        }
        return categoriaList;
    }

    @Override
    public void update(Connection conn, Categoria entity) throws Exception {
        String sql = "UPDATE categoria SET nome=? WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, entity.getNome());
        ps.setLong(++i, entity.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Connection conn, Long id) throws Exception {
        String sql = "DELETE FROM categoria WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

    @Override
    public Long countByCriteria(Connection conn, Map<Long, Object> criteria) throws Exception {
        String sql = "SELECT count(*) count FROM categoria WHERE 1=1 ";
        sql += applyCriteria(criteria);
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        Long count = 0L;
        if (rs.next()) {
            count = rs.getLong("count");
        }
        rs.close();
        s.close();
        return count;
    }

    @Override
    public String applyCriteria(Map<Long, Object> criteria) throws Exception{
        String sql = "";
        String nomeILike = (String) criteria.get(CategoriaCriteria.NOME_ILIKE);
        if (nomeILike != null && !nomeILike.isEmpty()) {
            sql += " AND nome ILIKE '%" + nomeILike + "%'";
        }

        String nomeEQ = (String) criteria.get(CategoriaCriteria.NOME_EQ);
        if (nomeEQ != null && !nomeEQ.isEmpty()) {
            sql += " AND nome = '" + nomeEQ + "'";
        }

        Long quantidade = (Long) criteria.get(CategoriaCriteria.PRODUTOS_GE);
        if (quantidade != null && quantidade > 0) {
            sql += " and id in(SELECT categoria_fk FROM produto GROUP BY categoria_fk HAVING count(*) >= " + quantidade + ")";
        }
        return sql;
    }

}
