package hu.helixlab.wolfika222.dao;

import hu.helixlab.wolfika222.model.Beer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Hp_Workplace on 2017. 07. 06..
 */
@Stateless
public class BeerDao {
    @PersistenceContext
    EntityManager em;

    public void saveBeer(Beer beer){
        em.persist(beer);
    }

    public List<Beer> getAllBeers(){
        Query query = em.createNamedQuery(Beer.GET_ALL_BEER);
        return query.getResultList();
    }

    public Beer getBeerById(Long id){
        Query query = em.createNamedQuery(Beer.GET_BEER_BY_ID).setParameter("beerId", id);
        return (Beer) query.getSingleResult();
    }
}
