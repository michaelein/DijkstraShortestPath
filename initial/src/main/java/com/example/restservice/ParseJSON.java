package com.example.restservice;


import java.io.*;
import java.nio.file.Path;
import java.util.Iterator;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;


import org.json.simple.parser.*;

/*
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
}*/
@Service
public class ParseJSON
{
String p="C:\\Users\\DESKTOP\\gs-rest-service\\data.json";//new File(p)

    public ParseJSON() {
        // parsing file "JSONExample.json"
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader( p));
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        // getting phoneNumbers
        JSONArray ja = (JSONArray) jo.get("links");
        // iterating phoneNumbers
        // getting phoneNumbers
       // JSONArray ja = (JSONArray) jo.get("phoneNumbers");

        // iterating phoneNumbers
        Iterator itr2 = ja.iterator();

        while (itr2.hasNext())
        {
            Iterator itr1 = ((Map) itr2.next()).entrySet().iterator();
            while (itr1.hasNext()) {
               // Map.Entry pair = itr1.next();
                System.out.println( itr1.next());
            }
        }



    }
}