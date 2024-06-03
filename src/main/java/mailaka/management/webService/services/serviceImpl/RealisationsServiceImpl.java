package mailaka.management.webService.services.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import mailaka.management.webService.DAO.OurServiceComponentDAO;
import mailaka.management.webService.DAO.RealisationsDAO;
import mailaka.management.webService.exception.EntityNotFoundException;
import mailaka.management.webService.exception.ErrorCodes;
import mailaka.management.webService.exception.InvalidEntityException;
import mailaka.management.webService.repository.RealisationsRepository;
import mailaka.management.webService.services.RealisationsService;
import mailaka.management.webService.validators.OurServiceValidator;
import mailaka.management.webService.validators.RealisationsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RealisationsServiceImpl implements RealisationsService {
    private RealisationsRepository repository;

    @Autowired
    public RealisationsServiceImpl(RealisationsRepository repository) {
        this.repository = repository;
    }

    @Override
    public RealisationsDAO save(RealisationsDAO realisationsDAO) {
        List<String> errors= RealisationsValidator.validate(realisationsDAO);
        if(!errors.isEmpty()){
            log.warn("l'objet que vous faites passé n'est pas valide et est surement null");
            throw new InvalidEntityException("votre objet que vous passez est null", ErrorCodes.REALISATIONS_NOT_VALID,errors);
        }
        return RealisationsDAO.fromEntity(
                repository.save(
                        RealisationsDAO.toEntity(realisationsDAO)
                )
        );
    }

    @Override
    public RealisationsDAO findById(Integer id) {
        return repository.findById(id)
                .map(RealisationsDAO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("aucun objet trouvé poue cet id"));
    }

    @Override
    public List<RealisationsDAO> findAll() {
        return repository.findAll().stream()
                .map(RealisationsDAO::fromEntity)
                .collect(Collectors.toList());
    }
}
