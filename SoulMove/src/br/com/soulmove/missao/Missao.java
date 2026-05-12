package br.com.soulmove.missao;

import br.com.soulmove.usuario.Usuario;

public abstract class Missao implements Cumprivel{
    String titulo; // o titulo da missão
    String desc; //descrição
    int pontos;//quantos pontos o usuário recebe ao completar a missão
    String id; // --> # --> SiglaDaMissao --> numero da instancia dessa missão


    //metodos acessores

    public int getPontos() {
        return pontos;
    }

    public String getDesc() {
        return desc;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getId() {return id;}

    public void missaoCumprida(Usuario user){
        user.addPontos(this.pontos);
        user.addMissao(this.id);
    }

}
