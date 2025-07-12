package com.abay_api_bdd;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.spring.CucumberContextConfiguration;

@AutoConfigureMockMvc
@CucumberContextConfiguration
@SpringBootTest(classes = SpringBddApplication.class)
public class StepDefinitions {
    
}
