package servlets;

import Service.AccountService;
import templater.PageGenerator;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class SignUpServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        HashMap<String, Object> data = new HashMap<>();
        data.put("process", "signup");
        response.getWriter().println(PageGenerator.instance().getPage("authorization", data));
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        AccountService.instance().signUp(request.getParameter("login"), request.getParameter("password"));
        response.sendRedirect("/");
    }
}
