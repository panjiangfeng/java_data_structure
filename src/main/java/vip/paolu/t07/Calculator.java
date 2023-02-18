package vip.paolu.t07;


import vip.paolu.t06.ArrayStack;

/**
 * Description: 栈实现计算器 不支持负数不支持括号优先级哦
 * User: Pan
 * Date: 2023-02-18-20:49
 */
public class Calculator {
    public static void main(String[] args) {
        //首先输入字符串 例3*5+5-2*5 = 10
        String str = "100+5*10";
        int num1;
        int num2;
        String tempNum = "";
        //创建2个栈  数字栈  字符栈
        CalStack numStack = new CalStack(10);
        CalStack chStack = new CalStack(10);
        int index = 0;//扫描字符串 为啥不用for  因为有可能连续数字  导致多遍历
        while (true) {
            //定义一个变量temp遍历
            //如果是字符栈
            char val = str.substring(index, index + 1).charAt(0);
            if (chStack.isOper(val)) {
                //先判断是否是第一次加入,是第一次直接压栈
                if (chStack.isEmpty()) {
                    chStack.push(val);
                } else {
                    //如果不是判断此次加入的字符优先级小于等于字符栈顶
                    if (chStack.getPrior(val) <= chStack.getPrior((char) chStack.getTopValue())) {
                        //是:拿出2个数字栈顶  拿出一个字符栈顶计算  然后压栈
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        int result = chStack.calculate(num1, num2, (char) chStack.pop());
                        numStack.push(result);
                        chStack.push(val);
                    } else {
                        //不是: 直接加入符号栈
                        chStack.push(val);
                    }
                }
            } else {
                //如果是数字 直接加入数字栈
                //numStack.push(val - 48);
                tempNum = tempNum + val;
                if (index == str.length() - 1) {
                    numStack.push(Integer.parseInt(tempNum));
                } else {
                    if (chStack.isOper(str.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(tempNum));
                        tempNum = "";

                    }
                }
            }
            index++;
            if (index == str.length()) {
                break;
            }
        }

        while (true) {
            //当字符串栈kon的时候  就结束了
            if (chStack.isEmpty()) {
                break;
            }
            //取出的时候
            //拿出2个数字栈顶  拿出一个字符栈顶计算
            //如果只剩下最后一个  那就是结果
            num1 = numStack.pop();
            num2 = numStack.pop();
            int result = chStack.calculate(num1, num2, (char) chStack.pop());
            numStack.push(result);
        }
        System.out.println("结果是:" + numStack.pop());

    }


}

/**
 * 计算器栈
 */
class CalStack extends ArrayStack {
    /**
     * 创建栈
     *
     * @param maxSize
     */
    public CalStack(int maxSize) {
        super(maxSize);
    }

    /**
     * 是否是操作符
     *
     * @param x
     * @return
     */
    public boolean isOper(char x) {
        return x == '+' || x == '-' || x == '*' || x == '/';
    }

    /**
     * 获取优先级  +- 是0  *\/是1
     *
     * @param x
     * @return
     */
    public int getPrior(char x) {
        if (x == '+' || x == '-') {
            return 0;
        } else if (x == '*' || x == '/') {
            return 1;
        } else {
            //你瞎输入哈 乱搞哦
            return -1;
        }
    }

    /**
     * 计算器
     *
     * @param x
     * @param y
     * @param oper
     * @return
     */
    public int calculate(int x, int y, char oper) {
        switch (oper) {
            case '+': {
                return x + y;
            }
            case '-': {
                return y - x;
            }
            case '*': {
                return x * y;
            }
            case '/': {
                return y / x;
            }
            default: {
                throw new RuntimeException("请输入正确的符号");
            }
        }
    }
}