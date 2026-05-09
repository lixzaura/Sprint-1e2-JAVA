import java.util.Scanner;

void main() {

    Scanner leitura = new Scanner(System.in);

    int escolha = 0;

    while (escolha != 0) {
        System.out.println("""
                             Escolha uma das opções abaixo
                                1. Cadastrar Usuário.
                                2. Calcular emissão.
                                3. Converter pontos.
                                0. Sair do programa.
                                """);

        escolha = leitura.nextInt();

    }
}
