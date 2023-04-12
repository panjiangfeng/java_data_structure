package vip.paolu.t23;

/**
 * Description: 分治算法 递归实现汉诺塔
 * User: 剑指屎山
 * Date: 2023-04-12-20:33
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(4, 'A', 'B', 'C');
    }

    public static void hanoiTower(int n, char a, char b, char c) {
        //只剩一层,直接从A->C
        if (n == 1) {
            System.out.println("第一个盘从" + a + "->" + c);
        } else {
            //分2层  最底层和上面的全部层
            //将顶层A柱全部转到B柱  C辅助
            hanoiTower(n - 1, a, c, b);
            //底下一层从A柱到C柱
            System.out.println("第" + n + "个盘从" + a + "->" + c);
            //将B柱上所有的通过辅助A中转到C
            hanoiTower(n - 1, b, a, c);
        }
    }
}
