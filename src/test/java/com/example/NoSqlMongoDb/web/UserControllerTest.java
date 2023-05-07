package com.example.NoSqlMongoDb.web;

import com.example.NoSqlMongoDb.domain.documents.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void setup() {
        mongoTemplate.getDb().drop();
        User user1 = User.builder().id(1L).firstName("John").lastName("Doe").email("john.doe@example.com").age(25).isMarried(true).build();
        User user2 = User.builder().id(2L).firstName("Jane").lastName("Doe").email("jane.doe@example.com").age(30).isMarried(false).build();
        mongoTemplate.save(user1);
        mongoTemplate.save(user2);
    }
    @Test
    public void getAllUsersTest() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[1].firstName").value("Jane"));
    }

    @Test
    public void getUserByIdTest() throws Exception {
        mockMvc.perform(get("/user/getById/1"))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void getUserByFirstNameTest() throws Exception {
        mockMvc.perform(get("/user/getByFirstName/John"))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$[0].firstName").value("John"));
    }

    @Test
    public void getUserByLastNameTest() throws Exception {
        mockMvc.perform(get("/user/getByLastName/Doe"))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$[0].lastName").value("Doe"));
    }

    @Test
    public void getByAgeGreaterThanTest() throws Exception {
        mockMvc.perform(get("/user/getByAgeGreaterThan/27"))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$[0].age").value(30));
    }

    @Test
    public void getUserByEmailTest() throws Exception {
        mockMvc.perform(get("/user/getByEmail/jane.doe@example.com"))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$.email").value("jane.doe@example.com"));
    }

    @Test
    public void getUserByIsMarriedTest() throws Exception {
        mockMvc.perform(get("/user/getByIsMarried/true"))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$[0].isMarried").value("true"));
    }

    @Test
    public void createUserTest() throws Exception {
        User user = User.builder().id(3L).firstName("Johns").lastName("Doe").email("johns.doe@example.com").age(24).isMarried(true).build();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonUser = objectMapper.writeValueAsString(user);

        mockMvc.perform(post("/users/create")
                .content(jsonUser)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value(user.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(user.getLastName()))
                .andExpect(jsonPath("$.email").value(user.getEmail()))
                .andExpect(jsonPath("$.age").value(user.getAge()))
                .andExpect(jsonPath("$.isMarried").value(user.getIsMarried()));
    }

    @Test
    public void deleteUserTest() throws Exception {
        mockMvc.perform(delete("/user/1"))
                .andExpect(status().isOk());

        assertNull(mongoTemplate.findById(1L,User.class));
    }

}
