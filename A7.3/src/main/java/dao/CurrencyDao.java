package dao;

import entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class CurrencyDao {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CompanyMariaDbUnit");

    public List<Currency> getAllCurrencies() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Currency c", Currency.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Currency getCurrency(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Currency.class, id);
        } finally {
            em.close();
        }
    }

    public void persist(Currency curr) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(curr);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public void update(Currency curr) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(curr);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public void delete(Currency curr) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Currency attached = em.contains(curr) ? curr : em.merge(curr);
            em.remove(attached);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public static void closeFactory() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}