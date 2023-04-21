package vip.paolu.t27;

import java.util.Arrays;

/**
 * Description:
 * User: 剑指屎山
 * Date: 2023-04-21-15:54
 */
public class Dijkstra {
    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] martex = new int[vertexs.length][vertexs.length];
        final int N = 65535;
        martex[0] = new int[]{N, 5, 7, N, N, N, 2};
        martex[1] = new int[]{5, N, N, 9, N, N, 3};
        martex[2] = new int[]{7, N, N, N, 8, N, N};
        martex[3] = new int[]{N, 9, N, N, N, 4, N};
        martex[4] = new int[]{N, N, 8, N, N, 5, 4};
        martex[5] = new int[]{N, N, N, 4, 5, N, 6};
        martex[6] = new int[]{2, 3, N, N, 4, 6, N};

        Graph graph = new Graph(vertexs, martex);
        graph.showGraph();
        graph.dsj(6);
        graph.showDijkstra();

    }
}

class VisitedVertex {
    //记录每个顶点是否被访问了  1表示访问0 表示未访问
    public int[] already_arr;
    public int[] pre_visited;
    //记录触发顶点到其他所有顶点的距离
    public int[] dis;

    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        Arrays.fill(dis, 65535);
        this.already_arr[index] = 1;
        this.dis[index] = 0;
    }

    //判断Index是否被访问古过 如果访问过返回true
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    //更新出发结点到index结点的距离
    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    public int updateArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        already_arr[index] = 1;
        return index;
    }

    //返回出发结点到index结点的距离
    public int getDis(int index) {
        return dis[index];
    }

    //更新结点Pre的前驱结点为index
    public void updatePre(int next, int index) {
        pre_visited[next] = index;
    }

    public void show() {
        //输出数组
        //System.out.println(Arrays.toString(already_arr));
        //System.out.println(Arrays.toString(pre_visited));
        System.out.println(Arrays.toString(dis));


    }

}

class Graph {
    private char[] vertex;
    private int[][] matrix;

    private VisitedVertex vv;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void dsj(int index) {
        vv = new VisitedVertex(vertex.length, index);
        update(6);
        for (int i = 1; i < vertex.length; i++) {
            index = vv.updateArr();
            update(index);
        }

    }


    private void update(int index) {
        int len = 0;
        for (int i = 0; i < matrix.length; i++) {
            //出发结点到index  +index到节点i
            //从你指定的节点开始到i的距离
            len = vv.getDis(index) + matrix[i][index];
            if (!vv.in(i) && len < vv.getDis(i)) {
                vv.updatePre(i, index);
                vv.updateDis(i, len);
            }

        }
    }

    public void showGraph() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void showDijkstra() {
        vv.show();
    }

}

