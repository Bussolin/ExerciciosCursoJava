package application;

import java.util.Locale;
import java.util.Scanner;
import model.entities.Conta;
import model.exception.SaqueExcecao;

public class Program {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        
        try{
            System.out.printf( "ID: " );
            Integer id = scan.nextInt();
            System.out.printf( "Nome: " );
            scan.nextLine();
            String nome = scan.nextLine();
            System.out.printf( "Saldo: " );
            Double saldo = scan.nextDouble();
            System.out.printf( "Limite de saque: " );
            Double limiteSaque = scan.nextDouble();
            Conta c = new Conta(id, nome, saldo, limiteSaque);
            System.out.println(c);
            
            System.out.printf( "Valor a sacar: " );
            Double saque = scan.nextDouble();
            
            c.saque( saque );
            
            System.out.println( c );
        }catch( SaqueExcecao e ){
            System.out.println(e.getMessage());
        }
        
    }
}
