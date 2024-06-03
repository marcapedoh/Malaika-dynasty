package mailaka.management.webService.services;

import mailaka.management.webService.DAO.OurServiceComponentDAO;
import mailaka.management.webService.models.OurServiceComponent;

import java.util.List;

public interface OurServiceService {
    OurServiceComponentDAO save(OurServiceComponentDAO ourServiceComponentDAO);
    OurServiceComponentDAO findById(Integer id);
    List<OurServiceComponentDAO> findAll();
}
