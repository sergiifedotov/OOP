package web.controller;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import web.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 9/8/13
 */
@WebServlet("/helloSpring")
public class HelloSpring extends HttpServlet {
    private WebApplicationContext context;
    private EmployeeDao employeeDao;


    @Override
    public void init() {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        employeeDao = context.getBean("employeeDaoImpl", EmployeeDao.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (context != null) {
            String log = request.getParameter("login");
            String pass = request.getParameter("password");
            HttpSession session;
//            if (log.equals("111") && pass.equals("111")) {
//                session = request.getSession();
//                // session.setAttribute("log", log);
//                session.setMaxInactiveInterval(10);
//                request.getRequestDispatcher("hello.jsp").forward(request, response);
//            } else {
//                request.getRequestDispatcher("index_taxi.jsp").forward(request, response);
//            }

            String message = (String) context.getBean("str");
            response.getWriter().print(message + " " + request.getParameter("log"));


            List list = employeeDao.findAll();
            System.out.println(list);

        } else  {
            response.getWriter().print("Error: Context not found");
        }
    }

}
