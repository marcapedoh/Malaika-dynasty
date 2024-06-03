package mailaka.management.webService.services;

import mailaka.management.webService.DAO.SliderButtonDAO;

public interface SliderButtonService {
    SliderButtonDAO save(SliderButtonDAO sliderButtonDAO);
    SliderButtonDAO findById(Integer id);
}
