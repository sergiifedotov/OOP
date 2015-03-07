package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by stan on 01.03.15.
 */
@WebServlet ("/login")
public class HiddenList extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws javax.servlet.ServletException, IOException{
        Map<String, String[]> parameterMap=req.getParameterMap();
        resp.getWriter().println("Hello, "+ parameterMap.get("login")[0]);


    }
}
