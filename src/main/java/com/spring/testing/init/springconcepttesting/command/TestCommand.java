package com.spring.testing.init.springconcepttesting.command;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TestCommand {
    private RestTemplate restTemplate;

    @Autowired
    public TestCommand(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    Logger logger = LoggerFactory.getLogger(TestCommand.class);

    public String execute() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(headers);
        logger.info("request going out from command");
        ResponseEntity<String> response = restTemplate.exchange("https://httpstat.us/200", HttpMethod.GET, httpEntity, String.class);
        return response.getBody();
    }
}
