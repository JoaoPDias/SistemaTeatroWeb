package br.com.sistemaTeatroWeb.teste;

import br.com.sistemaTeatroWeb.dao.TipoEspetaculoDao;
import br.com.sistemaTeatroWeb.modelo.TipoEspetaculo;

public class TesteExcluirTipoEspetaculo {

    public static void main(String args[]) {
        TipoEspetaculoDao dao = new TipoEspetaculoDao();
        TipoEspetaculo tipoespetaculo = dao.buscaId(2);
        dao.Exclui(tipoespetaculo);
    }
}
