package vip.paolu.t12;

/**
 * Description:线性查找 查找到的索引均从1开始
 * User: Pan
 * Date: 2023-03-18-19:58
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] ints = {1, 5, 3, 5, 5, 123, 532, 555};
        int index = getIndex(ints, 3);
        System.out.println(index);
    }

    public static int getIndex(int[] arr, int num) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] == num) {
                return i + 1;
            }
        }
        return -1;
    }
}
