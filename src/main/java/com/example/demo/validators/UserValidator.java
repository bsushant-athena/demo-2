package com.example.demo.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.entity.User;

@Component("beforeCreateUserValidator")
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        User user = (User) obj;
        if (checkInputString(user.getName())) {
            errors.rejectValue("name", "name.empty");
        }

        if (checkInputString(user.getEmail())) {
            errors.rejectValue("email", "email.empty");
        }
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
