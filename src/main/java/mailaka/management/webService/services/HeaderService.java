package mailaka.management.webService.services;

import mailaka.management.webService.DAO.HeaderDAO;

public interface HeaderService {
    HeaderDAO save(HeaderDAO headerDAO);
    HeaderDAO findById(Integer id);
}
