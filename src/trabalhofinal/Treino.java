/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal;

import java.util.ArrayList;

/**
 *
 * @author tainass
 */
public class Treino {
    String nome;
    ArrayList<Exercicio> exercicios = new ArrayList<>();
    
    public String tempoGasto() {
        int ht = 0, mt = 0, st = 0;
        for (Exercicio e : exercicios){
            String tempo = e.getTempoGasto();
            String[] val = tempo.split(":");
            ht += Integer.parseInt(val[0]);
            mt += Integer.parseInt(val[1]);
            st += Integer.parseInt(val[2]);
        }
        
        return ht+":"+mt+":"+st;
    }
    
    public float caloriasGastas() {
        float total = 0;
        for (Exercicio e : exercicios){
            total += e.caloriasGastasExercicio();
        }
        
        return total;
    }
    
    // TODO - MostrarTreino
}
