package vip.paolu.t18;

/**
 * Description:
 * User: Pan
 * Date: 2023-03-29-20:08
 */
public class BinarSortTree {
    private Node root;

    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 10, 12, 5, 1, 9, 2};
        BinarSortTree binarSortTree = new BinarSortTree();

        for (int i = 0; i < arr.length; i++) {
            binarSortTree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历二叉排序树");
        binarSortTree.infixOrder();

    }

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉树空  遍历不了");
        }
    }

}

class Node {
    Node left;
    Node right;
    int value;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void add(Node node) {
        if (node == null) {
            System.out.println("节点空,无法插入");
        } else {
            if (node.value < this.value) {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.add(node);
                }
            } else {
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.add(node);
                }
            }
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }
}