package br.com.soulmove.missao;

import br.com.soulmove.usuario.Usuario;

public abstract class Missao {
    String titulo; // o titulo da missão
    String desc; //descrição
    int pontos;//quantos pontos o usuário recebe ao completar a missão
    int id;



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

    public int getId() {
        return id;
    }

    public void missaoCumprida(Usuario user){
        user.addPontos(this.pontos);
    }

}
