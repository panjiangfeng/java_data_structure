package vip.paolu.t23;

/**
 * Description:二分查找法  非递归
 * User: 剑指屎山
 * Date: 2023-04-12-20:28
 */
public class BinarySearch {
    public static void main(String[] args) {
        int array[] = {1, 3, 8, 10, 11, 67, 100};
        int index = BinarySearch(array, 10);
        System.out.println(index);

    }

    public static int BinarySearch(int[] arr, int val) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == val) {
                return mid + 1;
            } else if (arr[mid] < val) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }


        }
        return -1;
    }
}

