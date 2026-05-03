package br.com.soulmove.usuario;

public class Usuario {
    //private int id;
    private String nome;
    private int pontos;

    private double creditos;
    private int viagensBicicleta;
    private double kmBicicleta;
    private int viagensTrem;
    private double kmTrem;
    private int viagensOnibus;
    private double kmOnibus;

    //construtor

    public Usuario(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.creditos = 0.0;
        this.viagensBicicleta = 0;
        this.kmBicicleta = 0.;
        this.viagensTrem = 0;
        this.kmTrem = 0.0;
        this.viagensOnibus = 0;
        this.kmOnibus = 0.0;
    }


    //metodos acessores

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public double getCreditos() {
        return creditos;
    }

    public void setCreditos(double creditos) {
        this.creditos = creditos;
    }

    public int getViagensBicicleta() {
        return viagensBicicleta;
    }

    public void setViagensBicicleta(int viagensBicicleta) {
        this.viagensBicicleta = viagensBicicleta;
    }

    public double getKmBicicleta() {
        return kmBicicleta;
    }

    public void setKmBicicleta(double kmBicicleta) {
        this.kmBicicleta = kmBicicleta;
    }

    public int getViagensTrem() {
        return viagensTrem;
    }

    public void setViagensTrem(int viagensTrem) {
        this.viagensTrem = viagensTrem;
    }

    public double getKmTrem() {
        return kmTrem;
    }

    public void setKmTrem(double kmTrem) {
        this.kmTrem = kmTrem;
    }

    public int getViagensOnibus() {
        return viagensOnibus;
    }

    public void setViagensOnibus(int viagensOnibus) {
        this.viagensOnibus = viagensOnibus;
    }

    public double getKmOnibus() {
        return kmOnibus;
    }

    public void setKmOnibus(double kmOnibus) {
        this.kmOnibus = kmOnibus;
    }

    public int getViagensColetivo(){
        return viagensTrem + viagensOnibus;
    }

    //outros métodos
    public void addPontos(int pontos){
        this.pontos += pontos;
    }




}
