package mailaka.management.webService.repository;

import mailaka.management.webService.models.Header;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeaderRepository extends JpaRepository<Header,Integer> {
    Optional<Header> findById(Integer id);
}
