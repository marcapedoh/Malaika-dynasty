package mailaka.management.webService.DAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mailaka.management.webService.models.Slider.Image;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SliderImageDAO {
    private Integer id;
    private String imagePath;

    public static SliderImageDAO fromEntity(Image image){
        if (image==null){
            return null;
        }
        return SliderImageDAO.builder()
                .id(image.getId())
                .imagePath(image.getImagePath())
                .build();
    }
    public  static Image toEntity(SliderImageDAO sliderImageDAO){
        if(sliderImageDAO==null){
            return null;
        }
        Image image= new Image();
        image.setId(sliderImageDAO.getId());
        image.setImagePath(sliderImageDAO.getImagePath());

        return image;
    }
}
