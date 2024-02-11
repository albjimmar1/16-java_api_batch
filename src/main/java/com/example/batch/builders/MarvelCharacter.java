package com.example.batch.builders;

public class MarvelCharacter {
    private int id;
    private String name;
    private String description;
    private String resourceURI;

    public MarvelCharacter() {
    }

    public MarvelCharacter(int id, String name, String description, String resourceURI) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.resourceURI = resourceURI;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
