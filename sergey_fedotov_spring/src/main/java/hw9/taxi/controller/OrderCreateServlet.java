package hw9.taxi.controller;

import hw9.taxi.exception.OrderException;
import hw9.taxi.service.OrderService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *
 */
@WebServlet("/orderCreate")
public class OrderCreateServlet extends HttpServlet {

    private WebApplicationContext context;

    @Override
    public void init() {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }


    private Date scanDate(String str) {
        final String DATE_FORMAT = "mm.dd.yyyy";
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        try {
            date = sdf.parse(str);
        } catch (ParseException pe) {
        }

        return date;
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (context != null) {


            Map<String,String[]> parametrs = req.getParameterMap();

            Date date = scanDate(parametrs.get("date")[0]);
            String client = parametrs.get("client")[0];
            String amount = parametrs.get("sum")[0];
            String addressFrom = parametrs.get("addressFrom")[0];
            String addressTo = parametrs.get("addressTo")[0];


            /*OrderService orderService = (OrderService) context.getBean("orderServiceImpl");
            String err = "";
            boolean createOK = false;
            try {
                createOK = orderService.createOrder(System.currentTimeMillis(), client, amount, addressFrom, addressTo);
            } catch (OrderException e) {
                err = e.getMessage();
            }

            if (createOK) {
                resp.getWriter().print("Hello " + req.getParameter("log"));
                req.setAttribute("rezult", "create new client");
                req.getRequestDispatcher("registerClient.jsp").forward(req, resp);

            } else {
                req.setAttribute("rezult", err);
                req.getRequestDispatcher("registerClient.jsp").forward(req, resp);
            }*/

        } else {
            req.setAttribute("rezult", "error context!!!");
            req.getRequestDispatcher("registerClient.jsp").forward(req, resp);
        }

    }

}
