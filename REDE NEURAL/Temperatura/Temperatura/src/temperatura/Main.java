/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperatura;

/**
 *
 * @author EVERTON
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    private List<Integer> entradaList = new ArrayList<>();

    private void executar() {
        
        Scanner scanner = new Scanner(System.in);
        String entrada;
        
        do {
            entrada = scanner.nextLine().trim().toLowerCase();
            if (!entrada.isEmpty()) {
                entradaList.add(Integer.parseInt(entrada));
            }
        } while (!entrada.isEmpty());
        
        
        //Tranformando os dados
        for (Integer auxEntrada : entradaList) {
            boolean valor = false;
            String resp = "";
            
            if(auxEntrada < 0){
                valor = true;
            }
            resp += " " + valor;
            if(auxEntrada >= 0 && auxEntrada <= 10){
                valor = true;
            }else{
                valor = false;
            }
            resp += " " + valor;
            if(auxEntrada > 10 && auxEntrada <= 20){
                valor = true;
            }else{
                valor = false;
            }
            resp += " " + valor;
            if(auxEntrada > 20 && auxEntrada <= 30){
                valor = true;
            }else{
                valor = false;
            }
            resp += " " + valor;
            if(auxEntrada > 30 && auxEntrada <= 40){
                valor = true;
            }else{
                valor = false;
            }
            resp += " " + valor;
            if(auxEntrada > 40 && auxEntrada <= 50){
                valor = true;
            }else{
                valor = false;
            }
            resp += " " + valor;
            if(auxEntrada > 50){
                valor = true;
            }else{
                valor = false;
            }
            resp += " " + valor;
            
            System.out.println(resp);
        }            

    }
    public static void main(String[] args) {
        Main obj = new Main();
        obj.executar();
    }

}
