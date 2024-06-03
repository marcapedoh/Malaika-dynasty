package mailaka.management.webService.controller.API;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mailaka.management.webService.DAO.HeaderDAO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static mailaka.management.webService.constant.Utils.APP_ROOT;

@Api(APP_ROOT + "header/")
public interface HeaderAPI {
    @PostMapping(value = APP_ROOT + "header/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer un header", notes=" cette methode permet d'enregistrer et modifier un header",response = HeaderDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'object Header a ete bien crée ou modifer")
    })
    HeaderDAO save(@RequestBody HeaderDAO headerDAO);
    @GetMapping(value = APP_ROOT+"header/findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un header", notes=" cette methode permet de rechercher un header par son ID",response = HeaderDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "le header a ete trouvé dans la base de donnée"),
            @ApiResponse(code=404,message = "aucun  header trouvé dans la base de donnée")
    })
    HeaderDAO findById(@PathVariable("id") Integer id);
}
