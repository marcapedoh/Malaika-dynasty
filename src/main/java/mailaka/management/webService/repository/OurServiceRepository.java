package mailaka.management.webService.repository;

import mailaka.management.webService.models.OurServiceComponent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OurServiceRepository extends JpaRepository<OurServiceComponent,Integer> {
    Optional<OurServiceComponent> findById(Integer id);
}
