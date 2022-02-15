package pl.edu.wszib.power.tool.rental.database.implementation.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.power.tool.rental.database.IUserDAO;
import pl.edu.wszib.power.tool.rental.model.User;

import javax.persistence.NoResultException;
import java.util.Optional;

@Repository
public class UserDAO implements IUserDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Optional<User> getUserByLogin(String login) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.edu.wszib.power.tool.rental.model.User WHERE login = :login");
        query.setParameter("login", login);
        try {
            User user = query.getSingleResult();
            session.close();
            return Optional.of(user);
        } catch (NoResultException e) {
            session.close();
            return Optional.empty();
        }
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(user);
            tr.commit();
        } catch (Exception e) {
            if(tr != null) {
                tr.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<User> getUserById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.edu.wszib.power.tool.rental.model.User WHERE id = :id");
        query.setParameter("id", id);
        try {
            User user = query.getSingleResult();
            session.close();
            return Optional.of(user);
        } catch (NoResultException e) {
            session.close();
            return Optional.empty();
        }
    }

    @Override
    public void updateUser(User user) {
        System.out.println(user.getId());
        Session session = this.sessionFactory.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.update(user);
            tr.commit();
        } catch (Exception e) {
            if(tr != null) {
                tr.rollback();
            }
        } finally {
            session.close();
        }
    }
}
