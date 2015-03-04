package hw8.taxi.action;

import hw8.taxi.service.AuthenticationService;
import hw8.taxi.service.AuthenticationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by sanya on 03.03.2015.
 */
@WebServlet("/hw8Register")
public class RegisterServlet extends HttpServlet {

    private AuthenticationServiceImpl authenticationService ;


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        authenticationService = new AuthenticationServiceImpl();
        boolean flagWrongAuth = false;

        Map<String, String[]> map = request.getParameterMap();
        String newLogin = map.get("login")[0];
        String newPassword = map.get("password")[0];
        String newCofirmPassword = map.get("confirmPassword")[0];
        String newIdentNumber = map.get("ident")[0];

        if (authenticationService.getUsers().containsKey(newLogin)) {
            request.setAttribute("loginUsed", "Логин уже существует попробуйте другой!!");
            flagWrongAuth = true;
        }
        if ((newLogin.indexOf(" ") != -1) || (newLogin.length() <4 )) {
            request.setAttribute("wrongNewLogin", "Введен неправильный логин. Не меньше 4-х символов без пробелов!!");
            flagWrongAuth = true;
        }
        if (!passStringAndInt(newPassword) || newPassword.length()<8){
            request.setAttribute("wrongNewPass", "Не безопасный пароль. Пароль должен содержать цифры и буквы, должно быть не меньше 8 символов.");
            flagWrongAuth = true;
        }
        if (!stringIsInteger(newIdentNumber) || newIdentNumber.length()<10) {
            request.setAttribute("identNotInt","Неверный идентификационный номер. Не меньше 10 цывр без букв.!!");
            flagWrongAuth = true;
        }
        if (!newPassword.equals(newCofirmPassword)){
            request.setAttribute("wrongConfPass", "Пароль должен совпадать");
            flagWrongAuth = true;
        }

        if (flagWrongAuth) {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }

        System.out.println("Log - "+newLogin+"Length - "+newLogin.length());
        System.out.println(newLogin.indexOf(" "));
        System.out.println("pass - "+newPassword);
        System.out.println("confPass - "+newCofirmPassword);
        System.out.println("ident - "+newIdentNumber);

    }

    private boolean stringIsInteger(String str){
        if ((str == null) || (str.length() == 0)){
            return false;
        } else {
            char c;
            for (int i = 0; i < str.length(); i++){
                c = str.charAt(i);
                if (!((c >= '0') && (c <= '9'))){
                    return false;
                }
            }
            return true;
        }
    }

    private boolean passStringAndInt(String str){
        boolean charIsInt = false;
        boolean charIsStr = false;
        boolean rez = false;
        if (str != null) {
            char c;
            for (int i = 0; i < str.length(); i++) {
                c = str.charAt(i);
                if (!((c >= '0') && (c <= '9'))) {
                    charIsStr = true;
                } else {
                    charIsInt = true;
                }
            }
        }
        if (charIsInt && charIsStr){
            rez = true;
        }
        return rez;
    }


}
