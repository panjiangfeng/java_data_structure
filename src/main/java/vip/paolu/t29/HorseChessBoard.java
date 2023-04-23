package vip.paolu.t29;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Description:
 * User: 剑指屎山
 * Date: 2023-04-23-19:14
 */
public class HorseChessBoard {
    private static int X;
    private static int Y;
    private static boolean[] visited;//是否访问过
    private static boolean finished;

    public static void main(String[] args) {
        X = 6;
        Y = 6;
        int row = 5;
        int column = 2;
        int[][] chessBoard = new int[X][Y];
        visited = new boolean[X * Y];
        long start = System.currentTimeMillis();
        traversalChessboard(chessBoard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                System.out.print(chessBoard[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static void traversalChessboard(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;
        visited[row * X + column] = true;
        ArrayList<Point> ps = next(new Point(column, row));
        sort(ps);
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);
            if (!visited[p.y * X + p.x]) {
                traversalChessboard(chessboard, p.y, p.x, step + 1);
            }
        }

        if (step < X * Y && !finished) {
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
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

    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int count1 = next(o1).size();
                int count2 = next(o2).size();
                if (count1 < count2) {
                    return -1;
                } else if (count1 == count2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }

}
