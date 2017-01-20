package sistemateatro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.Scanner;

public class PreferenciaDao {

    Preferencia preferencia = new Preferencia();

    public void VisualizarPreferencia(Pessoa pessoa) {
        Scanner leia = new Scanner(System.in);
        Reader fileReader = null;
        File arq = preferencia.getArq();
        boolean existe = arq.exists();

        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();

                LinkedList<Preferencia> lista = new LinkedList<>();
                while (linha != null) {
                    linha = Preferencia.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {
                        String[] dados = linha.split(";");

                        if (Integer.parseInt(dados[1]) == pessoa.getIdPessoa()) {
                            int id = Integer.parseInt(dados[0]);
                            preferencia.setIdPreferencia(id);
                            preferencia.setFk_Pessoa(pessoa);
                            TipoEspetaculo tipoespetaculo = TipoEspetaculo.buscaID(Integer.parseInt(dados[2]));
                            if (tipoespetaculo != null) {
                                preferencia.setFk_TipoDeEspetaculo(tipoespetaculo);
                            }
                        }
                        linha = br.readLine();
                    }
                    lista.add(preferencia);
                }
                System.out.println("Espectador: " + pessoa.getNome());
                for (Preferencia preferencias : lista) {
                    System.out.println(preferencias.getFk_TipoDeEspetaculo().getNome() + " - " + preferencias.getFk_TipoDeEspetaculo().getNome());
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

    }

    public void Incluir(Pessoa pessoa) {
        Scanner leia = new Scanner(System.in);
        LinkedList<TipoEspetaculo> tipoEspetaculo = TipoEspetaculo.buscaTodos();
        int i = 0;
        for (TipoEspetaculo j : tipoEspetaculo) {
            System.out.println(j.getIdTipoEspetaculo() + " - " + j.getNome());
            i++;
        }
        System.out.println(i + " - SAIR");
        System.out.println("\nEscolha suas preferências: ");
        int escolha = Integer.parseInt(leia.nextLine());
        LinkedList<TipoEspetaculo> escolhidos = new LinkedList<TipoEspetaculo>();
        while (escolha != i && !tipoEspetaculo.isEmpty()) {
            for (TipoEspetaculo tipoEspetaculoExistente : tipoEspetaculo) {
                if (escolha == tipoEspetaculoExistente.getIdTipoEspetaculo()) {
                    escolhidos.add(tipoEspetaculoExistente);
                    tipoEspetaculo.remove(tipoEspetaculoExistente);
                }
            }
            System.out.println("\nEscolha suas preferências: ");
            escolha = Integer.parseInt(leia.nextLine());
        }

        GeradorID gerador = new GeradorID();
        int id = gerador.genID(preferencia);
        if (id > 0) {
            preferencia.setIdPreferencia(id);
        } else {
            System.out.println("Erro na inserção");
        }

        File arq = preferencia.getArq();
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

            for (TipoEspetaculo tpEspetaculo : escolhidos) {

                bufferedWriter.write(Integer.toString(preferencia.getIdPreferencia()));
                bufferedWriter.write(";");
                bufferedWriter.write(Integer.toString(pessoa.getIdPessoa()));
                bufferedWriter.write(";");

                bufferedWriter.write(Integer.toString(tpEspetaculo.getIdTipoEspetaculo()));
                bufferedWriter.write(";");
                bufferedWriter.newLine();

                //o método flush libera a escrita no arquivo
                fileWriter.flush();
                bufferedWriter.flush();
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

}
