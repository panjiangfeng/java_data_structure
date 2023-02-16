package vip.paolu.t03;

/**
 * Description:
 * User: Pan
 * Date: 2023-02-16-19:15
 */
public class LinkListDemo {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.add(new LinkNode(1, "孙悟空"));
        linkList.add(new LinkNode(2, "猪八戒"));
        linkList.add(new LinkNode(4, "小白龙"));
        linkList.addByOrder(new LinkNode(3, "沙僧"));
        linkList.update(4, "哈哈哈");
        linkList.update(1, "嘻嘻嘻");
        linkList.showAll();
        System.out.println(linkList.getValidCount());
        try {
            linkList.delete(2);
            linkList.delete(2);
            linkList.delete(2);
            linkList.showAll();
            System.out.println(linkList.getValidCount());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}

class LinkList {
    private LinkNode head = new LinkNode(0, "");

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

    public int getValidCount() {
        int count = 0;
        LinkNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
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