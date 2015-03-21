package web.login;

/**
 * Created by stan on 15.03.15.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String uname= request.getParameter("username");
        String psw= request.getParameter("password");

        if(uname.equals("petiaPiyatochkin") && psw.equals("petiaPiyatochkin "))
        {
            out.println("You have successfully logged in");
        }
        else
            out.println("either user name or password is invalid");
    }
}