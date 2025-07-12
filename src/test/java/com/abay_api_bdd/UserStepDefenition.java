package com.abay_api_bdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

@ContextConfiguration(classes = SpringBddApplication.class)
@AutoConfigureMockMvc
public class UserStepDefenition extends StepDefinitions{
    
    @Autowired
    private MockMvc mvc;

    ResultActions action;

    @Given("I make the call {string}")
    public void i_make_the_call(String endpoint) {
        // Usa endpoint normalmente, por exemplo:
        System.out.println("Calling: " + endpoint);
    }

    @Then("I create a new user with the name 'Carlos', username 'carlos123', email 'carlos123@gmail.com' and password 'test1234'")
    public void i_create_a_new_user() throws Exception {
        String userJson = "{"
            + "\"name\": \"Carlos\","
            + "\"username\": \"carlos123\","
            + "\"email\": \"carlos123@gmail.com\","
            + "\"password\": \"test1234\""
            + "}";

        action = mvc.perform(post("/api/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(userJson));
    }

    @And("the user 'carlos123' should be created successfully")
    public void the_user_should_be_created_successfully() throws Exception {
        action.andExpect(status().isCreated()) 
              .andExpect(jsonPath("$.username").value("carlos123"));
    }
    


}
