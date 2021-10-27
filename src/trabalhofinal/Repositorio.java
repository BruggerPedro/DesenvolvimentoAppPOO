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

    public String nomeUser;
    public HashMap<String, Usuario> usuarios = new HashMap<>();
    public HashMap<String, Exercicio> exercicios = new HashMap<>();
    public HashMap<String, Treino> treinos = new HashMap<>();
    public HashMap<String, Refeicao> refeicoes = new HashMap<>();
    public HashMap<String, Alimento> alimentos = new HashMap<>();
    public HashMap<String, Dieta> dietas = new HashMap<>();
    public HashMap<String, RegistroDiario> registrosDiarios = new HashMap<>();

    public Repositorio() {
    }

    public Repositorio(String nomeUser) {
        this.nomeUser = nomeUser;
    }
    
    

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
                float pesoIni = Float.parseFloat(valores[7]);
                float alturaIni = Float.parseFloat(valores[8]);

                Usuario u = new Usuario(nomeCompleto, sexo, nomeUsuario, senha, dataNascimento, peso, altura, pesoIni, alturaIni);

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
            escritor.write(u.getNomeCompleto() + ";" + u.getSexo() + ";" + u.getNomeUsuario() + ";" + u.getSenha() + ";" + u.getDataNascimento().retornaData() + ";" + u.getPeso() + ";" + u.getAltura() + ";" + u.getPesoInicio()+ ";" + u.getAlturaInicio()+ "\n"); //Gravação do texto
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

                escritor.write(u.getNomeCompleto() + ";" + u.getSexo() + ";" + u.getNomeUsuario() + ";" + u.getSenha() + ";" + u.getDataNascimento().retornaData() + ";" + u.getPeso() + ";" + u.getAltura() + ";" + u.getPesoInicio()+ ";" + u.getAlturaInicio()+ "\n"); //Gravação do texto
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
            arquivo = new BufferedReader(new FileReader(new File("dados/"+this.getNomeUser()+"-exercicios.txt")));
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
            escritor = new BufferedWriter(new FileWriter(new File("dados/"+this.getNomeUser()+"-exercicios.txt"), true));
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
            escritor = new BufferedWriter(new FileWriter(new File("dados/"+this.getNomeUser()+"-exercicios.txt")));
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
            arquivo = new BufferedReader(new FileReader(new File("dados/"+this.getNomeUser()+"-treinos.txt")));
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
                    if(aux != null)
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
            escritor = new BufferedWriter(new FileWriter(new File("dados/"+this.getNomeUser()+"-treinos.txt"), true));
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
        this.leExercicios();
        BufferedWriter escritor = null; //objeto escritor
        try {
            escritor = new BufferedWriter(new FileWriter(new File("dados/"+this.getNomeUser()+"-treinos.txt")));
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
            arquivo = new BufferedReader(new FileReader(new File("dados/"+this.getNomeUser()+"-alimentos.txt")));
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
            escritor = new BufferedWriter(new FileWriter(new File("dados/"+this.getNomeUser()+"-alimentos.txt")));
            //Instanciação do objeto escritor
            for (String key : this.getAlimentos().keySet()) {
                Alimento a = this.getAlimentos().get(key);

                escritor.write(a.getTipo() + ";" + a.getNome() + ";" + a.getQuantidade() + ";" + a.getCaloriasTotais()+ "\n"); //Gravação do texto
            }
            escritor.flush(); //descarga do buffer de escrita
            escritor.close(); //fechamento do arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leRefeicoes() {
        this.leAlimentos();
        String linha;
        BufferedReader arquivo; //Objeto leitor 
        try {
            arquivo = new BufferedReader(new FileReader(new File("dados/"+this.getNomeUser()+"-refeicoes.txt")));
            //Instanciação do objeto leitor
            linha = arquivo.readLine();
            while (linha != null) {
                String[] valores = linha.split(";");

                String id = valores[0];
                String tipo = valores[1];

                Refeicao refeicao = new Refeicao(id, tipo);

                for (int i = 2; i < valores.length; i ++) {
                    String nomeAlimento = valores[i];
                    Alimento aux = this.getAlimentos().get(nomeAlimento);
                    if(aux != null)
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
        this.leAlimentos();
        BufferedWriter escritor = null; //objeto escritor
        try {
            escritor = new BufferedWriter(new FileWriter(new File("dados/"+this.getNomeUser()+"-refeicoes.txt")));
            //Instanciação do objeto escritor
            for (String key : this.getRefeicoes().keySet()) {
                Refeicao r = this.getRefeicoes().get(key);

                String alimentos = "";
                for (Alimento a : r.getAlimentos().values()) {
                    alimentos = alimentos + ";" +  a.getNome();
                }
                escritor.write(r.getId() + ";" + r.getTipo() + alimentos + "\n"); //Gravação do texto
            }
            escritor.flush(); //descarga do buffer de escrita
            escritor.close(); //fechamento do arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void leDietas() {
        this.leRefeicoes();
        String linha;
        BufferedReader arquivo; //Objeto leitor 
        try {
            arquivo = new BufferedReader(new FileReader(new File("dados/"+this.getNomeUser()+"-dietas.txt")));
            //Instanciação do objeto leitor
            linha = arquivo.readLine();
            while (linha != null) {
                String[] valores = linha.split(";");

                String id = valores[0];
                String nome = valores[1];
                int objCal = Integer.parseInt(valores[2]);
                int objHid = Integer.parseInt(valores[3]);

                Dieta d = new Dieta(id, nome, objCal, objHid);

                for (int i = 4; i < valores.length; i ++) {
                    String idRefeicao = valores[i];
                    Refeicao aux = this.getRefeicoes().get(idRefeicao);
                    if(aux != null)
                        d.getRefeicoes().put(aux.getId(), aux);
                }

                this.getDietas().put(id, d);
                linha = arquivo.readLine();
            }
            arquivo.close(); //fechamento do arquivo
        } catch (java.io.IOException e) {
            System.out.println("File error: " + e.toString());
        }
    }

    public void attDietas() {
        this.leRefeicoes();
        BufferedWriter escritor = null; //objeto escritor
        try {
            escritor = new BufferedWriter(new FileWriter(new File("dados/"+this.getNomeUser()+"-dietas.txt")));
            //Instanciação do objeto escritor
            for (String key : this.getDietas().keySet()) {
                Dieta d = this.getDietas().get(key);

                String refeicoes = "";
                for (Refeicao r : d.getRefeicoes().values()) {
                    refeicoes = refeicoes + ";" + r.getId();
                }
                escritor.write(d.getId() + ";" + d.getNome()+ ";" + d.getObjCalorico() + ";" + d.getObjHidrico() + refeicoes + "\n"); //Gravação do texto
            }
            escritor.flush(); //descarga do buffer de escrita
            escritor.close(); //fechamento do arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void leRegistrosDiarios() {
        this.leTreinos();
        this.leDietas();
        String linha;
        BufferedReader arquivo; //Objeto leitor 
        try {
            arquivo = new BufferedReader(new FileReader(new File("dados/"+this.getNomeUser()+"-registrosDiarios.txt")));
            //Instanciação do objeto leitor
            linha = arquivo.readLine();
            while (linha != null) {
                String[] valores = linha.split(";");
                
                String[] data = valores[0].split("/");
                String aguaIngerida = valores[1];
                String idTreino = valores[2];
                String idDieta = valores[3];
                
                Data d = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                Treino t = this.getTreinos().get(idTreino);
                Dieta di = this.getDietas().get(idDieta);
                
                if(t != null && di != null) {
                    RegistroDiario rd = new RegistroDiario(d, Float.parseFloat(aguaIngerida), t, di);
                    this.getRegistrosDiarios().put(d.retornaData(), rd);
                }
                
                linha = arquivo.readLine();
            }
            arquivo.close(); //fechamento do arquivo
        } catch (java.io.IOException e) {
            System.out.println("File error: " + e.toString());
        }
    }

    public void attRegistrosDiarios() {
        this.leTreinos();
        this.leDietas();
        BufferedWriter escritor = null; //objeto escritor
        try {
            escritor = new BufferedWriter(new FileWriter(new File("dados/"+this.getNomeUser()+"-registrosDiarios.txt")));
            //Instanciação do objeto escritor
            for (String key : this.getRegistrosDiarios().keySet()) {
                RegistroDiario rd = this.getRegistrosDiarios().get(key);
                
                escritor.write(rd.getData().retornaData() + ";" + rd.getAguaIngerida() + ";" + rd.getTreino().getId()+ ";" + rd.getDieta().getId() + "\n"); //Gravação do texto
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

    public HashMap<String, Dieta> getDietas() {
        return dietas;
    }

    public void setDietas(HashMap<String, Dieta> dietas) {
        this.dietas = dietas;
    }

    public HashMap<String, RegistroDiario> getRegistrosDiarios() {
        return registrosDiarios;
    }

    public void setRegistrosDiarios(HashMap<String, RegistroDiario> registrosDiarios) {
        this.registrosDiarios = registrosDiarios;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }
    
    
}
