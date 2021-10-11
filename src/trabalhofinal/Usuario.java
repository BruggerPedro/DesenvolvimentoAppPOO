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
    protected float peso, altura, IMC;
    protected Data dataNascimento;

    public Usuario(String nomeCompleto, String sexo, String nomeUsuario, String senha, Data dataNascimento) {
        this.nomeCompleto = nomeCompleto;
        this.sexo = sexo;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.altura = 0;
        this.peso = 0;
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

    public float getIMC() {
        return IMC;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public void calculaIMC() {
        if(peso > 0 && altura > 0) {
            this.IMC = peso/(altura*altura);
        } else {
            System.out.println("Impossível calcular IMC... por favor atribua valores ao peso e a altura!");
        }
    }
    
    public void perfilUsuario() {
        System.out.println("Nome completo: " + getNomeCompleto());
        System.out.println("Sexo: " + getSexo());
        System.out.print("Data de nascimento: ");
        getDataNascimento().mostrarData();
        System.out.println("Nome completo: " + getNomeCompleto());
    }
}
