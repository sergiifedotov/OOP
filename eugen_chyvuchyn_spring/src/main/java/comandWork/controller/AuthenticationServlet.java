package comandWork.controller;

import comandWork.domain.User;
import comandWork.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 9/8/13
 */
@WebServlet("/hello")
public class AuthenticationServlet extends HttpServlet {
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
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (context !=null){

            String message = (String) context.getBean("str");

            Map<String,String[]> parametrs = req.getParameterMap();
            String login = parametrs.get("login")[0];
            String pass = parametrs.get("password")[0];

            List<User> list = userService.findByNameAndPass(login, pass);

            if ( list.size()!= 0){

                req.getRequestDispatcher("dashboard.jsp").forward(req,resp);
            } else{

                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }



        }

    }
}
