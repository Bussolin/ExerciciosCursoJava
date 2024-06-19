package exerciciocurso;
import ordenacao.OrdenaNome;
import ordenacao.OrdenaRoom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class exerciciosMain {
    
    private int idade;
    private int room;
    private String nome;
    private String email;
    private float altura;
    
    public int getRoom() {
        return room;
    }

    public String getNome() {
        return nome;
    }

    
    @Override
    public String toString() {
        return room + ": " + nome + ", " + email;
    }
    
    public static void main(String[] args) {
        
        
    }
    
    
    public static void FuncarionariosCadastro(){
                List<Funcionario> funcionarios = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int n;
        int idFuncinario;
        int aumentoPorcentagem;
        
        
        System.out.println("Quantidade de Registrados: ");
        n = scan.nextInt();
        
        for( int i = 0; i < n; i++){
            System.out.println("Funcionario #" + (i + 1) + ":");
            System.out.print("Id: ");
            int id = scan.nextInt();
            System.out.print("Nome: ");
            scan.nextLine();
            String nome = scan.nextLine();
            System.out.print("Salario: ");
            double salario = scan.nextDouble();
            
            funcionarios.add(new Funcionario(id, nome, salario));
        }
        
        System.out.println("Funcionario que recebera aumento: ");
        idFuncinario = scan.nextInt();
        Funcionario f = funcionarios.stream().filter(x -> x.getId() == idFuncinario).findFirst().orElse(null);
        if( f != null ){
            System.out.println("Quantidade aumento (%): ");
            aumentoPorcentagem = scan.nextInt();
            
            f.AumentaSalario(aumentoPorcentagem);
        }else{
            System.out.println("Id inexsistente");
        }
       
        System.out.println("Lista de funcionarios");
        for( Funcionario func : funcionarios){
            System.out.println(func);
        }
    }
    
    public static void AluguelQuartos(){
                Scanner scan = new Scanner(System.in);
        
        System.out.println("Quantos quartos deseja alugar? 1 - 10");
        int n = scan.nextInt();
        exerciciosMain[] vetor = new exerciciosMain[n];
        
        for( int i = 0; i < vetor.length; i++){
            vetor[i] = new exerciciosMain();
            
            System.out.println("Rent #" + i);
            System.out.println("Name: ");
            scan.nextLine();
            vetor[i].nome = scan.nextLine();
            System.out.println("Email: ");
            vetor[i].email = scan.nextLine();
            System.out.println("Room: ");
            vetor[i].room = scan.nextInt();
        }
        
        System.out.println("Busy rooms: ");
        System.out.println("Tipo ordenação: \n1-Room \n2-Nome \nQualquer outro numero para nao ordenar");
        int ordena = scan.nextInt();
        switch( ordena){
            case 1->{
                Arrays.sort(vetor, new OrdenaRoom());
            }
            case 2->{
                Arrays.sort(vetor, new OrdenaNome());
            }
            default -> { System.out.println("Sem ordenacao"); }
        }

        for (exerciciosMain vetor1 : vetor) {
            System.out.println( vetor1 );
        }
    }

    public static void printNomes(){
        
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        System.out.println("quantidade entrada: ");
        
        float alturaMedia = 0;
        int n = scan.nextInt();
        exerciciosMain[] vetor = new exerciciosMain[n];
        String nomes16Anos = " ";
        int qtd16Anos = 0;
        
        for( int i = 0; i<vetor.length; i++){
            vetor[ i ] = new exerciciosMain();
            System.out.println("Dados da " + (i + 1) + "a Pessoa: ");
            System.out.println("Nome: ");
            scan.nextLine();
            vetor[i].nome = scan.nextLine();
            System.out.println("Idade: "); 
            vetor[i].idade = scan.nextInt();
            System.out.println("Altura:");
            vetor[i].altura = scan.nextFloat();
            alturaMedia += vetor[i].altura;
            
            if (vetor[i].idade < 16){
               nomes16Anos += vetor[i].nome + " / ";
               qtd16Anos++;
            }
        }
        System.out.println("Altura média: " + alturaMedia / vetor.length);
        System.out.println("Pessoas com menos de 16 anos: " + String.format( "%.2f",(float)qtd16Anos / vetor.length * 100) +  "\n" + nomes16Anos);
    }
    
    public static void Negativos(){
        Scanner scan = new Scanner(System.in);
        System.out.println("quantidade entrada: ");
        int n = scan.nextInt();
        int[] vetor = new int[n];

        for( int i = 0; i<vetor.length; i++){
            System.out.println("Numero " + (i + 1) + ": ");
            vetor[i] = scan.nextInt();
        }
        System.out.println("Numeros negativos");
        for( int numero : vetor ){
            if( numero < 0 ){
                System.out.println( numero );
            }
        }
    }
    public static void Banco(){
        
        int idConta;
        String nomeTitular;
        char depositoInicial;
        
        Banco conta;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite numero da conta: ");
        idConta = scan.nextInt();
        System.out.println("Digite nome do titular: ");
        scan.nextLine();
        nomeTitular = scan.nextLine();
        
        System.out.println("Deposito inicial (s/n)?");
        depositoInicial = scan.nextLine().charAt( 0 );
        
        if( depositoInicial == 's' || depositoInicial == 'S'){
            System.out.println("Valor deposito inicial: ");
            double valorDeposito = scan.nextDouble();
            conta = new Banco(idConta, nomeTitular, valorDeposito);
        }else{
            conta = new Banco(idConta, nomeTitular);
        }
        
        System.out.println("Dados da conta:\n" + conta );
        
        System.out.println("\nValor a depositar: ");
        conta.Depositar( scan.nextDouble() );
        System.out.println("Valores atualizados: ");
        System.out.println( conta );
        
        System.out.println("\nValor a sacar: ");
        conta.Saque(scan.nextDouble() );
        System.out.println("Valores atualizados: ");
        System.out.println(conta);
    }
}