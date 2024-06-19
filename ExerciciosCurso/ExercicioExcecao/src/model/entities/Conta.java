package model.entities;

import model.exception.SaqueExcecao;

public class Conta {
    private Integer id;
    private String nome;
    private Double saldo;
    private Double limiteSaque;

    public Conta() {
    }

    public Conta(Integer id, String nome, Double saldo, Double limiteSaque) {
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public void deposito( Double valorDeposito){
        this.saldo += valorDeposito;
    }
    
    public void saque( Double valorSaque ){
        if( valorSaque > this.saldo ){
            throw new SaqueExcecao("Saldo insuficiente");
        }
        if( valorSaque > this.limiteSaque){
            throw new SaqueExcecao("Valor maior que limite de saque");
        }
        this.saldo -= valorSaque;
    }

    @Override
    public String toString() {
        return "Id: " + id + " - " + nome + ", saldo: " + saldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(Double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }
    
    
    
    
    
    
    
            
}
