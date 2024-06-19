package service;

public interface ModeloPagamentoOnline {
    
    public Double getTaxaJuros( Double valorParcela );
    
    public Double getTaxaPagamento( Double valorParcela );
}
