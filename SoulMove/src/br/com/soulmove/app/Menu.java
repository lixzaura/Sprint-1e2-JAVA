package br.com.soulmove.app;

import br.com.soulmove.missao.Missao;
import br.com.soulmove.usuario.Usuario;
import br.com.soulmove.veiculo.*;
import br.com.soulmove.viagem.Viagem;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

import static br.com.soulmove.app.SoulMove.missoes;
import static br.com.soulmove.app.SoulMove.user;

public class Menu {

    public static Veiculo getVeiculo(String v){
        switch (v.toLowerCase()){
            case "carro" ->     {return new Carro();}
            case "trem" ->      {return new Trem();}
            case "metro" ->     {return new Metro();}
            case "onibus" ->    {return new Onibus();}
            case "bicicleta" -> {return new Bicicleta();}
            case "moto" ->      {return new Moto();}
        }

        return null;
    }

    public static String getVeiculo(Veiculo v){
        switch (v){
            case Carro carro ->         {return "carro";}
            case Trem trem ->           {return "trem";}
            case Metro metro ->         {return "metro";}
            case Onibus onibus ->       {return "onibus";}
            case Bicicleta bicicleta -> {return "bicicleta";}
            case Moto moto ->           {return "moto";}
            default ->                  {return null;}
        }
    }


    public static boolean isVeiculo(String veiculo){
        switch (veiculo.toLowerCase()){
            case "carro" ->     {return true;}
            case "trem" ->      {return true;}
            case "metro" ->     {return true;}
            case "onibus" ->    {return true;}
            case "bicicleta" -> {return true;}
            case "moto" ->      {return true;}
        }

        return false;
    }

    static void cadastrarUsuario(){
        Scanner leitura = new Scanner(System.in);
        System.out.println("▸⋮ ⌞ Insira o nome do usuário: ⌝");
        String nome = leitura.next() + leitura.nextLine();

        Usuario new_user = new Usuario(nome);

        System.out.println("\n" + "› Insira qualquer tecla para continuar: ");
        leitura.next();
        user = new_user;
    }

    static void verificarDados(){
        StringBuilder msg = new StringBuilder();



        System.out.println(user.getNome() + ": " + "⌞ Dados Gerais ⌝ ˎˊ˗");
        System.out.println("════════════════════════════");

        System.out.println("⋮ ≫ Pontos: " + user.getPontos());
        System.out.println("⋮ ≫ Passagems: " + user.getCreditos());

        System.out.println("\n");

        System.out.println(user.getNome() + ": " + "⌞ Dados de Viajem ⌝ ˎˊ˗");
        System.out.println("════════════════════════════");

        System.out.println("⋮ ≫ Viagens de Bicicleta: " + user.getViagens("bicicleta"));
        System.out.println("⋮ ≫ Viagens de Trem: " + user.getViagens("trem"));
        System.out.println("⋮ ≫ Viagens de Metro: " + user.getViagens("metro"));
        System.out.println("⋮ ≫ Viagens de Onibus: " + user.getViagens("onibus"));

        System.out.println("\n");
        System.out.println(user.getNome() + ": " + "⌞ Dados de Kilometragem ⌝ ˎˊ˗");
        System.out.println("════════════════════════════");

        System.out.println("⋮ ≫ KMs de Bicicleta: " + user.getKm("Bicicleta"));
        System.out.println("⋮ ≫ KMs de Trem: "      + user.getKm("Trem"));
        System.out.println("⋮ ≫ KMs de Metro: " + user.getKm("Metro"));
        System.out.println("⋮ ≫ KMs de Onibus: " + user.getKm("Onibus"));

        msg.append(user.getNome()+ ": " + "⌞ Dados Gerais ⌝ ˎˊ˗").append("\n");
        msg.append("════════════════════════════").append("\n");

        msg.append("⋮ ≫ Pontos: " + user.getPontos()).append("\n");
        msg.append("⋮ ≫ Passagems: " + user.getCreditos()).append("\n");

        msg.append("\n").append("\n");

        msg.append(user.getNome() + ": " + "⌞ Dados de Viajem ⌝ ˎˊ˗").append("\n");
        msg.append("════════════════════════════").append("\n");

        msg.append("⋮ ≫ Viagens de Bicicleta: " + user.getViagens("bicicleta")).append("\n");
        msg.append("⋮ ≫ Viagens de Trem: " + user.getViagens("trem")).append("\n");
        msg.append("⋮ ≫ Viagens de Metro: " + user.getViagens("metro")).append("\n");
        msg.append("⋮ ≫ Viagens de Onibus: " + user.getViagens("onibus")).append("\n");

        msg.append("\n");
        msg.append(user.getNome() + ": " + "⌞ Dados de Kilometragem ⌝ ˎˊ˗").append("\n");
        msg.append("════════════════════════════").append("\n");

        msg.append("⋮ ≫ KMs de Bicicleta: " + user.getKm("Bicicleta")).append("\n");
        msg.append("⋮ ≫ KMs de Trem: "      + user.getKm("Trem")).append("\n");
        msg.append("⋮ ≫ KMs de Metro: " + user.getKm("Metro")).append("\n");
        msg.append("⋮ ≫ KMs de Onibus: " + user.getKm("Onibus")).append("\n");

        JOptionPane.showMessageDialog(
                null,
                msg
        );
    }

    static void calcularEmissao(){
        Scanner leitura = new Scanner(System.in);
        System.out.println("▸⋮ ⌞ Insira o veiculo (sem acentos e minusculo) ⌝");
        String veiculo;
        veiculo = leitura.next() + leitura.nextLine();

        while (!isVeiculo(veiculo)){
            System.out.println("› Veiculo Inválido!");
            System.out.println("\n");
            System.out.println("▸⋮ ⌞ Insira o veiculo (sem acentos) ⌝");
            veiculo = leitura.nextLine();
        }

        System.out.println("▸⋮ ⌞ Insira a quantidade de quilometros que iremos simular ⌝");
        double km = Double.parseDouble(leitura.nextLine());
        Veiculo v = getVeiculo(veiculo);
        System.out.println("⋮ ≫ Você vai emitir " + v.calcularEmissao(km) + " Kg de carbono");

        System.out.println("\n" + "› Insira qualquer tecla para continuar: ");
        leitura.next();
    }

    static void converterPontos(){
        Scanner leitura = new Scanner(System.in);

        System.out.println("▸⋮ ⌞ Insira a quantidade de pontos que deseja converter em R$: ⌝");
        int pontosCon = leitura.nextInt();

        double conversao = pontosCon * 0.009;

        System.out.println("⋮ ≫ " + pontosCon + " pontos é igual a: R$" + String.format("%.2f", conversao));

        System.out.println("\n" + "› Insira qualquer tecla para continuar: ");
        leitura.next();
    }

    static void verificarMissoes(){
        StringBuilder msg = new StringBuilder();

        for (int i = 0; i < missoes.size(); i+=1){
            Missao missao = missoes.get(i);
            System.out.println("⌞ " + missao.getTitulo() + " ★ ⌝");
            System.out.println("⋮ ≫ " + missao.getDesc());
            System.out.println("════════════════════════════════════════════════════════");
            System.out.println("\n");
            msg.append("⌞ ").append(missao.getTitulo()).append(" ★ ⌝").append('\n');
            msg.append("⋮ ≫ ").append(missao.getDesc()).append('\n');
            msg.append("════════════════════════════════════════════════════════").append('\n');
            msg.append("\n").append('\n');
        }

        JOptionPane.showMessageDialog(
                null,
                msg
        );

    }



    static void simularViagem(){

        Scanner leitura = new Scanner(System.in);
        System.out.println("▸⋮ ⌞ Insira o veiculo (sem acentos) ⌝");
        String veiculo;
        veiculo = leitura.next() + leitura.nextLine();

        while (!isVeiculo(veiculo)){
            System.out.println("› Veiculo Inválido!");
            System.out.println("\n");
            System.out.println("▸⋮ ⌞ Insira o veiculo (sem acentos) ⌝");
            veiculo = leitura.nextLine();
        }

        System.out.println("▸⋮ ⌞ Insira o local de partida ⌝");
        String partida = leitura.nextLine();

        System.out.println("▸⋮ ⌞ Insira o destino simulado ⌝");
        String destino = leitura.nextLine();


        System.out.println("▸⋮ ⌞ Insira a quantidade de quilometros que iremos simular ⌝");

        double km = Double.parseDouble(leitura.nextLine());
        Veiculo v = getVeiculo(veiculo);
        Viagem viagem = new Viagem(v, km, partida, destino);
        user.addViagem(viagem);


    }
    static void verHistorico() {
        StringBuilder msg = new StringBuilder();

        List<Viagem> viagens = user.getHistoricoViagens();
        if (viagens.isEmpty()){

            System.out.println("› Nenhuma viagem Cadastrada!");
            msg.append("› Nenhuma viagem Cadastrada!");

        } else if (viagens.size() <=3) {

            for (int i = 1; i <= viagens.size(); i++){
                Viagem viagem = viagens.get(viagens.size()-i);

                System.out.println("⋮ ≫ Partida: " + viagem.getPartida());
                System.out.println("⋮ ≫ Destino: " + viagem.getDestino());
                System.out.println("⋮ ≫ Distancia: " + viagem.getKm());
                System.out.println("════════════════════════════════════════════════════════");
                System.out.println('\n');

                msg.append("⋮ ≫ Partida: " + viagem.getPartida()).append('\n');
                msg.append("⋮ ≫ Destino: " + viagem.getDestino()).append('\n');
                msg.append("⋮ ≫ Distancia: " + viagem.getKm()).append('\n');
                msg.append("════════════════════════════════════════════════════════").append('\n');
                msg.append('\n').append('\n');
            }
            
        } else {

            for (int i = 1; i <= 3; i++){
                Viagem viagem = viagens.get(viagens.size()-i);

                System.out.println("⋮ ≫ Partida: " + viagem.getPartida());
                System.out.println("⋮ ≫ Destino: " + viagem.getDestino());
                System.out.println("⋮ ≫ Distancia: " + viagem.getKm());
                System.out.println("════════════════════════════════════════════════════════");
                System.out.println('\n');

                msg.append("⋮ ≫ Partida: " + viagem.getPartida()).append('\n');
                msg.append("⋮ ≫ Destino: " + viagem.getDestino()).append('\n');
                msg.append("⋮ ≫ Distancia: " + viagem.getKm()).append('\n');
                msg.append("════════════════════════════════════════════════════════").append('\n');
                msg.append('\n').append('\n');
            }

        }
        JOptionPane.showMessageDialog(
                null,
                msg
        );
    }
    static void verificarMissaoCumprida(){
        Scanner leitura = new Scanner(System.in);
        for (int i = 0; i < missoes.size(); i++){
            if (missoes.get(i).verificarCumprida(user)){
                JOptionPane.showMessageDialog(
                        null,
                        "EBA!! Missao \"" +missoes.get(i).getTitulo() + "\" concluida\nVoce ganhou " + missoes.get(i).getPontos() + " pontos"
                );
                System.out.println("EBA!! Missao \"" +missoes.get(i).getTitulo() + "\" concluida\nVoce ganhou " + missoes.get(i).getPontos() + " pontos");

            }
        }
    }


}
