package entities;

public class PessoaFisica extends Pessoa {
    private Double gastoSaude;

    public PessoaFisica() {
    }

    public PessoaFisica(Double gastoSaude, String nome, Double rendaAnual) {
        super(nome, rendaAnual);
        this.gastoSaude = gastoSaude;
    }
    
    @Override
    public Double calculoImposto() {
        Double porcentagemImposto = 0.15;
        
        if( super.getRendaAnual() >= 20000){
            porcentagemImposto = 0.25;
        }
        if( this.gastoSaude != 0){
            return (super.getRendaAnual() * porcentagemImposto) - (this.gastoSaude * 0.5);
        }
        
        return super.getRendaAnual() * porcentagemImposto;
    }
    
    @Override
    public String imposto() {
        return super.getNome() + "R$ " + calculoImposto();
    }
    

    public Double getGastoSaude() {
        return gastoSaude;
    }

    public void setGastoSaude(Double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }
    
}
