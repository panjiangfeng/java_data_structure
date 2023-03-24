package vip.paolu.t15;

/**
 * Description:
 * User: Pan
 * Date: 2023-03-23-21:40
 */
public class ThreadedBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1, "tom");
        Node node2 = new Node(3, "jack");
        Node node3 = new Node(6, "smith");
        Node node4 = new Node(8, "mary");
        Node node5 = new Node(10, "king");
        Node node6 = new Node(14, "dim");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        Node leftNode = node5.getLeft();
        Node rightNode = node5.getRight();
        //System.out.println("线索化前：10号结点的前驱结点为：" + leftNode);//3
        //System.out.println("线索化前：10号结点的后继结点为：" + rightNode);//1
        threadedBinaryTree.threadedNodes();
        //测试，以10号结点测试
        //leftNode = node5.getLeft();
        //rightNode = node5.getRight();
        //System.out.println("10号结点的前驱结点为：" + leftNode);//3
        //System.out.println("10号结点的后继结点为：" + rightNode);//1
        threadedBinaryTree.threadShowByCenter();

    }


    private Node root;
    private Node pre;

    public ThreadedBinaryTree(Node root) {
        this.root = root;
    }

    public ThreadedBinaryTree() {
    }

    public void threadShowByCenter() {
        Node node = root;
        while (node != null) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private void threadedNodes() {
        this.threadedNodes(root);
    }

    public void threadedNodes(Node node) {
        if (node == null) {
            return;
        }
        threadedNodes(node.getLeft());
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        threadedNodes(node.getRight());


    }
}
