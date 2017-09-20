package jrr.aula.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import jrr.aula.model.base.BaseDAO;
import jrr.aula.model.entity.Administrador;
import jrr.aula.model.entity.Categoria;
import jrr.aula.model.entity.Cliente;
import jrr.aula.model.entity.Produto;
import jrr.aula.model.entity.Usuario;

public class UsuarioDAO implements BaseDAO<Usuario> {

    @Override
    public void create(Connection conn, Usuario entity) throws Exception {

        String sql = "INSERT INTO usuario(nome, email, senha) VALUES (?, ?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, entity.getNome());
        ps.setString(++i, entity.getEmail());
        ps.setString(++i, entity.getSenha());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entity.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();

        if (entity instanceof Administrador) {
            this.createAdministrador(conn, (Administrador) entity);
        } else if (entity instanceof Cliente) {
            this.createCliente(conn, (Cliente) entity);
        }
    }

    private void createAdministrador(Connection conn, Administrador entity) throws Exception {
        String sql = "INSERT INTO administrador (usuario_fk) VALUES (?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, entity.getId());
        ps.execute();
        ps.close();
    }

    private void createCliente(Connection conn, Cliente entity) throws Exception {
        String sql = "INSERT INTO cliente (usuario_fk) VALUES (?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, entity.getId());
        ps.execute();
        ps.close();
        this.updateProdutoList(conn, entity);
    }

    private void updateProdutoList(Connection conn, Cliente entity) throws Exception {
        String sql = "DELETE FROM cliente_produto WHERE cliente_fk=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, entity.getId());
        ps.execute();
        ps.close();

        sql = "INSERT INTO cliente_produto(cliente_fk, produto_fk) VALUES (?, ?);";
        ps = conn.prepareStatement(sql);
        for (Produto produto : entity.getProdutoList()) {
            i = 0;
            ps.setLong(++i, entity.getId());
            ps.setLong(++i, produto.getId());
            ps.execute();
        }
        ps.close();
    }

    @Override
    public Usuario readById(Connection conn, Long id) throws Exception {
        String sql = "select usuario.*, administrador.usuario_fk administrador, cliente.usuario_fk cliente, produto.id produto_id, produto.nome produto_nome, produto.preco produto_preco, produto.ativo produto_ativo, categoria.id categoria_id, categoria.nome categoria_nome from usuario left join administrador on usuario.id = administrador.usuario_fk left join cliente on usuario.id = cliente.usuario_fk left join cliente_produto on cliente.usuario_fk = cliente_produto.cliente_fk left join produto on produto.id = cliente_produto.produto_fk left join categoria on categoria.id=produto.categoria_fk where usuario.id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        Usuario usuario = null;
        while (rs.next()) {
            if (usuario == null) {
                if (rs.getLong("administrador") > 0) {
                    usuario = new Administrador();
                } else {
                    usuario = new Cliente();
                }
            }
            usuario.setId(rs.getLong("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            if (usuario instanceof Cliente) {
                if (rs.getLong("produto_id") > 0) {
                    Categoria categoria = new Categoria();
                    categoria.setId(rs.getLong("categoria_id"));
                    categoria.setNome(rs.getString("categoria_nome"));

                    Produto produto = new Produto();
                    produto.setId(rs.getLong("produto_id"));
                    produto.setNome(rs.getString("produto_nome"));
                    produto.setPreco(rs.getBigDecimal("produto_preco"));
                    produto.setAtivo(rs.getBoolean("produto_ativo"));
                    produto.setCategoria(categoria);

                    Cliente cliente = (Cliente) usuario;
                    cliente.getProdutoList().add(produto);
                }
            }
        }
        rs.close();
        ps.close();
        return usuario;
    }

    @Override
    public List<Usuario> readByCriteria(Connection conn, Map<Long, Object> criteria, Long limit, Long offset) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long countByCriteria(Connection conn, Map<Long, Object> criteria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Connection conn, Usuario entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Connection conn, Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String applyCriteria(Map<Long, Object> criteria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
