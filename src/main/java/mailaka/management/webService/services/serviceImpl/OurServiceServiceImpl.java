package mailaka.management.webService.services.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import mailaka.management.webService.DAO.HeaderDAO;
import mailaka.management.webService.DAO.OurServiceComponentDAO;
import mailaka.management.webService.exception.EntityNotFoundException;
import mailaka.management.webService.exception.ErrorCodes;
import mailaka.management.webService.exception.InvalidEntityException;
import mailaka.management.webService.repository.OurServiceRepository;
import mailaka.management.webService.services.OurServiceService;
import mailaka.management.webService.validators.HeaderValidator;
import mailaka.management.webService.validators.OurServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OurServiceServiceImpl implements OurServiceService {

    private final OurServiceRepository ourServiceRepository;

    @Autowired
    public OurServiceServiceImpl(OurServiceRepository ourServiceRepository) {
        this.ourServiceRepository = ourServiceRepository;
    }

    @Override
    public OurServiceComponentDAO save(OurServiceComponentDAO ourServiceComponentDAO) {
        List<String> errors= OurServiceValidator.validate(ourServiceComponentDAO);
        if(!errors.isEmpty()){
            log.warn("l'objet que vous faites passé n'est pas valide et est surement null");
            throw new InvalidEntityException("votre objet que vous passez est null", ErrorCodes.OUR_SERVICE_NOT_VALID,errors);
        }
        return OurServiceComponentDAO.fromEntity(
                ourServiceRepository.save(
                        OurServiceComponentDAO.toEntity(ourServiceComponentDAO)
                )
        );
    }

    @Override
    public OurServiceComponentDAO findById(Integer id) {
        return ourServiceRepository.findById(id)
                .map(OurServiceComponentDAO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("aucun service trouver pour cette id"));
    }

    @Override
    public List<OurServiceComponentDAO> findAll() {
        return ourServiceRepository.findAll().stream()
                .map(OurServiceComponentDAO::fromEntity)
                .collect(Collectors.toList());
    }
}
