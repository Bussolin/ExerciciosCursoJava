package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contrato {
    private Integer id;
    private LocalDate data;
    private Double valorContrato;
    private Integer quantidadeParcela;
    private List<Parcela> parcelas;

    public Contrato(LocalDate data, Double valorContrato, Integer quantidadeParcela ) {
        this.data = data;
        this.valorContrato = valorContrato;
        this.quantidadeParcela = quantidadeParcela;
        this.parcelas = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public Double getValorParcela(){
        return valorContrato /quantidadeParcela;
    }
    
    public Integer getQuantidadeParcela() {
        return quantidadeParcela;
    }

    public Double getValorContrato() {
        return valorContrato;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }
    
    
}
