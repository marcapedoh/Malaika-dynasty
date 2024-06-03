package mailaka.management.webService.controller.API;

import com.flickr4java.flickr.FlickrException;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static mailaka.management.webService.constant.Utils.APP_ROOT;

@Api(APP_ROOT+"photo/")
public interface FlickrAPI {
    @PostMapping(APP_ROOT+"/photo/savePhoto/{id}/{titre}/{context}")
    Object savePhoto(@PathVariable("context") String context, @PathVariable("id") Integer id, @RequestPart("file") MultipartFile photo, @PathVariable("titre") String title) throws IOException, FlickrException;

}
