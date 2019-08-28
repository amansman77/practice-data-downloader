package com.ho.practice.downloader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.ho.practice.downloader.controller.DataController;
import com.ho.practice.downloader.repository.RawdataMongoDBRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(DataController.class)
public class DataControllerTest {
	
    @Autowired
    private MockMvc mvc;
	
    @Value("${data-path}")
	private String dataPath;
    
    @MockBean
	RawdataMongoDBRepository rawdataMongoDBRepository;
    
	@Test
    public void testCreateDataFile() throws Exception {
        //given
		Float cycle = 1.0f;
		Integer day = 1;
		
        //when
        final ResultActions actions = mvc.perform(post("/data/init")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("cycle", cycle.toString())
                .param("day", day.toString()))
                .andDo(print());
        
        //then
        actions
                .andExpect(status().isOk())
                .andExpect(content().string("success"))
                ;
        assertThat(new File(dataPath+"/data_" + cycle + "_" + day + ".csv").exists()).isEqualTo(true);
    }

}
