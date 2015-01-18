package Weekend_1_HW;

import java.util.ArrayList;

/**
 * Created by sanya on 14.01.2015.
 */
public class ArrayListInt extends ArrayList
{

    ArrayList<Integer> arrayListInt = new ArrayList<Integer>();

    public void createArrayListInt(int in)
    {
        int index = 0;

        Long timeStartArrayListInt = System.nanoTime();
        for (int i = 0; i < 60000; i++)
        {
            if (in == 1){index = arrayListInt.size()/2;}
            else if (in == 2) {index = 0;}
            else if (in == 3)
            {
                if (arrayListInt.size()!=0){index = arrayListInt.size()-1;}
            }
            int obj = (int) (Math.random() * 10);
            arrayListInt.add(index, obj);
        }
        Long timeFinishArrayListInt = System.nanoTime();
        System.out.println("Time operating ArrayListInt : " + ((timeFinishArrayListInt - timeStartArrayListInt)/1000));
        //System.out.println("---------------------------------");
    }


}
