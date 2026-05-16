package br.com.soulmove.usuario;

import br.com.soulmove.app.Menu;
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

    private List<String> missoesCumpridas = new ArrayList<>(); //pelo id

    private List<Viagem> historicoViagens = new ArrayList<>();

    //construtor

    public Usuario(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.creditos = 0.0;
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


    //outros métodos

    //metodos pra adicionar
    public void addPontos(int pontos){
        this.pontos += pontos;
    }


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



    public void addViagem(Viagem viagem) {
        this.historicoViagens.add(viagem);
        double km = viagem.getKm();
    }

    public int getViagens(String veiculo){
        veiculo = veiculo.toLowerCase();
        int viagens = 0;
        for (int i = 0; i < historicoViagens.size(); i++){
            Viagem viagem = historicoViagens.get(i);
            String viagemV = Menu.getVeiculo(viagem.getVeiculo());
            if (veiculo.equals(viagemV))
                viagens +=1;
            else if (veiculo.equals("coletivo")) {
                if(viagemV.equals("trem") || viagemV.equals("metro") || viagemV.equals("onibus")){
                    viagens +=1;
                }
            }
        }
        return viagens;
    }

    public double getKm(String veiculo){
        veiculo = veiculo.toLowerCase();
        double viagens = 0;
        for (int i = 0; i < historicoViagens.size(); i++){
            Viagem viagem = historicoViagens.get(i);
            String viagemV = Menu.getVeiculo(viagem.getVeiculo());
            if (veiculo.equals(viagemV))
                viagens += viagem.getKm();
            else if (veiculo.equals("coletivo")) {
                if(viagemV.equals("trem") || viagemV.equals("metro") || viagemV.equals("onibus")){
                    viagens += viagem.getKm();
                }
            }
        }
        return viagens;
    }

}
