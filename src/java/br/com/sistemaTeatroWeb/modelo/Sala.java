
package br.com.sistemaTeatroWeb.modelo;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sala  {

    private int idSala;
    private String descricao;
    private int totalAssentos;
    private int totalFileira;
    public Apresentacao fk_apresentacao;
    public LinkedList<Integer> assentosComprados = new LinkedList<Integer>();
   

    

    public int getIdSala() {
        return idSala;
    }

    public Apresentacao getFk_Apresentacao() {
        return fk_apresentacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getTotalFileira() {
        return totalFileira;
    }

    public int getTotalAssentos() {
        return totalAssentos;
    }

    public void setIDSala(int idSala) {
        this.idSala = idSala;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTotalFileira(int totalFileiras) {
        this.totalFileira = totalFileiras;
    }

    public void setTotalAssentos(int totalAssentos) {
        this.totalAssentos = totalAssentos;
    }

    public void setAssentosComprados(LinkedList<Integer> assentosComprados) {
        this.assentosComprados.addAll(assentosComprados);
    }

    public void setAssentosComprados(int assentosComprados) {
        this.assentosComprados.add(assentosComprados);
    }

    public void setFk_Apresentacao(Apresentacao fk_apresentacao) {
        this.fk_apresentacao = fk_apresentacao;
    }
/*
    public static Sala buscaID(int codigo) {
        Reader fileReader = null;
        boolean existe = arq.exists();
        Sala sala = null;
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                while (linha != null) {
                    linha = Sala.removeUTF8BOM(linha);
                    if (!linha.equals("")) {
                        String[] dados = linha.split(";");

                        int id = Integer.parseInt(dados[0]);

                        if (id == codigo) {
                            sala = new Sala();
                            sala.setIDSala(id);
                            Apresentacao apresentacao = Apresentacao.buscaID(Integer.parseInt(dados[1]));
                            if (apresentacao != null) {
                                sala.setFk_Apresentacao(apresentacao);
                            }
                            sala.setDescricao(dados[2]);
                            sala.setTotalAssentos(Integer.parseInt(dados[3]));
                            sala.setAssentosComprados(Compra.totalAssentosComprados(id));
                            sala.setTotalFileira(Integer.parseInt(dados[4]));

                            return sala;
                        }
                    }
                    linha = br.readLine();
                }
            }

        } catch (IOException e) {
            System.out.println("Não foi possível alterar o arquivo");
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Não foi possível alterar o arquivo");
            }
        }
        return null;
    }

    

    public void exibirVagas() {
        for (int i = 0; i < (this.totalAssentos / this.totalFileira); i++) {
            for (int j = 0; j < this.totalFileira; j++) {
                if (this.assentosComprados.contains(i)) {
                    System.out.println("X\t");
                } else {
                    System.out.println(i + "\t");
                }
            }
            System.out.print("\n");
        }
    }

    public boolean HaVaga(int assento) {
        return this.assentosComprados.contains(assento);
    }

   
    
    public static void OcupacaoSala(){
        Scanner leia = new Scanner(System.in);
        System.out.println("Informe o código da sala");
        int codSala = Integer.parseInt(leia.nextLine());
        LinkedList<Integer> assentosOcupados = Compra.totalAssentosComprados(codSala);
        Sala sala = buscaID(codSala);
        double porcentagemOcupada = (sala.totalAssentos/assentosOcupados.size())*100;
        System.out.println("Porcentagem total da ocupação da sala: " + porcentagemOcupada);
    }*/
}

