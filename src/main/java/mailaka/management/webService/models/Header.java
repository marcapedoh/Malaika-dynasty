package mailaka.management.webService.models;

import jakarta.persistence.*;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EqualsAndHashCode(callSuper = true)
public class Header extends AbstractEntity {
    @Column(name = "localisation",nullable = true)
    private String localisation;
    @Column(name = "telephone",nullable = true)
    private String telephone;
    @Column(name = "email",nullable = true)
    private String email;
    @Column(name = "nomSite",nullable = true)
    private String nomSite;
    @Column(name = "logoImage",nullable = true)
    private String logoImage;
    @Column(name = "premierMenu",nullable = true)
    private String menuUn;
    @Column(name = "deuxiemeMenu",nullable = true)
    private String menuDeux;
    @Column(name = "troisiemeMenu", nullable = true)
    private String menuTrois;
    @Column(name = "quatriemeMenu", nullable = true)
    private String menuQuatre;
    @Column(name = "cinquiemeMenu", nullable = true)
    private String menuCinq;


}
