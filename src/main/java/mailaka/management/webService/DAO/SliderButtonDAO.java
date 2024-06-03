package mailaka.management.webService.DAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mailaka.management.webService.models.Slider.BouttonElement;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SliderButtonDAO {
    private Integer id;
    private String value;

    public static SliderButtonDAO fromEntity(BouttonElement bouttonElement){
        if(bouttonElement==null){
            return null;
        }
        return SliderButtonDAO.builder()
                .id(bouttonElement.getId())
                .value(bouttonElement.getValue())
                .build();
    }
    public static BouttonElement toEntity(SliderButtonDAO sliderButtonDAO){
        if(sliderButtonDAO==null){
            return null;
        }
        BouttonElement bouttonElement= new BouttonElement();
        bouttonElement.setId(sliderButtonDAO.getId());
        bouttonElement.setValue(sliderButtonDAO.getValue());
        return bouttonElement;
    }
}
