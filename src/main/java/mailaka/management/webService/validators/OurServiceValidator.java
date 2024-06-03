package mailaka.management.webService.validators;

import mailaka.management.webService.DAO.OurServiceComponentDAO;
import mailaka.management.webService.models.OurServiceComponent;

import java.util.ArrayList;
import java.util.List;

public class OurServiceValidator {

    public static List<String> validate(OurServiceComponentDAO ourServiceComponentDAO){
        List<String> errors= new ArrayList<>();
        if(ourServiceComponentDAO==null){
            errors.add("vous passez un objet vide");
        }
        return errors;
    }
}
