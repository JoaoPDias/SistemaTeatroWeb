//package br.com.sistemaTeatroWeb.dao;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
///**
// *
// * @author jpdia
// */
//public class ArtistaDao  {
//
//    Artista artista = new Artista();
//
//    /**
//     *
//     */
//    public static final String UTF8_BOM = "\uFEFF";
//
//    /**
//     *
//     */
//    @Override
//    public void Incluir() {
//        Scanner leia = new Scanner(System.in);
//        System.out.println("Forneça os dados: \n");
//        System.out.println("Informe o Nome: ");
//        String nome = leia.nextLine();
//        System.out.println("Informe a Data de Nascimento: ");
//        String data = leia.nextLine();
//        boolean valido = false;
//        Date dt = null;
//        while (!valido) {
//
//            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//            df.setLenient(false);
//            try {
//                dt = df.parse(data);
//                valido = true;
//            } catch (ParseException ex) {
//                System.out.println("Data Inválida! Digite Novamente: ");
//                data = leia.nextLine();
//            }
//        }
//        System.out.println("Informe o CPF: ");
//        String cpf = leia.nextLine();
//        System.out.println("Informe o RG: ");
//        String rg = leia.nextLine();
//        System.out.println("Informe o Celular: ");
//        String celular = leia.nextLine();
//        System.out.println("Informe o E-mail: ");
//        String email = leia.nextLine();
//
//        GeradorID gerador = new GeradorID();
//        int id = gerador.genID(this.artista);
//        if (id > 0) {
//            artista.setIDArtista(id);
//        } else {
//            System.out.println("Erro na inserção");
//        }
//        this.artista.setNome(nome);
//        this.artista.setDataNasc(dt.getTime());
//        this.artista.setCPF(cpf);
//        this.artista.setRG(rg);
//        this.artista.setCelular(celular);
//        this.artista.setEmail(email);
//        ArtistaDao.escrever(artista);
//    }
//
//    private static void escrever(Artista artista) {
//        File arq = artista.getArq();
//        FileWriter fileWriter = null;
//        BufferedWriter bufferedWriter = null;
//        try {
//            if (!arq.exists()) {
//                arq.createNewFile();
//            }
//            //Devemos passar no construtor do FileWriter qual arquivo
//            // vamos manipular.
//            // Esse construtor aceita dois tipos de parâmetros,
//            // File ou String.
//            //O parâmetro true indica que reescrevemos no arquivo
//            // sem apagar o que já existe.
//            // O false apagaria o conteúdo do arquivo e escreveria
//            // o novo conteúdo.
//            // Se não usar o 2° parâmetro, ele por padrão será false.
//            //O mais importante, essa linha abre o fluxo do arquivo
//            //FileWriter fileWriter = new FileWriter(arq, true);
//
//            //Agora vamos usar a classe PrintWriter para escrever
//            //fisicamente no arquivo.
//            //Precisamos passar o objeto FileReader em seu construtor
//            fileWriter = new FileWriter(arq.getAbsolutePath(), true);
//            bufferedWriter = new BufferedWriter(fileWriter);
//
//            bufferedWriter.write(Integer.toString(artista.getIDArtista()));
//            bufferedWriter.write(";");
//            bufferedWriter.write(artista.getNome());
//            bufferedWriter.write(";");
//            bufferedWriter.write(Long.toString(artista.getDataNasc()));
//            bufferedWriter.write(";");
//            bufferedWriter.write(artista.getCPF());
//            bufferedWriter.write(";");
//            bufferedWriter.write(artista.getRG());
//            bufferedWriter.write(";");
//            bufferedWriter.write(artista.getCelular());
//            bufferedWriter.write(";");
//            bufferedWriter.write(artista.getEmail());
//            bufferedWriter.write(";");
//            bufferedWriter.newLine();
//
//            //o método flush libera a escrita no arquivo
//            fileWriter.flush();
//            bufferedWriter.flush();
//
//        } catch (IOException e) {
//            System.out.println("Não foi possível escrever no arquivo");
//        } finally {
//            try {
//                fileWriter.close();
//                bufferedWriter.close();
//                System.out.println("Cadastro realizado com sucesso");
//            } catch (IOException e) {
//                System.out.println("Não foi possível alterar o arquivo");
//            }
//        }
//    }
//
//    /**
//     *
//     */
//    @Override
//    public void Alterar() {
//        System.out.println("Informe o Código do Artista\n");
//        Scanner leia = new Scanner(System.in);
//        int codigo = 0;
//        try {
//            codigo = Integer.parseInt(leia.nextLine());
//        } catch (InputMismatchException e) {
//            boolean valido = false;
//            while (!valido) {
//                System.out.println("Valor Inválido");
//                codigo = Integer.parseInt(leia.nextLine());
//            }
//        }
//        Artista artista = Artista.buscaID(codigo);
//        Artista newartista = new Artista();
//        System.out.println("Qual campo deseja alterar?\n");
//        this.FinalizaAlteracao(artista, newartista);
//    }
//
//    /**
//     *
//     */
//    @Override
//    public void Excluir() {
//        System.out.println("Informe o Código do Artista que deseja excluir\n");
//        Scanner leia = new Scanner(System.in);
//        int codigo = 0;
//        try {
//            codigo = leia.nextInt();
//        } catch (InputMismatchException e) {
//            boolean valido = false;
//            while (!valido) {
//                System.out.println("Valor Inválido");
//                codigo = leia.nextInt();
//            }
//        }
//        Artista artista = Artista.buscaID(codigo);
//        if (artista != null) {
//            this.Copia(artista);
//
//        } else {
//            System.out.println("Artista não encontrada! Exclusão Cancelada");
//
//        }
//    }
//
//    private void FinalizaAlteracao(Artista artista, Artista newartista) {
//        newartista.setIDArtista(artista.getIDArtista());
//        newartista.setNome(artista.getNome());
//        newartista.setDataNasc(artista.getDataNasc());
//        newartista.setCPF(artista.getCPF());
//        newartista.setRG(artista.getRG());
//        newartista.setCelular(artista.getCelular());
//        newartista.setEmail(artista.getEmail());
//        System.out.println("1-Nome do Artista\n"
//                + "2-Data de Nascimento do Artista\n"
//                + "3-CPF do Artista\n"
//                + "4-RG do Artista\n"
//                + "5-Celular do Artista\n"
//                + "6-Email do Artista\n"
//                + "7-Sair\n");
//        Scanner leia = new Scanner(System.in);
//        System.out.println("Informe a opção selecionada");
//        boolean valido = false;
//        int opcao = 0;
//        while (!valido) {
//
//            try {
//                opcao = Integer.parseInt(leia.nextLine());
//                valido = true;
//            } catch (NumberFormatException e) {
//                {
//                    System.out.println("Valor inválido! Digite Novamente: ");
//                    opcao = Integer.parseInt(leia.nextLine());
//                }
//
//            }
//        }
//
//        while (opcao != 7) {
//
//            switch (opcao) {
//                case 1:
//                    System.out.println("Nome do Artista: " + newartista.getNome());
//                    System.out.println("Novo Nome do Artista: ");
//                    String nome = leia.nextLine();
//                    newartista.setNome(nome);
//                    break;
//                case 2:
//                    Date data = new Date();
//                    data.setTime(newartista.getDataNasc());
//                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//                    System.out.println("Data de Nascimento do Artista: " + format.format(data));
//                    System.out.println("Nova Data de Nascimento do Artista: ");
//                    String novadata = leia.nextLine();
//
//                    valido = false;
//                    while (!valido) {
//
//                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//                        df.setLenient(false);
//                        try {
//                            data = df.parse(novadata);
//                            newartista.setDataNasc(data.getTime());
//                            valido = true;
//                        } catch (ParseException ex) {
//                            System.out.println("Data Inválida! Digite Novamente: ");
//                            novadata = leia.nextLine();
//                        }
//                    }
//                    break;
//                case 3:
//                    System.out.println("CPF do Artista: " + newartista.getCPF());
//                    System.out.println("Novo CPF do Artista: ");
//                    String cpf = leia.nextLine();
//                    newartista.setCPF(cpf);
//                    break;
//                case 4:
//                    System.out.println("RG do Artista: " + newartista.getRG());
//                    System.out.println("Novo RG do Artista: ");
//                    String rg = leia.nextLine();
//                    newartista.setRG(rg);
//                    break;
//                case 5:
//                    System.out.println("Celular do Artista: " + newartista.getCelular());
//                    System.out.println("Novo Celular do Artista: ");
//                    String celular = leia.nextLine();
//                    newartista.setCelular(celular);
//                    break;
//                case 6:
//                    System.out.println("Email do Artista: " + newartista.getEmail());
//                    System.out.println("Novo Email do Artista: ");
//                    String email = leia.nextLine();
//                    newartista.setEmail(email);
//                    break;
//
//            }
//            System.out.println(
//                    "1-Nome do Artista\n"
//                    + "2-Data de Nascimento do Artista\n"
//                    + "3-CPF do Artista\n"
//                    + "4-RG do Artista\n"
//                    + "5-Celular do Artista\n"
//                    + "6-Email do Artista\n");
//            leia = new Scanner(System.in);
//            System.out.println("Informe a opção selecionada");
//            valido = false;
//            opcao = 0;
//            while (!valido) {
//
//                try {
//                    opcao = Integer.parseInt(leia.nextLine());
//                    valido = true;
//                } catch (NumberFormatException e) {
//                    {
//                        System.out.println("Valor inválido! Digite Novamente: ");
//                        opcao = Integer.parseInt(leia.nextLine());
//                    }
//
//                }
//            }
//        }
//        this.Copia(artista, newartista);
//    }
//
//    private void Copia(Artista artista, Artista newartista) {
//        String linhaAlterar = Artista.TransformarEmLinha(artista);
//        String linhaAlterada = Artista.TransformarEmLinha(newartista);
//        File file = artista.getArq();
//        File nf = new File("Dados", "temporario.tmp");
//        FileWriter fw = null;
//        Scanner s = null;
//        BufferedWriter bufferedWriter = null;
//        try {
//            fw = new FileWriter(nf);
//            s = new Scanner(file);
//            bufferedWriter = new BufferedWriter(fw);
//            while (s.hasNextLine()) {
//                String linha = s.nextLine();
//                if (linha.equals(linhaAlterar)) {
//                    linha = linha.replace(linhaAlterar, linhaAlterada);
//                }
//
//                bufferedWriter.write(linha);
//                bufferedWriter.newLine();
//
//                fw.flush();
//                bufferedWriter.flush();
//                fw.close();
//                bufferedWriter.close();
//
//            }
//            fw = new FileWriter(file, false);
//            s = new Scanner(nf);
//            bufferedWriter = new BufferedWriter(fw);
//            while (s.hasNextLine()) {
//                String linha = s.nextLine();
//                bufferedWriter.write(linha);
//                bufferedWriter.newLine();
//
//                fw.flush();
//                bufferedWriter.flush();
//                System.out.println("Alteração realizada com sucesso");
//
//            }
//        } catch (IOException e) {
//            System.out.println("Não foi possível escrever no arquivo");
//        } finally {
//            try {
//                fw.close();
//                bufferedWriter.close();
//
//            } catch (IOException e) {
//                System.out.println("Não foi possível alterar o arquivo");
//            }
//        }
//
//    }
//
//    private void Copia(Artista artista) {
//        String linhaExcluir = Artista.TransformarEmLinha(artista);
//        File file = artista.getArq();
//        File nf = new File("Dados", "temporario.tmp");
//        FileWriter fw = null;
//        Scanner s = null;
//        BufferedWriter bufferedWriter = null;
//        try {
//            fw = new FileWriter(nf, false);
//            s = new Scanner(file);
//            bufferedWriter = new BufferedWriter(fw);
//            while (s.hasNextLine()) {
//                String linha = s.nextLine();
//                if (!(linha.equals(linhaExcluir))) {
//                    bufferedWriter.write(linha);
//                    bufferedWriter.newLine();
//                    fw.flush();
//                    bufferedWriter.flush();
//                    fw.close();
//                    bufferedWriter.close();
//                }
//
//            }
//            fw = new FileWriter(file, false);
//            s = new Scanner(nf);
//            bufferedWriter = new BufferedWriter(fw);
//            while (s.hasNextLine()) {
//                String linha = s.nextLine();
//                bufferedWriter.write(linha);
//                bufferedWriter.newLine();
//
//                fw.flush();
//                bufferedWriter.flush();
//                System.out.println("Exclusão realizada com sucesso");
//
//            }
//        } catch (IOException e) {
//            System.out.println("Não foi possível escrever no arquivo");
//        } finally {
//            try {
//                fw.close();
//                bufferedWriter.close();
//
//            } catch (IOException e) {
//                System.out.println("Não foi possível alterar o arquivo");
//            }
//        }
//
//    }
//
//}
