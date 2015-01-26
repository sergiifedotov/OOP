package Weekend_3_1;

/**
 * Created by sanya on 24.01.2015.
 */
public class Threeton {
    private static Threeton[] instance = new Threeton[3];;
    private Threeton(){

    }

    public synchronized static Threeton getInstanse1(){
        if (instance[0] == null) {
                instance[0] = new Threeton();
            }

        return instance[0];
    }

    public synchronized static Threeton getInstanse2(){
        if (instance[1] == null) {
            instance[1] = new Threeton();
        }

        return instance[1];
    }

    public synchronized static Threeton getInstanse3(){
        if (instance[2] == null) {
            instance[2] = new Threeton();
        }

        return instance[2];
    }

}
