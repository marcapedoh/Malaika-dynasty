package mailaka.management.webService.controller.API;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mailaka.management.webService.DAO.HeaderDAO;
import mailaka.management.webService.DAO.OurServiceComponentDAO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static mailaka.management.webService.constant.Utils.APP_ROOT;

@Api(APP_ROOT + "OurService/")
public interface OurServiceAPI {
    @PostMapping(value = APP_ROOT + "OurService/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer un ourService", notes=" cette methode permet d'enregistrer et modifier un OurService",response = OurServiceComponentDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'object OurService a ete bien crée ou modifer")
    })
    OurServiceComponentDAO save(@RequestBody OurServiceComponentDAO ourServiceComponentDAO);
    @GetMapping(value = APP_ROOT+"OurService/findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un ourservice", notes=" cette methode permet de rechercher un ouservice par son ID",response = OurServiceComponentDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "le ourService a ete trouvé dans la base de donnée"),
            @ApiResponse(code=404,message = "aucun  ourService trouvé dans la base de donnée")
    })
    OurServiceComponentDAO findById(@PathVariable("id") Integer id);

    @GetMapping(value = APP_ROOT+"OurService/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des ourService", notes=" cette methode permet de rechercher un OurService avec tous ses attributs",responseContainer = "List<OurServiceComponentDAO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "liste des ourServices/liste vide")
    })
    List<OurServiceComponentDAO> findAll();
}
