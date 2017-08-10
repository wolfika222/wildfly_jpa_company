package hu.helixlab.wolfika222.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Hp_Workplace on 2017. 07. 05..
 */
@Entity
@Table(name = "COMPANY")
@NamedQueries({
        @NamedQuery(name = Company.GET_ALL_COMPANY, query = "select c from Company c"),
        @NamedQuery(name = Company.GET_COMPANY_BY_ID, query = "select c from Company c where c.id=:companyId ")
})
@Data
public class Company {

    public static final String GET_ALL_COMPANY = "getAllCompany";
    public static final String GET_COMPANY_BY_ID = "getCompanyById";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String companyName;
    @OneToMany
    private List<Beer> beerList;
}
