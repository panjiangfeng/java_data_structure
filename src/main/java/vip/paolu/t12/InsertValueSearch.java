package vip.paolu.t12;

/**
 * Description: 差值查找 查找到的索引均从1开始
 * User: Pan
 * Date: 2023-03-19-0:02
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 5, 6, 9, 11, 11, 123, 532, 555};
        //int index = getIndex(nums, 11, 0, nums.length - 1);
        int index = getMultipleIndex(nums, 11, 0, nums.length - 1);
        System.out.println(index);
    }

    public static int getMultipleIndex(int[] arr, int num, int left, int right) {
        int length = arr.length;
        if (left > right || num < arr[0] || num > arr[length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (num - arr[left]) / (arr[right] - arr[left]);
        if (num < arr[mid]) {
            return getMultipleIndex(arr, num, left, mid - 1);
        } else if (num > arr[mid]) {
            return getMultipleIndex(arr, num, mid + 1, right);
        } else {

            return mid + 1;
        }
    }
}
