package main;

import br.com.conversormoeda.service.ExchangeRateAPI;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
    int escolha = 0;
    double valor = 0;
    Scanner scanner = new Scanner(System.in);
    // menu inicial
    String menu = """
            1) Dólar => Peso Argentino
            2) Peso argentino => Dólar
            3) Dólar => Real Brasileiro
            4) Real brasileiro => Dólar
            5) Dólar => Peso colombiano
            6) Peso colombiano => Dólar
            7) Dólar => Peso chileno
            8) Peso chileno => Dólar
            9) Dólar => Boliviano
            10) Boliviano => Dólar
            11) Sair
            Escolha uma opção válida:
            """;
    // opções de moedas
    String[][] opcoes = {
                {"USD", "ARS"},  // 1
                {"ARS", "USD"},  // 2
                {"USD", "BRL"},  // 3
                {"BRL", "USD"},  // 4
                {"USD", "COP"},  // 5
                {"COP", "USD"},  // 6
                {"USD", "CLP"},  // 7
                {"CLP", "USD"},  // 8
                {"USD", "BOB"},  // 9
                {"BOB", "USD"}   // 10
    };

    ExchangeRateAPI exchangeRateAPI = new ExchangeRateAPI();
    // Mensagem inicial
    System.out.println("Seja bem-vindo ao conversor de moedas!");
    do{
        escolha = validarEntradaInt (scanner, menu); // Verifica se a entrada é válida

        if (escolha >= 1 && escolha <= 10) {
            valor = validarEntradaDouble(scanner, "Digite o valor a ser convertido: "); // Verifica se a entrada é válida
            String[] moedas = opcoes[escolha - 1];
            exchangeRateAPI.configurarMoedasDeConversao(moedas[0], moedas[1]);
            exchangeRateAPI.setValor(valor);
            exchangeRateAPI.realizarConversao();
        } else if (escolha == 11) {
            System.out.println("Saindo...");
        } else {
            System.out.println("Opção inválida");
        }

    }while(escolha != 11);
    }

    public static int validarEntradaInt (Scanner scanner, String mensagem) {
        int num;
        while (true) {
            System.out.print(mensagem);
            try {
                num = scanner.nextInt();
                scanner.nextLine();
                return num;
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número.");
                scanner.nextLine();
            }
        }
    }

    public static double validarEntradaDouble(Scanner scanner, String mensagem) {
        double num;
        while (true) {
            System.out.print(mensagem);
            try {
                num = scanner.nextDouble();
                scanner.nextLine();
                return num;
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número decimal válido.");
                scanner.nextLine();
            }
        }
    }
}