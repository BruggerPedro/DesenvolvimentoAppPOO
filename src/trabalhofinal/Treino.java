/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal;

import java.util.HashMap;

/**
 *
 * @author tainass
 */
public class Treino {

    public String id;
    public String nome;
    public HashMap<String, Exercicio> exercicios = new HashMap<>();

    public String tempoGasto() {
        int ht = 0, mt = 0, st = 0;
        for (Exercicio e : getExercicios().values()) {
            String tempo = e.getTempoGasto();
            String[] val = tempo.split(":");
            st += Integer.parseInt(val[2]);
            if (st > 59) {
                mt++;
                st -= 59;
                if (mt > 59) {
                    ht++;
                    mt -= 59;
                }
            }
            mt += Integer.parseInt(val[1]);
            if (mt > 59) {
                ht++;
                mt -= 59;
            }
            ht += Integer.parseInt(val[0]);
        }

        return ht + ":" + mt + ":" + st;
    }

    public float caloriasGastas() {
        float total = 0;
        for (Exercicio e : getExercicios().values()) {
            total += e.caloriasGastasExercicio();
        }
        return total;
    }

    // TODO - MostrarTreino
    public Treino() {
    }

    public Treino(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public HashMap<String, Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(HashMap<String, Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

}
