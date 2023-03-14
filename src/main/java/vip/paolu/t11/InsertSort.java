package vip.paolu.t11;

/**
 * Description: 直接插入排序
 * User: Pan
 * Date: 2023-03-14-21:04
 */
public class InsertSort {
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

    public static int[] sort(int arr[]) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int insertVal = arr[i];
            int index = i - 1; //待插入值之前的索引
            while (index >= 0 && insertVal < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = insertVal;
        }
        return arr;
    }
}

