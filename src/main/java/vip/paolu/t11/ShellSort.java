package vip.paolu.t11;

/**
 * Description:希尔排序
 * User: Pan
 * Date: 2023-03-14-22:32
 */
public class ShellSort {

    public static void main(String[] args) {
        //int[] arr = new int[]{2, 5, 1, -1, 5, 6};
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

    /**
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {
                int j = i;
                temp = arr[j];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
        return arr;
    }


    /**
     * 这是冒泡实现的希尔排序,不行
     *
     * @param arr
     * @return
     */
    public static int[] flawSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    //内部执行冒泡
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }

        }
        return arr;
    }
}
