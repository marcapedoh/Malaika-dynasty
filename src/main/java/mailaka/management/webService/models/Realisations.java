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
public class Realisations extends  AbstractEntity{
    @Column(name = "titreRealisation",nullable = false)
    private String titre;
    @Column(name = "contenuRealisation",nullable = false)
    private String contenu;
    @Column(name = "imagePath",nullable = false)
    private String imagePath;
    @Column(name = "nomSection",nullable = false)
    private String nomSection;
    @Column(name = "descriptionTitre",nullable = false)
    private String descriptionTitre;
    @Column(name = "descriptionSection",nullable = false)
    private String descriptionSection;
}
