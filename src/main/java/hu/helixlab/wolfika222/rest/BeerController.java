package hu.helixlab.wolfika222.rest;

import hu.helixlab.wolfika222.dto.BeerDto;
import hu.helixlab.wolfika222.services.BeerService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Hp_Workplace on 2017. 07. 06..
 */
@Path("/beer")
public class BeerController {
    @EJB
    BeerService beerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BeerDto> getAllBeers() {
        return beerService.getAllBeers();

    }
}
