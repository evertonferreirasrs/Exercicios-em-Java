package paralelepipedo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Main obj = new Main();
        obj.execute();
    }
    
    private Map<String, Assinatura> assinaturas;
    
    public Main (){
        assinaturas = new HashMap<>();
    }
    
    private void execute(){
        treinar();
        testear();
    }

    private void treinar() {
        Scanner sc = new Scanner(System.in);
        String linha = sc.nextLine();
        while (linha != null && !linha.isEmpty()) {
            String atributos[] = linha.split(",");
            int i = 0;            
            Double sepallength = Double.parseDouble(atributos[i++]);
            Double sepalwidth = Double.parseDouble(atributos[i++]);
            Double petallength = Double.parseDouble(atributos[i++]);
            Double petalwidth = Double.parseDouble(atributos[i++]);
            
            String classe = atributos[i++];
            
            Assinatura assinatura = assinaturas.get(classe);
            if(assinatura == null){
                assinatura = new Assinatura();
                assinaturas.put(classe, assinatura);
            };
            
            assinatura.updatePetallength(petallength);
            assinatura.updatePetalwidth(petalwidth);
            assinatura.updateSepallength(sepallength);
            assinatura.updateSepalwidth(sepalwidth);
            
            for(String key : assinaturas.keySet()){
                Assinatura aux = assinaturas.get(key);
                System.out.println("PetallengthMax :"+aux.getPetallengthMax());
                System.out.println("PetallengthMin :"+aux.getPetallengthMin());;
                System.out.println("PetalwidthMax :"+aux.getPetalwidthMax());;
                System.out.println("PetalwidthMin :"+aux.getPetalwidthMin());;
                System.out.println("SepallengthMax :"+aux.getSepallengthMax());;
                System.out.println("SepallengthMin :"+aux.getSepallengthMin());;
                System.out.println("SepalwidthMax :"+aux.getSepalwidthMax());;
                System.out.println("SepalwidthMin :"+aux.getSepalwidthMin());;
                System.out.println("---------------------------");;
            }
            
            linha = sc.nextLine(); 
        }        
    }

    private void testear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
