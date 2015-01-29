package hw4.graph;

import java.util.Scanner;

public class GraphPresenter {

    private TypeFunction typeFunction;

    public void setTypeFunction(TypeFunction typeFunction) {
        this.typeFunction = typeFunction;
    }

    public void print() {
        typeFunction.print();
    }

}

interface TypeFunction {
    int BORDERGAP = 5;
    int TIMEOUT = 500;

    void print();
}

class Indent{

    public static String getIndent(int Indent, String str){

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Indent; i++) {
            sb.append(str);
        }

        return  sb.toString();
    }

    public static void sleep(int timeOut){
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class ParabolaFunction implements TypeFunction {

    @Override
    public void print() {
        for(int x=0; x<=BORDERGAP;x++){
            int y = x*x;
            System.out.print(Indent.getIndent(y, "  "));
            System.out.println("*");
            Indent.sleep(TIMEOUT);
        }
    }
}

class SinusoidFunction implements TypeFunction {

    @Override
    public void print() {

        for(int x=0; x<=BORDERGAP;x++){
            int y = (int) (10*Math.sin((double)x/5));
            System.out.print(Indent.getIndent(y,"  "));
            System.out.println("*");
            Indent.sleep(TIMEOUT);
        }

    }
}

class LinearFunction implements TypeFunction {

    @Override
    public void print() {

        for(int x=0; x<=BORDERGAP;x++){
            int y = x;
            System.out.print(Indent.getIndent(y, "  "));
            System.out.println("*");
            Indent.sleep(TIMEOUT);
        }

    }
}

