package vip.paolu.t26;

import java.util.Arrays;

/**
 * Description:
 * User: 剑指屎山
 * Date: 2023-04-19-21:00
 */
public class Kruskal {
    private int edgeNum;//边数
    private char vertexs[];//顶点数
    private int[][] matrix;//邻接矩阵
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};
        //大家可以在去测试其它的邻接矩阵，结果都可以得到最小生成树.

        Kruskal kruskal = new Kruskal(vertexs, matrix);
        //输出构建的
        kruskal.print();
        kruskal.compute();
    }

    public void compute() {
        int index = 0;
        //记录终点表
        int[] ends = new int[edgeNum];
        //最小生成图
        EData[] graph = new EData[edgeNum];
        //获取图中 所有的边的集合 ， 一共有12边
        EData[] edges = getEdges();
        sortEdges(edges);
        System.out.println("图的边的集合=" + Arrays.toString(edges) + " 共" + edges.length);
        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);
            System.out.println("=============" + p1);
            int p2 = getPosition(edges[i].end);
            int m = getEnd(ends, p1); //4
            int n = getEnd(ends, p2);//5
            //如果他们终点不一样  说明可以进入
            if (m != n) {
                //设置m 在已有最小生成树"中的终点
                ends[m] = n;// 设置m 在"已有最小生	成树"中的终点 <E,F> [0,0,0,0,5,0,0,0,0,0,0,0]
                graph[index++] = edges[i];
            }
        }
        System.out.println("最小生成树为");
        for (int i = 0; i < index; i++) {
            System.out.println(graph[i]);
        }
    }

    /**
     * 初始化
     *
     * @param vertexs
     * @param matrix
     */
    public Kruskal(char[] vertexs, int[][] matrix) {
        int vlen = vertexs.length;
        this.vertexs = new char[vlen];
        for (int i = 0; i < vlen; i++) {
            this.vertexs[i] = vertexs[i];
        }
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    this.edgeNum++;
                }
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param edges
     */
    private void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {//交换
                    EData tmp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 返回顶点值
     *
     * @param ch
     * @return
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 返回终点
     *
     * @param ends
     * @param i
     * @return
     */
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    /**
     * 遍历
     */
    public void print() {
        System.out.println("邻接矩阵为: ");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();//换行
        }
    }
}

class EData {
    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData [<" + start + ", " + end + ">= " + weight + "]";
    }
}
