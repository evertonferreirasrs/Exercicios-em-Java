package jrr.aula.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jrr.aula.model.base.BaseDAO;
import jrr.aula.model.criteria.ProdutoCriteria;
import jrr.aula.model.entity.Categoria;
import jrr.aula.model.entity.Produto;

public class ProdutoDAO implements BaseDAO<Produto> {

    @Override
    public void create(Connection conn, Produto entity) throws Exception {
        String sql = "INSERT INTO produto(nome, preco, categoria_fk, ativo) VALUES (?, ?, ?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, entity.getNome());

        if (entity.getPreco() != null) {
            ps.setBigDecimal(++i, entity.getPreco());
        } else {
            ps.setNull(++i, Types.DECIMAL);
        }

        if (entity.getCategoria() != null) {
            ps.setLong(++i, entity.getCategoria().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        if (entity.getAtivo() != null) {
            ps.setBoolean(++i, entity.getAtivo());
        } else {
            ps.setNull(++i, Types.BOOLEAN);
        }

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entity.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    @Override
    public Produto readById(Connection conn, Long id) throws Exception {
        String sql = "SELECT produto.*,categoria.id categoria_id, categoria.nome categoria_nome FROM produto LEFT JOIN categoria ON produto.categoria_fk=categoria.id WHERE produto.id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        Produto produto = null;
        if (rs.next()) {
            produto = new Produto();
            produto.setId(rs.getLong("id"));
            produto.setNome(rs.getString("nome"));
            produto.setPreco(rs.getBigDecimal("preco"));
            if (rs.getLong("categoria_id") > 0) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getLong("categoria_id"));
                categoria.setNome(rs.getString("categoria_nome"));
                produto.setCategoria(categoria);
            }
            produto.setAtivo(rs.getBoolean("ativo"));
        }
        rs.close();
        ps.close();
        return produto;
    }

    @Override
    public List<Produto> readByCriteria(Connection conn, Map<Long, Object> criteria, Long limit, Long offset) throws Exception {
        String sql = "SELECT produto.*,categoria.id categoria_id, categoria.nome categoria_nome FROM produto LEFT JOIN categoria ON produto.categoria_fk=categoria.id WHERE 1=1";

        String nomeILike = (String) criteria.get(ProdutoCriteria.NOME_ILIKE);
        if (nomeILike != null && !nomeILike.isEmpty()) {
            sql += " AND produto.nome ILIKE '%" + nomeILike + "%'";
        }

        String nomeEQ = (String) criteria.get(ProdutoCriteria.NOME_EQ);
        if (nomeEQ != null && !nomeEQ.isEmpty()) {
            sql += " AND produto.nome = '" + nomeEQ + "'";
        }

        if (limit != null && limit > 0) {
            sql += " limit " + limit;
        }
        if (offset != null && offset >= 0) {
            sql += " offset " + offset;
        }

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        List<Produto> produtoList = new ArrayList<>();
        while (rs.next()) {
            Produto produto = new Produto();
            produto.setId(rs.getLong("id"));
            produto.setNome(rs.getString("nome"));
            produto.setPreco(rs.getBigDecimal("preco"));
            if (rs.getLong("categoria_id") > 0) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getLong("categoria_id"));
                categoria.setNome(rs.getString("categoria_nome"));
                produto.setCategoria(categoria);
            }
            produto.setAtivo(rs.getBoolean("ativo"));
            produtoList.add(produto);
        }
        return produtoList;
    }

    @Override
    public Long countByCriteria(Connection conn, Map<Long, Object> criteria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Connection conn, Produto entity) throws Exception {
        String sql = "UPDATE produto SET nome=?, preco=?, categoria_fk=?, ativo=? WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, entity.getNome());

        if (entity.getPreco() != null) {
            ps.setBigDecimal(++i, entity.getPreco());
        } else {
            ps.setNull(++i, Types.DECIMAL);
        }

        if (entity.getCategoria() != null) {
            ps.setLong(++i, entity.getCategoria().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        if (entity.getAtivo() != null) {
            ps.setBoolean(++i, entity.getAtivo());
        } else {
            ps.setNull(++i, Types.BOOLEAN);
        }
        ps.setLong(++i, entity.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Connection conn, Long id) throws Exception {
        String sql = "DELETE FROM produto WHERE id=?;";
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