package Service;

import DAO.UserDAO;
import Entity.User;

public class AccountService {

    private User user;
    private boolean isLogin;
    private static AccountService accountService;
    private UserDAO userDAO= UserDAO.instance();

    public static AccountService instance() {
        if (accountService == null) {
            accountService = new AccountService();
        }
        return accountService;
    }

    private AccountService() {
    }

    public boolean signIn(String login, String pass) {
       user = userDAO.getUserFromDB(new User(login,pass));
       if(user!=null) {
           isLogin = true;
        }
    return isLogin;
    }

    public void signUp(String login, String pass) {
        userDAO.addUserToDB(login,pass);
        user = new User(login,pass);
    }

    public User getUser() {
        return user;
    }
}
