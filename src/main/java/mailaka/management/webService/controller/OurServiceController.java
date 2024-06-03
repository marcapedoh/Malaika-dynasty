package mailaka.management.webService.controller;

import mailaka.management.webService.DAO.OurServiceComponentDAO;
import mailaka.management.webService.controller.API.OurServiceAPI;
import mailaka.management.webService.services.OurServiceService;
import mailaka.management.webService.services.serviceImpl.OurServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OurServiceController implements OurServiceAPI {
    private final OurServiceService ourServiceService;

    @Autowired
    public OurServiceController(OurServiceService ourServiceService) {
        this.ourServiceService = ourServiceService;
    }

    @Override
    public OurServiceComponentDAO save(OurServiceComponentDAO ourServiceComponentDAO) {
        return ourServiceService.save(ourServiceComponentDAO);
    }

    @Override
    public OurServiceComponentDAO findById(Integer id) {
        return ourServiceService.findById(id);
    }

    @Override
    public List<OurServiceComponentDAO> findAll() {
        return ourServiceService.findAll();
    }
}
