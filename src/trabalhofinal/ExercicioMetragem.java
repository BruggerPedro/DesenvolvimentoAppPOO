/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal;

/**
 *
 * @author tainass
 */
public class ExercicioMetragem extends Exercicio {
    private int numSeries, numRepet;
    private float calPorSerie;

    @Override
    public float caloriasGastasExercicio() {
        return numSeries * calPorSerie;
    }

    @Override
    public void mostraExercicio() {
        System.out.println("Tempo gasto: "+getTempoGasto());
        System.out.println("Número de Séries: "+getNumSeries());
        System.out.println("Número de Repetições: "+getTempoGasto());
        System.out.println("Calorias gastas por série: "+getCalPorSerie());
        System.out.println("Calorias gastas no exercicio: "+caloriasGastasExercicio());
    }

    public int getNumSeries() {
        return numSeries;
    }

    public int getNumRepet() {
        return numRepet;
    }

    public float getCalPorSerie() {
        return calPorSerie;
    }
}
