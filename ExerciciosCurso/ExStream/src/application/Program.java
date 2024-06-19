package application;

import Model.Funcionario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        filtraFuncionarios( leFuncionarios() );
    }
    
    public static List<Funcionario> leFuncionarios(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nome do arquivo de fonte de dados: ");
        String caminhoArquivo = scan.nextLine();
        try( BufferedReader br = new BufferedReader(  new FileReader( caminhoArquivo ) ) ){
            String linha = br.readLine();
            List<Funcionario> funcionarios = new ArrayList<>();
            while( linha != null){
                String[] linhasArray = linha.split(",");
                funcionarios.add( new Funcionario( linhasArray[0], linhasArray[1], Double.valueOf( linhasArray[2] ) ) );
                linha = br.readLine();
            }
            return funcionarios;
        }catch( IOException e ){
            System.out.println( e.getMessage() );
        }
        return null;
    }
    
    public static void filtraFuncionarios( List<Funcionario> funcionarios ){
        if( funcionarios == null || funcionarios.isEmpty() ){
            return;
        }
        System.out.println("Salario Filtro: ");
        Double salarioFiltro = 160.0;
        List<String> emailsFiltrados = funcionarios.stream()
                                                                        .filter( f -> f.getSalario() > salarioFiltro )
                                                                        .map( f -> f.getEmail() )
                                                                        .sorted( (f1,f2) -> f1.toUpperCase().compareTo(f2.toUpperCase()) )
                                                                        .collect( Collectors.toList() );
        
        Double somaSalario = funcionarios.stream()
                                                            .filter( f -> f.getNome().toUpperCase().charAt( 0 ) == 'M' )
                                                            .map( f -> f.getSalario() )
                                                            .reduce( 0.0, ( x , y ) -> x + y ); 
        
        emailsFiltrados.forEach( System.out::println );
        System.out.println("Soma dos salários das pessoas que começam com M: " + somaSalario );
                                                            
        
    }
}
