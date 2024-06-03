package mailaka.management.webService.controller.API;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mailaka.management.webService.DAO.RealisationsDAO;
import mailaka.management.webService.DAO.ServiceInfoDAO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static mailaka.management.webService.constant.Utils.APP_ROOT;


@Api(APP_ROOT + "ServiceInfo/")
public interface ServiceInfoAPI {
    @PostMapping(value = APP_ROOT + "ServiceInfo/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer un serviceInfo", notes=" cette methode permet d'enregistrer et modifier un serviceInfo",response = ServiceInfoDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'object Realisation a ete bien crée ou modifer")
    })
    ServiceInfoDAO save(@RequestBody ServiceInfoDAO serviceInfoDAO);
    @GetMapping(value = APP_ROOT+"ServiceInfo/findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une ServiceInfo", notes=" cette methode permet de rechercher un ServiceInfo par son ID",response = ServiceInfoDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "le serviceInfo a ete trouvé dans la base de donnée"),
            @ApiResponse(code=404,message = "aucun serviceInfo trouvé dans la base de donnée")
    })
    ServiceInfoDAO findById(@PathVariable("id") Integer id);
}
