package jrr.aula.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jrr.aula.model.ConnectionManager;
import jrr.aula.model.base.service.BaseClienteService;
import jrr.aula.model.criteria.UsuarioCriteria;
import jrr.aula.model.dao.UsuarioDAO;
import jrr.aula.model.entity.Cliente;
import jrr.aula.model.entity.Usuario;

public class ClienteService implements BaseClienteService {

    @Override
    public void create(Cliente entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioDAO dao = new UsuarioDAO();
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
    public Cliente readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Cliente cliente = null;
        try {
            UsuarioDAO dao = new UsuarioDAO();
            cliente = (Cliente) dao.readById(conn, id);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
        return cliente;
    }

    @Override
    public List<Cliente> readByCriteria(Map<Long, Object> criteria, Long limit, Long offset) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Cliente> clienteList = null;
        try {
            UsuarioDAO dao = new UsuarioDAO();

            if (criteria == null) {
                criteria = new HashMap<>();
            }
            criteria.put(UsuarioCriteria.CLIENTE, Boolean.TRUE);

            clienteList = (List) dao.readByCriteria(conn, criteria, limit, offset);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
        return clienteList;
    }

    @Override
    public void update(Cliente entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioDAO dao = new UsuarioDAO();
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
            UsuarioDAO dao = new UsuarioDAO();
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
            UsuarioDAO dao = new UsuarioDAO();
 
            if (criteria == null) {
                criteria = new HashMap<>();
            }
            criteria.put(UsuarioCriteria.CLIENTE, Boolean.TRUE);

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
