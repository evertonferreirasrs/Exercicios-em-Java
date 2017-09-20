package transformacao1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Transformacao1 {

    public static void main(String[] args) {
        Map<String, Double> totais = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String linha = sc.next();
        while (!linha.equals("eof")) {
            String valores[] = linha.split("#");

            String idCliente = valores[0];
            Integer duracao = Integer.parseInt(valores[1]);
            Double valor = Double.parseDouble(valores[2]);

            Double total = (double) (duracao / 60);
            if (duracao % 60 > 0) {
                total += 1;
            }
            total *= valor;

            Double parcial = totais.get(idCliente);
            if (parcial == null) {
                parcial = 0.0;
            }
            parcial += total;
            totais.put(idCliente, parcial);

            linha = sc.next();
        }

        //For aprimorado
        for (String key : totais.keySet()) {
            System.out.println(key + "#" + totais.get(key));
        }
        //Iterator
//        Iterator<String> i = totais.keySet().iterator();
//        while (i.hasNext()) {
//            String key = i.next();
//            System.out.println(key + "#" + totais.get(key));
//        }

    }

}
