package hw2.hash;
import java.util.*;
/**
 * Created by sanya on 21.01.2015.
 */
public class HashMap {
    private int[] key;
    private User[] value;
    private final int ARRAYLENGTH = 2;

    public HashMap(){
        key = new int[ARRAYLENGTH];
        value = new User[ARRAYLENGTH];
    }


    public boolean put(User elem){
        boolean out = false;
        //System.out.println(key.length);
        int hash = elem.hashCode();
       if (hash<0){hash = hash*-1;}
        while(hash >= value.length){resize();}
        //System.out.println(key.length);
        if(value[hash] == null){
            value[hash] = elem;
            key[hash] = hash;
            out =true;
        }else{
            value[hash] = elem;
            out = false;
        }
        return out;
    }

    public int size(){return value.length;}

    private void resize(){
        int[] keyOld = key;
        User[] valueOld = value;
        key = new int[keyOld.length*2];
        value = new User[valueOld.length*2];
        int i = 0;
        for(int e: keyOld){
            key[i] = e;
            i++;
        }
        i = 0;
        for(User e: valueOld){
            value[i] = e;
            i++;
        }
    }

    public boolean remove(User elem){
        boolean out = false;
        int hash = elem.hashCode();
        if (value[hash] == null){
            out = false;
        }else{
            value[hash] = null;
            key[hash] = 0;
            out = true;
        }
        return out;
    }

    public boolean contains(User elem){
        boolean out = false;
        for(int i = 0; i < value.length; i++){
            if(value[i] != null && elem != null) {
                if (elem.equals(value[i])) {
                    out = true;
                }
            }
        }
        return out;
    }

    public void iterator(){
        for( int i = 0; i < key.length; i++){
            if (key[i] !=0 ){
                System.out.println("key="+key[i]+" value="+value[i].getLogin());
            }
        }

    }





}
