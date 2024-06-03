package mailaka.management.webService.repository;

import mailaka.management.webService.models.Slider.BouttonElement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SliderButtonRepository extends JpaRepository<BouttonElement,Integer> {
    Optional<BouttonElement> findById(Integer id);
}
