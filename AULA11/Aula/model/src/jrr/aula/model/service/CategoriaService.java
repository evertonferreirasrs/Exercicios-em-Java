package jrr.aula.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jrr.aula.model.ConnectionManager;
import jrr.aula.model.base.service.BaseCategoriaService;
import jrr.aula.model.criteria.CategoriaCriteria;
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
            throw e;
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
    public List<Categoria> readByCriteria(Map<Long, Object> criteria, Long limit, Long offset) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Categoria> categoriaList = null;
        try {
            CategoriaDAO dao = new CategoriaDAO();
            categoriaList = dao.readByCriteria(conn, criteria, limit, offset);
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

    @Override
    public Map<String, String> validate(Map<String, Object> fields) throws Exception {

        Map<String, String> errors = new HashMap<>();

        Long id = (Long) fields.get("id");
        String nome = (String) fields.get("nome");
        if (nome == null || nome.trim().isEmpty()) {
            errors.put("nome", "Campo Obrigatório!");
        } else {
            Map<Long, Object> criteria = new HashMap<>();
            criteria.put(CategoriaCriteria.NOME_EQ, nome);
            if (id != null && id > 0L) {
                criteria.put(CategoriaCriteria.ID_NE, id);
            }
            List<Categoria> categoriaList
                    = this.readByCriteria(criteria, null, null);
            if (!categoriaList.isEmpty()) {
                errors.put("nome", "Este valor já se encontra em uso!");
            }
        }
        return errors;
    }

    @Override
    public Long countByCriteria(Map<Long, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Long count = 0L;
        try {
            CategoriaDAO dao = new CategoriaDAO();
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
