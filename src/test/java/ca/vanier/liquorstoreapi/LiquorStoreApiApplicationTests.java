package ca.vanier.liquorstoreapi;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.json.JSONObject;

@SpringBootTest
@AutoConfigureMockMvc
class LiquorStoreApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext) {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    // THIS TEST DOES A GET REQUEST AND CHECKS STATUS AND RETURNED CONTENT TYPE
    @Test
    void testAllCustomers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customers/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    // THIS TEST DOES A GET REQUEST AND CHECKS STATUS AND RETURNED CONTENT TYPE
    @Test
    void testFindCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customers/find?id=1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    // THIS TEST DOES A POST REQUEST AND CHECKS STATUS
    @Test
    void testSaveCustomer() throws Exception {
        JSONObject requestJson = new JSONObject();
        requestJson.put("name", "Test");
        requestJson.put("lastname", "Bot");
        requestJson.put("age", "99");
        requestJson.put("email", "testbot@gmail.com");
        requestJson.put("address", "123 Rue Test");
        mockMvc.perform(MockMvcRequestBuilders.post("/customers/save")
                        .content(String.valueOf(requestJson))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    // THIS TEST DOES A PUT REQUEST AND CHECKS STATUS
    @Test
    void testUpdateCustomer() throws Exception {
        JSONObject requestJson = new JSONObject();
        // PLEASE CHANGE ID TO TEST PROPERLY
        requestJson.put("id", "152");
        requestJson.put("name", "REAL Test");
        requestJson.put("lastname", "Bot");
        requestJson.put("age", "99");
        requestJson.put("email", "testbot@gmail.com");
        requestJson.put("address", "123 Rue Test");
        mockMvc.perform(MockMvcRequestBuilders.put("/customers/update")
                        .content(String.valueOf(requestJson))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    // THIS TEST DOES A DELETE REQUEST AND CHECKS STATUS
    @Test
    void testDeleteCustomer() throws Exception {
        //PLEASE CHANGE ID TO TEST PROPERLY
        mockMvc.perform(MockMvcRequestBuilders.delete("/customers/remove?id=152"))
                .andExpect(status().isOk());
    }

}
