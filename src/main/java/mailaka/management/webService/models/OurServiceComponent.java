package mailaka.management.webService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EqualsAndHashCode(callSuper = true)
public class OurServiceComponent extends AbstractEntity {
    @Column(name = "nomSection",nullable = false)
    private String nomSection;
    @Column(name = "titre",nullable = false)
    private String titre;
    @Column(name = "contenu",nullable = false)
    private String contenu;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "imagePath",nullable = false)
    private String imagePath;
}
