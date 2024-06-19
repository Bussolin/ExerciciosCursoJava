package modelo;

import java.time.LocalDate;

public class Parcela {
    private Integer idContrato;
    private Double valorPagamento;
    private LocalDate dataVencimento;

    public Parcela(Integer idContrato, Double valorPagamento, LocalDate dataVencimento) {
        this.idContrato = idContrato;
        this.valorPagamento = valorPagamento;
        this.dataVencimento = dataVencimento;
    }

    @Override
    public String toString() {
        return String.format( "R$%.2f" , getValorPagamento()) + "  " + getDataVencimento();
    }

    
    
    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    
}
