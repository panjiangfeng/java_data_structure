package test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Description:
 * User: 剑指屎山
 * Date: 2023-04-23-20:16
 */
public class HorseChessBoard {
    public static int X;  //棋盘的列数
    public static int Y;  //棋盘的行数
    public static boolean[] isVisted;//标记棋盘的各个位置是否被访问过了
    public static boolean isFinshed; //表示所有位置都被访问过了

    public static void main(String[] args) {
        X = 8;
        Y = 8;
        isVisted = new boolean[X * Y];
        int x = 1, y = 1;
        int[][] chessBoard = new int[X][Y];
        travelChessBoard(chessBoard, x - 1, y - 1, 1);
        for (int[] ints : chessBoard) {
            System.out.println(Arrays.toString(ints));
        }


    }

    /**
     * 完成其实周游问题的算法
     *
     * @param chessBoard 棋盘
     * @param row        马儿当前在哪一行
     * @param column     马儿当前在哪一列
     * @param step       当前在第几步
     */
    public static void travelChessBoard(int[][] chessBoard, int row, int column, int step) {
        chessBoard[row][column] = step;
        isVisted[row * X + column] = true; //标记位置已经被访问
        //获取当前位置可以走的位置
        ArrayList<Point> next = next(new Point(column, row));
        //对next进行排序,排序的规则是next的下一个的数目
        sort(next);
        while (!next.isEmpty()) {
            Point point = next.remove(0);  //取出下一个可以访问的结点
            //判断此点是否访问过
            if (!isVisted[point.y * X + point.x]) {//没有访问过
                travelChessBoard(chessBoard, point.y, point.x, step + 1);
            }

        }
        //.判断马儿是否完成了任务，使用step和应该走的步数比较，
        // 如果没有达到数量，则表示没有完成任务，将整个棋盘置0
        if (step < X * Y && !isFinshed) {
            chessBoard[row][column] = 0;
            isVisted[row * X + column] = false;
        } else {
            isFinshed = true;
        }

    }

    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> points = new ArrayList<>();
        Point point = new Point();
        if ((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y - 1) >= 0) {//5
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x - 1) >= 0 && (point.y = curPoint.y - 2) >= 0) {//6
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x + 1) < X && (point.y = curPoint.y - 2) >= 0) {//7
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x + 2) < X && (point.y = curPoint.y - 1) >= 0) {//0
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x + 2) < X && (point.y = curPoint.y + 1) < Y) {//1
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x + 1) < X && (point.y = curPoint.y + 2) < Y) {//2
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x - 1) >= 0 && (point.y = curPoint.y + 2) < Y) {//3
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y + 1) < Y) {//4
            points.add(new Point(point));
        }


        return points;


    }

    //根据当前这一步的下一步的选择位置,进行排序
    public static void sort(ArrayList<Point> next) {
        next.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                ArrayList<Point> next1 = next(o1);
                ArrayList<Point> next2 = next(o2);
                return next1.size() - next2.size();
            }
        });
    }

}