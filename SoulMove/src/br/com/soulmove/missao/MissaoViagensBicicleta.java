package br.com.soulmove.missao;

import br.com.soulmove.usuario.Usuario;

public class MissaoViagensBicicleta extends Missao implements Cumprivel{

    public MissaoViagensBicicleta(int id_num){
        this.id = "#VBC" + id_num;
        this.pontos = 30;
        this.titulo = "Viagens de bicicleta";
        this.desc = "Faça 3 viagens de bicicleta para promover a sustentabilidade e resgatar os pontos 😊";
    }


    @Override
    public boolean verificarCumprida(Usuario user) {
        if (user.isDisponivel(this) && user.getViagensBicicleta() > 3){
            this.missaoCumprida(user);
             return true;
        }
        return false;

    }
}
