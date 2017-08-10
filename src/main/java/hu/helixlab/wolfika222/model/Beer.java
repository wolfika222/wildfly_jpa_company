package hu.helixlab.wolfika222.model;

/**
 * Created by Hp_Workplace on 2017. 07. 05..
 */

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BEER")
@NamedQueries(
        {
                @NamedQuery(name = Beer.GET_ALL_BEER, query = "SELECT b FROM Beer b"),
                @NamedQuery(name = Beer.GET_BEER_BY_ID, query = "select b from Beer b where b.id=:beerId")
        })

@Data
public class Beer {

    public static final String GET_ALL_BEER = "getAllBeer";
    public static final String GET_BEER_BY_ID = "getBeerById";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String beerName;
    private Double alcoholPercent;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @ManyToOne
    private Company company;

}
