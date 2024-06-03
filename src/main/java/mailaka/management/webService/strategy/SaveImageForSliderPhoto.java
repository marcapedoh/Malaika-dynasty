package mailaka.management.webService.strategy;

import com.flickr4java.flickr.FlickrException;
import lombok.extern.slf4j.Slf4j;
import mailaka.management.webService.DAO.HeaderDAO;
import mailaka.management.webService.DAO.SliderImageDAO;
import mailaka.management.webService.exception.ErrorCodes;
import mailaka.management.webService.exception.InvalidOperationException;
import mailaka.management.webService.services.FlickrService;
import mailaka.management.webService.services.SliderImageService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("imageSliderPhoto")
@Slf4j
public class SaveImageForSliderPhoto implements Strategy<SliderImageDAO>{

    private SliderImageService sliderImageService;
    private FlickrService flickrService;

    public SaveImageForSliderPhoto(SliderImageService sliderImageService, FlickrService flickrService) {
        this.sliderImageService = sliderImageService;
        this.flickrService = flickrService;
    }

    @Override
    public SliderImageDAO savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
        SliderImageDAO imageDAO = sliderImageService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo, titre);
        if (!StringUtils.hasLength(urlPhoto)) {
            throw new InvalidOperationException("Erreur lors de l'enregistrement de la photo", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
        }
        imageDAO.setImagePath(urlPhoto);
        return sliderImageService.save(imageDAO);
    }
}
