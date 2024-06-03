package mailaka.management.webService.controller;

import mailaka.management.webService.DAO.HeaderDAO;
import mailaka.management.webService.controller.API.HeaderAPI;
import mailaka.management.webService.services.HeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class HeaderController implements HeaderAPI {
    private HeaderService headerService;

    @Autowired
    public HeaderController(HeaderService headerService) {
        this.headerService = headerService;
    }

    @Override
    public HeaderDAO save(HeaderDAO headerDAO) {
        return headerService.save(headerDAO);
    }

    @Override
    public HeaderDAO findById(Integer id) {
        return headerService.findById(id);
    }
}
