package vip.paolu.t11;

/**
 * Description: 基数排序
 * User: Pan
 * Date: 2023-03-17-22:22
 */
public class RadixSort {
    public static void main(String[] args) {
        //int[] arr = new int[]{53, 3, 542, 748, 14, 214};
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
        int[] nums = new int[10]; //存储每个桶有几个数
        int[][] bucket = new int[10][length];//10个桶
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        int digit = (max + "").length();//位数
        for (int i = 0, n = 1; i < digit; i++, n *= 10) {
            for (int j = 0; j < length; j++) {
                //System.out.println(arr[j] + " " + n);
                int site = arr[j] / n % 10; //放第几个桶
                bucket[site][nums[site]] = arr[j];
                nums[site] = nums[site] + 1;
            }
            int index = 0;
            for (int x = 0; x < 10; x++) { //第几个桶
                for (int j = 0; j < nums[x]; j++) {//桶第几个
                    arr[index++] = bucket[x][j];
                }
            }
            nums = new int[10];
        }
        return arr;
    }
}

