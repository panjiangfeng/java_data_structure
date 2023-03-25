package vip.paolu.t16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: 构建哈夫曼树
 * User: Pan
 * Date: 2023-03-25-10:00
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int array[] = {13, 7, 8, 3, 29, 6, 1};
        Node res = createHuffmanTree(array);
        showByPre(res);
    }

    public static void showByPre(Node node) {
        node.showByPre();
    }

    public static Node createHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<Node>();
        for (int val : arr) {
            nodes.add(new Node(val));
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}
