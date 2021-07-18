package com.example.restservice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SomeClass {
    @JsonProperty("directed")
    public boolean directed;
    Graph graph;
    Links[] links;
}
