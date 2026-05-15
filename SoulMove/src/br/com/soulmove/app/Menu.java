package br.com.soulmove.app;

import br.com.soulmove.missao.Missao;
import br.com.soulmove.usuario.Usuario;
import br.com.soulmove.veiculo.*;
import br.com.soulmove.viagem.Viagem;

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
        Scanner leitura = new Scanner(System.in);

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

        System.out.println("\n" + "› Insira qualquer tecla para continuar: ");
        leitura.next();
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

        for (int i = 0; i < missoes.size(); i+=1){
            Missao missao = missoes.get(i);
            System.out.println("⌞ " + missao.getTitulo() + " ★ ⌝");
            System.out.println("⋮ ≫ " + missao.getDesc());
            System.out.println("════════════════════════════════════════════════════════");
            System.out.println("\n");
        }
        Scanner leitura = new Scanner(System.in);
        System.out.println("\n" + "› Insira qualquer tecla para continuar: ");
        leitura.next();
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
    static void verificarMissaoCumprida(){
        Scanner leitura = new Scanner(System.in);
        for (int i = 0; i < missoes.size(); i++){
            if (missoes.get(i).verificarCumprida(user)){
                System.out.println("EBA!! Missao \"" +missoes.get(i).getTitulo() + "\" concluida\nVoce ganhou " + missoes.get(i).getPontos() + " pontos");
                leitura.nextLine();

            }
        }
    }
}
