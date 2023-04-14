package vip.paolu.t24;

import java.util.Arrays;

/**
 * Description: kmp算法
 * User: 剑指屎山
 * Date: 2023-04-14-22:16
 */
public class KMP {
    public static void main(String[] args) {
        String st1 = "BBC ABCDAB ABCDABCDABDE";
        String st2 = "ABCDABD";

        int[] next = getKmpNext(st2);
        System.out.println(Arrays.toString(next));

        int index = kmpSearch(st1, st2, next);
        //加一  下标从一开始
        System.out.println(index + 1);

    }

    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                //因为此处j++超出最大了  多减了一个 所以+1
                //也可以j--;
                //return i-j;
                return i - j + 1;
            }
        }
        return -1;

    }

    //获取匹配值数组
    public static int[] getKmpNext(String target) {
        int[] next = new int[target.length()];
        //kmp此处都设置成0
        next[0] = 0;
        for (int i = 1, j = 0; i < target.length(); i++) {
            while (j > 0 && target.charAt(i) != target.charAt(j)) {
                j = next[j - 1];
            }
            if (target.charAt(i) == target.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
