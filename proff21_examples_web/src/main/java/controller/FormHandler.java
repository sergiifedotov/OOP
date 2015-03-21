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
 * Date: 01.03.15
 */
@WebServlet("/form")
public class FormHandler extends HttpServlet {
    private Map<String, String> users = new HashMap<>();

    @Override
    public void init() throws ServletException {
        users.put("Samuel", "Marshak") ;
        users.put("Shura", "Balaganov") ;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Map<String, String[]> parameters = req.getParameterMap();
        String value = parameters.get("login")[0];
        resp.getWriter().print(value);
    }
}
