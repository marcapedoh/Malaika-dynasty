package mailaka.management.webService.services;

import mailaka.management.webService.DAO.RealisationsDAO;

import java.util.List;

public interface RealisationsService {
    RealisationsDAO save(RealisationsDAO realisationsDAO);
    RealisationsDAO findById(Integer id);
    List<RealisationsDAO> findAll();
}
