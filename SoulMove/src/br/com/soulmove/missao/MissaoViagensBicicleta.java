package br.com.soulmove.missao;

import br.com.soulmove.usuario.Usuario;

public class MissaoViagensBicicleta extends Missao implements Cumprivel{

    public MissaoViagensBicicleta(){
        id = 1;
        pontos = 30;
        titulo = "Faça 3 viagens de bicicleta";
        desc = "Faça 3 viagens de bicicleta para promover a sustentabilidade e resgatar os pontos 😊";

    }


    @Override
    public boolean verificarCumprida(Usuario user) {
        if (/*checar disponibilidade &&*/ user.getViagensBicicleta() > 3)
            return true;


        return false;

    }
}
