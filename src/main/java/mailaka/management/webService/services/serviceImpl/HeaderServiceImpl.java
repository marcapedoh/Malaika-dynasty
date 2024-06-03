package mailaka.management.webService.services.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import mailaka.management.webService.DAO.HeaderDAO;
import mailaka.management.webService.exception.EntityNotFoundException;
import mailaka.management.webService.exception.ErrorCodes;
import mailaka.management.webService.exception.InvalidEntityException;
import mailaka.management.webService.repository.HeaderRepository;
import mailaka.management.webService.services.HeaderService;
import mailaka.management.webService.validators.HeaderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HeaderServiceImpl implements HeaderService {

    private HeaderRepository headerRepository;

    @Autowired
    public HeaderServiceImpl(HeaderRepository headerRepository) {
        this.headerRepository = headerRepository;
    }

    @Override
    public HeaderDAO save(HeaderDAO headerDAO) {
        List<String> errors= HeaderValidator.validate(headerDAO);
        if(!errors.isEmpty()){
            log.warn("l'objet que vous faites passé n'est pas valide et est surement null");
            throw new InvalidEntityException("votre objet que vous passez est null", ErrorCodes.HEADER_NOT_VALID,errors);
        }
        return HeaderDAO.fromEntity(
                headerRepository.save(
                        HeaderDAO.toEntity(headerDAO)
                )
        );
    }

    @Override
    public HeaderDAO findById(Integer id) {
        return headerRepository.findById(id)
                .map(HeaderDAO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("aucun objet trouvé pour cette ID"));
    }
}
