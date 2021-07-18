package com.example.restservice;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;

class Attributes {
    @JsonProperty("weight")
    double weight;
}
class Links {
    Attributes attributes;
    @JsonProperty("source")
    public String source;
    @JsonProperty("target")
    String target;
}
class Graph {
    @JsonProperty("name")
    public java.lang.String name;
    @JsonProperty("version")
    public java.lang.Number version;
}

class Employee implements Serializable
{
    private String           firstName;
    private String           lastName;
    private transient String confidentialInfo;

    //Setters and Getters
}

@Service
public class ParseJSON
{
    public String asString(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
    public SomeClass empObject ;
    public ParseJSON()
    {
        String jsonString_ = "{'id':1001, 'firstName':'Lokesh', 'lastName':'Gupta', 'email':'howtodoinjava@gmail.com'}";
        Gson gson = new Gson();
        Employee empObject_ = gson.fromJson(jsonString_, Employee.class);

        String msg;

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("data.json");
        String jsonString=asString(resource);
        this.empObject = gson.fromJson(jsonString, SomeClass.class);
       // System.out.println(empObject.links);
    }

    public SomeClass GetSome()
    {
        return this.empObject;
    }
}