package com.spring.testing.init.springconcepttesting.contoller;

import com.spring.testing.init.springconcepttesting.models.CustomException;
import com.spring.testing.init.springconcepttesting.models.Greeting;
import com.spring.testing.init.springconcepttesting.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {
    private TestService testService;

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    public TestController(TestService testService) {

        this.testService = testService;
    }

    @GetMapping(value = "/testing")
    @ResponseBody
    public ResponseEntity<String> greeting(@RequestParam(value = "name", required = false) String name) throws CustomException, InterruptedException {
        Greeting greeting = new Greeting();
        greeting.setValue(name);

        logger.info("request came to controller");
        String response = testService.callService(greeting);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
