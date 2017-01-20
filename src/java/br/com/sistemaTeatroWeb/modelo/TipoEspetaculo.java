
package br.com.sistemaTeatroWeb.modelo;


public class TipoEspetaculo {

   /* static TipoEspetaculo buscaID(int codigo) {
        Reader fileReader = null;
        boolean existe = arq.exists();
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                TipoEspetaculo tipoespetaculo = new TipoEspetaculo();
                while (linha != null) {
                    linha = TipoEspetaculo.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {
                        String[] dados = linha.split(";");

                        int id = Integer.parseInt(dados[0]);

                        if (id == codigo) {
                            tipoespetaculo.setIdTipoEspetaculo(Integer.parseInt(dados[0]));
                            tipoespetaculo.setNome(dados[1]);
                            tipoespetaculo.setNome(dados[0]);
                        }
                    }

                    linha = br.readLine();
                }
                return tipoespetaculo;

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
    static LinkedList<TipoEspetaculo> buscaTodos() {
        Reader fileReader = null;
        boolean existe = arq.exists();
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                LinkedList<TipoEspetaculo> tipos = new LinkedList<>();
                TipoEspetaculo tipoespetaculo = new TipoEspetaculo();
                while (linha != null) {
                    linha = TipoEspetaculo.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {
                        String[] dados = linha.split(";");


                            tipoespetaculo.setIdTipoEspetaculo(Integer.parseInt(dados[0]));
                            tipoespetaculo.setNome(dados[1]);
                            tipoespetaculo.setNome(dados[0]);
                        
                    }
                    tipos.add(tipoespetaculo);
                    linha = br.readLine();
                }
                return tipos;

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

    */
    private int idTipoEspetaculo;
    private String nome;
    private String descricao;
    public int getIdTipoEspetaculo() {
        return idTipoEspetaculo;
    }

    public void setIdTipoEspetaculo(int idTipoEspetaculo) {
        this.idTipoEspetaculo = idTipoEspetaculo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    
   

}
