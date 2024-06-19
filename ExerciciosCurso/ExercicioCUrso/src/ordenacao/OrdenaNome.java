/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenacao;

import exerciciocurso.exerciciosMain;
import java.util.Comparator;

/**
 *
 * @author Ingadev
 */
public class OrdenaNome implements Comparator<exerciciosMain> {

    /**
     *
     * @param a
     * @param b
     * @return 
     */
    @Override
    public int compare( exerciciosMain a, exerciciosMain b){
        return a.getNome().compareTo(b.getNome());
    }
    
}
