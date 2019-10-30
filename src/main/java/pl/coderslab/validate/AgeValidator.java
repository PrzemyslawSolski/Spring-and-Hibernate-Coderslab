package pl.coderslab.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

    private int legalAge;
    @Override
    public void initialize(Age constraintAnnotation) {
        this.legalAge = constraintAnnotation.min();

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null){
            return false;
        }
        return LocalDate.now().getYear() - value >= legalAge;
    }
}
