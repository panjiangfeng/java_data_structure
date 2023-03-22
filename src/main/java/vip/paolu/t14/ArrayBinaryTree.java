package vip.paolu.t14;

/**
 * Description:
 * User: Pan
 * Date: 2023-03-22-20:54
 */
public class ArrayBinaryTree {
    private int[] arr;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);
        //System.out.print("前序");
        //tree.showByPre(0);
        //System.out.print("中序");
        //tree.showByCenter(0);
        System.out.print("后序");
        tree.showByLatter(0);
    }

    public ArrayBinaryTree() {
    }

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void showByPre(int index) {
        //根左右
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空,遍历不了哦");
            return;
        }
        System.out.print(arr[index] + " ");
        //为什么没有小于等于呢,因为index从0开始  小于等于就要length-1
        if (index * 2 + 1 < arr.length) {
            showByPre(index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length) {
            showByPre(index * 2 + 2);
        }
    }

    public void showByCenter(int index) {
        //左根右
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空,遍历不了哦");
            return;
        }

        //为什么没有小于等于呢,因为index从0开始  小于等于就要length-1
        if (index * 2 + 1 < arr.length) {
            showByCenter(index * 2 + 1);
        }
        System.out.print(arr[index] + " ");
        if (index * 2 + 2 < arr.length) {
            showByCenter(index * 2 + 2);
        }
    }

    public void showByLatter(int index) {
        //左右根
        //为什么没有小于等于呢,因为index从0开始  小于等于就要length-1
        if (index * 2 + 1 < arr.length) {
            showByLatter(index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length) {
            showByLatter(index * 2 + 2);
        }
        System.out.print(arr[index] + " ");
    }
}
