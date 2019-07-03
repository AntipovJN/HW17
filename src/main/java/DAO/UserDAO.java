package DAO;

import Entity.User;
import org.hibernate.Session;
import persistence.HibernateSessionFactoryUtil;
import java.util.List;

public class UserDAO {

    private static UserDAO userDAO;

    public static UserDAO instance() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    private UserDAO() {
    }

    public void addUserToDB(String login, String password) {
        if ((login == null) || (password == null) || (login.equals("")) || (password.equals(""))) {
            return;
        }
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = new User(login, password);
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public User getUserFromDB(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<User> users = session.createCriteria(User.class).list();
        for (User u : users) {
            if (u.getLogin().equals(user.getLogin())
                    && u.getPassword().equals(user.getPassword())) {
                session.close();
                return u;
            }
        }
        return null;
    }
}
