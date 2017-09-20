package exercicio1;

public class Gerente extends Funcionarios{

    @Override
    public void consultarSalario() {
        super.consultarSalario(); 
        System.out.println("Salario Gerente");
    }

    @Override
    public double getSalarioComBonificacao() {
        return super.getSalarioComBonificacao() * 1.1;
    }
    
    
    
}
