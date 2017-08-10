package hu.helixlab.wolfika222.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by Hp_Workplace on 2017. 07. 06..
 */
@Data
public class BeerDto {

    private Long beerId;
    private String beerName;
    private Double alcoholPercent;
    private Date startDate;
    private String companyName;
}
