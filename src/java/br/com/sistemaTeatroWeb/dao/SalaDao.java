/*package br.com.sistemaTeatroWeb.dao;

import br.com.sistemaTeatroWeb.modelo.Apresentacao;
import br.com.sistemaTeatroWeb.modelo.Sala;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.joda.time.DateTime;

*//**
 *
 * @author jpdia
 *//*
public class SalaDao {

    private Connection connection;

   *//* public Sala getSala(int id) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Sala sala = null;
            while (rs.next()) {
                sala = new Sala();
                sala.set
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setDataNascimento(new DateTime(rs.getDate("dataNascimento")));

            }
            rs.close();
            stmt.close();
            return contato;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
*/
    /*public void Incluir() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Forneça os dados: \n");
        System.out.println("Informe a descrição: ");
        String descricao = leia.nextLine();
        System.out.println("Informe o total de assentos: ");
        int totalAssentos = Integer.parseInt(leia.nextLine());
        System.out.println("Informe a quantidade de fileiras: ");
        int totalFileira = Integer.parseInt(leia.nextLine());
        System.out.println("Informe o código do Apresentação: ");
        String apresentacao;
        boolean valido = false;
        while (!valido) {
            apresentacao = leia.nextLine();
            Apresentacao a = Apresentacao.buscaID(Integer.parseInt(apresentacao));
            if (a != null) {
                this.sala.setFk_Apresentacao(a);
                valido = true;
            } else {
                System.out.println("Apresentação não Encontrada. Informe novamente: ");

            }

        }

        GeradorID gerador = new GeradorID();
        int id = gerador.genID(this.sala);
        if (id > 0) {
            sala.setIDSala(id);
        } else {
            System.out.println("Erro na inserção");
        }
        this.sala.setDescricao(descricao);
        this.sala.setTotalAssentos(totalAssentos);
        this.sala.setTotalFileira(totalFileira);
        SalaDao.Escrever(sala);
    }

    private static void Escrever(Sala sala) {
        File arq = sala.getArq();
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
            bufferedWriter.write(Integer.toString(sala.getIdSala()));
            bufferedWriter.write(";");
            bufferedWriter.write(Integer.toString(sala.getFk_Apresentacao().getIdApresentacao()));
            bufferedWriter.write(";");
            bufferedWriter.write(sala.getDescricao());
            bufferedWriter.write(";");
            bufferedWriter.write(Integer.toString(sala.getTotalAssentos()));
            bufferedWriter.write(";");
            bufferedWriter.write(Integer.toString(sala.getTotalFileira()));
            bufferedWriter.write(";");
            bufferedWriter.newLine();

            //o método flush libera a escrita no arquivo
            fileWriter.flush();
            bufferedWriter.flush();

        } catch (Exception e) {
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

    *//**
     *
     *//*
    @Override
    public void Alterar() {
        System.out.println("Informe o Código da Sala\n");
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
        Sala sala = Sala.buscaID(codigo);
        Sala newsala = new Sala();
        System.out.println("Qual campo deseja alterar?\n");
        this.FinalizaAlteracao(sala, newsala);

    }

    *//**
     *
     *//*
    @Override
    public void Excluir() {
        System.out.println("Informe o Código da Sala que deseja excluir\n");
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
        Sala sala = Sala.buscaID(codigo);
        if (sala != null) {
            this.Copia(sala);

        } else {
            System.out.println("Sala não encontrada! Exclusão Cancelada");

        }

    }

    private void FinalizaAlteracao(Sala sala, Sala newsala) {
        newsala.setIDSala(sala.getIdSala());
        newsala.setFk_Apresentacao(sala.getFk_Apresentacao());
        newsala.setDescricao(sala.getDescricao());
        newsala.setTotalAssentos(sala.getTotalAssentos());
        newsala.setTotalFileira(sala.getTotalFileira());
        System.out.println(
                "1-Número da Sala\n"
                + "2-Código da Apresentação\n"
                + "3-Descrição\n"
                + "4-Quantidade de Assentos\n"
                + "5-Quantidade de Fileiras\n");
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
        while (opcao != 6) {
            switch (opcao) {
                case 1:
                    System.out.println("Número da Sala: " + sala.getIdSala());
                    System.out.println("Nova Sala: ");
                    int id = Integer.parseInt(leia.nextLine());
                    newsala.setIDSala(id);
                    break;
                case 2:
                    System.out.println("Código da Apresentação: " + sala.getFk_Apresentacao().getIdApresentacao());
                    System.out.println("Novo Apresentação: ");
                    String apresentacao;
                    valido = false;
                    while (!valido) {
                        apresentacao = leia.nextLine();
                        Apresentacao e = Apresentacao.buscaID(Integer.parseInt(apresentacao));
                        if (e != null) {
                            newsala.setFk_Apresentacao(e);
                            valido = true;
                        } else {
                            System.out.println("Apresentação não Encontrada. Informe novamente: ");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Descrição: " + sala.getDescricao());
                    System.out.println("Nova Descrição: ");
                    String descricao = leia.nextLine();
                    newsala.setDescricao(descricao);
                    break;
                case 4:
                    System.out.println("Quantidade de Assentos: " + sala.getTotalAssentos());
                    System.out.println("Nova Quantidade de Assentos: ");
                    int totalAssentos = Integer.parseInt(leia.nextLine());
                    newsala.setTotalAssentos(totalAssentos);
                    break;
                case 5:
                    System.out.println("Quantidade de Fileiras: " + sala.getTotalFileira());
                    System.out.println("Nova Quantidade de Fileiras: ");
                    int totalFileira = Integer.parseInt(leia.nextLine());
                    newsala.setTotalFileira(totalFileira);
                    break;
            }
        }
        this.Copia(sala, newsala);
    }

    private void Copia(Sala sala, Sala newsala) {
        String linhaAlterar = Sala.TransformarEmLinha(sala);
        String linhaAlterada = Sala.TransformarEmLinha(newsala);
        File file = sala.getArq();
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
                if (linha.equals(linhaAlterar)) {
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

    private void Copia(Sala sala) {
        String linhaExcluir = Sala.TransformarEmLinha(sala);
        File file = sala.getArq();
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
                if (!(linha.equals(linhaExcluir))) {
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

}*/
