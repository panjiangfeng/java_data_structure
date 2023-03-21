package vip.paolu.t13;

import java.util.Scanner;

/**
 * Description: 哈希表实现
 * User: Pan
 * Date: 2023-03-21-12:28
 */
public class HashTable {
    private int size;
    private LinkList[] hashList;

    public HashTable(int size) {
        this.size = size;
        hashList = new LinkList[size];
        for (int i = 0; i < size; i++) {
            hashList[i] = new LinkList();
        }
    }

    public void add(Node node) {
        int hashValue = getHashValue(node.id);
        hashList[hashValue].add(node);
    }

    public void show() {
        for (int i = 0; i < hashList.length; i++) {
            hashList[i].show(i);
        }
    }

    public void getNodeById(int id) {
        int hashValue = getHashValue(id);
        Node node = hashList[hashValue].getNodeById(id);
        if (node == null) {
            System.out.println(id + "不在当前哈希表中");
        } else {
            System.out.println(id + "在第" + hashValue + "个哈希表中找到了");
        }
    }

    public int getHashValue(int id) {
        //此处好像浪费数组最后一个空间
        return id % size;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(6);
        //写一个菜单
        String key = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("add：添加节点");
            System.out.println("show：显示节点");
            System.out.println("find：查找节点");
            System.out.println("remove：删除节点");
            System.out.println("exit：退出系统");
            key = sc.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = sc.nextInt();
                    System.out.println("输入名字");
                    String name = sc.next();
                    //创建Node
                    Node node = new Node(id, name);
                    hashTable.add(node);
                    break;
                case "show":
                    hashTable.show();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = sc.nextInt();
                    hashTable.getNodeById(id);
                    break;
                case "remove":
                    System.out.println("请输入要删除的id");
                    id = sc.nextInt();
                    hashTable.removeById(id);
                    break;
                case "exit":
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("输入有误");
                    break;
            }
        }

    }

    private void removeById(int id) {
        int hashValue = getHashValue(id);
        hashList[hashValue].removeNode(id);

    }
}

class Node {
    public int id;
    public String name;
    public Node next;

    public Node() {
    }

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class LinkList {
    private Node head;

    public void add(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        Node index = head;//游标
        while (index.next != null) {
            index = index.next;
        }
        index.next = node;
    }

    public void show(int i) {
        if (head == null) {
            System.out.println("第" + i + "个链表为空");
        } else {
            System.out.print("第" + i + "个链表内容为:");
            Node index = head;//游标
            while (true) {
                System.out.print(index.id + ":" + index.name + "   ");
                if (index.next == null) {
                    break;
                }
                index = index.next;
            }
            System.out.println();
        }
    }

    public Node getNodeById(int id) {
        if (head == null) {
            return null;
        }
        Node index = head;//指向头结点游标
        while (true) {
            if (id == index.id) {
                break;
            }
            if (index.next == null) {
                index = null;
                break;
            }
            index = index.next;
        }
        return index;

    }

    public void removeNode(int id) {
        if (head == null) {
            System.out.println("当前链表为空,无法删除任何元素");
            return;
        }
        if (head.id == id) {
            System.out.println("删除成功");
            head = head.next;
            return;
        }
        Node index = head;
        while (true) {
            if (head.id == id) {
                System.out.println("找到并删除了");
                head = head.next;
            }
            if (index.next == null) {
                break;
            }
            if (index.next.id == id) {
                System.out.println("找到并删除了");
                index.next = index.next.next;
            }
            index = index.next;
        }
        System.out.println("没找到要删除的节点");
    }
}
