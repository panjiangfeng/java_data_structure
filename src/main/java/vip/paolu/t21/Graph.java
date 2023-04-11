package vip.paolu.t21;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description:
 * User: Pan
 * Date: 2023-04-11-21:08
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

    public Graph(int numOfVertex) {
        this.numOfVertex = numOfVertex;
        vertexList = new ArrayList<>(numOfVertex);
        edges = new int[numOfVertex][numOfVertex];
        numOfEdge = 0;
    }

    public static void main(String[] args) {
        String[] vertexs = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(vertexs.length);
        //加顶点
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }
        //擦边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 0, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(2, 0, 1);
        graph.insertEdge(2, 1, 1);
        graph.insertEdge(3, 1, 1);
        graph.insertEdge(4, 1, 1);
        //来吧  展示
        graph.showGraph();
    }

    /**
     * 插顶点
     *
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
        numOfVertex++;
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
