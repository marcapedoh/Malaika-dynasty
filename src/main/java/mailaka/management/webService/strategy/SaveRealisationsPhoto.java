package mailaka.management.webService.strategy;

import com.flickr4java.flickr.FlickrException;
import lombok.extern.slf4j.Slf4j;
import mailaka.management.webService.DAO.HeaderDAO;
import mailaka.management.webService.DAO.RealisationsDAO;
import mailaka.management.webService.exception.ErrorCodes;
import mailaka.management.webService.exception.InvalidOperationException;
import mailaka.management.webService.services.FlickrService;
import mailaka.management.webService.services.RealisationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("realisationStrategy")
@Slf4j
public class SaveRealisationsPhoto implements Strategy<RealisationsDAO>{
    private final RealisationsService realisationsService;
    private final FlickrService flickrService;

    @Autowired
    public SaveRealisationsPhoto(RealisationsService realisationsService,FlickrService flickrService) {
        this.realisationsService = realisationsService;
        this.flickrService=flickrService;
    }

    @Override
    public RealisationsDAO savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
        RealisationsDAO realisationsDAO = realisationsService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo, titre);
        if (!StringUtils.hasLength(urlPhoto)) {
            throw new InvalidOperationException("Erreur lors de l'enregistrement de la photo", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
        }
        realisationsDAO.setImagePath(urlPhoto);
        return realisationsService.save(realisationsDAO);
    }
}
