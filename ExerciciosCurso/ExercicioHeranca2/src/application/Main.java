package application;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();

        System.out.println("---------IMPOSTO DE RENDA---------");
        System.out.println("Quantidade de entidades para consulta: ");
        int quantidade = scan.nextInt();
        
        for( int i = 1; i <= quantidade; i++){
            System.out.println("Entidade #" + i);
            System.out.print("Fisica ou Juridica (F/J): ");
            char tipoEntidade = scan.next().charAt(0);
            
            scan.nextLine();
            System.out.print("Nome: ");
            String nome = scan.nextLine();
            
            System.out.println("Renda anual: ");
            Double rendaAnual = scan.nextDouble();
            
            switch(tipoEntidade){
                case 'F','f' ->{
                    System.out.println("Gasto saude: ");
                    Double gastoSaude = scan.nextDouble();
                    pessoas.add(new PessoaFisica(gastoSaude, nome, rendaAnual)); 
                }
                case 'J','j' ->{
                    System.out.println("Quantidade funcionario: ");
                    Integer quantidadeFuncionario = scan.nextInt();
                    pessoas.add(new PessoaJuridica(quantidadeFuncionario, nome, rendaAnual));
                }
            }
            
        }
        
        Double soma = 0d;
        for( Pessoa p : pessoas){
            System.out.println( p.getNome());
            soma += p.calculoImposto();
        }
        System.out.println("Total: R$" + soma);
    }
}
