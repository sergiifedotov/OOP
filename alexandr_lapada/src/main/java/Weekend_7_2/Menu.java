package Weekend_7_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sanya on 22.02.2015.
 */

@Controller
public class Menu {
    private Scanner scan = new Scanner(System.in);
    private Integer choose;

    @Autowired
    private ServiceRegion serviceRegion;

    public void main() {
        System.out.println("1-Show all regions");
        choose = scan.nextInt();
        if (choose == 1){
            showAllRegions();
        }
    }


    private void showAllRegions(){
        ArrayList<Region> list = (ArrayList<Region>)serviceRegion.findAll();
        for(int i = 0; i < list.size(); i++){
            System.err.println(list.get(i));
        }
    }
}
