package enumeracaoExercicio.entities;

public class Produto {
    private String nome;
    private Double preco;
    private Integer quantidade;

    public Produto() {
    }

    public Produto(String nome, Double preco, Integer quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return nome 
                + ", R$" + preco +
                ", Quantidade: " + quantidade + 
                ", Subtotal: R$" + String.format("%.2f", subTotal()); 
    }
    
    public String getName() {
        return nome;
    }

    public Double subTotal(){
       return preco * quantidade;
    }
    
    public void setName(String nome) {
        this.nome = nome;
    }

    public Double getPrice() {
        return preco;
    }

    public void setPrice(Double preco) {
        this.preco = preco;
    }
    
}
