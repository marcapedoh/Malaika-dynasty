package mailaka.management.webService.DAO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mailaka.management.webService.models.Realisations;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RealisationsDAO {
    private Integer id ;
    private String titre;
    private String contenu;
    private String imagePath;
    private String nomSection;
    private String descriptionTitre;
    private String descriptionSection;

    public  static RealisationsDAO fromEntity(Realisations realisations){
        if(realisations==null){
            return null;
        }
        return RealisationsDAO.builder()
                .id(realisations.getId())
                .titre(realisations.getTitre())
                .contenu(realisations.getContenu())
                .imagePath(realisations.getImagePath())
                .nomSection(realisations.getNomSection())
                .descriptionTitre(realisations.getDescriptionTitre())
                .descriptionSection(realisations.getDescriptionSection())
                .build();
    }
    public static Realisations toEntity(RealisationsDAO realisationsDAO){
        if(realisationsDAO==null){
            return null;
        }
        Realisations realisations= new Realisations();

        realisations.setId(realisationsDAO.getId());
        realisations.setTitre(realisationsDAO.getTitre());
        realisations.setContenu(realisationsDAO.getContenu());
        realisations.setImagePath(realisationsDAO.getImagePath());
        realisations.setNomSection(realisationsDAO.getNomSection());
        realisations.setDescriptionTitre(realisationsDAO.getDescriptionTitre());
        realisations.setDescriptionSection(realisationsDAO.getDescriptionSection());
        return realisations;
    }
}
