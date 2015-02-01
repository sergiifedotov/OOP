package hw2.park;

/**
 * Created by sanya on 19.01.2015.
 */
public class Car {
    private String marka;
    private String color;
    private String number;

    public Car(){}

    public Car(String marka, String color, String number){
        this.marka = marka;
        this.color = color;
        this.number = number;
    }

    public String getMarka(){ return(marka); }
        public void setMarka(String marka){ this.marka = marka; }
    public String getColor(){ return(color); }
        public void setColor(String color){ this.color = color; }
    public String getNumber(){ return(number); }
        public void setNumber(String number){ this.number = number; }

}
