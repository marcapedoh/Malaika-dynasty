package mailaka.management.webService.repository;

import mailaka.management.webService.models.WhoWeAre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WhoWeAreRepository extends JpaRepository<WhoWeAre,Integer> {
    Optional<WhoWeAre> findById(Integer id);
}
