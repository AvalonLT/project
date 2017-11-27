package lt.jonas.project.util;


import lt.jonas.project.model.User1;
import lt.jonas.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidation implements Validator {
    @Autowired
    UserService userService;
    @Override
    public boolean supports(Class<?> aClass) {
        return User1.class.equals(aClass);
    }

    @Override
    public void validate(Object ourUser, Errors errors) {
        User1 user1 = (User1) ourUser;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "EmptySpace.username");

        if(userService.findByUsername(user1.getUsername())!=null) {//if user1 exists
            errors.rejectValue("username", "Warining.dublicate.username");
        }

        if((user1.getUsername().length()) < 6 || (user1.getUsername().length() > 32)) {
            errors.rejectValue("username", "Size.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "EmptySpace.password");

        if((user1.getPassword().length()) < 6 || (user1.getPassword().length() > 32)) {
            errors.rejectValue("password", "Size.password");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordconfirm", "EmptySpace.password");

        if(!user1.getPassword().equals(user1.getPasswordconfirm())) {
            errors.rejectValue("passwordconfirm", "Different.passwordConfirm");
        }
    }
}
