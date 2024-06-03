package mailaka.management.webService.DAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mailaka.management.webService.models.WhoWeAre;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WhoWeAreDAO {
    private Integer id;
    private String resume;
    private String contenu;
    private String image;
    private String imageArrondi;
    private String premierElement;
    private String secondElement;
    private String troisiemeElement;

    public static WhoWeAreDAO fromEntity(WhoWeAre whoWeAre){
        if(whoWeAre==null){
            return null;
        }
        return WhoWeAreDAO.builder()
                .id(whoWeAre.getId())
                .resume(whoWeAre.getResume())
                .contenu(whoWeAre.getContenu())
                .image(whoWeAre.getImage())
                .imageArrondi(whoWeAre.getImageArrondi())
                .premierElement(whoWeAre.getPremierElement())
                .secondElement(whoWeAre.getSecondElement())
                .troisiemeElement(whoWeAre.getTroisiemeElement())
                .build();
    }

    public static  WhoWeAre toEntity(WhoWeAreDAO whoWeAreDAO){
        if(whoWeAreDAO==null){
            return null;
        }
        WhoWeAre whoWeAre= new WhoWeAre();
        whoWeAre.setId(whoWeAreDAO.getId());
        whoWeAre.setResume(whoWeAreDAO.getResume());
        whoWeAre.setContenu(whoWeAreDAO.getContenu());
        whoWeAre.setImage(whoWeAreDAO.getImage());
        whoWeAre.setImageArrondi(whoWeAreDAO.getImageArrondi());
        whoWeAre.setPremierElement(whoWeAreDAO.getPremierElement());
        whoWeAre.setSecondElement(whoWeAreDAO.getSecondElement());
        whoWeAre.setTroisiemeElement(whoWeAreDAO.getTroisiemeElement());

        return  whoWeAre;
    }
}
