package mailaka.management.webService.validators;

import mailaka.management.webService.DAO.SliderImageDAO;

import java.util.ArrayList;
import java.util.List;

public class SliderImageValidator {
    public static List<String> validate(SliderImageDAO sliderImageDAO) {
        List<String> errors = new ArrayList<>();
        if (sliderImageDAO == null) {
            errors.add("l'image que vous passez est null");
        }
        return  errors;
    }
}
