package mailaka.management.webService.strategy;

import com.flickr4java.flickr.FlickrException;
import lombok.Setter;
import mailaka.management.webService.exception.ErrorCodes;
import mailaka.management.webService.exception.InvalidOperationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
@Service
public class StrategyPhotoContext{
    private BeanFactory beanFactory;
    private  Strategy strategy;
    @Setter
    private String context;
    @Autowired
    public StrategyPhotoContext(BeanFactory beanFactory) {
        this.beanFactory=beanFactory;
    }
    public Object savePhoto(String context, Integer id, InputStream photo, String title) throws FlickrException {
        determinContext(context);
        return strategy.savePhoto(id,photo,title);
    }
    private void determinContext(String context){
        final String beanName=context+"Strategy";
        switch (context){
            case "sliderImage":
                strategy= beanFactory.getBean(beanName,SaveImageForSliderPhoto.class);
                break;
            case "logoImage":
                strategy= beanFactory.getBean(beanName, SaveLogoPhoto.class);
                break;

            case "ourServiceImage":
                strategy= beanFactory.getBean(beanName,SaveOurServicesImagesPhoto.class);
                break;
            case "whoWeAreIamgeCard":
                strategy= beanFactory.getBean(beanName,SaveWhoWeAreImageCardPhoto.class);
                break;
            case "whoWeAreIamgeArrondi":
                strategy= beanFactory.getBean(beanName,SaveWhoWeAreImageArrondiPhoto.class);
                break;
            case "realisations":
                strategy= beanFactory.getBean(beanName,SaveRealisationsPhoto.class);
                break;
            default:
                throw new InvalidOperationException("contexte inconnue pour l'enregistrement de la photo", ErrorCodes.CONTEXT_INCONNU);
        }
    }
}