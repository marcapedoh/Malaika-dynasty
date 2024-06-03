package mailaka.management.webService.repository;

import mailaka.management.webService.models.Realisations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RealisationsRepository extends JpaRepository<Realisations,Integer> {
    Optional<Realisations> findById(Integer id);
}
