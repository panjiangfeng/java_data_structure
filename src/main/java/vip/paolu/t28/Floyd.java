package vip.paolu.t28;

import java.util.Arrays;

/**
 * Description:
 * User: 剑指屎山
 * Date: 2023-04-22-15:20
 */
public class Floyd {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //创建邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};
        Graph graph = new Graph(7, matrix, vertex);
        graph.floyd();
        graph.show();

    }
}

class Graph {
    private char[] vertex; //二维关系图
    private int[][] dis;//从某个顶点到各个顶点的距离最后的结果
    private int[][] pre;//中间关系顶点
    static final int N = 65535;

    public Graph(int length, int[][] matrix, char[] vertex) {
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];

        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    public void show() {
        System.out.println("前驱表：");
        for (int i = 0; i < dis.length; i++) {
            //先将pre数组输出的一行数据
            for (int j = 0; j < dis.length; j++) {
                System.out.print(pre[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("各个顶点距离表：");
        for (int i = 0; i < dis.length; i++) {
            //输出dis数组的一行数据
            for (int k = 0; k < dis.length; k++) {
                System.out.printf("%-10d ", dis[i][k]);
            }
            System.out.println();
        }
    }

    public void floyd() {
        int len = 0;
        for (int k = 0; k < dis.length; k++) {

            for (int i = 0; i < dis.length; i++) {
                for (int j = 0; j < dis.length; j++) {
                    len = dis[i][k] + dis[k][j];
                    if (len < dis[i][j]) {
                        dis[i][j] = len;
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }

}