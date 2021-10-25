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
public class ExercicioRepeticao extends Exercicio {
    private int numSeries, numRepet;
    private float calPorSerie;

    public ExercicioRepeticao(String nome, int numSeries, int numRepet, float calPorSerie, int hg, int mg, int sg) {
        super.setNome(nome);
        super.setTempoGasto(hg, mg, sg);
        this.numSeries = numSeries;
        this.numRepet = numRepet;
        this.calPorSerie = calPorSerie;
    }

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
