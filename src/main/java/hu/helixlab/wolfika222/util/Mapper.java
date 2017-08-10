package hu.helixlab.wolfika222.util;


import hu.helixlab.wolfika222.dto.BeerDto;
import hu.helixlab.wolfika222.dto.CompanyDto;
import hu.helixlab.wolfika222.model.Beer;
import hu.helixlab.wolfika222.model.Company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hp_Workplace on 2017. 07. 06..
 */
public class Mapper {

    public static BeerDto mapBeerToBeerDto(Beer beer) {
        BeerDto beerDto = new BeerDto();
        beerDto.setBeerId(beer.getId());
        beerDto.setBeerName(beer.getBeerName());
        beerDto.setAlcoholPercent(beer.getAlcoholPercent());
        beerDto.setStartDate(beer.getStartDate());
        beerDto.setCompanyName(beer.getCompany().getCompanyName());

        return beerDto;
    }

    public static Beer mapDtoToBeer(BeerDto beerDto) {
        Beer beer = new Beer();
        beer.setBeerName(beerDto.getBeerName());
        beer.setAlcoholPercent(beerDto.getAlcoholPercent());
        beer.setStartDate(beerDto.getStartDate());
        return beer;
    }

    public static CompanyDto mapCompanyToCompanyDto(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setCompanyId(company.getId());
        companyDto.setCompanyName(company.getCompanyName());
        List<Beer> beerList = company.getBeerList();
        List<BeerDto> beerDtoList = new ArrayList<>();
        for (Beer beerItem : beerList) {
            beerDtoList.add(mapBeerToBeerDto(beerItem));
        }
        companyDto.setBeerList(beerDtoList);
        return companyDto;
    }

    public static Company mapDtoToCompany(CompanyDto companyDto) {
        Company company = new Company();
        company.setCompanyName(companyDto.getCompanyName());
        //company.setBeerList(companyDto.getBeerList());
        return company;
    }
}
