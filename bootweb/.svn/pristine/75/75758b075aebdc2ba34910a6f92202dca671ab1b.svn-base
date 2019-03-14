package com.boot.controller;


import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * 学生类controller
 * Created by zhoujh on 2018/06/11
 */
@SpringBootTest
public class GetStuCOntrollerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new StudentController()).build();
    }

    @Test
    public void getStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getStudent")).andDo(print());
    }

    @Test
    public void getStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/getStudents")).andDo(print());
    }

}
