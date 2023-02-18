package vip.paolu.t06;

import java.util.Scanner;

/**
 * Description: 数组实现栈
 * User: Pan
 * Date: 2023-02-18-20:14
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        Scanner scanner = new Scanner(System.in);
        String mode;
        comand:
        while (true) {
            System.out.println("请输入命令");
            System.out.println("入栈push ");
            System.out.println("出栈pop ");
            System.out.println("遍历show ");
            System.out.println("退出exit ");
            mode = scanner.next();
            switch (mode) {
                case "push": {
                    System.out.println("请输入一个数字");
                    try {
                        arrayStack.push(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "pop": {
                    try {
                        System.out.println(arrayStack.pop() + "已pop");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "show": {
                    arrayStack.showAll();
                    break;
                }
                case "exit": {
                    System.out.println("成功退出");
                    break comand;
                }
                default: {
                    break;
                }
            }

        }


    }
}

/**
 * 数组栈
 */
class ArrayStack {
    private int top = -1; //最开始指向负一
    private int maxSize;
    private int[] stack;

    /**
     * 初始化栈
     *
     * @param maxSize 栈长度
     */
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 判是否空栈
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 判断是否满栈
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 压栈
     *
     * @param num
     */
    public void push(int num) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }
        stack[++top] = num;
    }

    /**
     * 弹栈
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[top--];
    }

    /**
     * 获取栈顶值
     *
     * @return
     */
    public int getTop() {
        return stack[top - 1];
    }

    /**
     * 遍历栈
     */
    public void showAll() {
        if (this.isEmpty()) {
            System.out.println("stack is empty");
        }

        for (int i = top; i >= 0; i--) {
            System.out.println("id:" + stack[i]);
        }
    }

}

