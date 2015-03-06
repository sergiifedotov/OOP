package hw8.taxi.service;

import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthorizationException;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by vladimir on 03.03.2015.
 *
 * Реализовать авторизацию пользователя системы (оператора).
 Пользователь вводит:
 - логин (должен быть не менее 4 символов, не должен содержать пробелы)
 - идентификационный номер (10 цифр, без букв и других знаков)
 - пароль (должен быть не менее 8 символов,
 включать большие и маленькие буквы, цифры, должен совпадать с подтверждением)
 - подтверждение пароля
 - пользователь с таким логином должен быть уникальным

 hw8.taxi.service.AuthorizationService
 boolean register(String login, String id, String pass) throws AuthorizationException

 */
public class AuthorizationServiceImpl implements AuthorizationService {

    public static AuthorizationService authorizationService = new AuthorizationServiceImpl();

    private ArrayList<Operator> operators = new ArrayList<>();

    public AuthorizationServiceImpl() {
    }

    public AuthorizationServiceImpl(ArrayList<Operator> operators) {
        this.operators = operators;
    }

    @Override
    public boolean register(String login, String accessId, String password) throws AuthorizationException {
        if (login == null || login.length() < 4) {
            throw new AuthorizationException("логин должен быть не менее 4 символов");
        }
        if (login.contains(" ")) {
            throw new AuthorizationException("логин не должен содержать пробелы");
        }
        if (getOperatorByLogin(login) != null) {
            throw new AuthorizationException("логин \"" + login + "\" уже существует");
        }
        if (accessId == null || !accessId.matches("^[0-9]*.{10}$")) {
            throw new AuthorizationException("идентификационный номер должен быть из 10 цифр, без букв и других знаков");
        }
        if (password == null || password.length() < 8) {
            throw new AuthorizationException("пароль должен быть не менее 8 символов");
        }
        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$")) {
            throw new AuthorizationException("пароль должен включать большие и маленькие буквы, цифры");
        }
        Long id = operators.size() + 1L;
        Date expireDate = new Date();
        Long monthMilliseconds = 1000L * 60 * 60 * 24 * 31;
        expireDate.setTime(expireDate.getTime() + monthMilliseconds); // todo
        boolean locked = false;
        Operator operator = new Operator(id, login, accessId, password, expireDate, locked);
        operators.add(operator);
        System.out.println(operator);
        return true;
    }

    public ArrayList<Operator> getOperators() {
        return operators;
    }

    public void setOperators(ArrayList<Operator> operators) {
        this.operators = operators;
    }

    @Override
    public Operator getOperatorByLogin(String login) {
        for (Operator operator : operators) {
            if (operator.getLogin().equals(login)) {
                return operator;
            }
        }
        return null;
    }
}
