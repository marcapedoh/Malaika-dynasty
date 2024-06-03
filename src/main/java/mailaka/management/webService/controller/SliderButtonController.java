package mailaka.management.webService.controller;

import mailaka.management.webService.DAO.SliderButtonDAO;
import mailaka.management.webService.controller.API.SliderButtonAPI;
import mailaka.management.webService.services.SliderButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class SliderButtonController implements SliderButtonAPI {
    private final SliderButtonService sliderButtonService;

    @Autowired
    public SliderButtonController(SliderButtonService sliderButtonService) {
        this.sliderButtonService = sliderButtonService;
    }

    @Override
    public SliderButtonDAO save(SliderButtonDAO sliderButtonDAO) {
        return sliderButtonService.save(sliderButtonDAO);
    }

    @Override
    public SliderButtonDAO findById(Integer id) {
        return sliderButtonService.findById(id);
    }
}
