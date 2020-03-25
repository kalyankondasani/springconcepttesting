
package com.spring.testing.init.springconcepttesting.models;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CustomValidator {

    public void validateRequest(Greeting greeting) throws CustomException {
        if(StringUtils.isEmpty(greeting.getValue())) {
            throw new CustomException("Required Id is not found");
        }
    }
}
