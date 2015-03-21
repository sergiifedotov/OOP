package web.controller;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 9/8/13
 */
@WebServlet("/ajax")
public class AjaxHello extends HttpServlet {
    private WebApplicationContext context;

    @Override
    public void init() {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().print(request.getParameter("name"));
        /*if (context != null) {
            String message = (String) context.getBean("str");
            response.getWriter().print(message + " " + request.getParameter("log"));
        } else  {
            response.getWriter().print("Error: Context not found");
        }*/
    }
}
