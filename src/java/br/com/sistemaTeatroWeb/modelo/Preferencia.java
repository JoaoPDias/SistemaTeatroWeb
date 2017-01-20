package br.com.sistemaTeatroWeb.modelo;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class Preferencia{

    private int idPreferencia;
    public TipoEspetaculo fk_TipoDeEspetaculo;
    public Pessoa fk_Pessoa;

    public int getIdPreferencia() {
        return idPreferencia;
    }

    public void setIdPreferencia(int id) {
        this.idPreferencia = id;
    }

    public TipoEspetaculo getFk_TipoDeEspetaculo() {
        return fk_TipoDeEspetaculo;
    }

    public void setFk_TipoDeEspetaculo(TipoEspetaculo fk_TipoDeEspetaculo) {
        this.fk_TipoDeEspetaculo = fk_TipoDeEspetaculo;
    }

    public Pessoa getFk_Pessoa() {
        return fk_Pessoa;
    }

    public void setFk_Pessoa(Pessoa fk_Pessoa) {
        this.fk_Pessoa = fk_Pessoa;
    }

    
}