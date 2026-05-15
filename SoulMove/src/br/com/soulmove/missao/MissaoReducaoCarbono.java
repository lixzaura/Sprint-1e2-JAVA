package br.com.soulmove.missao;

import br.com.soulmove.usuario.Usuario;
import br.com.soulmove.veiculo.Carro;
import br.com.soulmove.veiculo.Metro;
import br.com.soulmove.veiculo.Onibus;
import br.com.soulmove.veiculo.Trem;

public class MissaoReducaoCarbono extends Missao{

    public MissaoReducaoCarbono(int id_num){
        this.id = "#RC" + id_num;
        this.pontos = 40;
        this.titulo = "Reduzir emissão";
        this.desc =   "Reduza 10kg de emissão de carbono substituindo carro por transporte coletivo para resgatar os pontos 😊";
    }


    @Override
    public boolean verificarCumprida(Usuario user) {
        if (user.isDisponivel(this)){

            Carro carro = new Carro();
            Onibus onibus = new Onibus();
            Trem trem = new Trem();
            Metro metro = new Metro();

            double emissaoOnibus = onibus.calcularEmissao(user.getKm("onibus"));
            double emissaoTrem = trem.calcularEmissao(user.getKm("Trem"));
            double emissaoMetro = metro.calcularEmissao(user.getKm("Metro"));
            double kmTotal = user.getKm("Bicicleta") + user.getKm("Metro") + user.getKm("Trem") + user.getKm("Onibus");

            double emissaoTotalCarro = carro.calcularEmissao(kmTotal);
            if (emissaoTotalCarro - (emissaoMetro + emissaoOnibus + emissaoTrem) >= 1000){
                this.missaoCumprida(user);
                return true;
            }


        }
        return false;

    }
}
