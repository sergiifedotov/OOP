package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 28.02.15
 */
@WebServlet("/lsrv")
public class LoginServer extends HttpServlet {

    Map<String, String> list = new HashMap<>();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        list.put("name1", "pass1");
        list.put("name2", "pass2");
        list.put("name3", "pass3");
        Map<String, String[]> parameterMap = request.getParameterMap();
        String login = parameterMap.get("login")[0];
        String password = parameterMap.get("password")[0];
        try {
            if (Auth(login, password)) {
//                request.setAttribute("key", new String("Wrong LOGIN / PASSWORD!"));
                request.setAttribute("list", list);
                request.getRequestDispatcher("logpwdok.jsp").forward(request, response);
            } else {

//                request.getRequestDispatcher("wronglogpwd.jsp").forward(request, response);
                request.setAttribute("key", new String("Wrong LOGIN / PASSWORD!"));
                request.getRequestDispatcher("index.jsp").forward(request, response);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean Auth(String login, String password) {
        if (password.equals(list.get(login))) {
            return true;
        } else {
            return false;
        }
    }
}


//    parameterMap = request.getParameterMap();
        /*Map<String, String[]> parameterMap=request.getParameterMap();
        response.getWriter().print("Hello, " + parameterMap.get("login"));*/
//            request.getRequestDispatcher("index.jsp").forward(request, response);
        
