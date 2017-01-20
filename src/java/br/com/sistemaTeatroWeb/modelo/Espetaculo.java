
package br.com.sistemaTeatroWeb.modelo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Espetaculo{

    private int idEspetaculo;
    private String nome;
    private Date dataInicio;
    private Date dataFim;
    private String descricao;
    private int faixaEtaria;
    private int duracaoMinutos;
    private TipoEspetaculo fk_TipoDeEspetaculo;
    private LinkedList<Artista> fk_Artista = new LinkedList<Artista>();

    public LinkedList<Artista> getFk_Artista() {
        return fk_Artista;
    }

    public void setFk_Artista(Artista artista) {
        this.fk_Artista.add(artista);
    }

    public void setFk_Artista(LinkedList<Artista> artistas) {
        this.fk_Artista.addAll(artistas);
    }

    public Long getDataInicio() {
        return dataInicio.getTime();
    }

    public void setDataInicio(Long dataInicio) {
        this.dataInicio.setTime(dataInicio);
    }

    public Long getDataFim() {
        return dataFim.getTime();
    }

    public void setDataFim(Long dataFim) {
        this.dataFim.setTime(dataFim);
    }

    public int getIdEspetaculo() {
        return idEspetaculo;
    }

    public void setIdEspetaculo(int idEspetaculo) {
        this.idEspetaculo = idEspetaculo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public TipoEspetaculo getFk_TipoDeEspetaculo() {
        return fk_TipoDeEspetaculo;
    }

    public void setFk_TipoDeEspetaculo(TipoEspetaculo fk_TipoDeEspetaculo) {
        this.fk_TipoDeEspetaculo = fk_TipoDeEspetaculo;
    }


/*
    public static Espetaculo buscaID(int codigo) {
        Reader fileReader = null;
        boolean existe = arq.exists();
        Espetaculo espetaculo = null;
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                espetaculo = new Espetaculo();
                while (linha != null) {
                    linha = Espetaculo.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {
                        String[] dados = linha.split(";");

                        int id = Integer.parseInt(dados[0]);

                        if (id == codigo) {
                            espetaculo.setIdEspetaculo(id);
                            espetaculo.setNome(dados[1]);
                            espetaculo.setDataInicio(Long.parseLong(dados[2]));
                            espetaculo.setDataFim(Long.parseLong(dados[3]));
                            espetaculo.setFaixaEtaria(Integer.parseInt(dados[4]));
                            espetaculo.setDuracaoMinutos(Integer.parseInt(dados[5]));
                            TipoEspetaculo tipoespetaculo = TipoEspetaculo.buscaID(Integer.parseInt(dados[6]));
                            if (tipoespetaculo != null) {
                                espetaculo.setFk_TipoDeEspetaculo(tipoespetaculo);
                            }
                            Artista artista = Artista.buscaID(Integer.parseInt(dados[7]));
                            espetaculo.setFk_Artista(artista);
                        }
                    }

                    linha = br.readLine();
                }
                return espetaculo;

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

    public static LinkedList<Espetaculo> buscaTodos() {
        Reader fileReader = null;
        boolean existe = arq.exists();
        Espetaculo espetaculo = null;
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                espetaculo = new Espetaculo();
                LinkedList<Espetaculo> lista = new LinkedList<>();
                while (linha != null) {
                    linha = Espetaculo.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {
                        String[] dados = linha.split(";");

                        int id = Integer.parseInt(dados[0]);
                        espetaculo.setIdEspetaculo(id);
                        espetaculo.setNome(dados[1]);
                        espetaculo.setDataInicio(Long.parseLong(dados[2]));
                        espetaculo.setDataFim(Long.parseLong(dados[3]));
                        espetaculo.setFaixaEtaria(Integer.parseInt(dados[4]));
                        espetaculo.setDuracaoMinutos(Integer.parseInt(dados[5]));
                        TipoEspetaculo tipoespetaculo = TipoEspetaculo.buscaID(Integer.parseInt(dados[6]));
                        if (tipoespetaculo != null) {
                            espetaculo.setFk_TipoDeEspetaculo(tipoespetaculo);
                        }
                        Artista artista = Artista.buscaID(Integer.parseInt(dados[7]));
                        espetaculo.setFk_Artista(artista);
                        lista.add(espetaculo);
                    }
                    linha = br.readLine();
                }

                return lista;
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

    

    public static void buscaPorTipoEspetaculo() {
        Scanner leia = new Scanner(System.in);
        Reader fileReader = null;
        boolean existe = arq.exists();
        Espetaculo espetaculo = null;
        System.out.println("Digite o tipo de espetáculo desejado: ");
        String buscado = leia.nextLine();
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                espetaculo = new Espetaculo();
                LinkedList<Espetaculo> lista = new LinkedList<>();
                while (linha != null) {
                    linha = Espetaculo.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {
                        String[] dados = linha.split(";");
                        TipoEspetaculo tipoDeEspetaculo = TipoEspetaculo.buscaID(Integer.parseInt(dados[6]));
                        if (tipoDeEspetaculo.getNome().contains(buscado)) {
                            int id = Integer.parseInt(dados[0]);
                            espetaculo.setIdEspetaculo(id);
                            espetaculo.setNome(dados[1]);
                            espetaculo.setDataInicio(Long.parseLong(dados[2]));
                            espetaculo.setDataFim(Long.parseLong(dados[3]));
                            espetaculo.setFaixaEtaria(Integer.parseInt(dados[4]));

                            TipoEspetaculo tipoespetaculo = TipoEspetaculo.buscaID(Integer.parseInt(dados[6]));
                            if (tipoespetaculo != null) {
                                espetaculo.setFk_TipoDeEspetaculo(tipoespetaculo);
                            }
                        }

                        linha = br.readLine();
                    }

                }
                ImprimeBusca(lista);
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
    }

    public static void buscaPorArtista() {
        Scanner leia = new Scanner(System.in);
        Reader fileReader = null;
        boolean existe = arq.exists();
        Espetaculo espetaculo = null;
        System.out.println("Digite o nome do artista desejado: ");
        String buscado = leia.nextLine();
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                espetaculo = new Espetaculo();
                LinkedList<Espetaculo> lista = new LinkedList<>();
                while (linha != null) {
                    linha = Espetaculo.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {
                        String[] dados = linha.split(";");
                        Artista artistaBuscado = Artista.buscaID(Integer.parseInt(dados[7]));
                        if (artistaBuscado.getNome().contains(buscado)) {
                            int id = Integer.parseInt(dados[0]);
                            espetaculo.setIdEspetaculo(id);
                            espetaculo.setNome(dados[1]);
                            espetaculo.setDataInicio(Long.parseLong(dados[2]));
                            espetaculo.setDataFim(Long.parseLong(dados[3]));
                            espetaculo.setFaixaEtaria(Integer.parseInt(dados[4]));

                            TipoEspetaculo tipoespetaculo = TipoEspetaculo.buscaID(Integer.parseInt(dados[6]));
                            if (tipoespetaculo != null) {
                                espetaculo.setFk_TipoDeEspetaculo(tipoespetaculo);
                            }
                        }

                        linha = br.readLine();
                    }

                }
                ImprimeBusca(lista);
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
    }

    public static void buscaPorFaixaEtaria() {
        Scanner leia = new Scanner(System.in);
        Reader fileReader = null;
        boolean existe = arq.exists();
        Espetaculo espetaculo = null;
        System.out.println("Digite a faixa etária desejado: ");
        String buscado = leia.nextLine();
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                espetaculo = new Espetaculo();
                LinkedList<Espetaculo> lista = new LinkedList<>();
                while (linha != null) {
                    linha = Espetaculo.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {
                        String[] dados = linha.split(";");

                        if (dados[4].equals(buscado)) {
                            int id = Integer.parseInt(dados[0]);
                            espetaculo.setIdEspetaculo(id);
                            espetaculo.setNome(dados[1]);
                            espetaculo.setDataInicio(Long.parseLong(dados[2]));
                            espetaculo.setDataFim(Long.parseLong(dados[3]));
                            espetaculo.setFaixaEtaria(Integer.parseInt(dados[4]));

                            TipoEspetaculo tipoespetaculo = TipoEspetaculo.buscaID(Integer.parseInt(dados[6]));
                            if (tipoespetaculo != null) {
                                espetaculo.setFk_TipoDeEspetaculo(tipoespetaculo);
                            }

                        }

                        linha = br.readLine();
                    }

                }
                ImprimeBusca(lista);
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
    }

    private static void ImprimeBusca(LinkedList<Espetaculo> lista) {
        for (Espetaculo e : lista) {
            System.out.println(e.getIdEspetaculo() + "\n");
            System.out.println(e.getNome() + "\n");
            System.out.println(e.getDescricao() + "\n");
            Date data = new Date();
            data.setTime(e.getDataInicio());
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Data de Início: " + format.format(data) + "\n");
            data.setTime(e.getDataFim());
            System.out.println("Data de Fim: " + format.format(data) + "\n");
            System.out.println(e.getFk_TipoDeEspetaculo().getNome());
        }
    }*/

}

