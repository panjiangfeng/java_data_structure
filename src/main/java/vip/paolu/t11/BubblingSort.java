package vip.paolu.t11;

/**
 * Description: 冒泡排序
 * User: Pan
 * Date: 2023-03-14-20:54
 */

public class BubblingSort {
    public static void main(String[] args) {
        //int[] arr = new int[]{2, 5, 1, -1, 5, 6};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);//生成一个【0,8000000】数
        }
        long begin = System.nanoTime();
        arr = sort(arr);
        long end = System.nanoTime();
        System.out.println(end - begin);
    }

    public static int[] sort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            boolean isChanged = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    isChanged = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (isChanged == false) {
                break;
            }
        }
        return arr;
    }
}
