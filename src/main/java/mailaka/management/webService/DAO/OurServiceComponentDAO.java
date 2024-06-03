package mailaka.management.webService.DAO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mailaka.management.webService.models.OurServiceComponent;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OurServiceComponentDAO {
    private Integer id;
    private String nomSection;
    private String titre;
    private String contenu;
    private String description;
    private String imagePath;

    public static OurServiceComponentDAO fromEntity(OurServiceComponent ourServiceComponent){
        if(ourServiceComponent==null){
            return null;
        }
        return OurServiceComponentDAO.builder()
                .id(ourServiceComponent.getId())
                .nomSection(ourServiceComponent.getNomSection())
                .titre(ourServiceComponent.getTitre())
                .contenu(ourServiceComponent.getContenu())
                .description(ourServiceComponent.getDescription())
                .imagePath(ourServiceComponent.getImagePath())
                .build();
    }

    public static OurServiceComponent toEntity(OurServiceComponentDAO ourServiceDAO){
        if(ourServiceDAO==null){
            return null;
        }
        OurServiceComponent component=new OurServiceComponent();
        component.setId(ourServiceDAO.getId());
        component.setNomSection(ourServiceDAO.getNomSection());
        component.setTitre(ourServiceDAO.getTitre());
        component.setContenu(ourServiceDAO.getContenu());
        component.setDescription(ourServiceDAO.getDescription());
        component.setImagePath(ourServiceDAO.getImagePath());
        return component;
    }
}
