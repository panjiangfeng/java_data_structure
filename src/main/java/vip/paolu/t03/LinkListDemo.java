package vip.paolu.t03;

/**
 * Description: 带头节点单链表
 * User: Pan
 * Date: 2023-02-16-19:15
 */
public class LinkListDemo {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.add(new LinkNode(1, "孙悟空"));
        linkList.add(new LinkNode(2, "猪八戒"));
        linkList.add(new LinkNode(4, "小白龙"));
        //linkList.getByLast(1);
        linkList.addByOrder(new LinkNode(3, "沙僧"));
        //linkList.update(4, "哈哈哈");
        //linkList.update(1, "嘻嘻嘻");
        linkList.showAll();
        //System.out.println(linkList.getValidCount());
        //try {
        //    linkList.delete(2);
        //    linkList.delete(2);
        //    linkList.delete(2);
        //    linkList.showAll();
        //    linkList.getByLast(1);
        //    System.out.println(linkList.getValidCount());
        //} catch (Exception e) {
        //    System.out.println(e.getMessage());
        //}
        linkList.reverseList();
        System.out.println("==============");
        linkList.showAll();

    }
}

class LinkList {

    private LinkNode head = new LinkNode(0, "");//头节点

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(LinkNode node) {
        LinkNode temp = this.head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;

    }

    /**
     * 顺序添加节点
     *
     * @param node
     */
    public void addByOrder(LinkNode node) {
        if (node.id <= 0) {
            System.out.println("输入节点错误");
            return;
        }
        LinkNode temp = this.head;
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
        temp.next = node;
    }

    /**
     * 展示所有节点
     */
    public void showAll() {
        LinkNode temp = this.head.next;
        while (true) {
            if (temp == null) {
                break;
            } else {
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }

    /**
     * 删除节点
     *
     * @param index
     * @return
     */
    public LinkNode delete(int index) {
        LinkNode temp = this.head;
        if (index <= 0) {
            System.out.println("该节点不存在");
        }
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;

        }
        if (temp.next == null) {
            System.out.println("该节点不存在");
        }
        LinkNode result = temp.next;
        temp.next = temp.next.next;
        return result;
    }

    /**
     * 更新节点
     *
     * @param index
     * @param name
     */
    public void update(int index, String name) {
        if (index <= 0) {
            System.out.println("该节点不存在");
            return;
        }
        LinkNode temp = this.head;
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
     * 获取链表有效数量(不包括头结点)
     *
     * @return
     */
    public int getValidCount() {
        int count = 0;
        LinkNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    /**
     * 获取倒数第几个值
     *
     * @param index
     */
    public void getByLast(int index) {
        LinkNode temp = this.head;
        int size = this.getValidCount();
        for (int i = 0; i <= size - index; i++) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        System.out.println(temp);
    }

    public void reverseList() {
        LinkList linkList = new LinkList(); //新链表
        LinkNode temp; //永远指向原链表第一个有效值
        LinkNode x = linkList.head; //永远指向新链表第一个有效值
        while (head.next != null) {
            temp = head.next;
            this.head.next = temp.next;
            temp.next = x.next;
            linkList.head.next = temp;
        }
        this.head.next = linkList.head.next;
    }
}

class LinkNode {
    int id;
    String name;
    LinkNode next;

    public LinkNode(int id, String name) {
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