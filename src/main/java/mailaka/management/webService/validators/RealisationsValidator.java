package mailaka.management.webService.validators;

import mailaka.management.webService.DAO.RealisationsDAO;

import java.util.ArrayList;
import java.util.List;

public class RealisationsValidator {
    public static List<String> validate(RealisationsDAO realisationsDAO){
        List<String> errors= new ArrayList<>();
        if(realisationsDAO==null){
            errors.add("la realisation que vous passez n'est pas valide");
        }
        return errors;
    }
}
