package mailaka.management.webService.services.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import mailaka.management.webService.DAO.SliderImageDAO;
import mailaka.management.webService.DAO.WhoWeAreDAO;
import mailaka.management.webService.exception.EntityNotFoundException;
import mailaka.management.webService.exception.ErrorCodes;
import mailaka.management.webService.exception.InvalidEntityException;
import mailaka.management.webService.repository.WhoWeAreRepository;
import mailaka.management.webService.services.WhoWeAreService;
import mailaka.management.webService.validators.SliderImageValidator;
import mailaka.management.webService.validators.WhoWeAreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WhoWeAreServiceImpl implements WhoWeAreService {
    private final WhoWeAreRepository whoWeAreRepository;

    @Autowired
    public WhoWeAreServiceImpl(WhoWeAreRepository whoWeAreRepository) {
        this.whoWeAreRepository = whoWeAreRepository;
    }

    @Override
    public WhoWeAreDAO save(WhoWeAreDAO whoWeAreDAO) {
        List<String> errors= WhoWeAreValidator.validate(whoWeAreDAO);
        if(!errors.isEmpty()){
            log.warn("l'objet que vous faites passé n'est pas valide et est surement null");
            throw new InvalidEntityException("votre objet que vous passez est null", ErrorCodes.WHO_WE_ARE_NOT_VALID,errors);
        }
        return WhoWeAreDAO.fromEntity(
                whoWeAreRepository.save(
                        WhoWeAreDAO.toEntity(whoWeAreDAO)
                )
        );
    }

    @Override
    public WhoWeAreDAO findById(Integer id) {
        return whoWeAreRepository.findById(id)
                .map(WhoWeAreDAO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("aucun entité trouvé dans la base avec cet id"));
    }
}
