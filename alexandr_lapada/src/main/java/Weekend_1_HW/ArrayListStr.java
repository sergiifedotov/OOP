package Weekend_1_HW;

import java.util.ArrayList;

/**
 * Created by sanya on 14.01.2015.
 */
public class ArrayListStr
{
    ArrayList<String> arrayListStr = new ArrayList<String>();

    public void createArrayListStr(int in)
    {
        int index = 0;

        Long timeStartArrayListStr = System.nanoTime();
        String obj = "aaa";
        for (int i = 0; i < 60000; i++)
        {
            if (in == 1){index = arrayListStr.size()/2;}
            else if (in == 2) {index = 0;}
            else if (in == 3)
            {
                if (arrayListStr.size()!=0){index = arrayListStr.size()-1;}
            }
            arrayListStr.add(index, (String)(obj));
        }
        Long timeFinishArrayListStr = System.nanoTime();
        System.out.println("Time operating ArrayListStr : " + ((timeFinishArrayListStr - timeStartArrayListStr)/1000));
        //System.out.println("---------------------------------");
    }


}
