package com.ho.practice.downloader;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import com.ho.practice.downloader.controller.DataController;

@RunWith(SpringRunner.class)
@RestClientTest(DataController.class)
public class DataControllerTest {
	
	@Autowired
    private MockRestServiceServer server;
	
	private String dataApiUrl = "http://localhost:8080/data";
			
	@Test
    public void testGetFindOneFromRemote() throws Exception {
        server.expect(requestTo(dataApiUrl+"/file"))
        	.andExpect(method(HttpMethod.POST))
            .andRespond(withSuccess("success", MediaType.APPLICATION_JSON));
    }
	
}
