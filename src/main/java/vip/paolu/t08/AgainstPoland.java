package vip.paolu.t08;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Description:逆波兰表达式计算器(后缀表达式)
 * User: Pan
 * Date: 2023-02-19-14:34
 */
public class AgainstPoland {
    public static void main(String[] args) {
        List<String> data; //存放波兰表达式
        String str = "4 5 * 8 - 60 + 8 2 / +";
        data = getExpressionList(str);
        int result = calculate(data);
        System.out.println(result);
    }

    /**
     * 转成集合
     *
     * @param str
     * @return
     */
    public static List<String> getExpressionList(String str) {
        List<String> expression = Arrays.asList(str.split(" "));
        return expression;
    }

    /**
     * 使用栈计算后缀表达式
     *
     * @param data
     * @return
     */
    public static int calculate(List<String> data) {
        int i = 0;//计数
        int num1 = 0;//存放栈顶元素
        int num2 = 0;//存放栈顶之下的元素
        int result = 0;//存放运算结果
        Stack<String> stack = new Stack<String>();
        for (String str : data) {
            //是数字   搞里头
            if (str.matches("\\d+")) {
                stack.push(str);
            } else {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                //判断str是什么玩意
                switch (str) {
                    case "+": {
                        result = num1 + num2;
                        break;
                    }
                    case "-": {
                        result = num2 - num1;
                        break;
                    }
                    case "*": {
                        result = num1 * num2;
                        break;
                    }
                    case "/": {
                        result = num2 / num1;
                        break;
                    }
                    default: {
                        throw new RuntimeException("你输入的操作符有错啊,哥们");
                    }
                }
                stack.push(result + "");
            }
        }
        return result;
    }

    /**
     * 判断是否数字  用不到了 哈哈哈  用正则   String.match()
     *
     * @param x
     * @return
     */
    public static boolean isNum(char x) {
        return x >= '0' && x <= '9';
    }
}
