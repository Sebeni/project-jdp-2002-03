package com.kodilla.ecommercee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
<<<<<<< HEAD
import com.kodilla.ecommercee.domain.ProductGroup;
=======
import com.kodilla.ecommercee.domain.Group;
>>>>>>> 872dd384919b52a37396d0af9a90b6ffddac7101
import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.util.NestedServletException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class GroupControllerTest {
    private final static String controllerPath = "/v1/groups";
<<<<<<< HEAD
    private ProductGroup clothes;
    private ProductGroup jewelry;
    private ProductGroup shoes;
=======
    private Group clothes;
    private Group jewelry;
    private Group shoes;
>>>>>>> 872dd384919b52a37396d0af9a90b6ffddac7101

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private MockMvc mvc;

    @Before
    public void setUp() {
<<<<<<< HEAD
        clothes = groupRepository.save(new ProductGroup("Ubrania"));
        jewelry = groupRepository.save(new ProductGroup("Biżuteria"));
        shoes = groupRepository.save(new ProductGroup("Obuwie"));
=======
        clothes = groupRepository.save(new Group("Ubrania"));
        jewelry = groupRepository.save(new Group("Biżuteria"));
        shoes = groupRepository.save(new Group("Obuwie"));
>>>>>>> 872dd384919b52a37396d0af9a90b6ffddac7101
    }

    @After
    public void tearDown() {
        groupRepository.deleteAll();
    }

    @Test
    public void shouldReturnAllGroups() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get(controllerPath + "/getAllGroups"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(clothes.getName())))
                .andExpect(content().string(containsString(jewelry.getName())))
                .andExpect(content().string(containsString(shoes.getName())));
    }

    @Test
    public void shouldReturnNewGroupAndIncreaseRepository() throws Exception {
        String nameOfGroupToAdd = "Szaliki";

        mvc.perform(MockMvcRequestBuilders
                .post(controllerPath + "/addGroup")
                .param("name", nameOfGroupToAdd))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(nameOfGroupToAdd));

        long groupsInRepository = groupRepository.count();
        Assert.assertEquals(4, groupsInRepository);
    }

    @Test
    public void shouldReturnClothes() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get(controllerPath + "/getGroupById")
                .param("id", clothes.getId().toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(clothes.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(clothes.getName()));
    }

    @Test(expected = NestedServletException.class)
    public void shouldThrowErrorWhenNonExistentIdGet() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get(controllerPath + "/getGroupById")
                .param("id", "-1"))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }


    @Test
    public void shouldUpdateClothesName() throws Exception {
        GroupDto updatedGroup = new GroupDto(clothes.getId(), "Changed name");

        mvc.perform(MockMvcRequestBuilders
                .put(controllerPath + "/updateGroup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(updatedGroup)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(clothes.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Changed name"));

    }

    @Test(expected = NestedServletException.class)
    public void shouldThrowErrorWhenNonExistentIdUpdate() throws Exception {
        GroupDto updatedGroup = new GroupDto(-1L, "Changed name");

        mvc.perform(MockMvcRequestBuilders
                .put(controllerPath + "/updateGroup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(updatedGroup)))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }
}