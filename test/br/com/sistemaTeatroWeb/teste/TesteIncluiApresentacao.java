package br.com.sistemaTeatroWeb.teste;

import br.com.sistemaTeatroWeb.modelo.Apresentacao;
import br.com.sistemaTeatroWeb.modelo.Espetaculo;
import br.com.sistemaTeatroWeb.modelo.Sala;
import org.joda.time.DateTime;

public class TesteIncluiApresentacao {

    public static void main(String args[]) {
        Sala sala = new Sala();
        Espetaculo espetaculo = new Espetaculo();
        Apresentacao apresentacao = new Apresentacao();
        apresentacao.setData(new DateTime());
        
        
    }
}
