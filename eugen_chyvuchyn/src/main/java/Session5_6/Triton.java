package Session5_6;

/**
 * Created by Chuvychin on 24.01.2015.
 * написать триплтон (три обьекта)
 */
public class Triton {
    private static Triton tritonFirst;
    private static Triton tritonSecond;
    private static Triton tritonThird;
    private static int count;

    private Triton(){
        count++;
    }

    public synchronized static Triton getTritonFirst(){
        if (tritonFirst == null){
            tritonFirst = new Triton();
        }
        return tritonFirst;
    }
    public synchronized static Triton getTritonSecond(){
        if (tritonSecond == null){
            tritonSecond = new Triton();
        }
        return tritonSecond;
    }
    public synchronized static Triton getTritonThird(){
        if (tritonThird == null){
            tritonThird = new Triton();
        }
        return tritonThird;
    }
}
