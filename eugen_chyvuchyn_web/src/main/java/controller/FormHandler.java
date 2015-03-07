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
 * Created by Chuvychin on 01.03.2015.
 */
@WebServlet("/form")
public class FormHandler extends HttpServlet {
    Map<String, String> list = new HashMap<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Map<String,String> list = new HashMap<>();
        list.put("n","k");
        list.put("name1","k");
        list.put("name2","k");
        list.put("name3","k");
        list.put("name4","k");

        Map<String, String[]> parameters = req.getParameterMap();

        if (parameters.get("login")[0].equals("n") && parameters.get("pass")[0].equals("p")){
            req.setAttribute("list",list);
            req.getRequestDispatcher("session16.jsp").forward(req,resp);
        } else{
            req.setAttribute("ключ", new String("WARNING!!!"));
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }



    }
}
