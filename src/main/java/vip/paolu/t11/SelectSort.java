package vip.paolu.t11;

/**
 * Description:
 * User: Pan
 * Date: 2023-03-14-21:30
 */
public class SelectSort {
    public static void main(String[] args) {
        //int[] arr = new int[]{2, 5, 1, -1, 5, 0, 6};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);//生成一个【0,8000000】数
        }
        long begin = System.nanoTime();
        arr = sort(arr);
        //System.out.println(Arrays.toString(arr));
        long end = System.nanoTime();
        System.out.println(end - begin);
    }

    public static int[] sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i; j < length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
        return arr;
    }
}
