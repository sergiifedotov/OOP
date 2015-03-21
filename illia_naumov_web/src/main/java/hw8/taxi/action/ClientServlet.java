package hw8.taxi.action;

import hw8.taxi.service.AuthenticationService;
import hw8.taxi.service.ClientService;
import hw8.taxi.service.ClientServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

/**
 * Created by illia_naumov on 10.03.2015.
 */
@WebServlet("/clientServlet")
public class ClientServlet extends HttpServlet{
    private ClientService clientService;

    @Override
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        clientService = webApplicationContext.getBean("clientServiceImpl", ClientService.class);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        Map<String, String[]> paramets = req.getParameterMap();
        int portion = Integer.parseInt(paramets.get("portionSize")[0]);

        ClientService clientsService = new ClientServiceImpl();
        clientsService.showClientsByPortion(portion);
        req.setAttribute("clientsportion", clientsService.showClientsByPortion(portion));
        try {
            req.getRequestDispatcher("clients.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
