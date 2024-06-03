package mailaka.management.webService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(callSuper = true)
public class WhoWeAre extends AbstractEntity{
    @Column(name = "resume",nullable = false)
    private String resume;
    @Column(name = "contenu",nullable = false)
    private String contenu;
    @Column(name = "image",nullable = false)
    private String image;
    @Column(name = "imageArrondi",nullable = false)
    private String imageArrondi;
    @Column(name = "premierElement",nullable = false)
    private String premierElement;
    @Column(name = "secondElement",nullable = false)
    private String secondElement;
    @Column(name = "troisiemeElement",nullable = false)
    private String troisiemeElement;
}
