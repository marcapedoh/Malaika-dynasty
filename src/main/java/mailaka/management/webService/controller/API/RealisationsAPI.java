package mailaka.management.webService.controller.API;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mailaka.management.webService.DAO.OurServiceComponentDAO;
import mailaka.management.webService.DAO.RealisationsDAO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static mailaka.management.webService.constant.Utils.APP_ROOT;


@Api(APP_ROOT + "Realisation/")
public interface RealisationsAPI {
    @PostMapping(value = APP_ROOT + "Realisation/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer une Realisation", notes=" cette methode permet d'enregistrer et modifier une Realisation",response = RealisationsDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'object Realisation a ete bien crée ou modifer")
    })
    RealisationsDAO save(@RequestBody RealisationsDAO realisationsDAO);
    @GetMapping(value = APP_ROOT+"Realisation/findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une realisation", notes=" cette methode permet de rechercher un Realisation par son ID",response = RealisationsDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "la realisation a ete trouvé dans la base de donnée"),
            @ApiResponse(code=404,message = "aucune realisation trouvé dans la base de donnée")
    })
    RealisationsDAO findById(@PathVariable("id") Integer id);
    @GetMapping(value = APP_ROOT+"Realisation/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des realisations", notes=" cette methode permet de rechercher une realisation",responseContainer = "List<RealisationsDAO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "liste des reservations/liste vide")
    })
    List<RealisationsDAO> findAll();
}
