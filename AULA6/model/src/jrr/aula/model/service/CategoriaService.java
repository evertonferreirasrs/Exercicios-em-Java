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

    //Isso só existe no mock
    private static List<Categoria> categoriaList = new ArrayList<Categoria>();
    private static Long categoriaIdSequence = 0L;
    //

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
        Categoria categoria = null;
        for (Categoria aux : categoriaList) {
            if (aux.getId().equals(id)) {
                categoria = aux;
                break;
            }
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
        Categoria categoria = readById(entity.getId());
        if (categoria != null) {
            categoria.setNome(entity.getNome());
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
