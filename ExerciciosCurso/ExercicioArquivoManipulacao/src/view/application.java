package view;

import entities.Produto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class application {
    public static void main(String[] args) {

        try{
            List<Produto> produtos = registraProdutos();
            criaArquivoEGravaProdutos( produtos );
        }catch( IOException e){
            System.out.println( e.getMessage() );
        }
    }
    
    private static List<Produto> registraProdutos(){
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<>();
         
        System.out.println("Caminho: ");
        String strCaminho = scan.nextLine();
        
        File file = new File( strCaminho );
        
        try( BufferedReader br = new BufferedReader( new FileReader( file ) ) ){
            String linha = br.readLine();
            
            while( linha != null ){
                String[] dadosProduto = linha.split(",");
                produtos.add( new Produto( dadosProduto[0], Integer.valueOf(dadosProduto[1].trim()), Double.valueOf(dadosProduto[2].trim()) ) );
                linha = br.readLine();
            }
        }catch( IOException | NullPointerException e){
            System.out.println( e.getMessage() );
        } 
        return produtos;
    }
    
    private static boolean criaArquivoEGravaProdutos( List<Produto> produtos ) throws IOException{
        //criar pasta out
        System.out.println();
        boolean mkdir = new File( System.getProperty("user.dir") + "\\out").mkdir();
        if( mkdir ){
            System.out.println("Pasta criada");
        }else{
            System.out.println("Pasta ja existe ou impossivel de criar");
        }
        
        //gravar no summary.csv
        try( BufferedWriter bw = new BufferedWriter( new FileWriter(".\\out\\sumary.csv") )){
            for( Produto p : produtos){
                bw.write( p.getNome() + "," + p.getSubTotal() );
                bw.newLine();
            }
            System.out.println("Criado: .\\out\\sumary.csv");
        } catch (IOException e ){
            System.out.println( "error: " + e.getMessage() );
        }
        
        return false;
    }
}
