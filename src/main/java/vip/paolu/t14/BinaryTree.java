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
        //System.out.println("前序遍历查找：");//4次
        //Node resNode = binaryTree.getNodeByPre(5);
        //if (resNode != null) {
        //    System.out.printf("已找到 no=%d name=%s\n", resNode.getNo(), resNode.getName());
        //} else {
        //    System.out.printf("没有找到 no = %d 的英雄\n", 5);
        //}
        //System.out.println("中序遍历查找：");//3次
        //resNode = binaryTree.getNodeByCenter(5);
        //if (resNode != null) {
        //    System.out.printf("已找到 no=%d name=%s\n", resNode.getNo(), resNode.getName());
        //} else {
        //    System.out.printf("没有找到 no = %d 的英雄\n", 5);
        //}
        //System.out.println("后序遍历查找：");//2次
        //resNode = binaryTree.getNodeByLatter(5);
        //if (resNode != null) {
        //    System.out.printf("已找到 no=%d name=%s\n", resNode.getNo(), resNode.getName());
        //} else {
        //    System.out.printf("没有找到 no = %d 的英雄\n", 5);
        //}
        //第三阶段使用
        System.out.println("删除前：");
        binaryTree.showByPre();
        binaryTree.deleteNode(3);
        System.out.println("删除后：");
        binaryTree.showByPre();
    }

    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public BinaryTree() {
    }

    /**
     * 二叉树节点删除:
     * 注意此处删除规则是:  如果是叶子节点直接删除,如果不是叶子节点,那就删除整个子树  没错  逻辑就是这样
     *
     * @param no
     */
    public void deleteNode(int no) {
        if (root == null) {
            System.out.println("空树,删除不了哦");
        } else {
            if (root.no == no) {
                root = null;
            } else {
                root.deleteNode(no);
            }
        }
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
