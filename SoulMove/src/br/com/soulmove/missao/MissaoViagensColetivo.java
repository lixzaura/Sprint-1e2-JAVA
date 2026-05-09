package br.com.soulmove.missao;

import br.com.soulmove.usuario.Usuario;

public class MissaoViagensColetivo extends Missao implements Cumprivel{

    public MissaoViagensColetivo(int id_num){
        this.id = "#VTC" + id_num;
        this.pontos = 20;
        this.titulo = "Faça 5 viagens de transporte coletivo";
        this.desc = "Faça 5 viagens em transportes coletivos como Ônibus, metrô ou trem";
  }


    @Override
    public boolean verificarCumprida(Usuario user) {
        if (user.isDisponivel(this) && user.getViagensColetivo() > 5){
            this.missaoCumprida(user);
            return true;
        }
        return false;

    }
}
