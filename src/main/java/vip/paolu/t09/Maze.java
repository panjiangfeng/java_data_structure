package vip.paolu.t09;

/**
 * Description: 递归实现迷宫回溯
 * User: Pan
 * Date: 2023-02-21-19:53
 */
public class Maze {
    private int[][] map = new int[8][7];  //8*7的地图
    private int count;//走过的步数

    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.addObstacle();
        System.out.println("图:");
        maze.showMap();
        maze.setWay(1, 1);
        System.out.println("顺序");
        maze.showMap();

    }

    /**
     * 放置障碍物
     */
    public void addObstacle() {
        //左右
        for (int i = 0; i < 7; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //上下
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
    }

    /**
     * 展示地图
     */
    public void showMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 寻找路线
     *
     * @param x
     * @param y
     * @return
     */
    public boolean setWay(int x, int y) {
        //终点 6 5
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[x][y] == 0) {
                map[x][y] = 2;
                if (setWay(x + 1, y)) {
                    return true;
                } else if (setWay(x, y + 1)) {
                    return true;
                } else if (setWay(x - 1, y)) {
                    return true;
                } else if (setWay(x, y - 1)) {
                    return true;
                } else {
                    map[x][y] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
