package test;


import java.util.Scanner;

/**
 * Description:
 * User: Pan
 * Date: 2023-02-22-21:10
 */


//已知有一对兔子，每个月可以生一对兔子，而小兔子一个月后又可以生一对小兔子(比如:2月份出生的小兔子4月份可以生育)。也就是说，兔子的对数为：第一个月1对，第二个月2对，第三个月3对，第四个月5对....
// .假设兔子的生育期为两年，且不死。那么问题来了，你能说出每个月的兔子数么?
//  m=5
// 1:1
//    2:2
//    3:3
//    4:5
//    5:8
//        输入格式:
public class MainTest {
    public static void main(String[] args) {

    }

}

class ArrayUtils {
    public static double findMax(double[] arr, int begin, int end) throws IllegalArgumentException {
        if (begin < 0) {
            throw new IllegalArgumentException("begin:" + begin + " < 0");
        }
        if (end > arr.length) {
            throw new IllegalArgumentException("end:" + end + " > arr.length");
        }
        if (begin >= end) {
            throw new IllegalArgumentException("begin:" + begin + " >= " +
                    "end:" + end);
        }
        double max = Double.MIN_VALUE;
        for (int i = begin; i < end; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        double[] nums = new double[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextDouble();
        }

        scanner.nextLine();
        while (scanner.hasNextLine()) {
            int i1 = 0;
            int i2 = 0;
            try {
                i1 = scanner.nextInt();
                i2 = scanner.nextInt();

            } catch (Exception e) {
                break;
            } finally {
                scanner.nextLine();
            }
            try {
                double max = ArrayUtils.findMax(nums, i1, i2);
                System.out.println(max);

            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }

        }
        try {
            System.out.println(ArrayUtils.class.getDeclaredMethod("findMax", double[].class, int.class, int.class));
        } catch (Exception e1) {
        }


    }
}
