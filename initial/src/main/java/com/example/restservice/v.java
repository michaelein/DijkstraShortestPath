package com.example.restservice;

import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
/*
class Car {

    private String color;
    private String type;

    // standard getters setters
}
class CustomCarDeserializer extends StdDeserializer<Car> {

    public CustomCarDeserializer() {
        this(null);
    }

    public CustomCarDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Car deserialize(JsonParser parser, DeserializationContext deserializer) {
        Car car = new Car();
        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);

        // try catch block
        JsonNode colorNode = node.get("color");
        String color = colorNode.asText();
        car.setColor(color);
        return car;
    }
}*/