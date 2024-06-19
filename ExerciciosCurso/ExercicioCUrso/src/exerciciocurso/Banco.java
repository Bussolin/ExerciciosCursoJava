package exerciciocurso;

public class Banco {
    private int idConta;
    private String nomeTitular;
    private double Saldo;

    public Banco(int idConta, String nomeTitular) {
        this.idConta = idConta;
        this.nomeTitular = nomeTitular;
    }
    
    public Banco(int idConta, String nomeTitular, double Saldo) {
        this.idConta = idConta;
        this.nomeTitular = nomeTitular;
        Depositar(Saldo);
    }

    @Override
    public String toString( ) {
        return "Conta: " + this.idConta 
                + ", Titular: " + this.nomeTitular 
                + ", Saldo: R$" + this.Saldo;
    }
    
    public int getIdConta() {
        return idConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return Saldo;
    }
    
    public void Depositar( double valor ){
        this.Saldo = valor;
    }
    
    public void Saque( double valor ){
        this.Saldo -= valor + 5;
    }
}
