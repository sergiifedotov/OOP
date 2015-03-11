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
 * Created by Konstantin on 01.03.2015.
 */
//
//@WebServlet ("/authentication")
//public class FormHandler extends HttpServlet{
//
//    @Override
//    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//
//        Map<String, String[]> parametre = request.getParameterMap();
//        String log = parametre.get("login")[0];
//        String pass = parametre.get("password")[0];
//
//        if(log.equals("kostya") && pass.equals("123")){
//            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
//        }else{
//            request.getRequestDispatcher("index.jsp").forward(request, response);
//        }
//
//
//
//
//    }
//}
