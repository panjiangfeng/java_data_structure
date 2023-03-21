package vip.paolu.t14;

/**
 * Description: 二叉树
 * User: Pan
 * Date: 2023-03-21-13:17
 */
public class BinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1, "宋江");
        Node node2 = new Node(2, "吴用");
        Node node3 = new Node(3, "卢俊义");
        Node node4 = new Node(4, "林冲");
        Node node5 = new Node(5, "关胜");
        /*手动创建二叉树*/
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        //第一阶段使用
        //System.out.println("前序遍历：");
        //binaryTree.showByPre();
        //System.out.println("中序遍历：");
        //binaryTree.showByCenter();
        //System.out.println("后序遍历：");
        //binaryTree.showByLatter();
        //第二阶段使用
        System.out.println("前序遍历查找：");//4次
        Node resNode = binaryTree.getNodeByPre(5);
        if (resNode != null) {
            System.out.printf("已找到 no=%d name=%s\n", resNode.getNo(), resNode.getName());
        } else {
            System.out.printf("没有找到 no = %d 的英雄\n", 5);
        }
        System.out.println("中序遍历查找：");//3次
        resNode = binaryTree.getNodeByCenter(5);
        if (resNode != null) {
            System.out.printf("已找到 no=%d name=%s\n", resNode.getNo(), resNode.getName());
        } else {
            System.out.printf("没有找到 no = %d 的英雄\n", 5);
        }
        System.out.println("后序遍历查找：");//2次
        resNode = binaryTree.getNodeByLatter(5);
        if (resNode != null) {
            System.out.printf("已找到 no=%d name=%s\n", resNode.getNo(), resNode.getName());
        } else {
            System.out.printf("没有找到 no = %d 的英雄\n", 5);
        }
    }

    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public BinaryTree() {
    }

    public void showByPre() {
        if (root == null) {
            System.out.println("二叉树为空,无法遍历哦");
        } else {
            root.showByPre();
        }
    }

    public void showByCenter() {
        if (root == null) {
            System.out.println("二叉树为空,无法遍历哦");
        } else {
            root.showByCenter();
        }
    }

    public void showByLatter() {
        if (root == null) {
            System.out.println("二叉树为空,无法遍历哦");
        } else {
            root.showByLatter();
        }
    }

    //前序遍历查找
    public Node getNodeByPre(int no) {
        if (this.root != null) {
            return this.root.getNodeByPre(no);
        } else {
            return null;
        }
    }

    //中序遍历查找
    public Node getNodeByCenter(int no) {
        if (this.root != null) {
            return this.root.getNodeByCenter(no);
        } else {
            return null;
        }
    }

    //后序遍历查找
    public Node getNodeByLatter(int no) {
        if (this.root != null) {
            return this.root.getNodeByLatter(no);
        } else {
            return null;
        }
    }
}

class Node {
    public Node left;
    public Node right;
    public int no;
    public String name;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void showByPre() {
        //根左右
        System.out.println(this);
        if (this.left != null) {
            this.left.showByPre();
        }
        if (this.right != null) {
            this.right.showByPre();
        }
    }

    public void showByCenter() {
        //左根右
        if (this.left != null) {
            this.left.showByCenter();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.showByCenter();
        }
    }

    public void showByLatter() {
        //左右根
        if (this.left != null) {
            this.left.showByLatter();
        }
        if (this.right != null) {
            this.right.showByLatter();
        }
        System.out.println(this);
    }

    public Node getNodeByPre(int no) {

        if (this.no == no) {
            return this;
        }
        Node resultNode = null;
        if (this.left != null) {
            resultNode = this.left.getNodeByPre(no);
        }
        if (resultNode != null) {
            return resultNode;
        }
        if (this.right != null) {
            resultNode = this.right.getNodeByPre(no);
        }
        if (resultNode != null) {
            return resultNode;
        }
        return resultNode;

    }

    public Node getNodeByCenter(int no) {
        Node resultNode = null;
        if (this.left != null) {
            resultNode = this.left.getNodeByCenter(no);
        }
        if (resultNode != null) {
            return resultNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resultNode = this.right.getNodeByCenter(no);
        }
        return resultNode;

    }

    public Node getNodeByLatter(int no) {

        Node resultNode = null;
        if (this.left != null) {
            resultNode = this.left.getNodeByLatter(no);
        }
        if (resultNode != null) {
            return resultNode;
        }
        if (this.right != null) {
            resultNode = this.right.getNodeByLatter(no);
        }
        if (resultNode != null) {
            return resultNode;
        }
        if (this.no == no) {
            return this;
        }
        return resultNode;

    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
