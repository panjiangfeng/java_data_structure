package test; /**
 * Description:
 * User: Pan
 * Date: 2023-02-15-16:50
 */


import java.util.Scanner;

public class CircleQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    /**
     * 环形队列的实现
     */

    //初始化环型队列
    public CircleQueue(int maxSize) {
        this.arr = new int[maxSize];
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
    }

    //队列是否已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //入队
    public void addQueue(int num) {
        if (isFull()) {
            System.out.println("队列已满，请稍等~~~");
        } else {
            arr[rear] = num;
            rear = (rear + 1) % maxSize;
        }
    }

    //出队
    public int outQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能出队~~");
        }
        int outNum = arr[front];
        System.out.println("出队的数值为：" + outNum);
        front = (front + 1) % maxSize;
        return outNum;
    }

    //循环队列有效元素
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空~~");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf(" " + arr[i % maxSize]);
        }
    }

    //得到对头的元素
    public int getHeader() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空~~");
        }
        System.out.println("对头元素：" + arr[front % maxSize]);
        return arr[front % maxSize];
    }

    //得出有效元素的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(4);
        boolean loop = true;
        char sc = ' ';
        while (loop) {
            System.out.println("e 跳出循环");
            System.out.println("a 入队");
            System.out.println("o 出队");
            System.out.println("s 循环队列");
            System.out.println("h 展示队头");
            Scanner systemPut = new Scanner(System.in);
            sc = systemPut.next().charAt(0);
            switch (sc) {
                case 'a':
                    System.out.println("请输入数据：");
                    Scanner addNum = new Scanner(System.in);
                    int num = addNum.nextInt();
                    queue.addQueue(num);
                    break;
                case 'o':
                    queue.outQueue();
                    break;
                case 's':
                    queue.showQueue();
                    break;
                case 'h':
                    queue.getHeader();
                    break;
                case 'e':
                    loop = false;
                    break;
                default:
                    break;
            }
        }

    }
}

