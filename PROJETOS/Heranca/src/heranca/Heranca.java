package heranca;


public class Heranca {

    public static void main(String[] args) {
        Animal a = new Morcego();
        a.emitirSom(10);
        
        Voador v = new Morcego();
        v.voar();
        
        v = new Coruja();
        v.voar();
        
        v = new Galinha();
        v.voar();
        
        //v = (Voador) new Cachorro();
        
    }
    
}
//baixo acoplamento
//abstract nao é obrigado a implementar somente declarar