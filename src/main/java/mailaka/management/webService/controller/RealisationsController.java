package mailaka.management.webService.controller;

import mailaka.management.webService.DAO.RealisationsDAO;
import mailaka.management.webService.controller.API.RealisationsAPI;
import mailaka.management.webService.services.RealisationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RealisationsController implements RealisationsAPI {
    private final RealisationsService realisationsService;

    @Autowired
    public RealisationsController(RealisationsService realisationsService) {
        this.realisationsService = realisationsService;
    }

    @Override
    public RealisationsDAO save(RealisationsDAO realisationsDAO) {
        return realisationsService.save(realisationsDAO);
    }

    @Override
    public RealisationsDAO findById(Integer id) {
        return realisationsService.findById(id);
    }

    @Override
    public List<RealisationsDAO> findAll() {
        return realisationsService.findAll();
    }
}
