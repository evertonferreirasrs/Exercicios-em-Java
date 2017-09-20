package prova;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Prova {

    public static void main(String[] args) {
        Prova p = new Prova();
        Scanner sc = new Scanner(System.in);
        Map<String, List<Double>> m = new HashMap<>();

        String linha = sc.nextLine();

        while (!linha.equals("eof")) {
            String vetor[] = linha.split("#");

            String idCliente = vetor[0];
            String dataHota = vetor[1];
            Integer duracaoEmSegundos = Integer.parseInt(vetor[2]);
            Double valorMinuto = Double.parseDouble(vetor[3]);

            Double total = (double) (duracaoEmSegundos / 60);

            if (duracaoEmSegundos % 60 > 0) {
                total += 1;
            }
            total *= valorMinuto;
            //System.out.println(total);

            if (p.verificaSeExiste(m, idCliente)) {
                m.get(idCliente).add(total);
            } else {
                List<Double> l = new ArrayList();
                l.add(total);
                m.put(idCliente, l);
            }

            linha = sc.nextLine();
        }
        System.out.println("-----------------------------");
        p.valorPagar(m);
        System.out.println("-----------------------------");
        p.estatistica(m);
    }

    public Boolean verificaSeExiste(Map<String, List<Double>> mapa, String chave) {
        for (String aux : mapa.keySet()) {
            if (chave.equals(aux)) {
                return true;
            }
        }
        return false;
    }

    public void valorPagar(Map<String, List<Double>> mapa) {
        for (String aux : mapa.keySet()) {
            Double total = 0.0;
            for (int i = 0; i < mapa.get(aux).size(); i++) {
                total += mapa.get(aux).get(i);
            }
            System.out.println(aux + "#" + total);
        }
    }

    public void estatistica(Map<String, List<Double>> mapa) {
        for (String aux : mapa.keySet()) {
            Double media = 0.0;
            Double maior = 0.0;
            Double menor = 999999.9;

            for (int i = 0; i < mapa.get(aux).size(); i++) {
                if (mapa.get(aux).get(i) > maior) {
                    maior = mapa.get(aux).get(i);
                }
                if (mapa.get(aux).get(i) < menor) {
                    menor = mapa.get(aux).get(i);
                }

                media += mapa.get(aux).get(i);
            }
            media /= mapa.get(aux).size();

            System.out.print(aux + ": Maior: " + maior);
            System.out.print(" Menor: " + menor);
            System.out.println(" Media: " + media);

        }
    }
}
