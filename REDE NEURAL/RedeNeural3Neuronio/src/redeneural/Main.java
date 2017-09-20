/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redeneural;

/**
 *
 * @author EVERTON
 */
import java.util.Random;
import java.util.Scanner;

public class Main {

    double bias = -1;
    double eta = 0.3;
    double deltaEta = 0.000005;
    double erroMaximoAceitavel = 0.00001;
    int maxEpocas = 100;
    boolean wRandon = true;

    double entradas[][] = {{1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1}, //A
    {0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1}, //A
    {1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0}, //B
    {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}, //B
    {0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1}, //C
    {1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1}};//C
    

    double yDs[][] = {{1, 0, 0}, //A 
    {1, 0, 0}, //A
    {0, 1, 0}, //B
    {0, 1, 0}, //B
    {0, 0, 1}, //C
    {0, 0, 1}};//C

    double ws[][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    double wBias[] = {0, 0, 0};

    private void executar() {
        treinar();
        classificar();
    }

    private void classificar() {
        Scanner sc = new Scanner(System.in);
        double entrada[] = new double[entradas[0].length];
        //Ler entradas
        System.out.println("Entre com as " + entrada.length + " entradas:");
        for (int i = 0; i < entrada.length; i++) {
            entrada[i] = Double.parseDouble(sc.nextLine());
        }
        // Neuronio
        // Calcular o v
        double v = 0.0;
        for (int n = 0; n < yDs[0].length; n++) {
            v = (wBias[n] * bias);
            for (int j = 0; j < entrada.length; j++) {
                v += ws[n][j] * entrada[j];
            }
        }        
        // Calcular o y
        double y = calcularY(v);
        System.out.println(y);
    }

    private void treinar() {
        double erroQuadratico = 1; // Erro da Época
        int epoca = 0;
        // Inicializando pesos
        if (wRandon) {
            Random r = new Random();
            ws = new double[yDs[0].length][entradas[0].length];
            for (int i = 0; i < ws.length; i++) {       //varia na primeira dimensao
                for (int j = 0; j < ws.length; j++) {   //varia na segunda dimensao
                    ws[i][j] = r.nextDouble();
                    if (r.nextInt(2) != 0) {
                        ws[i][j] *= -1;
                    }
                }
            }
            
            
            wBias = new double[yDs[0].length];
            for (int k = 0; k < wBias.length; k++) {
                wBias[k] = r.nextDouble();
                if (r.nextInt(2) != 0) {
                    wBias[k] *= -1;
                }
            }
        }
        // Treinamento
        // Epoca
        while (erroQuadratico > erroMaximoAceitavel && epoca < maxEpocas) { //Varias Epocas
            erroQuadratico = 0;
            System.out.println("Época: " + (epoca + 1));
            System.out.println("Eta: " + eta);

            //Iteração
            for (int m = 0; m < entradas.length; m++) {
                // Neuronio
                for (int n = 0; n < yDs[0].length; n++) {
                    // Calcular o v, potencial de ativação
                    double v = (wBias[n] * bias);
                    for (int j = 0; j < entradas[m].length; j++) {
                        v += ws[n][j] * entradas[m][j];
                    }
                    
                    // Calcular o y
                    double y = calcularY(v);
                    
                    // Calcular o erro do neuronio na iteração
                    // Erro do instante, erro daquele momento
                    double erroInstantaneo = yDs[m][n] - y;

                    // Ajustar os pesos
                    wBias[n] += (bias * erroInstantaneo * eta);
                    for (int j = 0; j < entradas[m].length; j++) {
                        ws[n][j] += (entradas[m][j] * erroInstantaneo * eta);
                    }

                    // Incrementa o erro da epoca
                    erroQuadratico += (erroInstantaneo * erroInstantaneo);

                    //Mostrar resultados na tela
                    System.out.print(yDs[m][n] + " -> ");
                    System.out.print(y + " (" + erroInstantaneo + ")");
                    System.out.println("");
                }
                System.out.println("------------------");
            }
            erroQuadratico = erroQuadratico / (entradas.length * yDs[0].length);
            System.out.println("Erro Quadratico: " + erroQuadratico);
            epoca++;
            eta *= (1 - deltaEta);
        }
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.executar();
    }

    // Saidas:0 ou 1
    private double funcaoDegrau(double v) {
        double y = 0;
        if (v >= 0) {
            y = 1;
        }
        return y;
    }

    // Saidas entre -1 e 1
    private double funcaoTanHiperbolica(double v) {
        return StrictMath.tanh(v);
    }

    // Saidas entre 0 e 1
    private double funcaoSigmoidal(double v) {
        double beta = 0.5;
        double e = Math.E;
        return 1 / (1 + Math.pow(e, -(beta) * v));
    }

    private double calcularY(double v) {
        return funcaoDegrau(v);
    }

}
