package vip.paolu.t14;

/**
 * Description:
 * User: Pan
 * Date: 2023-03-22-20:53
 */

public class Node {
    public Node left;
    public Node right;
    public int no;
    public String name;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void deleteNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.deleteNode(no);
        }
        if (this.right != null) {
            this.right.deleteNode(no);
        }

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
