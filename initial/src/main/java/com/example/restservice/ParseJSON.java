package com.example.restservice;


import java.io.*;
import java.nio.file.Path;
import java.util.Iterator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

class SomeClass
{

    @JsonProperty("directed")
    public boolean directed;
    public class graph {
        @JsonProperty("name")
        public java.lang.String name;
        @JsonProperty("version")
        public java.lang.Number version;
    }


    public class links {
    public    class attributes {
        @JsonValue
            int weight;
        }
        @JsonValue
        public String source;
        @JsonValue
        String target;
    }
}
@Service
public class ParseJSON
{
String p="C:\\Users\\DESKTOP\\gs-rest-service\\data.json";

    public ParseJSON() {
        // create Object Mapper
        ObjectMapper mapper = new ObjectMapper();

// read JSON file and map/convert to java POJO
        try {

            SomeClass someClassObject = mapper.readValue(new File(p), SomeClass.class);
            System.out.println(someClassObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Path file = ResourceUtils.getFile(p).toPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}