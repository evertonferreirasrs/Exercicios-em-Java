package exemplos;

public class Produto {
    
    private Long id; // maiuscolo eh para classe e minisculo para tipo PRIMITIVO
    private String nome; // Maiusculo sempre
    private Float preco; // maiuscolo eh para classe e minisculo para tipo PRIMITIVO

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
    
    
}

