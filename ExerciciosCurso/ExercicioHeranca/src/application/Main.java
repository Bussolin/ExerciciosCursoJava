package application;

import Entities.Produto;
import Entities.ProdutoImportado;
import Entities.ProdutoUsado;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        int quantidadeProduto;
        List<Produto> produtos = new ArrayList<>();
        
        System.out.printf("Numero de produtos: ");
        quantidadeProduto = scan.nextInt();
        
        for(int i = 1; i <= quantidadeProduto; i++){
            char tipoProduto;
            String nome;
            Double preco;
            
            System.out.printf("Dados do produto #" + i);
            System.out.printf("\nComum, usado ou importado (C/U/I): ");
            tipoProduto = scan.next().charAt(0);
            
            scan.nextLine();
            System.out.printf("Nome: ");
            nome = scan.nextLine();
        
            System.out.printf("Preco: ");
            preco = scan.nextDouble();
            
            switch (tipoProduto) {
                case 'C','c' -> produtos.add( new Produto(nome, preco) );
                case 'U', 'u' -> {
                    System.out.printf("Data de fabricacao(DD/MM/YYYY): ");
                    scan.nextLine();
                    LocalDate data = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Produto produto = new ProdutoUsado(data, nome, preco);
                    produtos.add(produto);
                    break;
                }
                case 'I', 'i' -> {
                    System.out.printf("Tarifa: ");
                    Double tarifa = scan.nextDouble();
                    Produto produto = new ProdutoImportado(tarifa, nome, preco);
                    produtos.add(produto);
                    break;
                    
                }
                default -> {
                    System.out.println("Escolha um tipo valido");
                    i--;
                    continue;
                }
                
            }
        }
        System.out.println("Informacoes produtos");
        for( Produto p : produtos){
            System.out.println(p.preco());
        }
    }
}
