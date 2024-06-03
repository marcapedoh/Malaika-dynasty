package mailaka.management.webService.repository;

import mailaka.management.webService.models.Slider.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SliderImageRepository extends JpaRepository<Image,Integer> {
    Optional<Image> findById(Integer id);
}
