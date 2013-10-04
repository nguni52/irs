package com.irs.user;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import org.springframework.stereotype.Component;

/**
 *
 * @author Kenneth.Maposa
 */
@Component("UserValidator")
public class UserValidator {

    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        User user = (User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required.username");
        String username = user.getUsername();
        if ((username.length()) > 50) {
            errors.rejectValue("username", "lengthOfUser.user.username");
        }
        /*if (!(user.getPassword()).equals(user.getConfirmPassword())) {
            errors.rejectValue("password",
                    "matchingPassword.user.password");
        }*/
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password");
        /*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeID", "required.employeeID");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "required.lastName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telephone", "required.telephone");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobTitle", "required.jobTitle");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "required.role");*/
    }
}