package mailaka.management.webService.services.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import mailaka.management.webService.DAO.OurServiceComponentDAO;
import mailaka.management.webService.DAO.ServiceInfoDAO;
import mailaka.management.webService.exception.EntityNotFoundException;
import mailaka.management.webService.exception.ErrorCodes;
import mailaka.management.webService.exception.InvalidEntityException;
import mailaka.management.webService.repository.ServiceInfoRepository;
import mailaka.management.webService.services.ServiceInfoService;
import mailaka.management.webService.validators.OurServiceValidator;
import mailaka.management.webService.validators.ServiceInfoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ServiceInfoServiceImpl implements ServiceInfoService {
    private ServiceInfoRepository serviceInfoRepository;

    @Autowired
    public ServiceInfoServiceImpl(ServiceInfoRepository serviceInfoRepository) {
        this.serviceInfoRepository = serviceInfoRepository;
    }

    @Override
    public ServiceInfoDAO save(ServiceInfoDAO serviceInfoDAO) {
        List<String> errors= ServiceInfoValidator.validate(serviceInfoDAO);
        if(!errors.isEmpty()){
            log.warn("l'objet que vous faites passé n'est pas valide et est surement null");
            throw new InvalidEntityException("votre objet que vous passez est null", ErrorCodes.SERVICE_INFO_NOT_VALID,errors);
        }
        return ServiceInfoDAO.fromEntity(
                serviceInfoRepository.save(
                        ServiceInfoDAO.toEntity(serviceInfoDAO)
                )
        );
    }

    @Override
    public ServiceInfoDAO findById(Integer id) {
        return serviceInfoRepository.findById(id)
                .map(ServiceInfoDAO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("aucun service n'est trouvé pour cette Id"));
    }
}
