package enumeracaoExercicio.application;

import enumeracaoExercicio.entities.Cliente;
import enumeracaoExercicio.entities.Pedido;
import enumeracaoExercicio.entities.Produto;
import enumeracaoExercicio.enums.StatusPedido;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Cliente c = DadosCliente();
        Pedido p = PedidoCliente( c );
        System.out.println(p);
    }
    
    private static Cliente DadosCliente(){
       
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Cliente data: ");
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Email: ");
        String email = scan.nextLine();
        System.out.print("Nascimento(DD/MM/YYYY): ");
        String data = scan.nextLine();
        LocalDate nascimento = LocalDate.parse(data, formatoData);
        
        return new Cliente(nome, email, nascimento);
    }
    private static Pedido PedidoCliente(Cliente cliente){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Status do pedido: ");
        StatusPedido status = StatusPedido.valueOf(scan.next());
        
        Pedido p = new Pedido(LocalDateTime.now(),
                              status,
                              cliente);
        
        System.out.println("Quantos itens no pedido? ");
        int n = scan.nextInt();
        
        for( int i = 1; i<=n;i++){
            scan.nextLine();
            System.out.println("Dados produto #" + i);
            System.out.print("Nome: ");
            String nomeProduto = scan.nextLine();
            System.out.print("Preço: ");
            Double preco = scan.nextDouble();
            System.out.print("Quantidade: ");
            Integer quantidade = scan.nextInt();
            
            Produto produto = new Produto( nomeProduto, preco,  quantidade );
            p.adicionaItem(produto);
        }
        
        return p;
    }
}
