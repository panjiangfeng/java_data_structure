package vip.paolu.t06;

/**
 * Description:数组栈
 * User: Pan
 * Date: 2023-02-18-20:53
 */

/**
 * 数组栈
 */
public class ArrayStack {
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

    public ArrayStack() {
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
        return top;
    }

    public int getTopValue() {
        if (this.isEmpty()) {
            System.out.println("stack is empty");
        }
        return stack[top];
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

