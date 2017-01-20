package br.com.sistemaTeatroWeb.modelo;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author jpdia
 */
public class Compra {

    private int numeroReserva;
    private LinkedList<Integer> assentos;
    private double valorTotal;
    private Apresentacao fk_Apresentacao;
    private Pessoa fk_Pessoa;
    private String numeroCartao;
    private String bandeiraCartao;
    private String datavalidade;
    private String numBoleto;
    private Date dataVencimento;
    private String formaPagamento;
    
    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public long getDataVencimento() {
        return dataVencimento.getTime();
    }

    public void setDataVencimento(long dataVencimento) {
        this.dataVencimento = new Date(dataVencimento);
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    
    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }


    public String getBandeiraCartao() {
        return bandeiraCartao;
    }


    public void setBandeiraCartao(String bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }


    public String getDatavalidade() {
        return datavalidade;
    }


    public void setDatavalidade(String datavalidade) {
        this.datavalidade = datavalidade;
    }


    public String getNumBoleto() {
        return numBoleto;
    }


    public void setNumBoleto(String numBoleto) {
        this.numBoleto = numBoleto;
    }


    public int getNumeroReserva() {
        return numeroReserva;
    }

    
    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    
    public LinkedList<Integer> getAssentos() {
        return assentos;
    }

    public void setAssentos(int assento) {
        this.assentos.add(assento);
    }


    public void setAssentos(LinkedList<Integer> Totalassento) {
        this.assentos.addAll(Totalassento);
    }


    public double getValorTotal() {
        return valorTotal;
    }


    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

   
    public Apresentacao getFk_Apresentacao() {
        return fk_Apresentacao;
    }

   
    
    public void setFk_Apresentacao(Apresentacao fk_Apresentacao) {
        this.fk_Apresentacao = fk_Apresentacao;
    }

   
    public Pessoa getFk_Pessoa() {
        return fk_Pessoa;
    }

    
    public void setFk_Pessoa(Pessoa fk_Pessoa) {
        this.fk_Pessoa = fk_Pessoa;
    }

   
   
//    public static Compra buscaID(int codCompra) {
//        Reader fileReader = null;
//        boolean existe = arq.exists();
//        Compra compra = null;
//        try {
//
//            if (existe) {
//                fileReader = new FileReader(arq.getAbsolutePath());
//                BufferedReader br = new BufferedReader(fileReader);
//                String linha = br.readLine();
//                while (linha != null) {
//                    linha = Compra.removeUTF8BOM(linha);
//                    if (!(linha.equals(""))) {
//                        String[] dados = linha.split(";");
//
//                        int id = Integer.parseInt(dados[0]);
//
//                        if (id == codCompra) {
//                            compra = new Compra();
//                            compra.setNumeroReserva(id);
//                            Apresentacao apresentacao = Apresentacao.buscaID(Integer.parseInt(dados[3]));
//                            compra.setFk_Apresentacao(apresentacao);
//                            compra.setAssentos(Compra.totalAssentosCompradosporCompra(compra.getFk_Apresentacao().getFk_Sala().getIdSala(), id));
//                            compra.setValorTotal(Double.parseDouble(dados[2]));
//                            compra.setFk_Pessoa(Pessoa.buscaID(Integer.parseInt(dados[4])));
//                            if (dados[5].equals("Cartão de Crédito")) {
//                                compra.setFormaPagamento(dados[5]);
//                                compra.setNumeroCartao(dados[6]);
//                                compra.setBandeiraCartao(dados[7]);
//                                compra.setDatavalidade(dados[8]);
//                            } else {
//                                compra.setFormaPagamento(dados[5]);
//                                compra.setNumBoleto(dados[6]);
//                                compra.setDataVencimento(Long.parseLong(dados[7]));
//
//                            }
//
//                            return compra;
//
//                        }
//                        linha = br.readLine();
//                    }
//                }
//
//            }
//        } catch (IOException e) {
//            System.out.println("Não foi possível alterar o arquivo");
//        } finally {
//            try {
//                fileReader.close();
//            } catch (IOException e) {
//                System.out.println("Não foi possível alterar o arquivo");
//            }
//
//        }
//        return null;
//    }
//
//    /**
//     *
//     * @param idSala
//     * @return
//     */
//    public static LinkedList<Integer> totalAssentosComprados(int idSala) {
//        Reader fileReader = null;
//        boolean existe = arq.exists();
//        Apresentacao compra = null;
//        LinkedList<Integer> listaAssento = new LinkedList<>();
//        try {
//            if (existe) {
//                fileReader = new FileReader(arq.getAbsolutePath());
//                BufferedReader br = new BufferedReader(fileReader);
//                String linha = br.readLine();
//                while (linha != null) {
//                    linha = Compra.removeUTF8BOM(linha);
//                    if (!(linha.equals(""))) {
//                        String[] dados = linha.split(";");
//                        int idApresentacao = Integer.parseInt(dados[3]);
//                        compra = Apresentacao.buscaID(idApresentacao);
//                        int sala = compra.getFk_Sala().getIdSala();
//                        if (idSala == sala) {
//                            listaAssento.add(Integer.parseInt(dados[1]));
//                        }
//                    }
//                    linha = br.readLine();
//                }
//                return listaAssento;
//            }
//
//        } catch (IOException e) {
//            System.out.println("Não foi possível alterar o arquivo");
//        } finally {
//            try {
//                fileReader.close();
//            } catch (IOException e) {
//                System.out.println("Não foi possível alterar o arquivo");
//            }
//
//        }
//        return null;
//    }
//
//    /**
//     *
//     * @param idSala
//     * @param idCompra
//     * @return
//     */
//    public static LinkedList<Integer> totalAssentosCompradosporCompra(int idSala, int idCompra) {
//        Reader fileReader = null;
//        boolean existe = arq.exists();
//        Apresentacao apresentacao = null;
//        LinkedList<Integer> listaAssento = new LinkedList<>();
//        try {
//            if (existe) {
//                fileReader = new FileReader(arq.getAbsolutePath());
//                BufferedReader br = new BufferedReader(fileReader);
//                String linha = br.readLine();
//                while (linha != null) {
//                    linha = Compra.removeUTF8BOM(linha);
//                    if (!(linha.equals(""))) {
//                        String[] dados = linha.split(";");
//                        int idApresentacao = Integer.parseInt(dados[3]);
//                        apresentacao = Apresentacao.buscaID(idApresentacao);
//                        int sala = apresentacao.getFk_Sala().getIdSala();
//                        int compra = Integer.parseInt(dados[0]);
//                        if (idSala == sala && idCompra == compra) {
//                            listaAssento.add(Integer.parseInt(dados[1]));
//                        }
//                    }
//                    linha = br.readLine();
//                }
//                return listaAssento;
//            }
//
//        } catch (IOException e) {
//            System.out.println("Não foi possível alterar o arquivo");
//        } finally {
//            try {
//                fileReader.close();
//            } catch (IOException e) {
//                System.out.println("Não foi possível alterar o arquivo");
//            }
//
//        }
//        return null;
//    }
//
//    /**
//     *
//     * @param codPessoa
//     * @return
//     */
//    public static LinkedList<Compra> ComprasporPessoa(int codPessoa) {
//        Reader fileReader = null;
//        boolean existe = arq.exists();
//        Compra compra = null;
//        LinkedList<Compra> listaCompra = new LinkedList<>();
//        try {
//            if (existe) {
//                fileReader = new FileReader(arq.getAbsolutePath());
//                BufferedReader br = new BufferedReader(fileReader);
//                String linha = br.readLine();
//                while (linha != null) {
//                    linha = Compra.removeUTF8BOM(linha);
//                    if (!(linha.equals(""))) {
//                        String[] dados = linha.split(";");
//                        int idPessoa = Integer.parseInt(dados[4]);
//                        if (codPessoa == idPessoa) {
//                            compra = Compra.buscaID(Integer.parseInt(dados[0]));
//                            listaCompra.add(compra);
//                        }
//                    }
//                    linha = br.readLine();
//                }
//                return listaCompra;
//            }
//
//        } catch (IOException e) {
//            System.out.println("Não foi possível alterar o arquivo");
//        } finally {
//            try {
//                fileReader.close();
//            } catch (IOException e) {
//                System.out.println("Não foi possível alterar o arquivo");
//            }
//
//        }
//        return null;
//    }
//
//   
//    public static void TotalporEspetaculo() {
//        Reader fileReader = null;
//        boolean existe = arq.exists();
//        Compra compra = null;
//        LinkedList<Compra> listaCompra = new LinkedList<>();
//        try {
//
//            if (existe) {
//                fileReader = new FileReader(arq.getAbsolutePath());
//                BufferedReader br = new BufferedReader(fileReader);
//                String linha = br.readLine();
//                
//                while (linha != null) {
//                    linha = Compra.removeUTF8BOM(linha);
//                    if (!(linha.equals(""))) {
//                        String[] dados = linha.split(";");
//
//                        
//
//                        
//                            compra = new Compra();
//                            compra.setNumeroReserva(Integer.parseInt(dados[0]));
//                            Apresentacao apresentacao = Apresentacao.buscaID(Integer.parseInt(dados[3]));
//                            compra.setFk_Apresentacao(apresentacao);
//                            compra.setAssentos(Compra.totalAssentosCompradosporCompra(compra.getFk_Apresentacao().getFk_Sala().getIdSala(), compra.getNumeroReserva()));
//                            compra.setValorTotal(Double.parseDouble(dados[2]));
//                            compra.setFk_Pessoa(Pessoa.buscaID(Integer.parseInt(dados[4])));
//                            if (dados[5].equals("Cartão de Crédito")) {
//                                compra.setFormaPagamento(dados[5]);
//                                compra.setNumeroCartao(dados[6]);
//                                compra.setBandeiraCartao(dados[7]);
//                                compra.setDatavalidade(dados[8]);
//                            } else {
//                                compra.setFormaPagamento(dados[5]);
//                                compra.setNumBoleto(dados[6]);
//                                compra.setDataVencimento(Long.parseLong(dados[7]));
//
//                            }
//
//                            listaCompra.add(compra);
//
//                        }
//                        linha = br.readLine();
//                    }
//                }
//
//            
//        } catch (IOException e) {
//            System.out.println("Não foi possível alterar o arquivo");
//        } finally {
//            try {
//                fileReader.close();
//            } catch (IOException e) {
//                System.out.println("Não foi possível alterar o arquivo");
//            }
//
//        }
//        if(listaCompra.size()>0)
//        {
//            LinkedList<Espetaculo> lista = Espetaculo.buscaTodos();
//            for(Espetaculo e:lista)
//            {
//                double valorTotal =0;
//                for(Compra c :  listaCompra)
//                {
//                    if(e.getIdEspetaculo()==compra.getFk_Apresentacao().getFk_Espetaculo().getIdEspetaculo())
//                    {
//                        valorTotal+=compra.getValorTotal();
//                    
//                    }
//                
//                }
//                System.out.println("O valor total arrecado pelo Espetáculo: " + e.getNome() + "é: "+valorTotal );
//            }
//        }
//    }
}
