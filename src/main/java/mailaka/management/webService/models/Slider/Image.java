package mailaka.management.webService.models.Slider;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import mailaka.management.webService.models.AbstractEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EqualsAndHashCode(callSuper = true)
public class Image extends AbstractEntity {
    @Column(name = "imagePath",nullable = false)
    private String imagePath;
}
