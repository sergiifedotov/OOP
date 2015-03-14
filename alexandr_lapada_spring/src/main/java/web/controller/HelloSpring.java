package web.controller;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import web.dao.UserDao;
import web.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 9/8/13
 */
@WebServlet("/hello")
public class HelloSpring extends HttpServlet {
    private WebApplicationContext context;


    //@Autowired
    private UserDao userDao;

    @Override
    public void init() {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        //factory = (SessionFactory) context.getBean("factory");
        userDao = (UserDao) context.getBean("userDaoImpl");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        //if (session == null) {
            //request.getRequestDispatcher("index.jsp").forward(request, response);
            Map<String, String[]> mapRequest = request.getParameterMap();
            String login = mapRequest.get("login")[0];
            String password = mapRequest.get("pass")[0];
            String message = (String) context.getBean("str");
            boolean auth = false;

            ArrayList<User> list = (ArrayList<User>) userDao.findAll();
            System.err.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                User user = list.get(i);
                System.out.println(user.getLogin() + " " + user.getPass());
                if (user.getLogin().equals(login) && user.getPass().equals(password)) {
                    auth = true;
                    session = request.getSession();
                    session.setAttribute("sessionID", user.getId());
                    //session.setMaxInactiveInterval(10);
                    request.setAttribute("login",user.getLogin());
                    request.getRequestDispatcher("hello.jsp").forward(request, response);
                }
            }
            System.out.println(auth);
            if (!auth) {
                request.setAttribute("wrongAuth", "Wrong password or user");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        /*} else{
            request.setAttribute("login",session.getAttribute("sessionID"));
            request.getRequestDispatcher("hello.jsp").forward(request, response);
        }*/

        /*
        if (context != null) {
            String message = (String) context.getBean("str");
            response.getWriter().print(message + " " + request.getParameter("login"));
        } else  {
            response.getWriter().print("Error: Context not found");
        }
        */


    }
}
