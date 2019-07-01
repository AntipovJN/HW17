package Service;

import Entity.User;

public class AccountService {

    private User user;
    private boolean isLogin;
    private static AccountService accountService;

    public static AccountService instance() {
        if (accountService == null) {
            accountService = new AccountService();
        }
        return accountService;
    }

    private AccountService() {
    }

    public boolean signIn(String login, String pass) {
        if(user!=null) {
            if(login.equals(user.getLogin())){
                isLogin = true;
            }
        }
    return isLogin;
    }

    public void signUp(String login, String pass) {
        user = new User(login,pass);
    }

    public User getUser() {
        return user;
    }
}
