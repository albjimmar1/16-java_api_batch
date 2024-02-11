package com.example.batch.services;

import com.example.batch.builders.MarvelCharacter;
import com.example.batch.builders.MarvelResponse;
import com.example.batch.builders.ResponseBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class APIConsumerService {

    final Logger log = LoggerFactory.getLogger(APIConsumerService.class);

    public ResponseBuilder consume(String url, int limit, int offset) {
        String urlMod = url + "&limit=" + limit + "&offset=" + offset;
        MarvelResponse response = consumeAPIMarvelGetForObject(urlMod);

        return new ResponseBuilder(response.getData().getResults(), HttpStatus.OK);
    }

    private MarvelResponse consumeAPIMarvelGetStream(String uri) {
        MarvelResponse marvelResponse = new MarvelResponse();

        try {
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            InputStream stream = conn.getInputStream();
            byte[] arrStream = stream.readAllBytes();

            StringBuilder ctnJSON = new StringBuilder();

            for (byte tmp : arrStream) {
                ctnJSON.append((char) tmp);
            }

            JSONObject json = new JSONObject(ctnJSON.toString());
            JSONObject jsonData = json.getJSONObject("data");
            JSONArray jsonResults = jsonData.getJSONArray("results");
            List<MarvelCharacter> characters = new ArrayList<>();

            for (int i = 0; i < jsonResults.length(); i++) {
                JSONObject jsonItem = jsonResults.getJSONObject(i);

                characters.add(new MarvelCharacter(
                        jsonItem.getInt("id"),
                        jsonItem.getString("name"),
                        jsonItem.getString("description"),
                        jsonItem.getString("resourceURI")));
            }
            MarvelResponse.Data dataMarvel = new MarvelResponse.Data();
            dataMarvel.setResults(characters);
            marvelResponse.setData(dataMarvel);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return marvelResponse;
    }

    private MarvelResponse consumeAPIMarvelGetScanner(String uri) {
        MarvelResponse marvelResponse = new MarvelResponse();

        try {
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("An error ocurred: " + responseCode);
            } else {
                StringBuilder stringInformation = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    stringInformation.append(scanner.nextLine());
                }

                scanner.close();

                JSONObject json = new JSONObject(stringInformation.toString());
                JSONObject jsonData = json.getJSONObject("data");
                JSONArray jsonResults = jsonData.getJSONArray("results");
                List<MarvelCharacter> characters = new ArrayList<>();

                for (int i = 0; i < jsonResults.length(); i++) {
                    JSONObject jsonItem = jsonResults.getJSONObject(i);

                    characters.add(new MarvelCharacter(
                            jsonItem.getInt("id"),
                            jsonItem.getString("name"),
                            jsonItem.getString("description"),
                            jsonItem.getString("resourceURI")));
                }
                MarvelResponse.Data dataMarvel = new MarvelResponse.Data();
                dataMarvel.setResults(characters);
                marvelResponse.setData(dataMarvel);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return marvelResponse;
    }

    private MarvelResponse consumeAPIMarvelGetForObject(String url) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, MarvelResponse.class);
    }
}
