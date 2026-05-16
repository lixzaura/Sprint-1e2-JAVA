package br.com.soulmove.missao;

import br.com.soulmove.usuario.Usuario;

public class MissaoViagensColetivo extends Missao{

    public MissaoViagensColetivo(int id_num){
        this.id = "#VTC" + id_num;
        this.pontos = 20;
        this.titulo = "Viagens de transporte coletivo";
        this.desc = "Faça 5 viagens em transportes coletivos como Ônibus, metrô ou trem";
  }


    @Override
    public boolean verificarCumprida(Usuario user) {
        if (user.isDisponivel(this) && user.getViagens("Coletivo") > 5){
            this.missaoCumprida(user);
            return true;
        }
        return false;

    }
}
