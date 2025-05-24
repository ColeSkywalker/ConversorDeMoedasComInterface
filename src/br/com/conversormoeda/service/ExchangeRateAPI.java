package br.com.conversormoeda.service;
import br.com.conversormoeda.model.Moeda;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateAPI {
    private String moedaBase = "";
    private String moedaFinal = "";
    private double valor;

    public void configurarMoedasDeConversao(String moedaBase, String moedaFinal){
        this.moedaBase = moedaBase;
        this.moedaFinal = moedaFinal;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public String realizarConversao() throws IOException, InterruptedException {
        String apiKey = "766f12303378d9faf1a6507b";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/"+ apiKey +"/pair/"+ moedaBase +"/" + moedaFinal))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();
        Moeda moeda = gson.fromJson(json, Moeda.class);
        moeda.setValorConvertido(valor);
        double convertido = moeda.getValorConvertido();
        if (convertido < 0.01) {
            return String.format("%.6f %s é o equivalente a %.6f %s", valor, moedaBase, convertido, moedaFinal);
        } else {
            return String.format("%.2f %s é o equivalente a %.2f %s", valor, moedaBase, convertido, moedaFinal);
        }
    }
}
