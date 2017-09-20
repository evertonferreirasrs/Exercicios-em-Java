package exercicio1;

public class Funcionarios {
    private String Nome;
    private int Cpf;
    private double Salario;
    
    public double getSalarioComBonificacao(){
        return Salario;
    }
    
    public void consultarSalario(){
        System.out.println("Salario Funcionario");
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getCpf() {
        return Cpf;
    }

    public void setCpf(int Cpf) {
        this.Cpf = Cpf;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }
    
    
}
