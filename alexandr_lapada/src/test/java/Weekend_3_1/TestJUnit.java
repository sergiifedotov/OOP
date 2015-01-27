package Weekend_3_1;

import org.junit.Test;

/**
 * Created by sanya on 24.01.2015.
 */
public class TestJUnit {
    @Test
    public void testInstance(){
        Threeton triton1 = Threeton.getInstanse1();
        Threeton triton2 = Threeton.getInstanse2();
        Threeton triton3 = Threeton.getInstanse3();

        if (triton1 != triton2 && triton2 != triton3 && triton1 != triton3){
            System.out.println("test ok");
        }

    }
}
