package vip.paolu.t11;

/**
 * Description:归并排序
 * User: Pan
 * Date: 2023-03-16-19:55
 */
public class MergeSort {
    public static void main(String[] args) {
        //int[] arr = new int[]{2, 1, 4, 54, 2, 4, 5, 1, 2, 2};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);//生成一个【0,8000000】数
        }
        int[] temp = new int[arr.length];
        long begin = System.nanoTime();
        sort(arr, 0, arr.length - 1, temp);
        //System.out.println(Arrays.toString(arr));
        long end = System.nanoTime();
        System.out.println(end - begin);

    }

    /**
     * @param arr
     * @return
     */
    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, right, mid, temp);

        }
    }

    public static void merge(int[] arr, int left, int right, int mid, int[] temp) {
        int l = left; //左边序列初始索引
        int r = mid + 1; //右边序列初始索引
        int t = 0; //当前序列索引
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[t] = arr[l];
                t++;
                l++;
            } else {
                temp[t] = arr[r];
                t++;
                r++;
            }
        }
        while (l <= mid) {
            temp[t++] = arr[l++];
        }
        while (r <= right) {
            temp[t++] = arr[r++];
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }


}

