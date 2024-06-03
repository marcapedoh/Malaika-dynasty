package mailaka.management.webService.services;

import mailaka.management.webService.DAO.SliderImageDAO;

public interface SliderImageService {
    SliderImageDAO save(SliderImageDAO sliderImageDAO);
    SliderImageDAO findById(Integer id);
}
