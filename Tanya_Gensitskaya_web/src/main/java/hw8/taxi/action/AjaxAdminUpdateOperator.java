package hw8.taxi.action;

import hw8.taxi.dao.OperatorDaoImpl;
import hw8.taxi.domain.Operator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Tanya on 20.03.2015.
 */
@WebServlet("/ajaxAdminUpdateOperator")
public class AjaxAdminUpdateOperator extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        String idL = map.get("id")[0];
        Long id = Long.parseLong(idL);
        String login = map.get("login")[0];
        String password = map.get("password")[0];
        String confirmPassword = map.get("confirmPassword")[0];
        String idNumber = map.get("idNumber")[0];
        String isBlocked = map.get("isBlocked")[0];
        String isAdministrator = map.get("isAdministrator")[0];

        OperatorDaoImpl operatorDao = new OperatorDaoImpl();
        Operator operator = operatorDao.read(id);
        operator.setLogin(login);
        operator.setPassword(password);
        operator.setConfirmPassword(confirmPassword);
        operator.setIdNumber(idNumber);
        operator.setIsBlocked(isBlocked);
        operator.setIsAdministrator(isAdministrator);

        operatorDao.update(operator);

        response.getWriter().print("operator update successful");

    }
}

