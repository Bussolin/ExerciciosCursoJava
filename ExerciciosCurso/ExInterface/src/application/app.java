package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import modelo.Contrato;
import service.Paypal;
import service.ContratoService;

public class app {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Dados do contrato: ");
        System.out.print("Numero: ");
        Integer id = scan.nextInt();
        scan.nextLine();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Valor total do contrato: ");
        Double valorTotal = scan.nextDouble();
        System.out.print("Entre com numero das parcelas: ");
        Integer quantidadeParcela = scan.nextInt();
        
        Contrato contrato = new Contrato(data, valorTotal, quantidadeParcela );
        
        ContratoService cs = new ContratoService( new Paypal());
        cs.processaContrato( contrato, quantidadeParcela );
        
        for( int i = 0; i < quantidadeParcela; i++){
            System.out.println("Parcela #" + (i + 1) + ": "  + contrato.getParcelas().get(i) );
        }
        
    }
}
