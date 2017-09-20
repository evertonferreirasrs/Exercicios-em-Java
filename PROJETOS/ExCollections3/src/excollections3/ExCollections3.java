package excollections3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ExCollections3 {

    public static void main(String[] args) {
        
        Map<String,Object> mapa = new HashMap<>();
        mapa.put("nome","Everton");
        mapa.put("telefone", "9 9920-3483");
        mapa.put("idade", "24");
        
        
        
        System.out.println(mapa.get("nome"));
        System.out.println(mapa.get("telefone"));
        System.out.println(mapa.get("idade"));
        
        // finge que começou aqui
        
        System.out.println("-----------");
        
        for(String aux : mapa.keySet()){
            System.out.println(aux + " -> " + mapa.get(aux));
        }
        
        // Com Iterator
        System.out.println("-----------");
        
        Iterator<String> i  = mapa.keySet().iterator();
        while (i.hasNext()) {
            System.out.println(mapa.get(i.next()));
            
        }
    }
    
}
