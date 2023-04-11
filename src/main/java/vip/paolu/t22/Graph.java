package vip.paolu.t22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Description:
 * User: 剑指屎山
 * Date: 2023-04-11-21:38
 */


public class Graph {
    //顶点集
    ArrayList<String> vertexList;
    //二维矩阵
    int[][] edges;
    //边数
    int numOfEdge;
    //顶点总数
    int numOfVertex;
    //节点是否被访问过
    private boolean[] isVisited;

    public Graph(int numOfVertex) {
        this.numOfVertex = numOfVertex;
        vertexList = new ArrayList<>(numOfVertex);
        edges = new int[numOfVertex][numOfVertex];
        numOfEdge = 0;
        isVisited = new boolean[numOfVertex];
    }

    public static void main(String[] args) {
        int n = 8;
        String vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        Graph graph = new Graph(n);
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }
        //添加边
        // A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
        graph.showGraph();

        //深度遍历
        //System.out.println("深度遍历");
        //graph.DFS();
        System.out.println("广度遍历");
        graph.BFS();

    }

    /**
     * 插顶点
     *
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
        numOfEdge++;
    }

    /**
     * 广度优先
     */
    public void BFS() {
        for (int i = 0; i < numOfVertex; i++) {
            BFS(isVisited, i);
        }
    }

    public void BFS(boolean[] isVisited, int i) {
        //有必要说一下为啥这里要用队列,因为广度优先要回溯
        int u;//队列头
        int w;//下一个存在的节点
        LinkedList queue = new LinkedList();
        //展示第一个
        System.out.println(getValueByIndex(i) + "=>");
        isVisited[i] = true;
        //加入队列
        queue.add(i);
        while (!queue.isEmpty()) {
            u = (Integer) queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNexthbor(u, w);
            }
        }
    }

    /**
     * 获取当前节点下的第一个有权值的节点
     *
     * @param i
     * @return
     */
    public int getFirstNeighbor(int i) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[i][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 获取当前节点的下一个有权值的节点
     *
     * @param v1 横轴
     * @param v2 纵轴
     * @return
     */
    public int getNexthbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 重载深度优先
     */
    public void DFS() {
        for (int i = 0; i < numOfVertex; i++) {
            if (!isVisited[i]) {
                DFS(isVisited, i);
            }
        }
    }

    /**
     * 深度优先
     *
     * @param isVisited
     * @param i
     */
    public void DFS(boolean[] isVisited, int i) {
        //访问该节点
        System.out.println(getValueByIndex(i) + "->");
        isVisited[i] = true;
        //向下遍历
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                DFS(isVisited, w);
            } else {
                w = getNexthbor(i, w);
            }
        }
    }

    /**
     * 通过索引获取值
     *
     * @param i
     * @return
     */
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * 通过边获取权值
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 擦边
     *
     * @param v1
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdge++;
    }

    /**
     * 展示边
     */
    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }
}
