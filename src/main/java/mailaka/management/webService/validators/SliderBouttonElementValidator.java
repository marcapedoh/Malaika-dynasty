package mailaka.management.webService.validators;

import mailaka.management.webService.DAO.SliderButtonDAO;

import java.util.ArrayList;
import java.util.List;

public class SliderBouttonElementValidator {
    public static List<String> validate(SliderButtonDAO sliderBouttonElementDAO){
        List<String> errors= new ArrayList<>();
        if(sliderBouttonElementDAO==null){
            errors.add("le boutton doit pouvoir avoir un texte, veuillez fournir un texte s'il vous plait");
        }
        return errors;
    }
}
