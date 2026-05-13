package br.com.soulmove.usuario;

import br.com.soulmove.missao.Missao;
import br.com.soulmove.veiculo.*;
import br.com.soulmove.viagem.Viagem;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    //private int id;
    private String nome;
    private int pontos;

    private double creditos;
    private int viagensBicicleta;
    private double kmBicicleta;
    private int viagensTrem;
    private double kmTrem;
    private int viagensMetro;
    private double kmMetro;
    private int viagensOnibus;
    private double kmOnibus;

    private List<String> missoesCumpridas = new ArrayList<>(); //pelo id

    private List<Viagem> historicoViagens = new ArrayList<>();

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

    public int getPontos() {
        return pontos;
    }

    public double getCreditos() {
        return creditos;
    }

    public int getViagensBicicleta() {
        return viagensBicicleta;
    }

    public int getViagensTrem() {
        return viagensTrem;
    }

    public int getViagensOnibus() {
        return viagensOnibus;
    }

    public int getViagensMetro() {
        return viagensMetro;
    }

    public double getKmBicicleta() {
        return kmBicicleta;
    }

    public double getKmTrem() {
        return kmTrem;
    }

    public double getKmOnibus() {
        return kmOnibus;
    }

    public double getKmMetro() {
        return kmMetro;
    }

    //outros métodos

    //metodos pra adicionar
    public void addPontos(int pontos){
        this.pontos += pontos;
    }

    public void addViagemBicicleta(){this.viagensBicicleta += 1;}
    public void addViagemTrem(){this.viagensTrem += 1;}
    public void addViagemOnibus(){this.viagensOnibus += 1;}
    public void addViagemMetro(){this.viagensMetro +=1;}

    public void addKmBicicleta(double km){this.kmBicicleta +=km;}
    public void addKmTrem(double km){this.kmTrem +=km;}
    public void addKmOnibus(double km){this.kmOnibus +=km;}
    public void addKmMetro(double km){this.kmMetro +=km;}


    public void addMissao(Missao missao){

        missoesCumpridas.add(missao.getId());
    }
    public void addMissao(String id){
        missoesCumpridas.add(id);
    }

    public boolean isDisponivel(Missao missao){
        if(missoesCumpridas.contains(missao.getId())){
            return false;
        }
        return true;
    }


    public int getViagensColetivo() {
        return viagensTrem + viagensMetro + viagensOnibus;
    }

    public void addViagem(Viagem viagem) {
        this.historicoViagens.add(viagem);
        double km = viagem.getKm();
        switch (viagem.getVeiculo()){
            case Carro carro ->     {
                //addViagensCarro();
                //addKmCarro();


            }
            case Trem trem ->      {
                addViagemTrem();
                addKmTrem(km);
            }
            case Metro metro ->     {
                addViagemMetro();
                addKmMetro(km);
            }
            case Onibus onibus ->    {
                addViagemOnibus();
                addKmOnibus(km);
            }
            case Bicicleta bicicleta -> {
                addViagemBicicleta();
                addKmBicicleta(km);
            }
            case Moto moto ->      {
               // addViagensMoto();
               // addKmMoto();
            }
            default -> {}
        }
    }
}
