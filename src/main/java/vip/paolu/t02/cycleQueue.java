package vip.paolu.t02;

import java.util.Scanner;

/**
 * Description:循环队列  数组实现(顺序表)
 * User: Pan
 * Date: 2023-02-15-16:04
 */
public class cycleQueue {
    //数组
    private int[] queue;
    //指向首
    private int front;
    //指向尾部的下一个
    private int rear;
    //最大值
    private int maxSize;

    public static void main(String[] args) {
        cycleQueue queue = new cycleQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char mode = ' ';
        while (loop) {
            System.out.println("a 入队");
            System.out.println("o 出队");
            System.out.println("s 循环队列");
            System.out.println("h 展示队头");
            System.out.println("e 跳出循环");
            mode = scanner.next().charAt(0);
            switch (mode) {
                case 'a': {
                    System.out.println("请输入一个整数");
                    try {
                        int t = scanner.nextInt();
                        queue.add(t);
                        System.out.println("入队_值为" + t);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 'o': {
                    try {
                        int x = queue.remove();
                        System.out.println("出队_值为" + x);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 's': {
                    try {
                        queue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 'h': {
                    try {
                        System.out.println("首值为:" + queue.getFront());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 'e': {
                    loop = false;
                    System.out.println("exit");
                    break;
                }
                default:
                    break;

            }
        }


    }

    /**
     * 创建队列
     */
    public cycleQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
    }

    /**
     * 判空
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 判满
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 一共有几个
     */
    public int getCount() {
        return ((rear + maxSize) - front) % maxSize;
    }

    /**
     * 显示首值
     */
    public int getFront() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无法显示首值");
        }
        return queue[front];
    }

    /**
     * 进队
     */
    public void add(int item) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        queue[rear] = item;
        rear = (rear + 1) % maxSize;

    }

    /**
     * 出队
     */
    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int i = queue[front];
        front = (front + 1) % maxSize;
        return i;

    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i = front; i < front + getCount(); i++) {
            System.out.printf(" " + queue[i % maxSize]);
        }
        System.out.println();
    }
}
