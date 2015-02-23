package session14.hi.view;

import session14.hi.service.CompanyService;
import session14.hi.service.CompanyServiceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Sergey Tsimbalyuk
 * on 22.02.15.
 */
public class Menu {

    private BufferedReader reader;
    private CompanyService service;

    private String[] nameMenuItem = {
            "EXIT",
            "ADD NEW EMPLOYEE",
            "SHOW DEP LIST",
            "SHOW EMP LIST"
    };

    public Menu() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        service = new CompanyServiceImpl();

    }

    /*public Menu(BufferedReader reader, CompanyService service) {
        this.reader = reader;
        this.service = service;
    }*/
}
