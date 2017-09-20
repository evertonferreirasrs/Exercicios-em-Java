/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranformacaodedados;

/**
 *
 * @author EVERTON
 */
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private List<String> entradaList = new ArrayList<>();
    private Set<String> produtoSet = new LinkedHashSet<>();

    private void executar() {
        //Ler as entradas
        Scanner scanner = new Scanner(System.in);
        String entrada;
        do {
            entrada = scanner.nextLine().trim().toLowerCase();
            if (!entrada.isEmpty()) {
                entradaList.add(entrada);
            }
        } while (!entrada.isEmpty());

        //Eliminar as repetições
        for (String aux : entradaList) {
            String[] produtos = aux.split(",");
            for (String produto : produtos) {
                produtoSet.add(produto.trim());
            }
        }

        //Imprimindo o cabecalho
        String cabecalho = "";
        for (String aux : produtoSet) {
            cabecalho += "," + aux;
        }
        cabecalho = cabecalho.substring(1);
        System.out.println(cabecalho);

        //Tranformando os dados
        for (String auxEntrada : entradaList) {
            String linha = "";
            String[] produtos = auxEntrada.split(",");
            for (String auxProdutos : produtoSet) {
                boolean valor = false;
                for (String produto : produtos) {
                    if (auxProdutos.equals(produto)) {
                        valor = true;
                        break;
                    }
                }
                linha+=","+valor;
            }
            System.out.println(linha.substring(1));
        }

    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.executar();
    }

}
