package com.example.sample_serverside_kotlin_db.demo_db.controllers

import com.example.sample_serverside_kotlin_db.demo_db.MainController
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest
class ControllerTests {
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var target: MainController

    @Before
    fun setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(target).build()
    }

    @Test
    fun getAllUsersTest() {
        mockMvc.perform(get("/all"))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    }

    @Test
    fun addNewUserTest() {
        mockMvc.perform(post("/add").param("name", "unit_test"))
                .andExpect(status().isOk)
                .andExpect(content().string("Saved"))
    }
}