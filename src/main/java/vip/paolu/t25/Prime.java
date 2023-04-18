package vip.paolu.t25;

/**
 * Description:
 * User: 剑指屎山
 * Date: 2023-04-18-14:55
 */
public class Prime {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}};

        //创建Graph对象
        Graph graph = new Graph(verxs);
        //创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        minTree.showGraph(graph);
        minTree.prim(graph, 0);
    }

}

class MinTree {
    public void createGraph(Graph graph, int verxs, char data[], int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void prim(Graph graph, int v) {
        int[] visited = new int[graph.verxs];
        visited[v] = 1;
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        //总共需要找verxs-1次
        for (int k = 1; k < graph.verxs; k++) {

            for (int i = 0; i < graph.verxs; i++) {
                for (int j = 0; j < graph.verxs; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("边<" + graph.data[h1] + graph.data[h2] + "权值:" + minWeight);
            visited[h2] = 1;
            minWeight = 10000;
        }
    }

    public void showGraph(Graph graph) {
        for (int i = 0; i < graph.verxs; i++) {
            for (int j = 0; j < graph.verxs; j++) {
                System.out.printf("%-10d", graph.weight[i][j]);
            }
            System.out.println();
        }
    }
}

class Graph {
    int verxs;//图的节点个数
    char[] data; //存放节点
    int[][] weight; // 存放边之间的关系

    public Graph(int verxs) {
        this.verxs = verxs;
        this.data = new char[verxs];
        this.weight = new int[verxs][verxs];
    }


}
