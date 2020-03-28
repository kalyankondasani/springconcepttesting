package com.spring.testing.init.springconcepttesting.service;

import com.spring.testing.init.springconcepttesting.command.TestCommand;
import com.spring.testing.init.springconcepttesting.models.CustomException;
import com.spring.testing.init.springconcepttesting.models.CustomValidator;
import com.spring.testing.init.springconcepttesting.models.Greeting;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestServiceTest {

    private TestService testService;
    private CustomValidator customValidator;
    private TestService spyService;

    @Before
    public void setUp() {
        customValidator = Mockito.mock(CustomValidator.class);
        TestCommand testCommand = Mockito.mock(TestCommand.class);
        testService =  new TestService(testCommand, customValidator);
        spyService = Mockito.spy(testService);
    }

    @Test
    public void callServiceShouldReturnDefaultInCaseOfFault() throws CustomException, InterruptedException {

        Greeting greeting =  new Greeting();
        Mockito.doNothing().when(customValidator).validateRequest(greeting);
        String response = spyService.callService(greeting);

        Assertions.assertThat(response).isEqualTo("Kalyan");


    }
}