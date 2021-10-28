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

    public float distancia;
    public float calPorMetro;

    public ExercicioMetragem(String nome, float distancia, float calPorMetro, int hg, int mg, int sg) {
        super.setNome(nome);
        super.setTempoGasto(hg, mg, sg);
        this.distancia = distancia;
        this.calPorMetro = calPorMetro;
    }

    public float getDistancia() {
        return distancia;
    }

    public float getCalPorMetro() {
        return calPorMetro;
    }

    @Override
    public float caloriasGastasExercicio() {
        return getDistancia() * getCalPorMetro();
    }

    @Override
    public void mostraExercicio() {
        System.out.println("Tempo gasto: " + getTempoGasto());
        System.out.println("Distância percorrida: " + getDistancia());
        System.out.println("Calorias gastas por metro: " + getCalPorMetro());
        System.out.println("Calorias gastas no exercicio: " + caloriasGastasExercicio());
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public void setCalPorMetro(float calPorMetro) {
        this.calPorMetro = calPorMetro;
    }

}
