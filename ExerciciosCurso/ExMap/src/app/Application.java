package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        
        try( BufferedReader br = new BufferedReader( new FileReader( "C:\\temp\\in.txt") )){
            String linha = br.readLine();
            Map<String,Integer> candidatos = new HashMap<>();
            while( linha != null ){
                String[] linhaArray = linha.split(",");
                String nomeCandidato  = linhaArray[0];
                Integer votosCandidato = Integer.valueOf(linhaArray[1].trim());
                
                if( !candidatos.containsKey(nomeCandidato) ){
                    candidatos.put(nomeCandidato, votosCandidato);
                }else{
                    candidatos.put(nomeCandidato, votosCandidato + candidatos.get( nomeCandidato ));
                }
                
                linha = br.readLine();
            }
            for( String key : candidatos.keySet()){
                System.out.println( key + ": " + candidatos.get(key));
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
