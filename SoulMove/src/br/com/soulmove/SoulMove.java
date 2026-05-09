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
        }
    }

    private static void cadastrarUsuario(){
        Scanner leitura = new Scanner(System.in);
        System.out.println("Insira o nome do usuário");
        String nome = leitura.next() + leitura.nextLine();

        Usuario user = new Usuario(nome);
        usuarios.add(user);

    }

    private static void verificarDados(){
        System.out.println(user.getNome() + " // Dados");
        System.out.println("\nPontos: " + user.getPontos());
        System.out.println("\nPassagems: " + user.getCreditos());


        System.out.println("\n///////dados mágicos das viagens\n");
        System.out.println("Viagens de Bicicleta: " + user.getViagensBicicleta());
        System.out.println("Viagens de Trem: " + user.getViagensTrem());
        System.out.println("Viagens de Bicicleta: " + user.getViagensMetro());
        System.out.println("Viagens de Bicicleta: " + user.getViagensOnibus());

        System.out.println("////// Dados mágicos dos quilometros\n");

        System.out.println("KMs de Bicicleta: " + user.getKmBicicleta());
        System.out.println("KMs de Trem: "      + user.getKmTrem());
        System.out.println("KMs de Bicicleta: " + user.getKmMetro());
        System.out.println("KMs de Bicicleta: " + user.getKmOnibus());
    }

    private static void calcularEmissao(){
        Scanner leitura = new Scanner(System.in);
        System.out.println("Insira o veiculo (sem acentos e minusculo)");
        String veiculo;
        veiculo = leitura.next() + leitura.nextLine();

        while (!isVeiculo(veiculo)){
            System.out.println("Veiculo Inválido!");
            System.out.println("Insira o veiculo (sem acentos e minusculo)");
            veiculo = leitura.nextLine();
        }

        System.out.println("Insira a quantidade de quilometros que iremos simular");
        double km = leitura.nextDouble();
        Veiculo v = getVeiculo(veiculo);
        System.out.println(v.calcularEmissao(km) + " quilos de carbono");
        leitura.next();

    }

    private static void verificarMissoes(){

        for (int i = 0; i < missoes.size(); i+=1){
            Missao missao = missoes.get(i);
            System.out.println(missao.getTitulo() + '\n');
            System.out.println(missao.getDesc());
            System.out.println("- - - - --- - - - -");
        }
        Scanner scan = new Scanner(System.in);
        scan.next();
    }

    private static void simularViagem(){

        Scanner leitura = new Scanner(System.in);
        System.out.println("Insira o veiculo (sem acentos e minusculo)");
        String veiculo;
        veiculo = leitura.next() + leitura.nextLine();

        while (!isVeiculo(veiculo)){
            System.out.println("Veiculo Inválido!");
            System.out.println("Insira o veiculo (sem acentos e minusculo)");
            veiculo = leitura.nextLine();
        }

        System.out.println("Insira a quantidade de quilometros que iremos simular");
        double km = leitura.nextDouble();
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