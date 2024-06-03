package mailaka.management.webService.strategy;

import com.flickr4java.flickr.FlickrException;
import lombok.extern.slf4j.Slf4j;
import mailaka.management.webService.DAO.OurServiceComponentDAO;
import mailaka.management.webService.DAO.WhoWeAreDAO;
import mailaka.management.webService.exception.ErrorCodes;
import mailaka.management.webService.exception.InvalidOperationException;
import mailaka.management.webService.services.FlickrService;
import mailaka.management.webService.services.WhoWeAreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("whoweareImageArrondi")
@Slf4j
public class SaveWhoWeAreImageArrondiPhoto implements Strategy<WhoWeAreDAO>{
    private FlickrService flickrService;
    private WhoWeAreService whoWeAreService;

    @Autowired
    public SaveWhoWeAreImageArrondiPhoto(FlickrService flickrService, WhoWeAreService whoWeAreService) {
        this.flickrService = flickrService;
        this.whoWeAreService = whoWeAreService;
    }

    @Override
    public WhoWeAreDAO savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
        WhoWeAreDAO whoWeAreDAO = whoWeAreService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo, titre);
        if (!StringUtils.hasLength(urlPhoto)) {
            throw new InvalidOperationException("Erreur lors de l'enregistrement de  la photo", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
        }
        whoWeAreDAO.setImageArrondi(urlPhoto);
        return whoWeAreService.save(whoWeAreDAO);
    }
}
