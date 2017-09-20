package literal;

import java.util.Scanner;

public class Literal {

    public static void main(String[] args) {
        
        //Scanner s = new Scanner(System.in);
        //String entrada = s.nextLine();
        //System.out.println(entrada);
        
        //String entrada = "";
        /*while(!entrada.equals("FIM")){
            entrada = s.next();
            if(!entrada.equals("FIM")){
                System.out.println("-" + entrada);                        
            }
        }*/
        
        //int valor1 = Integer.parseInt(s.nextLine());
        //int valor2 = Integer.parseInt(s.nextLine());
        
        //System.out.println("O resultado é: "+(valor1 + valor2));
     
        
        //String exemplo = "   teste   ";
        //System.out.println(exemplo.toUpperCase());
        //System.out.println(exemplo.length());
        //exemplo = exemplo.replaceAll("e", "E");
        //System.out.println(exemplo);
        //exemplo = exemplo.substring(2);
        //System.out.println(exemplo);
        //exemplo = exemplo.substring(2,4);
        //System.out.println(exemplo);
        //exemplo = exemplo.trim();
        //System.out.println(exemplo);
        
        String exemplo = "01#bolacha#5.00";
        //System.out.println(exemplo.indexOf("#"));
        //System.out.println(exemplo.substring(0,exemplo.indexOf("#")));
        String[] aux = exemplo.split("#");
        for (int i = 0; i < aux.length; i++){
            System.out.println(aux[i]);
        }
        
    }
    
}
