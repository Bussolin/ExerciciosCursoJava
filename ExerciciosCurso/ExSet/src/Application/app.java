package Application;

import Model.Aluno;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class app {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scan = new Scanner(System.in)) {
            Set<Aluno> alunos = new HashSet<>();
            System.out.print("Quantidade de cursos que possui: ");
            Integer quantidade = scan.nextInt();
            for( int i = 0; i < quantidade; i++){
                System.out.print("Quantidade de alunos no curso " + (i + 1) + ": ");
                adicionaAlunosCurso( alunos );
            }
            System.out.println( "Quantidade total de alunos cadastrados: " + alunos.size() );
        }
    }
    
    
    public static void adicionaAlunosCurso( Set<Aluno> alunos ){
        
        Scanner scanf = new Scanner(System.in);
        int n = scanf.nextInt();
        for( int i = 0; i < n; i++){
            System.out.print( "Id do " + (i + 1) + " aluno: ");
            int idAluno = scanf.nextInt();
            alunos.add( new Aluno( idAluno ) );
        }
    }
}
