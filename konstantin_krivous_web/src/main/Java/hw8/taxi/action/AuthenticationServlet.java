package hw8.taxi.action;

import hw8.taxi.domain.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Оператор вводит логин и пароль.
 Если пароль с логином не совпадает то повторить ввод. Передача осуществляется методом POST.
 Колличество попыток ввода задается в properties файле. После последней неудачной попытки пользователь блокируется.
 Время действия пароля задается в сервисе
 После истечения действия пароля, пользователь должен поменять пароль. Предыдущий вводить нельзя
 */

@WebServlet("/authentication")
public class AuthenticationServlet extends HttpServlet {

    List<Client> client = new ArrayList<>();


    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> parameter = request.getParameterMap();
        String log = parameter.get("login")[0];
        String pas = parameter.get("password")[0];

        if(log.equals("kostya") && pas.equals("123")){
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

}
