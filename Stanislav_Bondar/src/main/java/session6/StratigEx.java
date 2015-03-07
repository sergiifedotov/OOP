package session6;

/**
 * Created by stan on 25.01.15.
 */
public class StratigEx {
    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        WheelStrategy wheels = new WheelStrategy();
        SkiStrategy skies = new SkiStrategy();
        JumpStrategy jump = new JumpStrategy();
        taxi.setStrategy(wheels);
        taxi.run();
        taxi.setStrategy(skies);
        taxi.run();
        taxi.setStrategy(jump);
        taxi.run();
    }
}
class Taxi{
    private MoveStrategy strategy;

    public void run(){
        strategy.run();
    }
    public MoveStrategy getStrategy(){
        return strategy;
    }

    public void setStrategy (MoveStrategy strategy){
        this.strategy = strategy;
    }
}

interface MoveStrategy{
    void run();
}



class WheelStrategy implements MoveStrategy{
    @Override
    public void run(){
        System.out.println("By wheels");
    }
}
class SkiStrategy implements MoveStrategy {
    @Override
    public void run(){
        System.out.println("By skies");
    }
}
class JumpStrategy implements MoveStrategy{
    @Override
    public void run(){
        System.out.println("I believe I can fly!!! I believe I can touch the sky!!!");
    }
}