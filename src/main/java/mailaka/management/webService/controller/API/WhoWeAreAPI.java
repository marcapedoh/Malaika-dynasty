package mailaka.management.webService.controller.API;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mailaka.management.webService.DAO.SliderImageDAO;
import mailaka.management.webService.DAO.WhoWeAreDAO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static mailaka.management.webService.constant.Utils.APP_ROOT;


@Api(APP_ROOT + "WhoWeAre/")
public interface WhoWeAreAPI {
    @PostMapping(value = APP_ROOT + "WhoWeAre/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer un WhoWeAre", notes=" cette methode permet d'enregistrer et modifier un WhoWeAre",response = WhoWeAreDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'object WhoWeAre a ete bien crée ou modifer")
    })
    WhoWeAreDAO save(@RequestBody WhoWeAreDAO whoWeAreDAO);
    @GetMapping(value = APP_ROOT+"WhoWeAre/findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un header", notes=" cette methode permet de rechercher un header par son ID",response = WhoWeAreDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "le WhoWeAre a ete trouvé dans la base de donnée"),
            @ApiResponse(code=404,message = "aucun  WhoWeAre trouvé dans la base de donnée")
    })
    WhoWeAreDAO findById(@PathVariable("id") Integer id);
}
