package mailaka.management.webService.validators;

import mailaka.management.webService.DAO.WhoWeAreDAO;

import java.util.ArrayList;
import java.util.List;

public class WhoWeAreValidator {
    public static List<String> validate(WhoWeAreDAO whoWeAreDAO){
        List<String> errors= new ArrayList<>();
        if(whoWeAreDAO==null){
            errors.add("le parametre que vous fournissez est vite");
        }
        return  errors;
    }
}
