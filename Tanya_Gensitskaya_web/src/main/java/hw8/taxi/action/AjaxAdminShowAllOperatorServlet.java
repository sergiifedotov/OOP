package hw8.taxi.action;


import hw8.taxi.dao.OperatorDaoImpl;
import hw8.taxi.domain.Operator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Tanya on 19.03.2015.
 */

@WebServlet("/ajaxAdminShowAllOperatorServlet")
public class AjaxAdminShowAllOperatorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OperatorDaoImpl operatorDao = new OperatorDaoImpl();
        List<Operator> list = operatorDao.findAll();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            Operator operator = list.get(i);
            Long idL = operator.getId();
            String idS = idL+"";

            String login = operator.getLogin();
            String password = operator.getPassword();
            String confirmPassword = operator.getConfirmPassword();
            String idNumber = operator.getIdNumber();
            String isBlocked = operator.getIsBlocked();
            String isAdministrator = operator.getIsAdministrator();

            sb.append(idS).append(" +");
            sb.append(login).append(" +");
            sb.append(password).append(" +");
            sb.append(confirmPassword).append(" +");
            sb.append(idNumber).append(" +");
            sb.append(isBlocked).append(" +");
            sb.append(isAdministrator).append(" +");
        }
        response.getWriter().print(sb);
    }
}