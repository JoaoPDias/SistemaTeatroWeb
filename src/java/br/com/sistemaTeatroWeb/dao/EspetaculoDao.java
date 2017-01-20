package br.com.sistemaTeatroWeb.dao;

import br.com.sistemaTeatroWeb.modelo.Espetaculo;
import br.com.sistemaTeatroWeb.modelo.Sala;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.joda.time.DateTime;

public class EspetaculoDao implements Dao {
    private Connection connection;

     public Espetaculo getEspetaculo(int id) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from espetaculo where id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Espetaculo espetaculo = null;
            while (rs.next()) {
                espetaculo = new Espetaculo();

            }
            rs.close();
            stmt.close();
            return espetaculo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void Incluir() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Forneça os dados: \n");
        System.out.println("Informe o nome do Espetaculo: ");
        String nome = leia.nextLine();
        System.out.println("Informe a descrição do espetaculo: ");
        String descricao = leia.nextLine();
        System.out.println("Informe a faixa etária: ");
        int faixaEtaria = Integer.parseInt(leia.nextLine());
        System.out.println("Informe a duração do espetaculo em minutos: ");
        int duracaoMinutos = Integer.parseInt(leia.nextLine());
        System.out.println("informe a quantidade de artistas: ");
        int artistas = Integer.parseInt(leia.nextLine());
        for (int i = 0; i < artistas; i++) {
            System.out.println("Informe o codigo do " + i+1 + "º artista: ");
            int codArtista = Integer.parseInt(leia.nextLine());
            Artista artista = Artista.buscaID(codArtista);
            if (artista != null) {
                espetaculo.setFk_Artista(artista);
            } else {
                System.out.println("Artista não encontrado. Informe novamente!");
                i--;
            }
        }

        System.out.println("Informe a data de início: ");
        String data = leia.nextLine();
        boolean valido = false;
        Date dt = null;
        while (!valido) {

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            try {
                dt = df.parse(data);
                valido = true;
            } catch (ParseException ex) {
                System.out.println("Data Inválida! Digite Novamente: ");
                data = leia.nextLine();
            }
        }
        System.out.println("Informe a data de término: ");
        String data1 = leia.nextLine();
        valido = false;
        Date dttemp = null;
        Date dt1 = null;
        while (!valido) {
            
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            try {
                    dttemp = df.parse(data1);
                    valido = true;
                } catch (ParseException ex) {
                    System.out.println("Data Inválida! Digite Novamente: ");
                    data1 = leia.nextLine();
                }
            df.setLenient(false);
            if (dt.compareTo(dt1) < 0) {
                try {
                    dt1 = df.parse(data1);
                    valido = true;
                } catch (ParseException ex) {
                    System.out.println("Data Inválida! Digite Novamente: ");
                    data1 = leia.nextLine();
                }
            } else {
                System.out.println("Data Inválida! Digite Novamente: ");
                data1 = leia.nextLine();
            }
        }
        System.out.println("Informe o Tipo de Espetáculo: ");
        int tipoEspetaculo = Integer.parseInt(leia.nextLine());
        this.espetaculo.setFk_TipoDeEspetaculo(TipoEspetaculo.buscaID(tipoEspetaculo));
        GeradorID gerador = new GeradorID();
        int id = gerador.genID(this.espetaculo);
        if (id > 0) {
            espetaculo.setIdEspetaculo(id);
        } else {
            System.out.println("Erro na inserção");
        }
        this.espetaculo.setNome(nome);
        this.espetaculo.setDataInicio(dt.getTime());
        this.espetaculo.setDataFim(dt1.getTime());
        this.espetaculo.setDescricao(descricao);
        this.espetaculo.setFaixaEtaria(faixaEtaria);
        this.espetaculo.setDuracaoMinutos(duracaoMinutos);
        EspetaculoDao.escrever(this.espetaculo);
    
    }
    public static void escrever(Espetaculo espetaculo) {
        File arq = espetaculo.getArq();
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            if (!arq.exists()) {
                arq.createNewFile();
            }
            //Devemos passar no construtor do FileWriter qual arquivo
            // vamos manipular.
            // Esse construtor aceita dois tipos de parâmetros,
            // File ou String.
            //O parâmetro true indica que reescrevemos no arquivo
            // sem apagar o que já existe.
            // O false apagaria o conteúdo do arquivo e escreveria
            // o novo conteúdo.
            // Se não usar o 2° parâmetro, ele por padrão será false.
            //O mais importante, essa linha abre o fluxo do arquivo
            //FileWriter fileWriter = new FileWriter(arq, true);

            //Agora vamos usar a classe PrintWriter para escrever
            //fisicamente no arquivo.
            //Precisamos passar o objeto FileReader em seu construtor
            fileWriter = new FileWriter(arq.getAbsolutePath(), true);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < espetaculo.getFk_Artista().size(); i++) {

                bufferedWriter.write(Integer.toString(espetaculo.getIdEspetaculo()));
                bufferedWriter.write(";");
                bufferedWriter.write(espetaculo.getNome());
                bufferedWriter.write(";");
                bufferedWriter.write(Long.toString(espetaculo.getDataInicio()));
                bufferedWriter.write(";");
                bufferedWriter.write(Long.toString(espetaculo.getDataFim()));
                bufferedWriter.write(";");
                bufferedWriter.write(espetaculo.getDescricao());
                bufferedWriter.write(";");
                bufferedWriter.write(Integer.toString(espetaculo.getFaixaEtaria()));
                bufferedWriter.write(";");
                bufferedWriter.write(Integer.toString(espetaculo.getDuracaoMinutos()));
                bufferedWriter.write(";");
                bufferedWriter.write(Integer.toString(espetaculo.getFk_TipoDeEspetaculo().getIdTipoEspetaculo()));
                bufferedWriter.write(";");
                bufferedWriter.write(Integer.toString(espetaculo.getFk_Artista().get(i).getIDArtista()));
            }

        } catch (IOException e) {
            System.out.println("Não foi possível escrever no arquivo");
        } finally {
            try {
                fileWriter.close();
                bufferedWriter.close();
                System.out.println("Cadastro realizado com sucesso");
            } catch (IOException e) {
                System.out.println("Não foi possível alterar o arquivo");
            }
        }
    }

    @Override
    public void Alterar() {
        System.out.println("Informe o Código da Apresentação\n");
        Scanner leia = new Scanner(System.in);
        int codigo = 0;
        try {
            codigo = Integer.parseInt(leia.nextLine());
        } catch (InputMismatchException e) {
            boolean valido = false;
            while (!valido) {
                System.out.println("Valor Inválido");
                codigo = Integer.parseInt(leia.nextLine());
            }
        }
        Espetaculo espetaculo = Espetaculo.buscaID(codigo);
        Espetaculo newespetaculo = new Espetaculo();
        System.out.println("Qual campo deseja alterar?\n");
        this.FinalizaAlteracao(espetaculo, newespetaculo);

    }

    public void FinalizaAlteracao(Espetaculo espetaculo, Espetaculo newespetaculo) {

        newespetaculo.setIdEspetaculo(espetaculo.getIdEspetaculo());
        newespetaculo.setNome(espetaculo.getNome());
        newespetaculo.setDataInicio(espetaculo.getDataInicio());
        newespetaculo.setDataFim(espetaculo.getDataFim());
        newespetaculo.setDescricao(espetaculo.getDescricao());
        newespetaculo.setFaixaEtaria(espetaculo.getFaixaEtaria());
        newespetaculo.setDuracaoMinutos(espetaculo.getDuracaoMinutos());
        newespetaculo.setFk_TipoDeEspetaculo(espetaculo.getFk_TipoDeEspetaculo());
        newespetaculo.setFk_Artista(espetaculo.getFk_Artista());
        //fazer um for? 

        System.out.println(
                "1-Nome do Espetáculo\n"
                + "2-Data de início\n"
                + "3-Data de fim\n"
                + "4-Descrição do Espetáculo\n"
                + "5-Faixa etária\n"
                + "6-Duração do Espetáculo em minutos\n"
                + "7-Tipo de Espetáculo\n"
                + "8-Sair");

        Scanner leia = new Scanner(System.in);
        System.out.println("Informe a opção selecionada");
        boolean valido = false;
        int opcao = 0;
        while (!valido) {

            try {
                opcao = Integer.parseInt(leia.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                {
                    System.out.println("Valor inválido! Digite Novamente: ");
                    opcao = Integer.parseInt(leia.nextLine());
                }

            }
        }

        while (opcao != 8) {

            switch (opcao) {
                case 1:
                    System.out.println("Nome do Espetáculo: " + espetaculo.getNome());
                    System.out.println("Novo nome: ");
                    valido = false;
                    String e;
                    e = leia.nextLine();
                    Espetaculo espe = Espetaculo.buscaID(Integer.parseInt(e));
                    if (e != null) {
                        newespetaculo.setNome(e);
                        valido = true;
                    } else {
                        System.out.println("Espetáculo não Encontrado. Informe novamente: ");

                    }

                    break;
                case 2:
                    Date datanew = new Date();
                    datanew.setTime(espetaculo.getDataInicio());
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println("Data da Apresentação: " + format.format(datanew));
                    System.out.println("Nova Data da Apresentação: ");
                    String novadata = leia.nextLine();

                    valido = false;
                    while (!valido) {

                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        df.setLenient(false);
                        try {
                            datanew = df.parse(novadata);
                            newespetaculo.setDataInicio(datanew.getTime());
                            valido = true;
                        } catch (ParseException ex) {
                            System.out.println("Data Inválida! Digite Novamente: ");
                            novadata = leia.nextLine();
                        }
                    }
                    break;
                case 3:
                    Date data1 = new Date();
                    data1.setTime(espetaculo.getDataFim());
                    SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println("Data da Apresentação: " + format1.format(data1));
                    System.out.println("Nova Data da Apresentação: ");
                    String newdata = leia.nextLine();

                    valido = false;
                    while (!valido) {

                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        df.setLenient(false);
                        Date DataInicio = new Date();
                        DataInicio.setTime(newespetaculo.getDataInicio());
                        try {
                            if (DataInicio.compareTo(data1) <= 0) {
                                data1 = df.parse(newdata);
                                newespetaculo.setDataFim(data1.getTime());
                                valido = true;
                            } else {
                                throw new IllegalArgumentException("Data Final maior que a Data Inicial");
                            }
                        } catch (ParseException ex) {
                            System.out.println("Data Inválida! Digite Novamente: ");
                            newdata = leia.nextLine();
                        } catch (IllegalArgumentException exc) {
                            exc.getMessage();
                            newdata = leia.nextLine();
                        }
                    }
                    break;
                case 4:
                    //Descrição do Espetáculo
                    System.out.println("Descrição do espetáculo: " + espetaculo.getDescricao());
                    System.out.println("Nova descrição:");
                    valido = false;
                    String descricao;
                    descricao = leia.nextLine();
                    Espetaculo espeta = Espetaculo.buscaID(Integer.parseInt(descricao));
                    if (descricao != null) {
                        newespetaculo.setDescricao(descricao);
                        valido = true;
                    } else {
                        System.out.println("Espetáculo não Encontrado. Informe novamente: ");

                    }
                    break;
                case 5:
                    //Faixa etária
                    System.out.println("Faixa Etária: " + espetaculo.getFaixaEtaria());
                    System.out.println("Nova Faixa Etária: ");
                    try {
                        int valor = Integer.parseInt(leia.nextLine());

                        if (valor > 0) {
                            newespetaculo.setFaixaEtaria(valor);
                        }

                    } catch (InputMismatchException ex) {
                        System.out.println("Faixa Etária inválida.");
                    }

                    break;
                case 6:
                    //Duração do Espetáculo em minutos
                    System.out.println("Duração do Espetáculo em minutos: " + espetaculo.getDuracaoMinutos());
                    System.out.println("Novo tempo: ");
                    try {
                        int valor = Integer.parseInt(leia.nextLine());

                        if (valor > 0) {
                            newespetaculo.setDuracaoMinutos(valor);
                        }

                    } catch (InputMismatchException ex) {
                        System.out.println("Duração inválida.");
                    }

                    break;
                case 7:
                    //Tipo de Espetáculo
                    System.out.println("Tipo do Espetáculo: " + espetaculo.getFk_TipoDeEspetaculo());
                    System.out.println("Novo Tipo de Espetáculo: ");
                    String novoTipo;
                    valido = false;
                    while (!valido) {
                        novoTipo = leia.nextLine();
                        TipoEspetaculo tipoEspe = TipoEspetaculo.buscaID(Integer.parseInt(novoTipo));
                        if (tipoEspe != null) {
                            newespetaculo.setFk_TipoDeEspetaculo(tipoEspe);
                            valido = true;
                        } else {
                            System.out.println("Tipo de Espetáculo não Encontrado. Informe novamente: ");
                        }
                    }
                    break;
                default:
                    break;
            }

        }
        this.Copia(espetaculo, newespetaculo);
    }

    private void Copia(Espetaculo espetaculo, Espetaculo newespetaculo) {
        String linhaAlterar = Espetaculo.TransformarEmLinha(espetaculo);
        String linhaAlterada = Espetaculo.TransformarEmLinha(newespetaculo);
        File file = espetaculo.getArq();
        File nf = new File("Dados", "temporario.tmp");
        FileWriter fw = null;
        Scanner s = null;
        BufferedWriter bufferedWriter = null;
        try {
            fw = new FileWriter(nf);
            s = new Scanner(file);
            bufferedWriter = new BufferedWriter(fw);
            while (s.hasNextLine()) {
                String linha = s.nextLine();
                if (linha.contains(linhaAlterar)) {
                    linha = linha.replace(linhaAlterar, linhaAlterada);
                }

                bufferedWriter.write(linha);
                bufferedWriter.newLine();

                fw.flush();
                bufferedWriter.flush();
                fw.close();
                bufferedWriter.close();

            }
            fw = new FileWriter(file, false);
            s = new Scanner(nf);
            bufferedWriter = new BufferedWriter(fw);
            while (s.hasNextLine()) {
                String linha = s.nextLine();
                bufferedWriter.write(linha);
                bufferedWriter.newLine();

                fw.flush();
                bufferedWriter.flush();
                System.out.println("Alteração realizada com sucesso");

            }
        } catch (IOException e) {
            System.out.println("Não foi possível escrever no arquivo");
        } finally {
            try {
                fw.close();
                bufferedWriter.close();

            } catch (IOException e) {
                System.out.println("Não foi possível alterar o arquivo");
            }
        }

    }

    private void Copia(Espetaculo espetaculo) {
        String linhaExcluir = Espetaculo.TransformarEmLinha(espetaculo);
        File file = espetaculo.getArq();
        File nf = new File("Dados", "temporario.tmp");
        FileWriter fw = null;
        Scanner s = null;
        BufferedWriter bufferedWriter = null;
        try {
            fw = new FileWriter(nf, false);
            s = new Scanner(file);
            bufferedWriter = new BufferedWriter(fw);
            while (s.hasNextLine()) {
                String linha = s.nextLine();
                if (!(linha.contains(linhaExcluir))) {
                    bufferedWriter.write(linha);
                    bufferedWriter.newLine();
                    fw.flush();
                    bufferedWriter.flush();
                    fw.close();
                    bufferedWriter.close();
                }

            }
            fw = new FileWriter(file, false);
            s = new Scanner(nf);
            bufferedWriter = new BufferedWriter(fw);
            while (s.hasNextLine()) {
                String linha = s.nextLine();
                bufferedWriter.write(linha);
                bufferedWriter.newLine();

                fw.flush();
                bufferedWriter.flush();
                System.out.println("Exclusão realizada com sucesso");

            }
        } catch (IOException e) {
            System.out.println("Não foi possível escrever no arquivo");
        } finally {
            try {
                fw.close();
                bufferedWriter.close();

            } catch (IOException e) {
                System.out.println("Não foi possível alterar o arquivo");
            }
        }

    }

    @Override
    public void Excluir() {
        System.out.println("Informe o Código do Espetaculo que deseja excluir\n");
        Scanner leia = new Scanner(System.in);
        int codigo = 0;
        try {
            codigo = leia.nextInt();
        } catch (InputMismatchException e) {
            boolean valido = false;
            while (!valido) {
                System.out.println("Valor Inválido");
                codigo = leia.nextInt();
            }
        }
        Espetaculo espetaculo = Espetaculo.buscaID(codigo);
        if (espetaculo != null) {
            this.Copia(espetaculo);

        } else {
            System.out.println("Espetaculo não encontrado! Exclusão Cancelada");

        }

    }

}
