package mailaka.management.webService.services.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import mailaka.management.webService.DAO.ServiceInfoDAO;
import mailaka.management.webService.DAO.SliderButtonDAO;
import mailaka.management.webService.exception.EntityNotFoundException;
import mailaka.management.webService.exception.ErrorCodes;
import mailaka.management.webService.exception.InvalidEntityException;
import mailaka.management.webService.repository.SliderButtonRepository;
import mailaka.management.webService.services.SliderButtonService;
import mailaka.management.webService.validators.ServiceInfoValidator;
import mailaka.management.webService.validators.SliderBouttonElementValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SliderButtonButtonServiceImpl implements SliderButtonService {

    private SliderButtonRepository sliderButtonRepository;

    @Autowired
    public SliderButtonButtonServiceImpl(SliderButtonRepository sliderButtonRepository) {
        this.sliderButtonRepository = sliderButtonRepository;
    }

    @Override
    public SliderButtonDAO save(SliderButtonDAO sliderButtonDAO) {
        List<String> errors= SliderBouttonElementValidator.validate(sliderButtonDAO);
        if(!errors.isEmpty()){
            log.warn("l'objet que vous faites passé n'est pas valide et est surement null");
            throw new InvalidEntityException("votre objet que vous passez est null", ErrorCodes.TEXT_ON_BUTTON_NOT_VALID,errors);
        }
        return SliderButtonDAO.fromEntity(
                sliderButtonRepository.save(
                        SliderButtonDAO.toEntity(sliderButtonDAO)
                )
        );
    }

    @Override
    public SliderButtonDAO findById(Integer id) {
        return sliderButtonRepository.findById(id)
                .map(SliderButtonDAO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("aucun element reconnu dans notre base de donnée avec cet Id"));
    }
}
