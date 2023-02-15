package vip.paolu;

/**
 * Description: 稀疏数组
 * User: Pan
 * Date: 2023-02-15-15:19
 */
public class SparseArray {
    private int[][] array;
    private int[][] sparseArray;
    private int row = 0;
    private int col = 0;
    private int count = 0;//原数组中不同数值

    public static void main(String[] args) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.initArray();
        sparseArray.showArray();
        sparseArray.initSparseArray();
        sparseArray.recovery();
    }

    /**
     * 创建一个11*11的数组并设置初始值
     */
    public void initArray() {
        row = 11;
        col = 11;
        array = new int[row][col];
        array[1][2] = 1;
        array[2][3] = 2;
    }

    /**
     * 遍历数组
     */
    public void showArray() {
        System.out.println("原数组:");
        for (int[] array : array) {
            for (int item : array) {
                System.out.printf("%4d", item);
            }
            System.out.println();
        }
    }

    /**
     * 初始化稀疏数组
     */
    public void initSparseArray() {
        //查询不同数
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    count++;
                }
            }
        }
        //创建数组
        sparseArray = new int[count + 1][3];
        sparseArray[0][0] = row;
        sparseArray[0][1] = col;
        sparseArray[0][2] = count;

        int temp = 0;//计数遍历稀疏数组层次

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    temp++;
                    sparseArray[temp][0] = i;
                    sparseArray[temp][1] = j;
                    sparseArray[temp][2] = array[i][j];
                }
            }
        }

        //遍历稀疏数组
        System.out.println("稀疏数组:");
        System.out.printf("%-5s%-5s%-5s", "row", "col", "val");
        System.out.println();
        for (int[] array : sparseArray) {
            for (int item : array) {
                System.out.printf("%-5d", item);
            }
            System.out.println();
        }
    }

    /**
     * 恢复数组
     */
    public void recovery() {
        int row = sparseArray[0][0];
        int col = sparseArray[0][1];
        int diff = sparseArray[0][2];
        int[][] list = new int[row][col];

        for (int i = 1; i < sparseArray.length; i++) {
            list[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];

        }

        //遍历数组
        System.out.println("恢复数组:");
        for (int[] array : list) {
            for (int item : array) {
                System.out.printf("%4d", item);
            }
            System.out.println();
        }
    }
}
