package mailaka.management.webService.repository;

import mailaka.management.webService.models.footer.ServiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceInfoRepository extends JpaRepository<ServiceInfo, Integer> {
    Optional<ServiceInfo> findById(Integer id);
}
