package mailaka.management.webService.services;

import mailaka.management.webService.DAO.SliderImageDAO;

import java.util.List;

public interface SliderImageService {
    SliderImageDAO save(SliderImageDAO sliderImageDAO);
    SliderImageDAO findById(Integer id);
    List<SliderImageDAO> findAll();
}
