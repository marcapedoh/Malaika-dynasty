package mailaka.management.webService.controller;

import mailaka.management.webService.DAO.WhoWeAreDAO;
import mailaka.management.webService.controller.API.WhoWeAreAPI;
import mailaka.management.webService.services.WhoWeAreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WhoWeAreController implements WhoWeAreAPI {
    private final WhoWeAreService whoWeAreService;

    @Autowired
    public WhoWeAreController(WhoWeAreService whoWeAreService) {
        this.whoWeAreService = whoWeAreService;
    }

    @Override
    public WhoWeAreDAO save(WhoWeAreDAO whoWeAreDAO) {
        return whoWeAreService.save(whoWeAreDAO);
    }

    @Override
    public WhoWeAreDAO findById(Integer id) {
        return whoWeAreService.findById(id);
    }
}
