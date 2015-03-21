package web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by tsv on 15.03.15.
 */
@WebServlet("/ajaxauth")
public class ajaxAuth extends HttpServlet {
    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
//        String msgOk = "login ok";
//        String msgNotOk = "login/pwd is wrong";
        if ((login.equals("log")) && (password.equals("pwd"))) {
//            request.setAttribute(msgOk);
            response.getWriter().print("login ok");
        } else {
//            request.setAttribute(msgNotOk);
            response.getWriter().print("login/pwd is wrong");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }
    public void destroy() {

    }
}
