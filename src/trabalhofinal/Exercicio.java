/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal;

import java.sql.Time;

/**
 *
 * @author tainass
 */
public abstract class Exercicio {
    private String nome;
    private Time tempoGasto;

    public abstract float caloriasGastasExercicio();
    public abstract void mostraExercicio();

    public void setTempoGasto(int h, int min, int seg) {
        this.tempoGasto = new Time(h,min,seg);
    }

    public String getNome() {
        return nome;
    }

    public String getTempoGasto() {
        return tempoGasto.toString();
    }
}
