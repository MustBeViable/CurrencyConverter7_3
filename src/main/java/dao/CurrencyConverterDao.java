package dao;

import entity.*;
import jakarta.persistence.EntityManager;

import model.CurrencyCode;

import java.util.List;

public class CurrencyConverterDao {

    public void persist(Currency curr) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(curr);
        em.getTransaction().commit();
    }

    public Currency find(CurrencyCode code) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        Currency curr = em.find(Currency.class, code.toString());
        return curr;
    }

    public List<Currency> findAll() {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        List<Currency> currencyList = em.createQuery("select c from Currency c").getResultList();
        return currencyList;
    }

    public void update(Currency curr) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.merge(curr);
        em.getTransaction().commit();
    }

    public void delete(Currency curr) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.remove(curr);
        em.getTransaction().commit();
    }

    public Currency getConvercionRate(CurrencyCode code) {
        try {
            EntityManager em = datasource.MariaDbJpaConnection.getInstance();
            Currency curr = em.createQuery(
                    "select c from Currency c where c.currencyCode = :code",
                    Currency.class).setParameter("code", code).getResultStream().findFirst().orElse(null);
            if (curr != null) {
                return curr;
            } else {
                System.out.println(code.toString());
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}