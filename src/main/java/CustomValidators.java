import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CustomValidators {
    public void validateEmailUniqueness(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String email = (String) value;

        User user = new User();
        ArrayList<User> usersList = user.usersList();

        for (User u : usersList) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                throw new ValidatorException(new FacesMessage("Email already exists"));
            }
        }
    }

    public void validateNameNotStartingWithDigit(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String name = (String) value;
        if (name != null && !name.isEmpty()) {
            char firstChar = name.charAt(0);
            if (Character.isDigit(firstChar)) {
                throw new ValidatorException(new FacesMessage("Name cannot start with a digit"));
            }
        }
    }
}
