package mailaka.management.webService.services;

import mailaka.management.webService.DAO.WhoWeAreDAO;

public interface WhoWeAreService{
    WhoWeAreDAO save(WhoWeAreDAO whoWeAreDAO);
    WhoWeAreDAO findById(Integer id);
}
