package jrr.aula.model;

import java.sql.Connection;
import jrr.aula.model.dao.UsuarioDAO;
import jrr.aula.model.entity.Administrador;
import jrr.aula.model.entity.Cliente;
import jrr.aula.model.entity.Produto;
import jrr.aula.model.entity.Usuario;

public class Main {

    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();

        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.readById(conn, 1L);
        System.out.println(usuario.getId());
        System.out.println(usuario.getNome());
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getSenha());
        if (usuario instanceof Administrador) {
            Administrador administrador = (Administrador) usuario;
        } else {
            Cliente cliente = (Cliente) usuario;
            for (Produto produto : cliente.getProdutoList()) {
                String tab="\t";
                System.out.println(tab+produto.getId());
                System.out.println(tab+produto.getNome());
                System.out.println(tab+produto.getPreco());
                System.out.println(tab+produto.getAtivo());
                System.out.println(tab+tab+produto.getCategoria().getId());
                System.out.println(tab+tab+produto.getCategoria().getNome());
            }
        }
        conn.close();
    }

}
