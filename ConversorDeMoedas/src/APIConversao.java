package org.json;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class APIConversao {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/783fd8e1e9d4936813e8a4c9/latest/USD"; // Insira sua chave de API no lugar correto
    private HttpClient client;

    public APIConversao() {
        client = HttpClient.newHttpClient();
    }

    public double converterMoeda(double valor, String moedaOrigem, String moedaDestino) throws Exception {
        // Fazer a requisição HTTP para obter a resposta JSON
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parsear a resposta JSON
        JSONObject jsonResponse = new JSONObject(response.body());
        JSONObject conversionRates = jsonResponse.getJSONObject("conversion_rates");

        // Verificar se as moedas existem
        if (!conversionRates.has(moedaOrigem) || !conversionRates.has(moedaDestino)) {
            throw new Exception("Moeda não encontrada.");
        }

        // Obter as taxas de conversão
        double taxaOrigem = conversionRates.getDouble(moedaOrigem);
        double taxaDestino = conversionRates.getDouble(moedaDestino);

        // Realizar a conversão
        return (valor / taxaOrigem) * taxaDestino;
    }
}
