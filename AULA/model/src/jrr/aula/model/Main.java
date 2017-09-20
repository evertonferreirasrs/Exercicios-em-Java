package jrr.aula.model;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import jrr.aula.model.dao.UsuarioDAO;
import jrr.aula.model.entity.Cliente;
import jrr.aula.model.entity.Produto;
import jrr.aula.model.entity.Usuario;
import jrr.aula.model.service.ProdutoService;

public class Main {

    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();

        Cliente usuario = new Cliente();
        usuario.setNome("Julio");
        usuario.setEmail("julio4@fai-mg.br");
        usuario.setSenha("123456");
        
        ProdutoService s = new ProdutoService();
        List<Produto> produtoList = 
        s.readByCriteria(new HashMap<>(), null, null);

        usuario.setProdutoList(produtoList);
        
        UsuarioDAO dao = new UsuarioDAO();
        dao.create(conn, usuario);
          
        conn.commit();

    }

}
