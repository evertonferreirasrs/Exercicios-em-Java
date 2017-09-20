package jrr.aula.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jrr.aula.model.ConnectionManager;
import jrr.aula.model.base.service.BaseProdutoService;
import jrr.aula.model.criteria.ProdutoCriteria;
import jrr.aula.model.dao.ProdutoDAO;
import jrr.aula.model.entity.Produto;

public class ProdutoService implements BaseProdutoService {

    @Override
    public void create(Produto entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            ProdutoDAO dao = new ProdutoDAO();
            dao.create(conn, entity);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    @Override
    public Produto readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Produto produto = null;
        try {
            ProdutoDAO dao = new ProdutoDAO();
            produto = dao.readById(conn, id);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
        return produto;
    }

    @Override
    public List<Produto> readByCriteria(Map<Long, Object> criteria, Long limit, Long offset) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Produto> produtoList = null;
        try {
            ProdutoDAO dao = new ProdutoDAO();
            produtoList = dao.readByCriteria(conn, criteria, limit, offset);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
        return produtoList;
    }

    @Override
    public void update(Produto entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            ProdutoDAO dao = new ProdutoDAO();
            dao.update(conn, entity);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            ProdutoDAO dao = new ProdutoDAO();
            dao.delete(conn, id);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

    @Override
    public Map<String, String> validate(Map<String, Object> fields) throws Exception {

        Map<String, String> errors = new HashMap<>();

        return errors;
    }

    @Override
    public Long countByCriteria(Map<Long, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Long count = 0L;
        try {
            ProdutoDAO dao = new ProdutoDAO();
            count = dao.countByCriteria(conn, criteria);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
        return count;
    }
}
