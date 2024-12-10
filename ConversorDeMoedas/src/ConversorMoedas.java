import org.json.APIConversao;

import java.util.Scanner;

public class ConversorMoedas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        APIConversao apiConversao = new APIConversao();

        // Exibir menu de opções de moedas
        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("Escolha entre as moedas disponíveis abaixo:");
        System.out.println("1 - USD (Dólar Americano)");
        System.out.println("2 - EUR (Euro)");
        System.out.println("3 - BRL (Real Brasileiro)");
        System.out.println("4 - ARS (Peso Argentino)");
        System.out.println("5 - BOB (Boliviano Boliviano)");
        System.out.println("6 - CLP (Peso Chileno)");

        // Seleção da moeda de origem
        System.out.print("Escolha o número correspondente à moeda de origem: ");
        int escolhaOrigem = scanner.nextInt();
        String moedaOrigem = obterCodigoMoeda(escolhaOrigem);
        if (moedaOrigem == null) {
            System.out.println("Escolha inválida para a moeda de origem.");
            return;
        }

        // Seleção da moeda de destino
        System.out.print("Escolha o número correspondente à moeda de destino: ");
        int escolhaDestino = scanner.nextInt();
        String moedaDestino = obterCodigoMoeda(escolhaDestino);
        if (moedaDestino == null) {
            System.out.println("Escolha inválida para a moeda de destino.");
            return;
        }

        // Solicitar o valor a ser convertido
        System.out.print("Digite a quantidade a ser convertida: ");
        double valor = scanner.nextDouble();

        // Realizar a conversão
        try {
            double valorConvertido = apiConversao.converterMoeda(valor, moedaOrigem, moedaDestino);
            System.out.printf("%.2f %s equivale a %.2f %s\n", valor, moedaOrigem, valorConvertido, moedaDestino);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    // Método auxiliar para obter o código da moeda com base na escolha do usuário
    private static String obterCodigoMoeda(int escolha) {
        return switch (escolha) {
            case 1 -> "USD"; // Dólar Americano
            case 2 -> "EUR"; // Euro
            case 3 -> "BRL"; // Real Brasileiro
            case 4 -> "ARS"; // Peso Argentino
            case 5 -> "BOB"; // Boliviano Boliviano
            case 6 -> "CLP"; // Peso Chileno
            default -> null;
        };
    }
}
