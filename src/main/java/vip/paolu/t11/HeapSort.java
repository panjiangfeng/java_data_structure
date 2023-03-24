package vip.paolu.t11;

/**
 * Description:
 * User: Pan
 * Date: 2023-03-24-19:22
 */
public class HeapSort {
    public static void main(String[] args) {
        //int[] arr = new int[]{2, 5, 1, -1, 5, 6};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);//生成一个【0,8000000】数
        }
        long begin = System.nanoTime();
        sort(arr);
        //System.out.println(Arrays.toString(arr));
        long end = System.nanoTime();
        System.out.println(end - begin);
    }

    public static void sort(int[] arr) {
        int temp = 0;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 从上往下一直交换
     *
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j + 1] > arr[j]) {
                j++;
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;

    }
}
