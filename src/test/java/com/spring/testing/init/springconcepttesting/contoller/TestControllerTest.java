package com.spring.testing.init.springconcepttesting.contoller;

import com.spring.testing.init.springconcepttesting.contoller.TestController;
import com.spring.testing.init.springconcepttesting.models.CustomException;
import com.spring.testing.init.springconcepttesting.models.CustomValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class TestControllerTest {

    @Autowired
    TestController testController;

    @MockBean
    CustomValidator customValidator;

    @MockBean
    RestTemplate restTemplate;

    @Test
    public void testGreeting() throws CustomException, InterruptedException {
        Mockito.doNothing().when(customValidator).validateRequest(Mockito.any());
        Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.any(), Mockito.eq(String.class)))
                .thenReturn(new ResponseEntity<>("Kalyan", HttpStatus.OK));

        ResponseEntity<String> response = testController.greeting("");
        Assertions.assertThat(response.getBody()).isEqualTo("Kalyan");
    }
}