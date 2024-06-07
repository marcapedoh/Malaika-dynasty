package mailaka.management.webService.controller.API;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mailaka.management.webService.DAO.HeaderDAO;
import mailaka.management.webService.DAO.SliderImageDAO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static mailaka.management.webService.constant.Utils.APP_ROOT;


@Api(APP_ROOT + "SliderImage/")
public interface SliderImageAPI {
    @PostMapping(value = APP_ROOT + "SliderImage/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer un sliderImage", notes=" cette methode permet d'enregistrer et modifier un sliderImage",response = SliderImageDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'object sliderImage a ete bien crée ou modifer")
    })
    SliderImageDAO save(@RequestBody SliderImageDAO sliderImageDAO);
    @GetMapping(value = APP_ROOT+"SliderImage/findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un header", notes=" cette methode permet de rechercher un header par son ID",response = SliderImageDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "le sliderImage a ete trouvé dans la base de donnée"),
            @ApiResponse(code=404,message = "aucun  sliderImage trouvé dans la base de donnée")
    })
    SliderImageDAO findById(@PathVariable("id") Integer id);
    @GetMapping(value = APP_ROOT+"SliderImage/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Images", notes=" cette methode permet de rechercher un Image avec tous ses attributs",responseContainer = "List<SliderImageDAO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "liste des SliderImage/liste vide")
    })
    List<SliderImageDAO> findAll();
}
