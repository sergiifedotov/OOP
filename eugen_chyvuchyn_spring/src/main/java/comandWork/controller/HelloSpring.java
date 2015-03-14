package web.controller;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import web.domain.User;
import web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 9/8/13
 */
@WebServlet("/hello")
public class HelloSpring extends HttpServlet {
    private WebApplicationContext context;
    UserService userService;
//    UserDao userDao;


    @Override
    public void init() {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        userService = context.getBean("userServiceImpl", UserService.class);
//      userDao = context.getBean(UserDao.class);
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        if (context != null) {
//            String message = (String) context.getBean("str");
//            response.getWriter().print(message + " " + request.getParameter("log"));
//        } else  {
//            response.getWriter().print("Error: Context not found");
//        }
//    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (context !=null){

            String message = (String) context.getBean("str");
            List<User> list = userService.findByNameAndPass(req.getParameter("login"), req.getParameter("pass"));

            if ( list.size()!= 0){
                resp.getWriter().print(message + " old " + req.getParameter("login"));
            } else{
                User tempBase = new User(req.getParameter("login"), req.getParameter("pass"));
                userService.add(tempBase);
                resp.getWriter().print(message + " new " + req.getParameter("login"));
            }



        }

    }
}
