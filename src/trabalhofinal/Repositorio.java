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
    public HashMap<String, Exercicio> exercicios = new HashMap<>();
    public HashMap<String, Treino> treinos = new HashMap<>();
    public HashMap<String, Refeicao> refeicoes = new HashMap<>();
    public HashMap<String, Alimento> alimentos = new HashMap<>();

    public void leUsuarios() {
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

                getUsuarios().put(nomeUsuario, u);

                linha = arquivo.readLine();
            }
            arquivo.close(); //fechamento do arquivo
        } catch (java.io.IOException e) {
            System.out.println("File error: " + e.toString());
        }
    }

    public void addUsuario(Usuario u) {
        BufferedWriter escritor = null; //objeto escritor
        try {
            escritor = new BufferedWriter(new FileWriter(new File("usuarios.txt"), true));
            //Instanciação do objeto escritor

            // nomeCompleto, sexo, nomeUsuario, senha, dataNascimento, peso, altura
            escritor.write(u.getNomeCompleto() + ";" + u.getSexo() + ";" + u.getNomeUsuario() + ";" + u.getSenha() + ";" + u.getDataNascimento().retornaData() + ";" + u.getPeso() + ";" + u.getAltura() + "\n"); //Gravação do texto
            escritor.flush(); //descarga do buffer de escrita
            escritor.close(); //fechamento do arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void attUsuarios() {
        BufferedWriter escritor = null; //objeto escritor
        try {
            escritor = new BufferedWriter(new FileWriter(new File("usuarios.txt")));
            //Instanciação do objeto escritor
            for (String key : this.getUsuarios().keySet()) {
                Usuario u = this.getUsuarios().get(key);

                escritor.write(u.getNomeCompleto() + ";" + u.getSexo() + ";" + u.getNomeUsuario() + ";" + u.getSenha() + ";" + u.getDataNascimento().retornaData() + ";" + u.getPeso() + ";" + u.getAltura() + "\n"); //Gravação do texto
            }
            escritor.flush(); //descarga do buffer de escrita
            escritor.close(); //fechamento do arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leExercicios() {
        String linha;
        BufferedReader arquivo; //Objeto leitor 
        try {
            arquivo = new BufferedReader(new FileReader(new File("exercicios.txt")));
            //Instanciação do objeto leitor
            linha = arquivo.readLine();
            while (linha != null) {
                String[] valores = linha.split(";");

                String nome = valores[0];
                String tempoGasto = valores[1];
                String[] tempoGastoVal = valores[1].split(":");

                Exercicio e;

                if (valores.length == 4) {
                    String distancia = valores[2];
                    String calMetro = valores[3];
                    e = new ExercicioMetragem(nome, Float.parseFloat(distancia), Float.parseFloat(calMetro), Integer.parseInt(tempoGastoVal[0]), Integer.parseInt(tempoGastoVal[1]), Integer.parseInt(tempoGastoVal[2]));
                } else {
                    String numeroSerie = valores[2];
                    String numrepeticao = valores[3];
                    String calSerie = valores[4];
                    e = new ExercicioRepeticao(nome, Integer.parseInt(numeroSerie), Integer.parseInt(numrepeticao), Float.parseFloat(calSerie), Integer.parseInt(tempoGastoVal[0]), Integer.parseInt(tempoGastoVal[1]), Integer.parseInt(tempoGastoVal[2]));
                }

                getExercicios().put(nome, e);

                linha = arquivo.readLine();
            }
            arquivo.close(); //fechamento do arquivo
        } catch (java.io.IOException erro) {
            System.out.println("File error: " + erro.toString());
        }
    }

    public void addExercicio(Exercicio e) {
        BufferedWriter escritor = null; //objeto escritor
        try {
            escritor = new BufferedWriter(new FileWriter(new File("exercicios.txt"), true));
            //Instanciação do objeto escritor

            // nomeCompleto, sexo, nomeUsuario, senha, dataNascimento, peso, altura
            if (e instanceof ExercicioMetragem) {
                escritor.write(e.getNome() + ";" + e.getTempoGasto() + ";" + ((ExercicioMetragem) e).getDistancia() + ";" + ((ExercicioMetragem) e).getCalPorMetro() + "\n"); //Gravação do texto
            } else {
                escritor.write(e.getNome() + ";" + e.getTempoGasto() + ";" + ((ExercicioRepeticao) e).getNumSeries() + ";" + ((ExercicioRepeticao) e).getNumRepet() + ";" + ((ExercicioRepeticao) e).getCalPorSerie() + "\n"); //Gravação do texto
            }

            escritor.flush(); //descarga do buffer de escrita
            escritor.close(); //fechamento do arquivo
        } catch (IOException erro) {
            erro.printStackTrace();
        }
    }

    public void attExercicio() {
        BufferedWriter escritor = null; //objeto escritor
        try {
            escritor = new BufferedWriter(new FileWriter(new File("exercicios.txt")));
            //Instanciação do objeto escritor
            for (String key : this.getExercicios().keySet()) {
                Exercicio e = this.getExercicios().get(key);

                if (e instanceof ExercicioMetragem) {
                    escritor.write(e.getNome() + ";" + e.getTempoGasto() + ";" + ((ExercicioMetragem) e).getDistancia() + ";" + ((ExercicioMetragem) e).getCalPorMetro() + "\n"); //Gravação do texto
                } else {
                    escritor.write(e.getNome() + ";" + e.getTempoGasto() + ";" + ((ExercicioRepeticao) e).getNumSeries() + ";" + ((ExercicioRepeticao) e).getNumRepet() + ";" + ((ExercicioRepeticao) e).getCalPorSerie() + "\n"); //Gravação do texto
                }

            }
            escritor.flush(); //descarga do buffer de escrita
            escritor.close(); //fechamento do arquivo
        } catch (IOException erro) {
            erro.printStackTrace();
        }
    }

    public void leTreinos() {
        this.leExercicios();
        String linha;
        BufferedReader arquivo; //Objeto leitor 
        try {
            arquivo = new BufferedReader(new FileReader(new File("treinos.txt")));
            //Instanciação do objeto leitor
            linha = arquivo.readLine();
            while (linha != null) {
                String[] valores = linha.split(";");

                String id = valores[0];
                String nome = valores[1];

                Treino treino = new Treino(id, nome);

                // antes de fazer a leitura dos treinos tem que ler os exercícios
                for (int i = 2; i < valores.length; i++) {

                    String nomeEx = valores[i];
                    Exercicio aux = this.getExercicios().get(nomeEx);
                    treino.getExercicios().put(aux.getNome(), aux);

                }

                this.getTreinos().put(id, treino);
                linha = arquivo.readLine();
            }
            arquivo.close(); //fechamento do arquivo
        } catch (java.io.IOException e) {
            System.out.println("File error: " + e.toString());
        }
    }

    public void addTreino(Treino t) {
        this.leExercicios();
        BufferedWriter escritor = null; //objeto escritor
        try {
            escritor = new BufferedWriter(new FileWriter(new File("treinos.txt"), true));
            //Instanciação do objeto escritor

            // nomeCompleto, sexo, nomeUsuario, senha, dataNascimento, peso, altura
            String exercicios = "";
            for (Exercicio e : t.getExercicios().values()) {

                exercicios = exercicios + ";" + e.getNome();

            }
            escritor.write(t.getId() + ";" + t.getNome() + exercicios + "\n"); //Gravação do texto
            escritor.flush(); //descarga do buffer de escrita
            escritor.close(); //fechamento do arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void attTreinos() {
        BufferedWriter escritor = null; //objeto escritor
        try {
            escritor = new BufferedWriter(new FileWriter(new File("treinos.txt")));
            //Instanciação do objeto escritor
            for (String key : this.getTreinos().keySet()) {
                Treino t = this.getTreinos().get(key);

                String exercicios = "";
                for (Exercicio e : t.getExercicios().values()) {

                    exercicios = exercicios + ";" + e.getNome();

                }
                escritor.write(t.getId() + ";" + t.getNome() + exercicios + "\n"); //Gravação do texto
            }
            escritor.flush(); //descarga do buffer de escrita
            escritor.close(); //fechamento do arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leAlimentos() {
        String linha;
        BufferedReader arquivo; //Objeto leitor 
        try {
            arquivo = new BufferedReader(new FileReader(new File("alimentos.txt")));
            //Instanciação do objeto leitor
            linha = arquivo.readLine();
            while (linha != null) {
                String[] valores = linha.split(";");
                if (valores.length == 4) {
                    String tipoAlimento = valores[0];
                    String nomeAlimento = valores[1];
                    String quantidadeAlimento = valores[2];
                    String calQuantidade = valores[3];

                    Alimento alimento = new Alimento(tipoAlimento, nomeAlimento, quantidadeAlimento, Float.parseFloat(calQuantidade));

                    this.getAlimentos().put(valores[1], alimento); // a chave é o nome
                }
                linha = arquivo.readLine();
            }
            arquivo.close(); //fechamento do arquivo
        } catch (java.io.IOException e) {
            System.out.println("File error: " + e.toString());
        }
    }

    public void attAlimento() {
        BufferedWriter escritor = null; //objeto escritor
        try {
            escritor = new BufferedWriter(new FileWriter(new File("alimentos.txt")));
            //Instanciação do objeto escritor
            for (String key : this.getAlimentos().keySet()) {
                Alimento a = this.getAlimentos().get(key);

                escritor.write(a.getTipo() + ";" + a.getNome() + ";" + a.getQuantidade() + ";" + a.getCalQuantidade() + "\n"); //Gravação do texto
            }
            escritor.flush(); //descarga do buffer de escrita
            escritor.close(); //fechamento do arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leRefeicoes() {
        String linha;
        BufferedReader arquivo; //Objeto leitor 
        try {
            arquivo = new BufferedReader(new FileReader(new File("refeições.txt")));
            //Instanciação do objeto leitor
            linha = arquivo.readLine();
            while (linha != null) {
                String[] valores = linha.split(";");

                String id = valores[0];
                String tipo = valores[1];

                Refeicao refeicao = new Refeicao(id, tipo);

                // antes de fazer a leitura dos treinos tem que ler os exercícios
                for (int i = 2; i < valores.length; i += 4) {

                    String tipoAlimento = valores[i];
                    String nomeAlimento = valores[i+1];
                    String quantidadeAlimento = valores[i+2];
                    float calQuantidade = Float.parseFloat(valores[i+3]);

                    Alimento aux = new Alimento(tipoAlimento, nomeAlimento, quantidadeAlimento, calQuantidade);
                    refeicao.getAlimentos().put(aux.getNome(), aux);

                }

                this.getRefeicoes().put(id, refeicao);
                linha = arquivo.readLine();
            }
            arquivo.close(); //fechamento do arquivo
        } catch (java.io.IOException e) {
            System.out.println("File error: " + e.toString());
        }
    }

    public void attRefeicoes() {
        BufferedWriter escritor = null; //objeto escritor
        try {
            escritor = new BufferedWriter(new FileWriter(new File("refeições.txt")));
            //Instanciação do objeto escritor
            for (String key : this.getRefeicoes().keySet()) {
                Refeicao r = this.getRefeicoes().get(key);

                String alimentos = "";
                for (Alimento a : r.getAlimentos().values()) {

                    alimentos = alimentos + ";" + a.getTipo() + ";" + a.getNome() + ";" + a.getQuantidade() + ";" + a.getCalQuantidade();

                }
                escritor.write(r.getId() + ";" + r.getTipo() + alimentos + "\n"); //Gravação do texto
            }
            escritor.flush(); //descarga do buffer de escrita
            escritor.close(); //fechamento do arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(HashMap<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public HashMap<String, Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(HashMap<String, Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public HashMap<String, Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(HashMap<String, Treino> treinos) {
        this.treinos = treinos;
    }

    public HashMap<String, Refeicao> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(HashMap<String, Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }

    public HashMap<String, Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(HashMap<String, Alimento> alimentos) {
        this.alimentos = alimentos;
    }

}
