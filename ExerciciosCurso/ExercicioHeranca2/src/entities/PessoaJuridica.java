package entities;

public class PessoaJuridica extends Pessoa{
    private Integer quantidadeFuncionario;

    public PessoaJuridica() {
    }

    public PessoaJuridica(Integer quantidadeFuncionario, String nome, Double rendaAnual) {
        super(nome, rendaAnual);
        this.quantidadeFuncionario = quantidadeFuncionario;
    }
    
    @Override
    public Double calculoImposto() {
        Double porcentagemImposto = 0.16;
        
        if( this.quantidadeFuncionario > 10){
            porcentagemImposto = 0.14;
        }
        
        return super.getRendaAnual() * porcentagemImposto;
    }
    
    @Override
    public String imposto() {
        return super.getNome() + "R$ " + calculoImposto();
    }
    
    public Integer getQuantidadeFuncionario() {
        return quantidadeFuncionario;
    }

    public void setQuantidadeFuncionario(Integer quantidadeFuncionario) {
        this.quantidadeFuncionario = quantidadeFuncionario;
    }
}
