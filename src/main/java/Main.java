import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.MainPageServlet;
import servlets.MirrorServlet;
import servlets.SignInServlet;
import servlets.SignUpServlet;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class Main {
    public static void main(String[] args) throws Exception {
        MirrorServlet mirrorServlet = new MirrorServlet();
        MainPageServlet mainPageServlet = new MainPageServlet();
        SignInServlet signInServlet = new SignInServlet();
        SignUpServlet signUpServlet = new SignUpServlet();
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(mainPageServlet),"/");
        context.addServlet(new ServletHolder(mirrorServlet),"/mirror");
        context.addServlet(new ServletHolder(signInServlet),"/signIn");
        context.addServlet(new ServletHolder(signUpServlet),"/signUp");

        Server server = new Server(8080);
        server.setHandler(context);
        server.start();
        System.out.println("Server started");
        server.join();
    }
}
