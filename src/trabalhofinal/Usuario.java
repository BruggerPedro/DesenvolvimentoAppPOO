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
public class Usuario {
    protected String nomeCompleto, sexo, nomeUsuario, senha;
    protected float pesoInicio, alturaInicio, peso, altura;
    protected Data dataNascimento;
    
    public Usuario(String nomeCompleto, String sexo, String nomeUsuario, String senha, Data dataNascimento, float peso, float altura, float pesoInicio, float alturaInicio) {
        this.nomeCompleto = nomeCompleto;
        this.sexo = sexo;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
        this.peso = peso;
        this.pesoInicio = pesoInicio;
        this.alturaInicio = alturaInicio;
    }
    
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public float getPesoInicio() {
        return pesoInicio;
    }

    public void setPesoInicio(float pesoInicio) {
        this.pesoInicio = pesoInicio;
    }

    public float getAlturaInicio() {
        return alturaInicio;
    }

    public void setAlturaInicio(float alturaInicio) {
        this.alturaInicio = alturaInicio;
    }
    
    public float calculaIMCInicial() {
        return pesoInicio/(alturaInicio*alturaInicio);
    }
    
    public float calculaIMC() {
        return peso/(altura*altura);
    }
}
