package vip.paolu.t08;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description: 实现中缀转后缀
 * User: Pan
 * Date: 2023-02-19-15:25
 */

//中缀表达式转后缀表达式（逆波兰表达式）
//思路分析


public class CenterfixToPostfix {
    private String expression; //存放表达式
    //（1）初始化两个栈，运算符栈s1和存储中间结果的栈s2；
    private Stack<String> s1 = new Stack();//;临时存放符号  后续会空
    private List<String> s2 = new ArrayList<>();//存放数字  为啥不用栈  因为只push不pop  还需要逆序  不如集合好用
    private static final int ADD = 1;// +  以下四个用来判断优先级
    private static final int SUB = 1;// -
    private static final int MUL = 2;// *
    private static final int DIVIDE = 2;//

    public static void main(String[] args) {
        CenterfixToPostfix centerfixToPostfix = new CenterfixToPostfix("1+(2+3)*4-5");
        List<String> centerExpressionList = centerfixToPostfix.getCenterExpressionList();
        centerfixToPostfix.parseExpression(centerExpressionList);
        System.out.println(centerfixToPostfix.getS2());
        System.out.println("结果是" + AgainstPoland.calculate(centerfixToPostfix.getS2()));
    }

    /**
     * 初始化表达式
     *
     * @param expression
     */
    public CenterfixToPostfix(String expression) {
        this.expression = expression;
    }

    /**
     * 格式化中缀表达式到s2
     *
     * @param expressionList
     */
    public void parseExpression(List<String> expressionList) {
        //（2）从左到右扫描中缀表达式
        for (int i = 0; i < expressionList.size(); i++) {
            String data = expressionList.get(i);
            if (data.matches("\\d+")) {
                //（3）遇到操作数时，将其压s2
                s2.add(data);
            } else if (data.equals("(")) {
                //1.左括号(则直接压入s1
                s1.push(data);
            } else if (data.equals(")")) {
                //2.有符号)则弹出s1栈顶的运算符并压入s2,直到遇到左括号，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                //* （4）遇到运算符时，比较其与s1栈顶运算符的优先级
                // * 1.如果s1为空或（ 则直接压入
                // * 2.如果优先级比栈顶的高，压入
                // * 3.否则将s1栈顶的运算符弹出并压入s2中，再次钻到4.1与s1中新的栈顶比较
                char ch = data.charAt(0);
                while (s1.size() != 0 && getPriorValue(s1.peek().charAt(0)) >= getPriorValue(ch)) {
                    s2.add(s1.pop());
                }
                s1.push(ch + "");
            }
        }
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
    }

    /**
     * 获取s2表达式集合
     *
     * @return
     */
    public List<String> getS2() {
        return s2;
    }

    /**
     * 中缀字符串转表达式
     *
     * @return
     */
    public List<String> getCenterExpressionList() {
        int index = 0;//定位
        ArrayList<String> centerExpressionList = new ArrayList<>();
        char ch;//存放表达式字符
        while (index < expression.length()) {
            ch = expression.charAt(index);
            String num = "";
            if (AgainstPoland.isNum(ch)) {
                //逻辑:不止一位数字
                num = num + ch;
                //判断下一位还是数字么  是  继续加
                while (index + 1 < expression.length() && AgainstPoland.isNum(expression.charAt(index + 1))) {
                    index++;
                    ch = expression.charAt(index);
                    num = num + ch;
                }
                centerExpressionList.add(num);
            } else {
                centerExpressionList.add(ch + "");
            }
            index++;
        }
        return centerExpressionList;
    }

    /**
     * 获取优先级
     *
     * @param ch
     * @return
     */
    public int getPriorValue(char ch) {
        int val = 0;//优先级别  0最小
        switch (ch) {
            case '+': {
                val = ADD;
                break;
            }
            case '-': {
                val = SUB;
                break;
            }
            case '*': {
                val = MUL;
                break;
            }
            case '/': {
                val = DIVIDE;
                break;
            }
            default: {
                break;
            }
        }
        return val;
    }
}
