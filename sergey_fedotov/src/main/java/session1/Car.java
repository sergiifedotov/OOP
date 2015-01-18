package session1;

public class Car {
    private String number;
    private String marka;
    private String color;

    public static void main(String[] args) {

    }

    public Car(String number, String marka, String color){
        this.number = number;
        this.marka = marka;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getMarka() {
        return marka;
    }

    /*@Override
    public boolean equals(Object obj){




        return false;
    }*/
}
