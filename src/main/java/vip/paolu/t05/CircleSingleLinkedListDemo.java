package vip.paolu.t05;

/**
 * Description: 约瑟夫环问题  坑点注意了解规则不然很容易出错  哈哈哈
 * User: Pan
 * Date: 2023-02-18-13:57
 */
public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.add(5);
        //list.showAll();
        list.outByOrder(2, 3);

    }
}

class CircleSingleLinkedList {
    private CircleSingleLinkedNode first = null;
    private int count = 0;

    /**
     * 添加几个数  依次顺序加入  填5  就是 1 2 3 4 5
     *
     * @param nums 数量
     */
    public void add(int nums) {
        CircleSingleLinkedNode temp = null;
        if (nums < 2) {
            System.out.println("至少2个人才能完,你不配!");
        }

        for (int i = 1; i <= nums; i++) {
            CircleSingleLinkedNode node = new CircleSingleLinkedNode(i);
            if (i == 1) {
                first = node;
                temp = first;
            } else {
                temp.setNext(node);
                temp = node;
            }
            node.setNext(first);
        }
        this.count = nums;
    }

    public void showAll() {
        CircleSingleLinkedNode temp = this.first;
        while (true) {
            System.out.println(temp);
            if (temp.getNext() == first) {
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 从begin开始喊,喊的第countNum的人出去
     * 逻辑一开始写错了   应该是从begin开始喊    喊到第countNum的人出去,而不是begin开始的第countNum
     *
     * @param begin
     * @param countNum
     */
    public void outByOrder(int begin, int countNum) {
        if (begin < 1 || begin >= count) {
            System.out.println("开始的人号数必须小于1,不能大于总人数");
        }
        CircleSingleLinkedNode out = first; //指向要出圈的节点
        CircleSingleLinkedNode preOut = first;//指向出圈前一个节点
        while (true) {
            if (preOut.getNext() == first) {
                break;
            }

            preOut = (preOut.getNext());
        }
        for (int i = 0; i < begin - 1; i++) {
            out = out.getNext();
            preOut = preOut.getNext();
        }
        while (true) {
            if (out == preOut) {
                //已经只剩一个了
                break;
            } else {
                for (int i = 0; i < countNum - 1; i++) {
                    out = out.getNext();
                    preOut = preOut.getNext();
                }
                preOut.setNext(out.getNext());
                System.out.println("出圈人是" + out.getNo());
                out = preOut.getNext();

            }
        }

    }
}

class CircleSingleLinkedNode {
    private int no;
    private CircleSingleLinkedNode next;

    public int getNo() {
        return no;
    }

    @Override
    public String toString() {
        return "编号为" +
                "=" + no
                ;
    }

    public CircleSingleLinkedNode(int no) {
        this.no = no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public CircleSingleLinkedNode getNext() {
        return next;
    }

    public void setNext(CircleSingleLinkedNode next) {
        this.next = next;
    }
}