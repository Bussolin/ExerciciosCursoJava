/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import service.ModeloPagamentoOnline;

/**
 *
 * @author Ingadev
 */
public class Paypal implements ModeloPagamentoOnline{

    private Integer parcela = 0;
    
    @Override
    public Double getTaxaJuros( Double valorParcela ) {
        parcela++;
        return valorParcela * (0.01 * parcela);
    }

    @Override
    public Double getTaxaPagamento( Double valorParcela ) {
        return valorParcela * 0.02;
    }
    
    
}
