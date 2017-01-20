package br.com.sistemaTeatroWeb.modelo;

import org.joda.time.DateTime;



public class Artista{

    private int idArtista;
    private String nome;
    private DateTime dataNasc;
    private String CPF;
    private String RG;
    private String celular;
    private String email;

    public int getIDArtista() {
        return idArtista;
    }

    public String getNome() {
        return nome;
    }

    public DateTime getDataNasc() {
        return this.dataNasc;
    }

    public String getCPF() {
        return CPF;
    }

    public String getRG() {
        return RG;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }


    public void setIDArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNasc(DateTime dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public static Artista buscaID(int codigo) {
        Reader fileReader = null;
        boolean existe = arq.exists();
        Artista artista = null;
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                while (linha != null) {
                    linha = Artista.removeUTF8BOM(linha);
                    if (!linha.equals("")) {
                        String[] dados = linha.split(";");

                        int id = Integer.parseInt(dados[0]);

                        if (id == codigo) {
                            artista = new Artista();
                            artista.setIDArtista(id);
                            artista.setNome(dados[1]);
                            artista.setDataNasc(Long.parseLong(dados[2]));
                            artista.setCPF(dados[3]);
                            artista.setRG(dados[4]);
                            artista.setCelular(dados[5]);
                            artista.setEmail(dados[6]);

                            return artista;
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
    }*/
    
}
