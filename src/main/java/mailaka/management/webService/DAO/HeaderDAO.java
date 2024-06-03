package mailaka.management.webService.DAO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mailaka.management.webService.models.Header;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HeaderDAO {
    private Integer id;
    private String localisation;
    private String telephone;
    private String email;
    private String nomSite;
    private String logoImage;
    private String menuUn;
    private String menuDeux;
    private String menuTrois;
    private String menuQuatre;
    private String menuCinq;

    public static HeaderDAO fromEntity(Header header){
        if(header==null){
            return null;
        }
        return HeaderDAO.builder()
                .id(header.getId())
                .localisation(header.getLocalisation())
                .telephone(header.getTelephone())
                .email(header.getEmail())
                .nomSite(header.getNomSite())
                .logoImage(header.getLogoImage())
                .menuUn(header.getMenuUn())
                .menuDeux(header.getMenuDeux())
                .menuTrois(header.getMenuTrois())
                .menuQuatre(header.getMenuQuatre())
                .menuCinq(header.getMenuCinq())
                .build();
    }
    public static Header toEntity(HeaderDAO headerDAO){
        if(headerDAO==null){
            return null;
        }
        Header header= new Header();
        header.setId(headerDAO.getId());
        header.setLocalisation(headerDAO.getLocalisation());
        header.setTelephone(headerDAO.getTelephone());
        header.setEmail(headerDAO.getEmail());
        header.setNomSite(headerDAO.getNomSite());
        header.setLogoImage(headerDAO.getLogoImage());
        header.setMenuUn(headerDAO.getMenuUn());
        header.setMenuDeux(headerDAO.getMenuDeux());
        header.setMenuTrois(headerDAO.getMenuTrois());
        header.setMenuQuatre(headerDAO.getMenuQuatre());
        header.setMenuCinq(headerDAO.getMenuCinq());
        return header;
    }
}
