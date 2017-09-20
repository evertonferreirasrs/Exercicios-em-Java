package exarray;

public class ExArray {
    
    //int a[]; vetor
    //Integer a[][]; vetor de vetor
    //int a[][]; vetor muito louco
    
    int a[][];
    int c[][];
    
    public static void main(String[] args) {
        ExArray obj = new ExArray();
        obj.executar();
    }

    private void executar() {
        //a = new int[5]; vetor     
        //a = new Integer[5][2]; vetor de vetor        
        //a[0][0] = 1; vetor de vetor
        
        /*a = new int[4][]; vetor muito loko
        a[0] = new int[1];
        a[1] = new int[2];
        a[2] = new int[3];
        a[3] = new int[4];
        */
        
        a = new int [2][3];
        c = new int [3][2];
        a[0][0] = 5;
        a[0][1] = 2;
        a[0][2] = 7;
        a[1][0] = 9;
        a[1][1] = 3;
        a[1][2] = 0;
        
        c[0][0] = 5;
        c[0][1] = 2;
        c[1][0] = 7;
        c[1][1] = 9;
        c[2][0] = 3;
        c[2][1] = 0;
        
        percorreVetor(a);     
        int b[] = maiores(a);
        
        for(int i = 0; i< b.length; i++){
            System.out.println(b[i]);
        }

        percorreVetor(c);
        b = maiores(c);
        for(int i = 0; i< b.length; i++){
            System.out.println(b[i]);
        }
        
    }
    
    /*private void percorreVetor(int [] vetor){  -- vetor
        for (int i=0; i < vetor.length; i++)
            System.out.println(vetor[i]);
    }*/
    
    /*private void percorreVetor(Integer [][] vetor){  -- vetor de vetor
        for (int i=0; i < vetor.length; i++){
            for (int j=0; j < vetor[i].length; j++){
            System.out.print(vetor[i][j]+ " ");
            }
            System.out.println("");
                    
        }
    }*/
    
    /*private void percorreVetor(int [][] vetor){  -- vetor muito loko
        for (int i=0; i < vetor.length; i++){
            for (int j=0; j < vetor[i].length; j++){
            System.out.print(vetor[i][j]+ " ");
            }
            System.out.println("");
                    
        }
    }*/
    
    private void percorreVetor(int [][] vetor){
        for (int i=0; i < vetor.length; i++){
            for (int j=0; j < vetor[i].length; j++){
            System.out.print(vetor[i][j]+ " ");
            }
            System.out.println("");
                    
        }
    }
    
    private int[] maiores (int [][] vetor){
        int b[];
        b = new int [vetor.length];
        
        
        for (int i=0; i < vetor.length; i++){
            for (int j=0; j < vetor[i].length; j++){
                if(vetor[i][j] > b[i]){
                    b[i] = vetor [i][j];
                }
            }  
        }
        return b;
    }
}
