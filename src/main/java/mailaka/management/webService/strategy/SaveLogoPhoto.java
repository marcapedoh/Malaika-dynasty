package mailaka.management.webService.strategy;


import com.flickr4java.flickr.FlickrException;
import lombok.extern.slf4j.Slf4j;
import mailaka.management.webService.DAO.HeaderDAO;
import mailaka.management.webService.exception.ErrorCodes;
import mailaka.management.webService.exception.InvalidOperationException;
import mailaka.management.webService.services.FlickrService;
import mailaka.management.webService.services.HeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("headerStrategy")
@Slf4j
public class SaveLogoPhoto implements Strategy<HeaderDAO> {

    private final FlickrService flickrService;
    private final HeaderService headerService;

    @Autowired
    public SaveLogoPhoto(FlickrService flickrService, HeaderService headerService) {
        this.flickrService = flickrService;
        this.headerService = headerService;
    }



    @Override
    public HeaderDAO savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
        HeaderDAO headerDAO = headerService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo, titre);
        if (!StringUtils.hasLength(urlPhoto)) {
            throw new InvalidOperationException("Erreur lors de l'enregistrement de la photo", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
        }
        headerDAO.setLogoImage(urlPhoto);
        return headerService.save(headerDAO);
    }
}