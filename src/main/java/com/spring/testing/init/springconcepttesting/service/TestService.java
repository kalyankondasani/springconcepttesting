package com.spring.testing.init.springconcepttesting.service;

import com.spring.testing.init.springconcepttesting.command.TestCommand;
import com.spring.testing.init.springconcepttesting.contoller.TestController;
import com.spring.testing.init.springconcepttesting.models.CustomException;
import com.spring.testing.init.springconcepttesting.models.CustomValidator;
import com.spring.testing.init.springconcepttesting.models.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private CustomValidator customValidator;
    private TestCommand testCommand;
    Logger logger = LoggerFactory.getLogger(TestController.class);
    public TestService(TestCommand testCommand, CustomValidator customValidator) {
        this.testCommand = testCommand;
        this.customValidator = customValidator;
    }

    public String callService(Greeting greeting) throws InterruptedException, CustomException {
        logger.info("service level log");

        customValidator.validateRequest(greeting);

        Boolean result = manipulateGreetingModel(greeting);
        String response = null;
        if(result) {

            response = testCommand.execute();

        }

        Thread.sleep(5000);
        return response == null ? "Default": response;
    }

    public Boolean manipulateGreetingModel(Greeting greeting) {
        if(greeting.getValue().equalsIgnoreCase("Kalyan")) {
            return true;
        }

        return false;
    }
}
