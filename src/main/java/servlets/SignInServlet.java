package servlets;

import Service.AccountService;
import templater.PageGenerator;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class SignInServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        HashMap<String, Object> data = new HashMap<>();
        data.put("process", "signIn");
        response.getWriter().println(PageGenerator.instance().getPage("authorization", data));

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        if(AccountService.instance().signIn(request.getParameter("login"), request.getParameter("pass"))) {
            response.setStatus(200);
            response.getWriter().println("Authorized: " + AccountService.instance().getUser().getLogin());
        }else{
            response.setStatus(401);
            response.getWriter().println("Unauthorized");
        }

    }
}
