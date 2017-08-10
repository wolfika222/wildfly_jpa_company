package hu.helixlab.wolfika222.ws;

import hu.helixlab.wolfika222.dto.CompanyDto;
import hu.helixlab.wolfika222.dto.GetCompanyByNameWSRequest;
import hu.helixlab.wolfika222.dto.GetCompanyByNameWSResponse;
import hu.helixlab.wolfika222.services.CompanyService;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Hp_Workplace on 2017. 07. 24..
 */
@WebService
public class CompanyWs {
    @EJB
    CompanyService companyService;

    @WebMethod
    public GetCompanyByNameWSResponse getCompanyByNameWs(GetCompanyByNameWSRequest request){
        GetCompanyByNameWSResponse response = new GetCompanyByNameWSResponse();
        response.setCompanyDto(companyService.getCompanyDtoById(request.getCompanyName());
        return response;
    }

    @WebMethod
    public void saveCompany(CompanyDto companyDto){
        companyService.saveCompany(companyDto);
    }

    @WebMethod
    public List<CompanyDto> getAllCompanyWs(){
        return companyService.getAllCompany();
    }
}
