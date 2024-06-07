package mailaka.management.webService.services.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import mailaka.management.webService.DAO.SliderButtonDAO;
import mailaka.management.webService.DAO.SliderImageDAO;
import mailaka.management.webService.exception.EntityNotFoundException;
import mailaka.management.webService.exception.ErrorCodes;
import mailaka.management.webService.exception.InvalidEntityException;
import mailaka.management.webService.repository.SliderImageRepository;
import mailaka.management.webService.services.SliderImageService;
import mailaka.management.webService.validators.SliderBouttonElementValidator;
import mailaka.management.webService.validators.SliderImageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SliderImageServiceImpl implements SliderImageService {

    private SliderImageRepository sliderImageRepository;

    @Autowired
    public SliderImageServiceImpl(SliderImageRepository sliderImageRepository) {
        this.sliderImageRepository = sliderImageRepository;
    }

    @Override
    public SliderImageDAO save(SliderImageDAO sliderImageDAO) {
        List<String> errors= SliderImageValidator.validate(sliderImageDAO);
        if(!errors.isEmpty()){
            log.warn("l'objet que vous faites passé n'est pas valide et est surement null");
            throw new InvalidEntityException("votre objet que vous passez est null", ErrorCodes.IMAGE_NOT_VALID,errors);
        }
        return SliderImageDAO.fromEntity(
                sliderImageRepository.save(
                        SliderImageDAO.toEntity(sliderImageDAO)
                )
        );
    }

    @Override
    public SliderImageDAO findById(Integer id) {
        return sliderImageRepository.findById(id)
                .map(SliderImageDAO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("aucune inmage n'est stocker avec cette Id chez nous vous vous trompez surement"));
    }

    @Override
    public List<SliderImageDAO> findAll() {
        return sliderImageRepository.findAll().stream()
                .map(SliderImageDAO::fromEntity)
                .collect(Collectors.toList());
    }
}
