package pedido;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pedido {

    public static void main(String[] args) {
        Map <String,Double> pedidosClientes = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String linha = sc.next();

        while (!linha.equals("eof")) {
            String valores[] = linha.split("#");
            String idCliente = valores[0];
            
            Double total = 0.0;
            int i = 1;
            while(i < valores.length){
                String idProduto = valores[i++];
                Integer quantidade = Integer.parseInt(valores[i++]);
                Double preco = Double.parseDouble(valores[i++]);
                
                total += (quantidade * preco);
                
                Double parcial = pedidosClientes.get(idCliente);
                if(parcial == null){
                    parcial = 0.0;
                }
                parcial += total;
                
                pedidosClientes.put(idCliente, parcial);
            }
            //System.out.println(idCliente + "#" + total);
            linha = sc.next();
        }
        Double maior = 0.0;
        Double menor = 99999999.0;
        
        for(String key : pedidosClientes.keySet() )
        {
            if(pedidosClientes.get(key) > maior){
               maior =  pedidosClientes.get(key);
            }
            if(pedidosClientes.get(key) < menor){
               menor =  pedidosClientes.get(key);
            }
        }
        System.out.println("Menor: " + menor + " Maior: " + maior);
        
    }
    
}
