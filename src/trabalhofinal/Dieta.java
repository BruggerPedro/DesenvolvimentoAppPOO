/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal;

import java.util.HashMap;

/**
 *
 * @author Tiago
 */
public class Dieta {

    private String id, nome;
    private int objCalorico, objHidrico;
    private HashMap<String, Refeicao> refeicoes = new HashMap<>();

    public Dieta(String id, String nome, int objCalorico, int objHidrico) {
        this.id = id;
        this.nome = nome;
        this.objCalorico = objCalorico;
        this.objHidrico = objHidrico;
    }

    public float caloriasIngeridas() {
        float total = 0;
        for (Refeicao e : this.getRefeicoes().values()) {
            total += e.caloriasGastasRefeicao();
        }

        return total;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getObjCalorico() {
        return objCalorico;
    }

    public void setObjCalorico(int objCalorico) {
        this.objCalorico = objCalorico;
    }

    public int getObjHidrico() {
        return objHidrico;
    }

    public void setObjHidrico(int objHidrico) {
        this.objHidrico = objHidrico;
    }

    public HashMap<String, Refeicao> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(HashMap<String, Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }
}
