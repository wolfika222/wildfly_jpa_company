package hu.helixlab.wolfika222.services;

import hu.helixlab.wolfika222.dao.BeerDao;
import hu.helixlab.wolfika222.dto.BeerDto;
import hu.helixlab.wolfika222.model.Beer;
import hu.helixlab.wolfika222.util.Mapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Hp_Workplace on 2017. 07. 06..
 */
@Stateless
public class BeerService {
    @EJB
    BeerDao beerDao;

    public void saveBeer(BeerDto beerDto) {
        Beer beer = Mapper.mapDtoToBeer(beerDto);
        beerDao.saveBeer(beer);
    }

    public BeerDto getBeerDtoById(Long id) {
        Beer beerById = beerDao.getBeerById(id);
        return Mapper.mapBeerToBeerDto(beerById);
    }

    public List<BeerDto> getAllBeers() {
        return beerDao.getAllBeers().stream()
                .map(Mapper::mapBeerToBeerDto)
                .collect(Collectors.toList());
    }

    public List<BeerDto> getAllBeersJava7() {
        List<Beer> allBeers = beerDao.getAllBeers();
        List<BeerDto> beerDtoList = new ArrayList<>();
        for (Beer beer : allBeers) {
            beerDtoList.add(Mapper.mapBeerToBeerDto(beer));
        }
        return beerDtoList;
    }
}
