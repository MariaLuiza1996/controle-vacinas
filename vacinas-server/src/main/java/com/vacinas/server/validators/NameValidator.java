package com.vacinas.server.validators;

import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "nameValidator")
public class NameValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (Objects.isNull(value)) {
            return;
        }
        //Validation
//        if (value.toString().length() > 10) {
//            FacesMessage msg = new FacesMessage("O Nome não deve ter mais doque 10 caracteres!");
//            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//            throw new ValidatorException(msg);
//        }

    }

}
