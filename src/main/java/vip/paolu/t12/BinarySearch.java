package vip.paolu.t12;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 二分查找  查找到的索引均从1开始
 * User: Pan
 * Date: 2023-03-18-20:02
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 5, 6, 9, 11, 11, 123, 532, 555};
        //int index = getIndex(nums, 11, 0, nums.length - 1);
        List<Integer> list = getMultipleIndex(nums, 1, 0, nums.length - 1);
        System.out.println(list);

    }

    public static int getIndex(int[] arr, int num, int left, int right) {
        if (left > right) {
            return -1;
        }
        int length = arr.length;
        int mid = (left + right) / 2;
        if (num < arr[mid]) {
            return getIndex(arr, num, left, mid - 1);
        } else if (num > arr[mid]) {
            return getIndex(arr, num, mid + 1, right);
        } else {
            return mid + 1;
        }
    }

    public static List<Integer> getMultipleIndex(int[] arr, int num, int left, int right) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int length = arr.length;
        int mid = (left + right) / 2;
        if (num < arr[mid]) {
            return getMultipleIndex(arr, num, left, mid - 1);
        } else if (num > arr[mid]) {
            return getMultipleIndex(arr, num, mid + 1, right);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            int index = mid;
            while (index >= 0 && arr[index] == num) {
                list.add((index--) + 1);
            }
            index = mid + 1;
            while (index <= arr.length - 1 && arr[index] == num) {
                list.add((index++) + 1);
            }
            return list;
        }
    }

}
