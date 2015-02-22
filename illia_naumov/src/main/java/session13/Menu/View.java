package session13.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import session13.Service.ServiceDao;
import session13.Service.ServiceDaoImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by illia_naumov on 22.02.2015.
 */

@Controller("view")
public class View {
    @Autowired
    ServiceDao serv;
    BufferedReader bf;

    public View() throws IOException {
        System.out.println("Type '1' to print all employees");
        bf = new BufferedReader(new InputStreamReader(System.in));
        int chose = Integer.parseInt(bf.readLine());
        if(chose == 1){

            serv.readAll();
        }
    }

    public void chose(){


    }

}
