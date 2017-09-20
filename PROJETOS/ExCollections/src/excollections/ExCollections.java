package excollections;

import java.util.ArrayList;
import java.util.List;

class ExCollections {

    public static void main(String[] args) {

        //int vetor[] = new int[3];
        //List<String> lista = new ArrayList<>();        
        //lista.add("Oi!");
        //lista.add("mais um obj");
        //lista.add(true);
        //lista.add(-22.15);
        //lista.add(vetor);
        //lista.add(1,"que veio depois");
        
        
        /*List lista = new EvertonList();
        lista.add("Oi!");
        lista.add("mais um obj");
        lista.add("que veio depois");

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }

        lista.remove(0);

        //for(int i=0; i<lista.size();i++){
        //   System.out.println(lista.get(i));
        //}*/
        
        
        List lista1 = ListaFactory.createList();
        lista1.size();
        List lista2 = ListaFactory.createList();
        lista2.size();
        List lista3 = ListaFactory.createList();
        lista3.size();
        List lista4 = ListaFactory.createList();
        lista4.size();
        List lista5 = ListaFactory.createList();
        lista5.size();
    }

}

// collectins: LISTA (list) CONJUNTO (set) MAPA (map)
// list permite repetições
// set nao permime repetições
// map associativa
// exemplos de lista (list): vector, arraylist,...
// exemplos de conjuntos (set): hashset, linkedhashset
// exemplos de mapa (map): hashmap, linkedmap, property
