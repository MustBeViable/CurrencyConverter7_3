package dao;

import entity.*;
import jakarta.persistence.EntityManager;

public class TransactionDao {
    public void persist(Transaction t) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }

    public Transaction find(int id) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        try {
            return em.find(Transaction.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
