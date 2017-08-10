package hu.helixlab.wolfika222.dao;

import hu.helixlab.wolfika222.model.Company;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Hp_Workplace on 2017. 07. 06..
 */
@Stateless
public class CompanyDao {

    @PersistenceContext
    EntityManager em;

    public void saveCompany(Company company) {
        em.persist(company);
    }

    public List<Company> getAllCompany() {
        Query query = em.createNamedQuery(Company.GET_ALL_COMPANY);
        return query.getResultList();
    }

    public Company getCompanyById(Long id){
        Query query = em.createNamedQuery(Company.GET_COMPANY_BY_ID).setParameter("companyId", id);
        return (Company) query.getSingleResult();
    }
}
