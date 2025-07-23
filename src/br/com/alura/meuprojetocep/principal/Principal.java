package br.com.alura.meuprojetocep.principal;

import br.com.alura.meuprojetocep.modelos.CEPGeral;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {




            List<CEPGeral> listaDeCEPs = new ArrayList<>();
            Gson gson = new Gson();
            HttpClient client = HttpClient.newHttpClient();

            BufferedReader leitor = new BufferedReader(new FileReader("ceps.csv"));
            String linha;

            while ((linha = leitor.readLine()) != null) {
                String cep = linha.trim();

                if (cep.isEmpty()) continue;


                System.out.println("Buscando CEP: " + cep);
                String buscaCEP = "https://viacep.com.br/ws/" + cep + "/json/";


                    HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(buscaCEP))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();


            CEPGeral meuCEP = gson.fromJson(json, CEPGeral.class);


            listaDeCEPs.add(meuCEP);
            meuCEP.exibeCEPGeral();
            System.out.println("--------------");

        }

        FileWriter escrita = new FileWriter("CEP.txt");
        for (CEPGeral cep : listaDeCEPs) {
            escrita.write(cep.toString() + "\n");
        }
        escrita.close();

        System.out.println("Programa Encerrado");

    }
}
