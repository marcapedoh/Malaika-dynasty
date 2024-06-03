package mailaka.management.webService.services;

import mailaka.management.webService.DAO.ServiceInfoDAO;

import java.security.Provider;

public interface ServiceInfoService {
    ServiceInfoDAO save(ServiceInfoDAO serviceInfoDAO);
    ServiceInfoDAO findById(Integer id);
}
