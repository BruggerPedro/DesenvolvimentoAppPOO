/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal;

/**
 *
 * @author huryel
 */
public class Alimento {

    private String tipo;
    private String nome;
    private String quantidade;
    private float calQuantidade;

    public Alimento() {
    }

    public Alimento(String tipo, String nome, String quantidade, float calQuantidade) {
        this.tipo = tipo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.calQuantidade = calQuantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public float getCalQuantidade() {
        return calQuantidade;
    }

    public void setCalQuantidade(float calQuantidade) {
        this.calQuantidade = calQuantidade;
    }

}
