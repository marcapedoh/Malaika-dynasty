package mailaka.management.webService.controller;

import com.flickr4java.flickr.FlickrException;
import mailaka.management.webService.controller.API.FlickrAPI;
import mailaka.management.webService.strategy.StrategyPhotoContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
public class FlickrController implements FlickrAPI {
    private final StrategyPhotoContext strategyPhotoContext;
    @Autowired
    public FlickrController(StrategyPhotoContext strategyPhotoContext) {
        this.strategyPhotoContext = strategyPhotoContext;
    }
    @Override
    public Object savePhoto(String context, Integer id, MultipartFile photo, String title) throws IOException, FlickrException, IOException, FlickrException {
        return strategyPhotoContext.savePhoto(context,id,photo.getInputStream(),title);
    }
}
