package enumeracaoExercicio.entities;

import enumeracaoExercicio.enums.StatusPedido;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Pedido {
    
    private Cliente cliente;
    private LocalDateTime momento;
    private StatusPedido status;
    private List<Produto> itens;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public Pedido(LocalDateTime momento, StatusPedido status, Cliente cliente) {
        this.itens = new ArrayList<>();
        this.cliente = cliente;
        this.momento = momento;
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Informacoes do pedido: \n");
        sb.append("Momento do pedido: ").append(dataFormatada()).append("\n");
        sb.append("Status do pedido: ").append(formataStatus()).append("\n");
        sb.append(cliente).append("\n");
        sb.append("Itens do pedido: \n" );
        for( Produto p : itens){
            sb.append(p).append("\n");
        }
        sb.append("Preco total: R$").append(String.format("%.2f", total()) );
        return sb.toString();
    }
    
    public String formataStatus(){
        return this.status.toString().replaceAll("_", " ");
    }
    
    public String dataFormatada(){
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return momento.format(formatoData);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public LocalDateTime getMomento() {
        return momento;
    }

    public void setMomento(LocalDateTime momento) {
        this.momento = momento;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
    
    public void adicionaItem( Produto produto){
        itens.add( produto );
    }
    
    public void removeItem( Produto produto ){
        itens.remove( produto );
    }
    
    public Double total(){
        Double sum = 0d;
        
        for( Produto p : itens ){
            sum += p.subTotal();
        }
        return sum;
    }
}
