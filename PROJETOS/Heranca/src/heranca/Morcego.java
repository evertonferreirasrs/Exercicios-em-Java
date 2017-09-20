package heranca;

public class Morcego extends Mamifero implements Voador{

    @Override
    public void emitirSom() {
        System.out.println("Som morcego");
    }
    public void emitirSom(int a){
        System.out.println("Som morcego nivel:" + a);
    }

    @Override
    public void voar() {
        System.out.println("Voar do morcego");
    }

}
