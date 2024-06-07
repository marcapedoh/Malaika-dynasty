package mailaka.management.webService.controller.API;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mailaka.management.webService.DAO.HeaderDAO;
import mailaka.management.webService.DAO.SliderButtonDAO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static mailaka.management.webService.constant.Utils.APP_ROOT;


@Api(APP_ROOT + "SliderButton/")
public interface SliderButtonAPI {
    @PostMapping(value = APP_ROOT + "SliderButton/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer un sliderButton", notes=" cette methode permet d'enregistrer et modifier un header",response = SliderButtonDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'object SliderButton a ete bien crée ou modifer")
    })
    SliderButtonDAO save(@RequestBody SliderButtonDAO sliderButtonDAO);
    @GetMapping(value = APP_ROOT+"SliderButton/findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un header", notes=" cette methode permet de rechercher un header par son ID",response = SliderButtonDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "le sliderButton a ete trouvé dans la base de donnée"),
            @ApiResponse(code=404,message = "aucun  sliderButton trouvé dans la base de donnée")
    })
    SliderButtonDAO findById(@PathVariable("id") Integer id);
}
