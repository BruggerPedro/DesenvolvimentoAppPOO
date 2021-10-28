/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal;

import java.util.HashMap;

/**
 *
 * @author huryel
 */
public class Refeicao {

    private String id;
    private String tipo;
    private HashMap<String, Alimento> alimentos = new HashMap<>();

    public Refeicao() {
    }

    public Refeicao(String id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public float caloriasGastasRefeicao() {
        float total = 0;
        for (Alimento e : this.getAlimentos().values()) {
            total += e.getCaloriasTotais();
        }

        return total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public HashMap<String, Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(HashMap<String, Alimento> alimentos) {
        this.alimentos = alimentos;
    }

}
