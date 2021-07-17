package com.example.restservice;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;
@SpringBootTest
class michaelTest {

    @Autowired
    private GreetingController controller;

    @Test
    public void contextLoads() {
    }
    @Test
    public void contextLoads2() {
    }
    @Test
    public void contextLoads3() {
        assertThat(controller).isNull();
    }
}
