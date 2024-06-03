package mailaka.management.webService.validators;

import mailaka.management.webService.DAO.HeaderDAO;

import java.util.ArrayList;
import java.util.List;

public class HeaderValidator {
    public static List<String> validate(HeaderDAO headerDAO){
        List<String> errors= new ArrayList<>();
        if(headerDAO==null){
            errors.add("l'objet que vous passez est vite");
        }
        return  errors;
    }
}
