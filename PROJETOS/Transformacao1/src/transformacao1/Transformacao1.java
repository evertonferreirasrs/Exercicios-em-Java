package transformacao1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Transformacao1 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Map<String,Double> mapa = new HashMap<>();
        String linha = sc.next();
        while (!linha.equals("eof")){
            String valores[] = linha.split("#");
            
            String idCliente = valores[0];
            Integer duracao = Integer.parseInt(valores[1]);
            Double valor = Double.parseDouble(valores[2]);
            
            Double total = (double) (duracao / 60);
            if(duracao % 60 > 0){
                total +=1;
            }
            total *= valor;
            //System.out.println(idCliente + "#" + total);
            //linha = sc.next();
            
            String comparacao = "diferente";
            
            for (String aux: mapa.keySet()) {
                if(aux.equals(idCliente)){
                    mapa.put(aux,mapa.get(aux) + total);
                    comparacao = "igual";
                }
            }
            if(comparacao.equals("diferente")){
                mapa.put(idCliente,total);
            }
            linha = sc.next();
        }
        for(String aux: mapa.keySet()){
            System.out.println(aux + "#" + mapa.get(aux));
        }
    }
    
}
