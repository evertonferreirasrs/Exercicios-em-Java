
package pedido;

import java.util.Scanner;

public class Pedido {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linha = sc.next();
        
        while(!linha.equals("eof")){            
            String valores[] = linha.split("#");
            
            String idCLiente = valores[0];
            
            Double total = 0.0;            
            int i = 1;
            while(i < valores.length){
                String idProduto = valores[i++];
                Integer quantidade = Integer.parseInt(valores[i++]);
                Double preco = Double.parseDouble(valores[i++]);
                total+=(quantidade*preco);
            }
            System.out.println(idCLiente +"#" + total);
            
            linha = sc.next();
        }
    }
    
}
