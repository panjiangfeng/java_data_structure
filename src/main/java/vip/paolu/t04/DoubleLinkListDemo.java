package vip.paolu.t04;


/**
 * Description:带头结点双向链表
 * User: Pan
 * Date: 2023-02-18-13:12
 */
public class DoubleLinkListDemo {
    public static void main(String[] args) {
        DoubleLinkList doubleLinkList = new DoubleLinkList();
        doubleLinkList.add(new DoubleLinkNode(1, "孙悟空"));
        doubleLinkList.add(new DoubleLinkNode(2, "猪八戒"));
        doubleLinkList.add(new DoubleLinkNode(4, "小白龙"));
        doubleLinkList.add(new DoubleLinkNode(3, "沙僧"));
        //doubleLinkList.showAll();
        System.out.println("删除节点为" + doubleLinkList.delete(4));
        doubleLinkList.showAll();
        //doubleLinkList.update(3, "小白龙");
        doubleLinkList.addByOrder(new DoubleLinkNode(3, "沙僧"));
        doubleLinkList.showAll();
        //System.out.println(doubleLinkList.getValidCount());
    }
}

/**
 * 双向链
 */
class DoubleLinkList {
    private DoubleLinkNode head = new DoubleLinkNode(0, "");//头节点

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(DoubleLinkNode node) {
        DoubleLinkNode temp = this.head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        node.pre = temp;
        temp.next = node;

    }

    /**
     * 顺序添加节点
     *
     * @param node
     */
    public void addByOrder(DoubleLinkNode node) {
        if (node.id <= 0) {
            System.out.println("输入节点错误");
            return;
        }
        DoubleLinkNode temp = this.head;
        while (true) {
            if (temp.id <= node.id) {
                temp = temp.next;
            }
            if (temp.next.id >= node.id) {
                break;
            }
        }
        if (temp.id == node.id || temp.next.id == node.id) {
            System.out.println("该用户已存在,插入失败");
        }
        node.next = temp.next;
        if (temp.next != null) {
            temp.next.pre = node;
        }
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 展示所有节点
     */
    public void showAll() {
        DoubleLinkNode temp = this.head.next;
        while (true) {
            if (temp == null) {
                break;
            } else {
                System.out.println(temp);
                temp = temp.next;
            }
        }
        System.out.println();
    }

    /**
     * 删除节点
     *
     * @param index
     * @return
     */
    public DoubleLinkNode delete(int index) {
        DoubleLinkNode temp = this.head;
        if (index <= 0) {
            System.out.println("该节点不存在");
        }
        for (int i = 0; i < index; i++) {
            temp = temp.next;
            System.out.println(temp);
        }
        if (temp == null) {
            System.out.println("该节点不存在");
        }
        DoubleLinkNode result = temp;
        if (temp.next != null) {
            temp.next.pre = temp.pre;
        }
        temp.pre.next = temp.next;
        return result;
    }

    /**
     * 更新节点  从1开始  比如更新第一个节点
     *
     * @param index
     * @param name
     */
    public void update(int index, String name) {
        if (index <= 0) {
            System.out.println("该节点不存在");
            return;
        }
        DoubleLinkNode temp = this.head;
        for (int i = 0; i < index; i++) {
            if (temp.next == null) {
                break;
            } else {
                temp = temp.next;
            }
        }
        if (temp == null) {
            System.out.println("该节点不存在");
        } else {
            temp.name = name;
        }


    }

    /**
     * 获取有效节点数
     *
     * @return
     */
    public int getValidCount() {
        int count = 0;
        DoubleLinkNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

}

/**
 * 双向节点
 */
class DoubleLinkNode {
    int id;
    String name;
    DoubleLinkNode pre;
    DoubleLinkNode next;

    public DoubleLinkNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "LinkNode{" +
                "id=" + id +
                ", name=" + name + "}";
    }
}