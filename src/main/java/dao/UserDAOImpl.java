package dao;

import model.Auto;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateSessionFactoryUtil;

import java.util.List;

public class UserDAOImpl {

    public User findById(int id) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public Auto getAutoById(int id) {
        Session session =  HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Auto auto = session.get(Auto.class, id);
        session.close();

        return auto;
    }

    public List<User> getAll() {
         Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();

         Query query = session.createQuery("FROM User");
         List users = query.list();
         session.close();

         return users;
    }

    public List<Auto> getAllAutoByUserId(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Auto WHERE user.id = :id");
        query.setParameter("id", id);
        List autos = query.list();
        session.close();

        return autos;
    }

}
