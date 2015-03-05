package hw8.taxi.action;

import hw8.taxi.exception.AuthorizationException;
import hw8.taxi.exception.OrderException;
import hw8.taxi.service.AuthorizationService;
import hw8.taxi.service.AuthorizationServiceImpl;
import hw8.taxi.service.OrderService;
import hw8.taxi.service.OrderServiceImpl;

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
 * Created by warit on 01.03.2015.
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,String[]> parametrs = req.getParameterMap();

        Date date = scanDate(parametrs.get("date")[0]);
        String client = parametrs.get("client")[0];
        String amount = parametrs.get("sum")[0];
        String addressFrom = parametrs.get("addressFrom")[0];
        String addressTo = parametrs.get("addressTo")[0];


        OrderService orderService = new OrderServiceImpl();
        boolean ok = false;
        try {
            ok = orderService.createOrder(System.currentTimeMillis(), null, amount, addressFrom,addressTo);
        } catch (OrderException e) {
            e.printStackTrace();
        }

    }

}
