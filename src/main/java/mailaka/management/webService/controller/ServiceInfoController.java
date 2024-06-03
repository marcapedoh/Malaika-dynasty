package mailaka.management.webService.controller;

import mailaka.management.webService.DAO.ServiceInfoDAO;
import mailaka.management.webService.controller.API.ServiceInfoAPI;
import mailaka.management.webService.services.ServiceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ServiceInfoController implements ServiceInfoAPI {
    private final ServiceInfoService serviceInfoService;

    @Autowired
    public ServiceInfoController(ServiceInfoService serviceInfoService) {
        this.serviceInfoService = serviceInfoService;
    }

    @Override
    public ServiceInfoDAO save(ServiceInfoDAO serviceInfoDAO) {
        return serviceInfoService.save(serviceInfoDAO);
    }

    @Override
    public ServiceInfoDAO findById(Integer id) {
        return serviceInfoService.findById(id);
    }
}
