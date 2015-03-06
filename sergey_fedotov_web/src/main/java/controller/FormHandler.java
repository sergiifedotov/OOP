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
 * Created by warit on 01.03.2015.
 */
@WebServlet("/form")
public class FormHandler extends HttpServlet {

    private Map<String,String> loginMap = new HashMap<>();

    @Override
    public void init() throws ServletException {
        loginMap.put("login1","pass1");
        loginMap.put("login2","pass2");
        loginMap.put("login3","pass3");
        loginMap.put("login4", "pass5");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]> parametrs = request.getParameterMap();
        String login = parametrs.get("login")[0];
        String pass = parametrs.get("pass")[0];

        String result = loginMap.get(login);

        if (pass.equals(result)){
            request.setAttribute("list",loginMap.keySet().toArray());
            request.getRequestDispatcher("loginOk.jsp").forward(request,response);
        }else{
            request.setAttribute("errLogin",new String("error login!!!"));
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        //response.getWriter().print("Hi, " + login + "!");
    }

}
