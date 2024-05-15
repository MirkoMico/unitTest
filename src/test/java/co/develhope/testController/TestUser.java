package co.develhope.testController;
import co.develhope.testController.controller.HomeController;
import co.develhope.testController.controller.UserController;
import co.develhope.testController.entities.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles(value = "test")
public class TestUser {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserController userController;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void userControllerLoads() {
        assertThat(userController).isNotNull();
    }
    @Test
    public void getAll() throws Exception {
        this.mockMvc.perform(get("/users")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getSingle() throws Exception {
        this.mockMvc.perform(get("/users/1")).andDo(print()).andExpect(status().isOk());
    }

    public User createUser (){

        return User.builder()
                .id(1L)
                .name("Mirko")
                .surname("Bianchi")
                .age(21)
                .isActive(true)
                .build();
    }

    @Test
    public void create() throws Exception {


            this.mockMvc.perform(MockMvcRequestBuilders.post("/users/new")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(createUser())))
                    .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void update() throws Exception {
        this.mockMvc.perform(put("/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createUser())))

                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteAll() throws Exception {
        this.mockMvc.perform(delete(("/users/1"))).andDo(print()).andExpect(status().isOk());
    }




}
