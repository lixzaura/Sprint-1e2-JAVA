package br.com.soulmove.missao;

import br.com.soulmove.usuario.Usuario;
import br.com.soulmove.veiculo.Carro;
import br.com.soulmove.veiculo.Metro;
import br.com.soulmove.veiculo.Onibus;
import br.com.soulmove.veiculo.Trem;

public class MissaoReducaoCarbono extends Missao implements Cumprivel{

    public MissaoReducaoCarbono(int id_num){
        this.id = "#RC" + id_num;
        this.pontos = 40;
        this.titulo = "Reduza 10kg de emissão de carbono";
        this.desc =   "Reduza 10kg de emissão de carbono substituindo carro por transporte coletivo para resgatar os pontos 😊";
    }


    @Override
    public boolean verificarCumprida(Usuario user) {
        if (user.isDisponivel(this)){

            Carro carro = new Carro();
            Onibus onibus = new Onibus();
            Trem trem = new Trem();
            Metro metro = new Metro();

            double emissaoOnibus = onibus.calcularEmissao(user.getKmOnibus());
            double emissaoTrem = trem.calcularEmissao(user.getKmTrem());
            double emissaoMetro = metro.calcularEmissao(user.getKmMetro());
            double kmTotal = user.getKmBicicleta() + user.getKmMetro() + user.getKmTrem() + user.getKmOnibus();

            double emissaoTotalCarro = carro.calcularEmissao(kmTotal);
            if (emissaoTotalCarro - (emissaoMetro + emissaoOnibus + emissaoTrem) >= 1000){
                this.missaoCumprida(user);
                return true;
            }


        }
        return false;

    }
}
