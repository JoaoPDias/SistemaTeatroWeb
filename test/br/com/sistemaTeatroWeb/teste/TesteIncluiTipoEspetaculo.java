package br.com.sistemaTeatroWeb.teste;

import br.com.sistemaTeatroWeb.dao.TipoEspetaculoDao;
import br.com.sistemaTeatroWeb.modelo.TipoEspetaculo;

public class TesteIncluiTipoEspetaculo {
    public static void main(String args[]) {
        TipoEspetaculo tipoespetaculo = new TipoEspetaculo();
        TipoEspetaculoDao dao = new TipoEspetaculoDao();
        tipoespetaculo.setIdTipoEspetaculo(dao.getIdTipoEspetaculo());
        tipoespetaculo.setNome("Comédia Dramática");
        tipoespetaculo.setDescricao("A comédia dramática está presenta no mundo desde de Shakespere");
        dao.Inclui(tipoespetaculo);
        tipoespetaculo.setDescricao("A comédia dramática está presente no mundo desde de Shakespere");
        dao.Altera(tipoespetaculo);
        
        
    }
    
}
