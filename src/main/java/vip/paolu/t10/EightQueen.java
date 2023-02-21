package vip.paolu.t10;

/**
 * Description: 递归实现八皇后
 * User: Pan
 * Date: 2023-02-21-20:22
 */
public class EightQueen {
    private int[] map = new int[8]; //地图  用一维表写  下标就是行 填的值就是列
    int count; //计算几种方法

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.setQueen(0);
        System.out.println(eightQueen.count);
    }

    /**
     * 防止皇后
     *
     * @param n
     */
    public void setQueen(int n) {
        if (n == 8) {
            showMap();
            count++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            map[n] = i;
            if (check(n)) {
                setQueen(n + 1);
            }
        }
    }

    /**
     * 判断是否同行同列同斜
     *
     * @param n
     * @return
     */
    public boolean check(int n) {
        for (int i = 0; i < n; i++) {
            if (map[n] == map[i] || Math.abs(n - i) == Math.abs(map[n] - map[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 遍历数组
     */
    public void showMap() {
        for (int i = 0; i < map.length; i++) {
            System.out.print(map[i] + "  ");
        }
        System.out.println();
    }
}
