package hw3.graph;

import java.util.Scanner;

public class GraphPresenter implements Runnable {

    private TypeFunction typeFunction;

    public void setTypeFunction(TypeFunction typeFunction) {
        this.typeFunction = typeFunction;
    }

    public void print() {
        typeFunction.print();
    }

    @Override
    public void run() {

        System.out.println("Select type function:");
        System.out.print("1 - Parabola(y=x*x)\t");
        System.out.print("2 - Sinusoid(y=10*sin(x/5))\t");
        System.out.print("3 - Linear(y=x)\t");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int typeFunction = scanner.nextInt();

        if ((typeFunction > 0)&&(typeFunction < 4)) {
            if (typeFunction == 1) {
                setTypeFunction(new ParabolaFunction());
            } else if (typeFunction == 2) {
                setTypeFunction(new SinusoidFunction());
            } else if (typeFunction == 3) {
                setTypeFunction(new LinearFunction());
            }
        }
        this.typeFunction.print();
    }

    public static void main(String[] args) {

        GraphPresenter graphPresenter = new GraphPresenter();
        Thread thread1 = new Thread(graphPresenter);
        thread1.start();
        GraphPresenterStop graphPresenterStop = new GraphPresenterStop();
        //Thread thread2 = new Thread(graphPresenterStop);
        //thread2.start();
    }
}


class GraphPresenterStop implements Runnable {

    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);

        while (!Thread.currentThread().interrupted()) {
            if (scan.nextLine().length()==0){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.currentThread().interrupt();
                //currentThread().stop();
            }

        }

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

