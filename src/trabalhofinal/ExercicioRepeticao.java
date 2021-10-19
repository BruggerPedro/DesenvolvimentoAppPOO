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
    private float distancia, calPorMetro;

    public float getDistancia() {
        return distancia;
    }

    public float getCalPorMetro() {
        return calPorMetro;
    }

    @Override
    public float caloriasGastasExercicio() {
        return distancia * calPorMetro;
    }

    @Override
    public void mostraExercicio() {
        System.out.println("Tempo gasto: "+getTempoGasto());
        System.out.println("Distância percorrida: "+getDistancia());
        System.out.println("Calorias gastas por metro: "+getCalPorMetro());
        System.out.println("Calorias gastas no exercicio: "+caloriasGastasExercicio());
    }
    
}
