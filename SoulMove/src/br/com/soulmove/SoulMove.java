package br.com.soulmove;

import br.com.soulmove.missao.Missao;
import br.com.soulmove.missao.MissaoReducaoCarbono;
import br.com.soulmove.missao.MissaoViagensBicicleta;
import br.com.soulmove.missao.MissaoViagensColetivo;
import br.com.soulmove.usuario.Usuario;
import br.com.soulmove.veiculo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoulMove {

    private static Usuario user = new Usuario("Zeni");
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Missao> missoes = new ArrayList<>();

    public static void main(String[] args) {


        missoes.add(new MissaoViagensBicicleta(1));
        missoes.add(new MissaoViagensColetivo (1));
        missoes.add(new MissaoReducaoCarbono  (1));

        Scanner leitura = new Scanner(System.in);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n");
            System.out.println("""
                    ✮⋆˙ Escolha uma das opções abaixo:
                    
                        ⋮ ⌗ ┆ 1. Cadastrar usuário.
                        ⋮ ⌗ ┆ 2. Verificar Dados.
                        ⋮ ⌗ ┆ 3. Calcular emissão.
                        ⋮ ⌗ ┆ 4. Converter pontos.
                        ⋮ ⌗ ┆ 5. Verificar missões.
                        ⋮ ⌗ ┆ 6. Simular viajem.
                        ⋮ ⌗ ┆ 0. SAIR DO PROGRAMA.
                    """);

            System.out.print("Insira a opção: ");
            opcao = leitura.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\n" + "- - - Cadastrar usuário - - -" + "\n");
                    cadastrarUsuario();
                    break;
                case 2:
                    System.out.println("\n" + "- - - Verificar dados - - -" + "\n");
                    verificarDados();
                    break;

                case 3:
                    System.out.println("\n" + "- - - Calcular emissão - - -" + "\n");
                    calcularEmissao();
                    break;

                case 4:
                    System.out.println("\n" + "- - - Converter pontos - - -" + "\n");
                    converterPontos();
                    break;

                case 5:
                    System.out.println("\n" + "- - - Verificar missões - - -" + "\n");
                    verificarMissoes();
                    break;

                case 6:
                    System.out.println("\n" + "- - - Simular viajem - - -" + "\n");
                    simularViagem();
                    break;

                case 0:
                    System.out.println("\n" + "- - - Saindo do programa - - -" + "\n");
                    break;

                default:
                    System.out.println("\n" + "- - - Opção inválida - - - " + "\n");
                    break;
            }
            verificarMissaoCumprida();
        }
    }

    private static void cadastrarUsuario(){
        Scanner leitura = new Scanner(System.in);
        System.out.println("▸⋮ ⌞ Insira o nome do usuário: ⌝");
        String nome = leitura.next() + leitura.nextLine();

        Usuario user = new Usuario(nome);
        usuarios.add(user);

        System.out.println("\n" + "› Insira qualquer tecla para continuar: ");
        leitura.next();
    }

    private static void verificarDados(){
        Scanner leitura = new Scanner(System.in);

        System.out.println(user.getNome() + ": " + "⌞ Dados Gerais ⌝ ˎˊ˗");
        System.out.println("════════════════════════════");

        System.out.println("⋮ ≫ Pontos: " + user.getPontos());
        System.out.println("⋮ ≫ Passagems: " + user.getCreditos());

        System.out.println("\n");

        System.out.println(user.getNome() + ": " + "⌞ Dados de Viajem ⌝ ˎˊ˗");
        System.out.println("════════════════════════════");

        System.out.println("⋮ ≫ Viagens de Bicicleta: " + user.getViagensBicicleta());
        System.out.println("⋮ ≫ Viagens de Trem: " + user.getViagensTrem());
        System.out.println("⋮ ≫ Viagens de Bicicleta: " + user.getViagensMetro());
        System.out.println("⋮ ≫ Viagens de Bicicleta: " + user.getViagensOnibus());

        System.out.println("\n");
        System.out.println(user.getNome() + ": " + "⌞ Dados de Kilometragem ⌝ ˎˊ˗");
        System.out.println("════════════════════════════");

        System.out.println("⋮ ≫ KMs de Bicicleta: " + user.getKmBicicleta());
        System.out.println("⋮ ≫ KMs de Trem: "      + user.getKmTrem());
        System.out.println("⋮ ≫ KMs de Bicicleta: " + user.getKmMetro());
        System.out.println("⋮ ≫ KMs de Bicicleta: " + user.getKmOnibus());

        System.out.println("\n" + "› Insira qualquer tecla para continuar: ");
        leitura.next();
    }

    private static void calcularEmissao(){
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

    private static void converterPontos(){
        Scanner leitura = new Scanner(System.in);

        System.out.println("▸⋮ ⌞ Insira a quantidade de pontos que deseja converter em R$: ⌝");
        int pontosCon = leitura.nextInt();

        double conversao = pontosCon * 0.009;

        System.out.println("⋮ ≫ " + pontosCon + " pontos é igual a: R$" + String.format("%.2f", conversao));

        System.out.println("\n" + "› Insira qualquer tecla para continuar: ");
        leitura.next();
    }

    private static void verificarMissoes(){

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

    private static void verificarMissaoCumprida(){
        Scanner leitura = new Scanner(System.in);
        for (int i = 0; i < missoes.size(); i++){
            if (missoes.get(i).verificarCumprida(user)){
                System.out.println("EBA!! Missao \"" +missoes.get(i).getTitulo() + "\" concluida\nVoce ganhou " + missoes.get(i).getPontos() + " pontos");
                leitura.nextLine();

            }
        }
    }

    private static void simularViagem(){

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

        System.out.println("▸⋮ ⌞ Insira a quantidade de quilometros que iremos simular ⌝");

        double km = Double.parseDouble(leitura.nextLine());
        Veiculo v = getVeiculo(veiculo);
        switch (veiculo.toLowerCase()){
            case "carro" ->     {
                //user.addViagensCarro();
                //user.addKmCarro();

            }
            case "trem" ->      {
                user.addViagemTrem();
                user.addKmTrem(km);
            }
            case "metro" ->     {
                user.addViagemMetro();
                user.addKmMetro(km);
            }
            case "onibus" ->    {
                user.addViagemOnibus();
                user.addKmOnibus(km);
            }
            case "bicicleta" -> {
                user.addViagemBicicleta();
                user.addKmBicicleta(km);
            }
            case "moto" ->      {
                //user.addViagensMoto();
                //user.addKmMoto();
            }
        }


    }

    private static boolean isVeiculo(String veiculo){
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
    private static Veiculo getVeiculo(String v){
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
}