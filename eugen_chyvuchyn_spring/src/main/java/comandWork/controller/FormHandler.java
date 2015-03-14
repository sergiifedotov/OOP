package comandWork.controller;

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
 *
 */
@WebServlet("/form")
public class FormHandler extends HttpServlet {

    private WebApplicationContext context;
    UserService userService;

    @Override
    public void init() {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        userService = context.getBean("userServiceImpl", UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if (context !=null){

            String message = (String) context.getBean("str");

            Map<String,String[]> parametrs = req.getParameterMap();
            String login = parametrs.get("login")[0];
            String pass = parametrs.get("pass")[0];

            List<User> list = userService.findByNameAndPass(login, pass);

            request.setAttribute("list",list);

        }
        else{
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }

    }

}
