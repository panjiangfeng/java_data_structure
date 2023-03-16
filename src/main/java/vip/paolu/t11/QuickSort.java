package vip.paolu.t11;

/**
 * Description: 快速排序
 * User: Pan
 * Date: 2023-03-15-20:39
 */
public class QuickSort {
    public static void main(String[] args) {
        //int[] arr = new int[]{2, 5, 1, -1, 5, 0, 6, 9, 10, 3, 8, 6,};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);//生成一个【0,8000000】数
        }
        long begin = System.nanoTime();
        arr = sort(arr, 0, arr.length - 1);
        //System.out.println(Arrays.toString(arr));
        long end = System.nanoTime();
        System.out.println(end - begin);
    }

    /**
     * 快速排序
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int[] sort(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp;
        while (l < r) {
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            while (l < r && arr[l] <= pivot) {
                l++;
            }
            //交换2边
            if (l < r) {
                temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }
        }
        //将基准值处和相交处交换,然后存基准值
        arr[left] = arr[l];
        arr[l] = pivot;
        sort(arr, left, l - 1);
        sort(arr, l + 1, right);
        return arr;
    }


}
