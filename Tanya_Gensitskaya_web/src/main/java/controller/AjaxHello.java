package session11;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 9/8/13
 */
@WebServlet("/ajaxold")
public class AjaxHello extends HttpServlet {
//    private WebApplicationContext context;

    @Override
    public void init() {
//        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "{\"name\":\"ajax\",\"nickname\":\"a1\"}";
        response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("name", "Ajax");
            jsonObj.put("nickname", "al1");
        } catch (JSONException e) {
            e.printStackTrace();
        }
//            System.out.println(jsonObj.get("message"));
//            JSONObject obj = new JSONObject();
//            obj.put("message", "hello from server");
        response.getWriter().print(jsonObj.toString());
    }
}
