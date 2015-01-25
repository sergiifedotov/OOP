package session6.strategy;

/**
 * Created by Yaroslav_Syrota on 25.01.2015.
 */
public class Stategy {
    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        WheelStrategy wheels = new WheelStrategy();
        SkiStrategy skies = new SkiStrategy();
        ParachuteStrategy parachute = new ParachuteStrategy();
        taxi.setStarategy(wheels);
        taxi.run();
        taxi.setStarategy(skies);
        taxi.run();
        taxi.setStarategy(parachute);
        taxi.run();
        taxi.setStarategy(wheels);
        taxi.run();
    }
}


class Taxi {
    private MoveStarategy starategy;

    public void run() {
        starategy.run();
    }

    public MoveStarategy getStarategy() {
        return starategy;
    }

    public void setStarategy(MoveStarategy starategy) {
        this.starategy = starategy;
    }
}

interface MoveStarategy {
    void run();
}

class WheelStrategy implements MoveStarategy {

    @Override
    public void run() {
        System.out.println("By wheels");
    }
}

class SkiStrategy implements MoveStarategy {

    @Override
    public void run() {
        System.out.println("By skies");
    }
}

class ParachuteStrategy implements MoveStarategy {

    @Override
    public void run() {
        System.out.println("By parachute");
    }
}
