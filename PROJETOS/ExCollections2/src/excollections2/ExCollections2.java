package excollections2;

import java.util.LinkedHashSet;
import java.util.Set;

public class ExCollections2 {

    public static void main(String[] args) {
        /*Set<String> conjunto = new HashSet<>();
        conjunto.add("A");
        conjunto.add("B");
        conjunto.add("A");
        conjunto.add("A");
        conjunto.add("A");
        conjunto.add("A");
        conjunto.add("C");
        System.out.println(conjunto.size());
        System.out.println("-----------------");

        for (String elemento : conjunto) {
            System.out.println(elemento);
        }
        System.out.println("-----------------");
        
        
        Iterator<String> aux = conjunto.iterator();
        while (aux.hasNext()) {
            System.out.println(aux.next());            
        }
        
        */
        
        Set<Contato> conjunto = new LinkedHashSet<>();//HashSet = sem ordem de insersao - LinkedHashSet = com ordem de insersao
        
        Contato contato = new Contato();
        contato.setNome("Everton");
        contato.setTelefone("999203483");
        conjunto.add(contato);
        
        contato = new Contato();
        contato.setNome("Roberto");
        contato.setTelefone("988620837");
        conjunto.add(contato);
        
        contato = new Contato();
        contato.setNome("Everton");
        contato.setTelefone("999203483");
        conjunto.add(contato);
        
        System.out.println(conjunto.size());
        
    }

}
