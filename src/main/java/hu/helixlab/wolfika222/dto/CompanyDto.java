package hu.helixlab.wolfika222.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by Hp_Workplace on 2017. 07. 24..
 */
@Data
public class CompanyDto {

    private Long companyId;
    private String companyName;
    private List<BeerDto> beerList;
}
