package tools;

import java.util.ArrayList;

/**
 * Created by Sergey Tsimbalyuk on 10.03.15.
 */
public class Warnsdorf {
    static int N = 8; // размерность шахматной доски доски
    static int[][] board = new int[N][N];// шахматная доска, на которой отмечается куда уже походил конь
    static int[][] boardMove = new int[N][N]; // шахматная доска, на которой указывается следующий ход коня

    public static void main(String[] args) {
        int c=0;
        int x=0;
        int y=0;
        boardMove[0][0]=c;
        board[0][0]=99;

        while(c < 63){
            c++;
            Point p = findNext(x,y);
            x=p.getX();
            y=p.getY();
            boardMove[p.getX()][p.getY()]=c;
            board[p.getX()][p.getY()]=99;
            updateBoard();

        }
        printArray();
    }

    /**
     *  поиск возможных ходов коня с определенной позиции
     */
    public static Point findNext(int x, int y){
        // в коллекцию добавляются все клетки, на которые может походить конь и которые являются на доске
        ArrayList<Point> list = new ArrayList<Point>();
        int min=100;
        int bufI = 100;
        if(onBoard(x+2,y-1)){
            list.add(new Point(x+2,y-1));
        }
        if(onBoard(x+2,y+1)){
            list.add(new Point(x+2,y+1));
        }
        if(onBoard(x-2,y+1)){
            list.add(new Point(x-2,y+1));
        }
        if(onBoard(x-2,y-1)){
            list.add(new Point(x-2,y-1));
        }
        if(onBoard(x+1,y+2)){
            list.add(new Point(x+1,y+2));
        }
        if(onBoard(x-1,y+2)){
            list.add(new Point(x-1,y+2));
        }
        if(onBoard(x+1,y-2)){
            list.add(new Point(x+1,y-2));
        }
        if(onBoard(x-1,y-2)){
            list.add(new Point(x-1,y-2));
        }

        // выбор точки с наименьшим количеством возможных ходов (правило Варнсдорфа)
        for(int i = 0; i < list.size();i++){
            if(board[list.get(i).getX()][list.get(i).getY()] < min){
                min = board[list.get(i).getX()][list.get(i).getY()];
                bufI=i;
            }
        }
        return list.get(bufI);
    }

    /**
     * определение для каждой клетки шахкатной доски, на которую ещё не ходил конь
     * всех возможных ходов, которые он может сделать с неё
     */
    public static void updateBoard(){
        int count=0;
        for(int x = 0; x< N; x++)
            for(int y = 0; y < N; y++){
                count=0;
                if(onBoard(x+2,y-1)){
                    count++;
                }
                if(onBoard(x+2,y+1)){
                    count++;
                }
                if(onBoard(x-2,y+1)){
                    count++;
                }
                if(onBoard(x-2,y-1)){
                    count++;
                }
                if(onBoard(x+1,y+2)){
                    count++;
                }
                if(onBoard(x-1,y+2)){
                    count++;
                }
                if(onBoard(x+1,y-2)){
                    count++;
                }
                if(onBoard(x-1,y-2)){
                    count++;
                }
                if(board[x][y] != 99)
                    board[x][y]=count;
            }
    }

    /**
     * проверка того, является ли точка на шахматной доске
     */
    public static boolean onBoard(int x, int y){
        if(x < N && x >= 0 && y < N && y >=0)
            if(board[x][y] != 99) return true;
        return false;
    }

    /**
     * вывод результата на консоль
     */
    public static void printArray(){
        for(int i = 0; i<N; i++){
            for(int j = 0; j < N; j++){
                System.out.print("  "+boardMove[i][j]);
            }
            System.out.println();
        }
    }
}

/**
 * клас, что хранит точку с определенными координатами
 */
class Point{
    private int x;
    private int y;

    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

}