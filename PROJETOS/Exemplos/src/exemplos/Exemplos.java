package exemplos;

public class Exemplos {

    public static void main(String[] args) {
       
        Produto p = new Produto(); // chama o metodo construtor Produto
        p.setId(1L); // coloca um L pra tratar o inteiro para LONG
        p.setNome("Agua Mineral");
        p.setPreco(2.00F); // padrao eh ser DOUBLE
        
        Produto p2 = p; // p2 tambem aponta para o Objeto
        p2.setId(2L);
        
        System.out.println(p.getId());
        
       // p = null;
       // p2 = null;
        
    }
    
}
