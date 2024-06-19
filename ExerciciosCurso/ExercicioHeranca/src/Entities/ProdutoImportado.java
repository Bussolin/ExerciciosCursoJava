package Entities;

public class ProdutoImportado extends Produto {
    private Double tarifa;

    public ProdutoImportado() {
        super();
    }
    
    public ProdutoImportado(Double tarifa, String nome, Double preco) {
        super(nome, preco);
        this.tarifa = tarifa;
    }
    
    @Override
    public String preco(){
        return super.getNome() + " R$ " + precoTotal() + "(Tarifa: R$" + this.tarifa + ")";
    }
    
    public Double precoTotal(){
        return super.getPreco() + this.tarifa;
    }

    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }
    
}
