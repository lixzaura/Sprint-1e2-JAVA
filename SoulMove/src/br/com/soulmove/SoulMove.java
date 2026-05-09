package br.com.soulmove;

import br.com.soulmove.usuario.Usuario;

import java.util.Scanner;

public class SoulMove {

    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("""
                    ✮⋆˙ Escolha uma das opções abaixo:
                    
                        ⋮ ⌗ ┆ 1. Cadastrar usuário.
                        ⋮ ⌗ ┆ 2. Calcular emissão.
                        ⋮ ⌗ ┆ 3. Converter pontos.
                        ⋮ ⌗ ┆ 4. Verificar missões.
                        ⋮ ⌗ ┆ 5. Simular viajem.
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
                    System.out.println("\n" + "- - - Calcular emissão - - -" + "\n");
                    break;

                case 3:
                    System.out.println("\n" + "- - - Converter pontos - - -" + "\n");
                    break;

                case 4:
                    System.out.println("\n" + "- - - Verificar missões - - -" + "\n");
                    break;

                case 5:
                    System.out.println("\n" + "- - - Simular viajem - - -" + "\n");
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

    }

    private static void calcularEmissao(){
        System.out.println("Insira o veiculo (sem acentos e minusculo)");
        do {

        }
    }

    private static boolean isVeiculo(String veiculo){
        switch (veiculo.toLowerCase()){
            case "carro" ->     {return true;}
            case "trem" ->      {return true;}
            case "metro" ->     {return true;}
            case "onibus" ->    {return true;}
            case "bicicleta" -> {return true;}
            case "moto" ->     {return true;}
        }

        return false;
    }
}