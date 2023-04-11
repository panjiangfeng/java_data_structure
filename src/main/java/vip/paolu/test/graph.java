package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class graph {
    private ArrayList<String> vertexList; //存储结点集合
    private int[][] edges; //存储图对应的邻接矩阵
    private int numOfEdges;//表示表的数目
    //定义数组boolean[]，记录某个结点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 8;
        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        //创建图对象
        graph Graph = new graph(n);
        //循环的添加结点
        for (String vertex : Vertexs) {
            Graph.insertVertex(vertex);
        }


        //添加边
        // A-B A-C B-C B-D B-E
        Graph.insetEdge(0, 1, 1);
        Graph.insetEdge(0, 2, 1);


        Graph.insetEdge(1, 3, 1);
        Graph.insetEdge(1, 4, 1);

        Graph.insetEdge(3, 7, 1);
        Graph.insetEdge(4, 7, 1);
        Graph.insetEdge(2, 5, 1);
        Graph.insetEdge(2, 6, 1);
        Graph.insetEdge(5, 6, 1);

        Graph.showGraph();


        //深度遍历
        //System.out.println("深度遍历");
        //Graph.DFS();
        System.out.println("广度遍历");


        Graph.BFS();
    }

    public graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //根据前一个邻接结点的下标获取下一个
    public int getNexthbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0)
                return j;

        }
        return -1;
    }

    ///得到第一个邻接结点的下标
    //如果存在 返回对应下标
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++)
            if (edges[index][j] > 0)
                return j;
        return -1;
    }

    //遍历所有结点进行BFS
    private void BFS() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            BFS(isVisited, i);
        }
    }

    //对一个结点进行广度优先遍历
    private void BFS(boolean[] isVistied, int i) {
        int u; // 表示队列的头结点对应下标
        int w; //邻接结点

        //队列，记录结点访问的顺序
        LinkedList queue = new LinkedList();

        //访问结点，输出结点信息
        System.out.println(getValueByIndex(i) + "=>");
        isVistied[i] = true;
        //将结点加入队列
        queue.add(i);

        while (!queue.isEmpty()) {
            //取出队列的头结点
            u = (Integer) queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1) {
                //是否访问
                if (!isVisited[w]) {
                    //System.out.println(getValueByIndex(w)+"=>");
                    isVisited[w] = true;
                    ;
                    queue.addLast(w);

                }
                //以u为中心，找下一个邻居
                w = getNexthbor(u, w);


            }
        }
    }


    //DFS
    public void DFS(boolean[] isVisited, int i) {
        //首先访问该结点
        System.out.println(getValueByIndex(i) + "->");
        isVisited[i] = true;

        //查找这个结点的邻接结点
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                DFS(isVisited, w);
            }
            //如果已经被访问过
            else {
                w = getNexthbor(i, w);
            }
        }
    }


    //对DFS进行重载 遍历所有的结点并进行DFS
    public void DFS() {
        //遍历所有的结点进行DFS
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                DFS(isVisited, i);
            }
        }
    }


    public int getNumOfVertex() {
        return vertexList.size();
    }

    //返回结点i(下标对应的数据)
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public void insetEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;

    }

    //  插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }


}