package Weekend_7_1;

/**
 * Created by sanya on 21.02.2015.
 */
public class Company {
    private Car car;
    private Man direktor;
    private Double fond;

    public Company() {
    }

    public Company(Car car, Man direktor) {
        this.car = car;
        this.direktor = direktor;
    }

    public Company(Car car, Man direktor, Double fond) {
        this.car = car;
        this.direktor = direktor;
        this.fond = fond;
    }



    @Override
    public String toString() {
        return "Company{"+"car=" + car +", director=" + direktor +", fond="+fond+'}';
    }
}
