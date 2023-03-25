package vip.paolu.t16;

/**
 * Description:
 * User: Pan
 * Date: 2023-03-25-9:58
 */
public class Node implements Comparable<Node> {
    int value;//权值
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
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

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
