package service;

import modelo.Contrato;
import modelo.Parcela;

public class ContratoService {
    
    private ModeloPagamentoOnline taxasPagamento;

    public ContratoService(ModeloPagamentoOnline taxasPagamento ) {
        this.taxasPagamento = taxasPagamento;
    }
    
    public void processaContrato( Contrato c, Integer quantidadeParcela){
        for( int i = 1; i <= quantidadeParcela; i++){
            c.getParcelas().add( new Parcela( c.getId(), getValorParcelaJuros( c ), c.getData().plusMonths(i) ));
        }
    }
    
    public Double getValorParcelaJuros( Contrato c ){
        Double valorParcelaJuros = (c.getValorParcela() + taxasPagamento.getTaxaJuros( c.getValorParcela() ));
        return valorParcelaJuros + taxasPagamento.getTaxaPagamento( valorParcelaJuros );
    }
}
