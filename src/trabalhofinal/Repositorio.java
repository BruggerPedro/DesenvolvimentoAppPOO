/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Tiago
 */
public class Repositorio {
    public HashMap<String, Usuario> usuarios = new HashMap<>();
    
    public void leUsuarios () {
        String linha;
        BufferedReader arquivo; //Objeto leitor 
        try {
            arquivo = new BufferedReader(new FileReader(new File("usuarios.txt")));
            //Instanciação do objeto leitor
            linha = arquivo.readLine();
            while (linha != null) {
                String[] valores = linha.split(";");
                
                String nomeCompleto = valores[0];
                String sexo = valores[1];
                String nomeUsuario = valores[2];
                String senha = valores[3];
                
                String[] data = valores[4].split("/");
                Data dataNascimento = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                
                float peso = Float.parseFloat(valores[5]);
                float altura = Float.parseFloat(valores[6]);
                
                Usuario u = new Usuario(nomeCompleto, sexo, nomeUsuario, senha, dataNascimento, peso, altura);
                
                usuarios.put(nomeUsuario, u);
                
                linha = arquivo.readLine();
            }
            arquivo.close(); //fechamento do arquivo
        } catch (java.io.IOException e) {
            System.out.println("File error: " + e.toString());
        }
    }

    public void addUsuario (Usuario u) {
        BufferedWriter escritor = null; //objeto escritor
        try {
            escritor = new BufferedWriter(new FileWriter(new File("usuarios.txt"), true));
            //Instanciação do objeto escritor
            
            // nomeCompleto, sexo, nomeUsuario, senha, dataNascimento, peso, altura
            escritor.write(u.getNomeCompleto()+";"+u.getSexo()+";"+u.getNomeUsuario()+";"+u.getSenha()+";"+u.getDataNascimento().retornaData()+";"+u.getPeso()+";"+u.getAltura()+"\n"); //Gravação do texto
            escritor.flush(); //descarga do buffer de escrita
            escritor.close(); //fechamento do arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void attUsuarios () {
        BufferedWriter escritor = null; //objeto escritor
        try {
            escritor = new BufferedWriter(new FileWriter(new File("usuarios.txt")));
            //Instanciação do objeto escritor
            for (String key : this.usuarios.keySet()) {
                Usuario u = this.usuarios.get(key);
                
                escritor.write(u.getNomeCompleto()+";"+u.getSexo()+";"+u.getNomeUsuario()+";"+u.getSenha()+";"+u.getDataNascimento().retornaData()+";"+u.getPeso()+";"+u.getAltura()+"\n"); //Gravação do texto
            }
            escritor.flush(); //descarga do buffer de escrita
            escritor.close(); //fechamento do arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
