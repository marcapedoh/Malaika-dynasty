package mailaka.management.webService.controller;

import mailaka.management.webService.DAO.SliderImageDAO;
import mailaka.management.webService.controller.API.SliderImageAPI;
import mailaka.management.webService.services.SliderImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class SliderImageController implements SliderImageAPI {
    private final SliderImageService sliderImageService;

    @Autowired
    public SliderImageController(SliderImageService sliderImageService) {
        this.sliderImageService = sliderImageService;
    }

    @Override
    public SliderImageDAO save(SliderImageDAO sliderImageDAO) {
        return sliderImageService.save(sliderImageDAO);
    }

    @Override
    public SliderImageDAO findById(Integer id) {
        return sliderImageService.findById(id);
    }
}
