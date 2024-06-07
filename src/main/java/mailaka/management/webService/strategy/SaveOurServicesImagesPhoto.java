package mailaka.management.webService.strategy;

import com.flickr4java.flickr.FlickrException;
import lombok.extern.slf4j.Slf4j;
import mailaka.management.webService.DAO.OurServiceComponentDAO;
import mailaka.management.webService.DAO.SliderImageDAO;
import mailaka.management.webService.exception.ErrorCodes;
import mailaka.management.webService.exception.InvalidOperationException;
import mailaka.management.webService.services.FlickrService;
import mailaka.management.webService.services.OurServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("ourServiceStrategy")
@Slf4j
public class SaveOurServicesImagesPhoto implements Strategy<OurServiceComponentDAO>{

    private FlickrService flickrService;
    private OurServiceService ourServiceService;

    @Autowired
    public SaveOurServicesImagesPhoto(FlickrService flickrService, OurServiceService ourServiceService) {
        this.flickrService = flickrService;
        this.ourServiceService = ourServiceService;
    }

    @Override
    public OurServiceComponentDAO savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
        OurServiceComponentDAO ourServiceComponentDAO = ourServiceService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo, titre);
        if (!StringUtils.hasLength(urlPhoto)) {
            throw new InvalidOperationException("Erreur lors de l'enregistrement de la photo", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
        }
        ourServiceComponentDAO.setImagePath(urlPhoto);
        return ourServiceService.save(ourServiceComponentDAO);
    }
}
