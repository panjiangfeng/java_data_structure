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

