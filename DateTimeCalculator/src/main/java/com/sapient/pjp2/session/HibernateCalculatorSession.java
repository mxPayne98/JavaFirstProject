package com.sapient.pjp2.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class HibernateCalculatorSession implements CalculatorSession {
    private final SessionFactory sessionFactory;

    public HibernateCalculatorSession() {
        this.sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(DateTimeOperation.class)
                .addAnnotatedClass(OperationTransaction.class)
                .buildSessionFactory();
    }

    /**
     * Writes operations to DB.
     *
     * @param transaction The operation executed.
     */
    public void save(OperationTransaction transaction) {
        DateTimeOperation dateTimeOperation = new DateTimeOperation(transaction);
        try (Session session = this.sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(dateTimeOperation);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        // TODO
    }

    public List<DateTimeOperation> getHistory() {
        try (Session session = this.sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<DateTimeOperation> history = loadAllData(DateTimeOperation.class, session);
            session.getTransaction().commit();
            return history;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DateTimeOperation> getRecentHistory() {
        try (Session session = this.sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<DateTimeOperation> history = loadRecentData(DateTimeOperation.class, session);
            session.getTransaction().commit();
            return history;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DateTimeOperation lastOperation() {
        try (Session session = this.sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<DateTimeOperation> history = loadLastData(DateTimeOperation.class, session);
            session.getTransaction().commit();
            return history.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static <T> List<T> loadLastData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root);
        query.orderBy(builder.desc(root.get("id")));
        return session.createQuery(query).setMaxResults(1).getResultList();
    }

    private static <T> List<T> loadAllData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        query.from(type);
        return session.createQuery(query).getResultList();
    }

    private static <T> List<T> loadRecentData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root);
        query.orderBy(builder.desc(root.get("id")));
        return session.createQuery(query).setMaxResults(100).getResultList();
    }
}
