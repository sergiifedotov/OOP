//package controller;
//
//import hw8.taxi.domain.Client;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created with IntelliJ IDEA.
// * User: al1
// * Date: 28.02.15
// */
//@WebServlet("/serv")
//public class HelloServlet extends HttpServlet {
//    Map<Client> userMap = new HashMap<>();
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        userMap.put("Vasya", "111");
//        userMap.put("Petya", "222");
//        userMap.put("Kolya", "333");
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        String password = parameterMap.get("password")[0];
//        String user = parameterMap.get("name")[0];
//        if (userMap.containsKey(user) && userMap.get(user).equals(password)) {
//            request.setAttribute("name", user);
//            request.setAttribute("map", userMap);
//            request.getRequestDispatcher("welcome.jsp").forward(request, response);
//        } else {
//            request.getRequestDispatcher("index_example.jsp").forward(request, response);
//        }
//        // response.getWriter().print("Hello " + value);
//    }
//}
