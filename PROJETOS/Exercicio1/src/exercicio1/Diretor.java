package exercicio1;

public class Diretor extends Gerente{

    @Override
    public void consultarSalario() {
        super.consultarSalario(); 
        System.out.println("Salario Diretor");
    }

    @Override
    public double getSalarioComBonificacao() {
        return super.getSalario() * 1.2; 
    }
}
