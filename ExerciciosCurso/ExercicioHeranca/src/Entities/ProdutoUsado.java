package Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoUsado extends Produto {
    private static DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private LocalDate dataFabricacao;

    public ProdutoUsado() {
    }

    public ProdutoUsado(LocalDate dataFabricacao, String nome, Double preco) {
        super(nome, preco);
        this.dataFabricacao = dataFabricacao;
    }
    
    @Override
    public String preco(){
        return super.getNome() + " (Usado) R$ " + super.getPreco() + "(Data de fabricacao: " + this.dataFabricacao.format(formatoData) + ")";
    }
    
}
