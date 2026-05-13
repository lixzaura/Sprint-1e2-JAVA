package br.com.soulmove.viagem;

import br.com.soulmove.veiculo.Veiculo;

public class Viagem {
    private Veiculo veiculo;
    private double km;
    private String partida;
    private String destino;

    public Viagem(Veiculo veiculo,double km, String partida, String destino){
        this.veiculo = veiculo;
        this.km = km;
        this.partida = partida;
        this.destino = destino;
    }

    public Veiculo getVeiculo(){
        return this.veiculo;
    }
    public double getKm(){
        return this.km;
    }
    public String getPartida(){
        return this.partida;
    }
    public String getDestino(){
        return this.destino;
    }

    public double getEmissao(){
        return veiculo.calcularEmissao(km);
    }
}
