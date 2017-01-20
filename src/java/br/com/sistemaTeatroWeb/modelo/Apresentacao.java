package br.com.sistemaTeatroWeb.modelo;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;

public class Apresentacao {

    private int idApresentacao;
    private DateTime data;
    private LocalTime horario;
    private double valorIngresso;
    private Espetaculo fk_Espetaculo;
    private Sala fk_Sala;
    public LinkedList<Compra> compras = new LinkedList<>();

    public int getIdApresentacao() {
        return idApresentacao;
    }

    public void setIdApresentacao(int idApresentacao) {
        this.idApresentacao = idApresentacao;
    }

    public DateTime getData() {
        return this.data;
    }

    public void setData(DateTime date) {
        this.data = date;
    }

    public LocalTime getHorario() {
        return this.horario;
    }

    public void setHorario(LocalTime time) {
        this.horario = time;
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public Espetaculo getFk_Espetaculo() {
        return fk_Espetaculo;
    }

    public void setFk_Espetaculo(Espetaculo fk_Espetaculo) {
        this.fk_Espetaculo = fk_Espetaculo;
    }

    public Sala getFk_Sala() {
        return fk_Sala;
    }

    public void setFk_Sala(Sala fk_Sala) {
        this.fk_Sala = fk_Sala;
    }

    public LinkedList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(LinkedList<Compra> compras) {
        this.compras = compras;
    }

}

/*public static Apresentacao buscaSala(int codigoSala)*/

 /*public static Apresentacao buscaID(int codigo)*/
 /*public static LinkedList<Apresentacao> buscaTodos()*/
