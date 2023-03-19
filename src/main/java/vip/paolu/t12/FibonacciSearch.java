package vip.paolu.t12;

import java.util.Arrays;

/**
 * Description: 斐波那契
 * User: Pan
 * Date: 2023-03-19-22:30
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int index = getIndex(arr, 1000);
        System.out.println(index);

    }

    public static int[] getFibArr(int size) {
        int[] arr = new int[size];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < size; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    public static int getIndex(int[] arr, int num) {
        //当前是f[k]-1
        int left = 0;
        int right = arr.length - 1;
        int index = 0;//菲薄下标
        int mid = 0;//中间值
        int[] fibArr = getFibArr(arr.length);
        while (right > fibArr[index] - 1) {
            index++;
        }
        int[] temp = Arrays.copyOf(arr, fibArr[index]);
        for (int i = arr.length; i < temp.length - 1; i++) {
            temp[i] = arr[right];
        }
        while (left <= right) {
            System.out.println("==");
            mid = left + fibArr[index - 1] - 1;
            if (num < temp[mid]) {
                right = mid - 1;
                index--;
            } else if (num > temp[mid]) {
                left = mid + 1;
                index -= 2;
            } else {
                if (mid > right) {
                    return mid + 1;
                } else {
                    return mid + 1;
                }
            }
        }
        return -1;
    }
}

class FibonacciSearch1 {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int[] fib = fib(20);
        System.out.println(Arrays.toString(fib));
        System.out.println(fibSearch(arr, 1000));
    }

    /**
     * 获取斐波那契数列
     */
    public static int[] fib(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            if (i == 1 || i == 0) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        }
        return arr;
    }

    /**
     * 斐波那契查找算法
     *
     * @param arr 数组
     * @param key 查找的值
     * @return 返回对相应下标，默认返回-1；
     */
    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int hight = arr.length - 1;
        //斐波那契数组的下标
        int k = 0;
        //存放mid值
        int mid = 0;
        int[] fibArr = fib(arr.length);
        //获取斐波那契分割数值的下标
        while (hight > fibArr[k] - 1) {
            k++;
        }
        //fibArr[k]的值可能大于a的长度，需要扩充，新增的值用原数组最大值
        int[] temp = Arrays.copyOf(arr, fibArr[k]);
        for (int i = arr.length; i < fibArr[k]; i++) {
            temp[i] = arr[arr.length - 1];
        }
        //使用while寻找key
        while (low <= hight) {
            System.out.println("==");
            mid = low + fibArr[k - 1] - 1;
            //fibArr[k]=fibArr[k-1]+fibArr[k-2];
            //全部元素=前边的元素+后边的元素
            //前边k-1 后边k-2
            if (key < temp[mid]) {
                hight = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid > hight) {
                    return hight;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
