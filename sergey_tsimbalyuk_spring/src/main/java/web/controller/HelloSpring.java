package web.controller;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import web.dao.UserDao;
import web.domain.User;
import web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * UserDao: al1
 * Date: 9/8/13
 */

@WebServlet("/test")
public class HelloSpring extends HttpServlet {
    private WebApplicationContext context;
    UserService userService;
    UserDao userdao;
    @Override
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
//        userService = context.getBean(UserService.class);
        userdao = context.getBean(UserDao.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(context != null) {
            String message = (String) context.getBean("str");
            User usr = new User(request.getParameter("login"), request.getParameter("pass"));
//            userService.addUser(usr);
            userdao.create(usr);
//            response.getWriter().print(message);
            response.getWriter().print(message + " " + request.getParameter("login"));
        } else  {
            response.getWriter().print("Error: Context not found!");
        }   HttpSession session = request.getSession();
        if(session.isNew()) {
            response.getWriter().print(" new session");
        } else {
            response.getWriter().print(session.getId());
        }
    }


}
//@WebServlet("/hello")
//public class HelloSpring extends HttpServlet {
//    private WebApplicationContext context;
//
//    @Override
//    public void init() {
//        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        if (context != null) {
//            String message = (String) context.getBean("str");
//            response.getWriter().print(message + " " + request.getParameter("log"));
//        } else  {
//            response.getWriter().print("Error: Context not found");
//        }
//    }
//}
