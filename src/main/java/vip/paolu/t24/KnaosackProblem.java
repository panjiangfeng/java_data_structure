package vip.paolu.t24;

/**
 * Description:
 * User: 剑指屎山
 * Date: 2023-04-13-23:12
 */
public class KnaosackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};
        int[] val = {1500, 3000, 2000};
        int m = 4;//能装的容量大小
        int n = val.length;//物品大小
        //存放值
        int[][] v = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1];
        //初始化
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        //以下处理
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.printf("%-7d", v[i][j]);
            }
            System.out.println();
        }
        System.out.println("====================================");
        int pathLen = path.length - 1;
        int pathSonLen = path[0].length - 1;
        while (pathLen > 0 && pathSonLen > 0) {
            if (path[pathLen][pathSonLen] == 1) {
                System.out.printf("第%d个商品放入到背包\n", pathLen);
                pathSonLen -= w[pathLen - 1];
            }
            pathLen--;
        }
    }
}
