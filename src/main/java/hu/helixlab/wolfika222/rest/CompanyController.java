package hu.helixlab.wolfika222.rest;

import hu.helixlab.wolfika222.dto.CompanyDto;
import hu.helixlab.wolfika222.services.CompanyService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Hp_Workplace on 2017. 07. 24..
 */
@Path("/company")
public class CompanyController {
    @EJB
    CompanyService companyService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CompanyDto> getAllCompany(){
        return companyService.getAllCompany();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCompany(CompanyDto companyDto){
        companyService.saveCompany(companyDto);
    }


}
