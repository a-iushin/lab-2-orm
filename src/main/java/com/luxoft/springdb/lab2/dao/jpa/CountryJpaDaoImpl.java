package com.luxoft.springdb.lab2.dao.jpa;

import com.luxoft.springdb.lab2.dao.CountryDao;
import com.luxoft.springdb.lab2.model.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

    @Override
    public void save(Country country) {
        EntityManager em = entityManagerFactory.createEntityManager();
        if (em != null) {
            em.getTransaction().begin();
            em.persist(country);
            em.getTransaction().commit();
        } else System.out.println("Can't create Entity Manager");
    }

    @Override
    public List<Country> getAllCountries() {
        EntityManager em = entityManagerFactory.createEntityManager();
        return Optional.ofNullable(em.createQuery("select c from Country c", Country.class).getResultList())
                .orElse(Collections.emptyList());
    }

    @Override
    public Country getCountryByName(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        return Optional.ofNullable(
                (Country) em.createQuery("select c from Country c where c.name = :name")
                        .setParameter("name", name)
                        .getSingleResult())
                .orElse(null);
    }

}
