package exercicio1;

public class Exercicio1 {

    public static void main(String[] args) {
        
        Funcionarios f = new Funcionarios();
        f.setSalario(1000);
        
        Gerente g = new Gerente();
        g.setSalario(1000);
        
        Diretor d = new Diretor();
        d.setSalario(1000);
        
        System.out.println("Salario Funcionario: " + f.getSalario());
        System.out.println("Salario Gerente 10%: " + g.getSalarioComBonificacao());
        System.out.println("Salario Diretor 20%: " + d.getSalarioComBonificacao());
    }
    
}
