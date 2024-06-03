package mailaka.management.webService.validators;

import mailaka.management.webService.DAO.ServiceInfoDAO;

import java.util.ArrayList;
import java.util.List;

public class ServiceInfoValidator {
    public static List<String> validate(ServiceInfoDAO serviceInfoDAO){
        List<String> errors= new ArrayList<>();
        if(serviceInfoDAO==null){
            errors.add("vous passez un serviceInfo invalid");
        }
        return errors;
    }
}
