package jrr.aula.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jrr.aula.model.ConnectionManager;
import jrr.aula.model.base.service.BaseCategoriaService;
import jrr.aula.model.dao.CategoriaDAO;
import jrr.aula.model.entity.Categoria;

public class CategoriaService implements BaseCategoriaService {

    @Override
    public void create(Categoria entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            CategoriaDAO dao = new CategoriaDAO();
            dao.create(conn, entity);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

    @Override
    public Categoria readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Categoria categoria = null;
        try {
            CategoriaDAO dao = new CategoriaDAO();
            categoria = dao.readById(conn, id);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
        return categoria;
    }

    @Override
    public List<Categoria> readByCriteria(Map<Long, Object> criteria) throws Exception {
        
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Categoria> categoriaList = null;
        try {
            CategoriaDAO dao = new CategoriaDAO();
            categoriaList = dao.readByCriteria(conn, criteria);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
        return categoriaList;
    }

    @Override
    public void update(Categoria entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            CategoriaDAO dao = new CategoriaDAO();
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
            CategoriaDAO dao = new CategoriaDAO();
            dao.delete(conn, id);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }
}
