package com.fuzaro.validator;

import com.fuzaro.dto.request.UserInformation;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static java.util.Objects.isNull;


public class UserValidator {

    public static void validCreateUser(UserInformation userInformation) {
        if (isNull(userInformation.getName()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name is a mandatory information");

        if (isNull(userInformation.getEmail()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is a mandatory information");

        if (isNull(userInformation.getBirthDate()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Birth date is a mandatory information");
    }

}
