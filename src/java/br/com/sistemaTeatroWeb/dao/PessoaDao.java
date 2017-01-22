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
//import java.util.LinkedList;
//import java.util.Scanner;
//
//public class PessoaDao {
//
//    Pessoa pessoa = new Pessoa();
//    public static final String UTF8_BOM = "\uFEFF";
//
//    @Override
//    public void Incluir() {
//        Scanner leia = new Scanner(System.in);
//        System.out.println("Forneça os dados: \n");
//        System.out.println("Nome do Espectador: ");
//        String nome = leia.nextLine();
//        System.out.println(" \nEndereço Completo: ");
//        String endereco = leia.nextLine();
//        System.out.println("\nTelefone de contato: ");
//        String telefone = leia.nextLine();
//        System.out.println("\nEmail: ");
//        String email = leia.nextLine();
//        System.out.println("\nLocal de Trabalho: ");
//        String local = leia.nextLine();
//        System.out.println("\nEndereço Comercial Completo: ");
//        String enderecocomercial = leia.nextLine();
//        System.out.println("\nData de Nascimento: ");
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
//        System.out.println("\nCPF: ");
//        String cpf = leia.nextLine();
//        System.out.println("\nRG: ");
//        String rg = leia.nextLine();
//        System.out.println("\nLogin: ");
//        String login = leia.nextLine();
//        valido = Pessoa.buscaLogin(login);
//        while (valido) {
//            login = leia.nextLine();
//            valido = Pessoa.buscaLogin(login);
//        }
//        System.out.println("\nSenha: ");
//        String senha = leia.nextLine();
//        GeradorID gerador = new GeradorID();
//        int id = gerador.genID(pessoa);
//        if (id > 0) {
//            pessoa.setIdPessoa(id);
//        } else {
//            System.out.println("Erro na inserção");
//        }
//        pessoa.setNome(nome);
//        pessoa.setEndereco(endereco);
//        pessoa.setTelefone(telefone);
//        pessoa.setEmail(email);
//        pessoa.setLocalTrabalho(local);
//        pessoa.setEnderecoComercial(enderecocomercial);
//        pessoa.setDataNasc(dt.getTime());
//        pessoa.setCPF(cpf);
//        pessoa.setRG(rg);
//        pessoa.setLogin(login);
//        pessoa.setSenha(senha);
//        pessoa.setNivelAcesso(1);
//        PessoaDao.escrever(pessoa);
//    }
//
//    public void IncluirMantenedor() {
//        Scanner leia = new Scanner(System.in);
//        System.out.println("Primeiro Acesso Ao Sistema! Forneça os dados do Administrador: \n");
//        System.out.println("Nome do Mantenedor: ");
//        String nome = leia.nextLine();
//        System.out.println(" \nEndereço Completo: ");
//        String endereco = leia.nextLine();
//        System.out.println("\nTelefone de contato: ");
//        String telefone = leia.nextLine();
//        System.out.println("\nEmail: ");
//        String email = leia.nextLine();
//        System.out.println("\nLocal de Trabalho: ");
//        String local = leia.nextLine();
//        System.out.println("\nEndereço Comercial Completo: ");
//        String enderecocomercial = leia.nextLine();
//        System.out.println("\nData de Nascimento: ");
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
//        System.out.println("\nCPF: ");
//        String cpf = leia.nextLine();
//        System.out.println("\nRG: ");
//        String rg = leia.nextLine();
//        System.out.println("\nLogin: ");
//        String login = leia.nextLine();
//        valido = Pessoa.buscaLogin(login);
//        while (valido) {
//            login = leia.nextLine();
//            valido = Pessoa.buscaLogin(login);
//        }
//        System.out.println("\nSenha: ");
//        String senha = leia.nextLine();
//        GeradorID gerador = new GeradorID();
//
//        if (gerador.genID(pessoa) > 0) {
//            pessoa.setIdPessoa(gerador.genID(pessoa));
//        } else {
//            System.out.println("Erro na inserção");
//        }
//        pessoa.setNome(nome);
//        pessoa.setEndereco(endereco);
//        pessoa.setTelefone(telefone);
//        pessoa.setEmail(email);
//        pessoa.setLocalTrabalho(local);
//        pessoa.setEnderecoComercial(enderecocomercial);
//        pessoa.setDataNasc(dt.getTime());
//        pessoa.setCPF(cpf);
//        pessoa.setRG(rg);
//        pessoa.setLogin(login);
//        pessoa.setSenha(senha);
//        pessoa.setNivelAcesso(0);
//        PessoaDao.escrever(pessoa);
//
//    }
//
//    @Override
//    public void Alterar() {
//        System.out.println("Informe o Código da Pessoa\n");
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
//        Pessoa pessoa = Pessoa.buscaID(codigo);
//        Pessoa newpessoa = new Pessoa();
//        System.out.println("Qual campo deseja alterar?\n");
//        this.FinalizaAlteracao(pessoa, newpessoa);
//
//    }
//
//    @Override
//    public void Excluir() {
//        System.out.println("Informe o Código do Espectador que deseja excluir\n");
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
//        //if(buscarDependencia(int id))
//        Pessoa pessoa = Pessoa.buscaID(codigo);
//
//    }
//
//    private static void escrever(Pessoa pessoa) {
//        File arq = pessoa.getArq();
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
//            bufferedWriter.write(Integer.toString(pessoa.getIdPessoa()));
//            bufferedWriter.write(";");
//            bufferedWriter.write(pessoa.getNome());
//            bufferedWriter.write(";");
//            bufferedWriter.write(pessoa.getEndereco());
//            bufferedWriter.write(";");
//            bufferedWriter.write(pessoa.getTelefone());
//            bufferedWriter.write(";");
//            bufferedWriter.write(pessoa.getEmail());
//            bufferedWriter.write(";");
//            bufferedWriter.write(pessoa.getLocalTrabalho());
//            bufferedWriter.write(";");
//            bufferedWriter.write(pessoa.getEnderecoComercial());
//            bufferedWriter.write(";");
//            bufferedWriter.write(pessoa.getDataNasc().toString());
//            bufferedWriter.write(";");
//            bufferedWriter.write(pessoa.getCPF());
//            bufferedWriter.write(";");
//            bufferedWriter.write(pessoa.getRG());
//            bufferedWriter.write(";");
//            bufferedWriter.write(pessoa.getLogin());
//            bufferedWriter.write(";");
//            bufferedWriter.write(pessoa.getSenha());
//            bufferedWriter.write(";");
//            bufferedWriter.write(Integer.toString(pessoa.getNivelAcesso()));
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
//    private void FinalizaAlteracao(Pessoa pessoa, Pessoa newpessoa) {
//        newpessoa.setIdPessoa(pessoa.getIdPessoa());
//        newpessoa.setNome(pessoa.getNome());
//        newpessoa.setCPF(pessoa.getCPF());
//        newpessoa.setDataNasc(pessoa.getDataNasc());
//        newpessoa.setEmail(pessoa.getEmail());
//        newpessoa.setEndereco(pessoa.getEndereco());
//        newpessoa.setEnderecoComercial(pessoa.getEnderecoComercial());
//        newpessoa.setLocalTrabalho(pessoa.getLocalTrabalho());
//        newpessoa.setLogin(pessoa.getLogin());
//        newpessoa.setNivelAcesso(pessoa.getNivelAcesso());
//        newpessoa.setRG(pessoa.getRG());
//        newpessoa.setSenha(pessoa.getSenha());
//        newpessoa.setTelefone(pessoa.getTelefone());
//        System.out.println(
//                "1-Nome\n"
//                + "2-Endereço\n"
//                + "3-Telefone\n"
//                + "4-E-mail\n"
//                + "5-Local de Trabalho\n"
//                + "6-Endereço Comercial\n"
//                + "7-Data de Nascimento\n"
//                + "8-CPF\n"
//                + "9-RG\n"
//                + "10-Senha\n"
//                + "11-Sair");
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
//        while (opcao != 11) {
//            switch (opcao) {
//                case 1:
//                    System.out.println("Nome do Espectador: " + pessoa.getNome());
//                    System.out.println("Novo Nome: ");
//                    String nome = leia.nextLine();
//                    newpessoa.setNome(nome);
//                    break;
//                case 2:
//                    System.out.println("Endereço do Espectador: " + pessoa.getEndereco());
//                    System.out.println("Novo Endereço: ");
//                    String endereco = leia.nextLine();
//                    newpessoa.setEndereco(endereco);
//                    break;
//                case 3:
//                    System.out.println("Telefone do Espectador: " + pessoa.getTelefone());
//                    System.out.println("Novo Telefone: ");
//                    String telefone = leia.nextLine();
//                    newpessoa.setTelefone(telefone);
//                    break;
//                case 4:
//                    System.out.println("Email do Espectador: " + pessoa.getEmail());
//                    System.out.println("Novo Email: ");
//                    String email = leia.nextLine();
//                    newpessoa.setEmail(email);
//                    break;
//                case 5:
//                    System.out.println("Local de Trabalho do Espectador: " + pessoa.getLocalTrabalho());
//                    System.out.println("Novo Local de Trabalho: ");
//                    String localTrabalho = leia.nextLine();
//                    newpessoa.setLocalTrabalho(localTrabalho);
//                    break;
//                case 6:
//                    System.out.println("Endereço Comercial do Espectador: " + pessoa.getEnderecoComercial());
//                    System.out.println("Novo Endereço Comercial: ");
//                    String enderecoComercial = leia.nextLine();
//                    newpessoa.setEnderecoComercial(enderecoComercial);
//                    break;
//                case 7:
//                    Date data = new Date();
//                    data.setTime(pessoa.getDataNasc());
//                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//                    System.out.println("Data de Nascimento do Espectador: " + format.format(data));
//                    System.out.println("Nova Data de Nascimento: ");
//                    String DataNasc = leia.nextLine();
//                    valido = false;
//
//                    while (!valido) {
//
//                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//                        df.setLenient(false);
//                        try {
//                            data = df.parse(DataNasc);
//                            valido = true;
//                        } catch (ParseException ex) {
//                            System.out.println("Data Inválida! Digite Novamente: ");
//                            DataNasc = leia.nextLine();
//                        }
//                    }
//                    newpessoa.setDataNasc(data.getTime());
//                    break;
//                case 8:
//                    System.out.println("CPF do Espectador: " + pessoa.getCPF());
//                    System.out.println("Novo CPF: ");
//                    String CPF = leia.nextLine();
//                    newpessoa.setCPF(CPF);
//                    break;
//                case 9:
//                    System.out.println("RG do Espectador: " + pessoa.getRG());
//                    System.out.println("Novo RG: ");
//                    String RG = leia.nextLine();
//                    newpessoa.setRG(RG);
//                    break;
//                case 10:
//                    System.out.println("Senha do Espectador: " + pessoa.getNome());
//                    System.out.println("Nova Senha: ");
//                    String senha = leia.nextLine();
//                    newpessoa.setSenha(senha);
//                    break;
//                default:
//                    break;
//
//            }
//            System.out.println(
//                    "1-Nome\n"
//                    + "2-Endereço\n"
//                    + "3-Telefone\n"
//                    + "4-E-mail\n"
//                    + "5-Local de Trabalho\n"
//                    + "6-Endereço Comercial\n"
//                    + "7-Data de Nascimento\n"
//                    + "8-CPF\n"
//                    + "9-RG\n"
//                    + "10-Senha\n"
//                    + "11-Sair");
//            System.out.println("Informe a opção selecionada");
//            valido = false;
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
//        this.Copia(pessoa, newpessoa);
//    }
//
//    public void Copia(Pessoa pessoa, Pessoa newpessoa) {
//        String linhaAlterar = Pessoa.TransformarEmLinha(pessoa);
//        String linhaAlterada = Pessoa.TransformarEmLinha(newpessoa);
//        File file = pessoa.getArq();
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
//    public void Copia(Pessoa pessoa) {
//        String linhaExcluir = Pessoa.TransformarEmLinha(pessoa);
//        File file = pessoa.getArq();
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
//}
