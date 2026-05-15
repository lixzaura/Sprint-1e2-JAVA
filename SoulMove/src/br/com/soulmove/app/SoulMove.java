package br.com.soulmove.app;

import br.com.soulmove.missao.Missao;
import br.com.soulmove.missao.MissaoReducaoCarbono;
import br.com.soulmove.missao.MissaoViagensBicicleta;
import br.com.soulmove.missao.MissaoViagensColetivo;
import br.com.soulmove.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoulMove {

    static Usuario user = new Usuario("Zeni");
    private static List<Usuario> usuarios = new ArrayList<>();
    static List<Missao> missoes = new ArrayList<>();

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
                        ⋮ ⌗ ┆ 7. Ver histórico.
                        ⋮ ⌗ ┆ 0. SAIR DO PROGRAMA.
                    """);

            System.out.print("Insira a opção: ");
            opcao = leitura.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\n" + "- - - Cadastrar usuário - - -" + "\n");
                    Menu.cadastrarUsuario();
                    break;
                case 2:
                    System.out.println("\n" + "- - - Verificar dados - - -" + "\n");
                    Menu.verificarDados();
                    break;

                case 3:
                    System.out.println("\n" + "- - - Calcular emissão - - -" + "\n");
                    Menu.calcularEmissao();
                    break;

                case 4:
                    System.out.println("\n" + "- - - Converter pontos - - -" + "\n");
                    Menu.converterPontos();
                    break;

                case 5:
                    System.out.println("\n" + "- - - Verificar missões - - -" + "\n");
                    Menu.verificarMissoes();
                    break;

                case 6:
                    System.out.println("\n" + "- - - Simular viajem - - -" + "\n");
                    Menu.simularViagem();
                    break;

                case 7:
                    System.out.println("\n" + "- - - Ver histórico - - -" + "\n");
                    verHistorico();
                    break;

                case 0:
                    System.out.println("\n" + "- - - Saindo do programa - - -" + "\n");
                    break;

                default:
                    System.out.println("\n" + "- - - Opção inválida - - - " + "\n");
                    break;
            }
            Menu.verificarMissaoCumprida();
        }
    }



    private static void verHistorico(){

    }




}