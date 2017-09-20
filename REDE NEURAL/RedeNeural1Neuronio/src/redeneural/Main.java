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

public class Main {

    double bias = -1;
    double eta = 0.3;
    double deltaEta = 0;
    double erroMaximoAceitavel = 0.05;
    int maxEpocas = 1000;
    boolean wRandon = true;

    double entradas[][] = {{0, 0, 0}, {0, 1, 0}, {1, 0, 0}, {1, 1, 1}};
    double yDs[] = {0, 1, 1, 0};
    double ws[] = {0.2, -0.3, 0.5};
    double wBias = 0.5;

    private void executar() {
        treinar();
        classificar();
    }
    
    private void classificar() {
        double a = 1;
        double b = 1;
        double c = 1;
        double v;
        
        v = ws[0] * a;
        v += ws[1] * b;
        v += ws[2] * c;
        v +=  (bias * wBias);
        
        double y = funcaoDegrau(v);
        
        System.out.println("y: " + y);
    }
    
    
    private void treinar() {
        double erroQuadratico = 1; // Erro da Época
        int epoca = 0;
        // Inicializando pesos
        if (wRandon) {
            Random r = new Random();
            ws = new double[entradas[0].length];
            for (int j = 0; j < ws.length; j++) {
                ws[j] = r.nextDouble();
                if (r.nextInt(2) != 0) {
                    ws[j] *= -1;
                }
            }
            wBias = r.nextDouble();
            if (r.nextInt(2) != 0) {
                wBias *= -1;
            }
        }
        // Treinamento
        while (erroQuadratico > erroMaximoAceitavel && epoca < maxEpocas) {
            // Epoca
            erroQuadratico = 0;
            System.out.println("Época: " + (epoca + 1));
            for (int i = 0; i < entradas.length; i++) {
                // Iteração
                // Calcular o v
                double v = (wBias * bias);
                for (int j = 0; j < entradas[i].length; j++) {
                    v += ws[j] * entradas[i][j];
                }
                // Calcular o y
                double y = funcaoDegrau(v);
                // Calcular o erro da iteração
                double erroInstantaneo = yDs[i] - y;
                // Ajustar os pesos
                wBias += (bias * erroInstantaneo * eta);
                for (int j = 0; j < entradas[i].length; j++) {
                    ws[j] += (entradas[i][j] * erroInstantaneo * eta);
                }
                eta *= (1 - deltaEta);
                // Incrementa o erro da epoca
                erroQuadratico += (erroInstantaneo * erroInstantaneo);

                for (int j = 0; j < entradas[i].length; j++) {
                    System.out.print(entradas[i][j] + " | ");
                }
                System.out.print(yDs[i] + " -> ");
                System.out.print(y + " (" + erroInstantaneo + ")");
                System.out.println("");
            }
            erroQuadratico = erroQuadratico / entradas.length;
            System.out.println("Erro Quadratico: " + erroQuadratico);
            epoca++;
        }
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.executar();

    }
    // Saidas 0 ou 1
    private double funcaoDegrau(double v) {
        double y = 0;
        if (v >= 0) {
            y = 1;
        }
        return y;
    }
    // Saidas entre -1 e 1
    private double funcaoTanHiperbolica(double v ){
        return StrictMath.tanh(v);        
    }    
    // Saidas entre 0 e 1
    private double funcaoSigmoidal(double v) {
        double beta = 0.5;
        double e = Math.E;
        return 1 / (1 + Math.pow(e, -(beta) * v));
    }
}
