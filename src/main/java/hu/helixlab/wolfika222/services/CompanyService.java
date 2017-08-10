package hu.helixlab.wolfika222.services;

import hu.helixlab.wolfika222.dao.CompanyDao;
import hu.helixlab.wolfika222.dto.CompanyDto;
import hu.helixlab.wolfika222.model.Company;
import hu.helixlab.wolfika222.util.Mapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Hp_Workplace on 2017. 07. 24..
 */
@Stateless
public class CompanyService {
    @EJB
    CompanyDao companyDao;

    public void saveCompany(CompanyDto companyDto) {
        Company company = Mapper.mapDtoToCompany(companyDto);
        companyDao.saveCompany(company);
    }

    public CompanyDto getCompanyDtoById(Long id) {
        Company companyById = companyDao.getCompanyById(id);
        return Mapper.mapCompanyToCompanyDto(companyById);
    }

    public List<CompanyDto> getAllCompany() {
        return companyDao.getAllCompany().stream()
                .map(Mapper::mapCompanyToCompanyDto)
                .collect(Collectors.toList());
    }
}
