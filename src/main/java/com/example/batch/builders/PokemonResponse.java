package com.example.batch.builders;

public class PokemonResponse {

    private String name;
    private String urlDetails;

    public PokemonResponse() {
    }

    public PokemonResponse(String name, String urlDetails) {
        this.name = name;
        this.urlDetails = urlDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlDetails() {
        return urlDetails;
    }

    public void setUrlDetails(String urlDetails) {
        this.urlDetails = urlDetails;
    }
}
