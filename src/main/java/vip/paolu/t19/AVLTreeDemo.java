package vip.paolu.t19;

/**
 * Description:
 * User: Pan
 * Date: 2023-04-04-21:02
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] arr = {4, 3, 6, 5, 7, 8};
        //int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历：");
        avlTree.infixOrder();
        System.out.println("树的高度为：" + avlTree.getRoot().height());
        System.out.println("树的左子树高度为：" + avlTree.getRoot().leftHeight());
        System.out.println("树的右子树高度为" + avlTree.getRoot().rightHeight());
    }
}

class AVLTree {
    private Node root;


    //添加
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public Node getRoot() {
        return root;
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("空树无法遍历");
        }
    }

    //查找要删除的节点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 功能：返回以node为根节点的二叉排序树的最小节点的值 并删除以node为根节点的二叉排序树的最小节点
     *
     * @param node 传入的当做二叉树根节点的节点
     * @return 返回以node为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左节点 直到找到最小值
        while (target.left != null) {
            target = target.left;
        }//退出循环时说明找到了 target指向的就是最小值
        //删除该最小值节点
        delNode(target.value);
        return target.value;
    }

    /**
     * 功能：返回以node为根节点的二叉排序树的最大节点的值 并删除以node为根节点的二叉排序树的最大节点
     *
     * @param node 传入的当做二叉树根节点的节点
     * @return 返回以node为根节点的二叉排序树的最大节点的值
     */
    public int delLeftTreeMax(Node node) {
        Node target = node;
        //循环的查找右节点 直到找到最大值
        while (target.right != null) {
            target = target.right;
        }//退出循环时说明找到了 target指向的就是最大值节点
        //删除该最大值节点
        delNode(target.value);
        return target.value;
    }

    //删除节点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //1、需要先去找到要删除的结点  targetNode
            Node targetNode = search(value);
            if (targetNode == null) {//没有找到
                return;
            }
            //如果当前二叉排序树只有一个节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //2、找到targetNode 的 父结点 parent
            Node parent = searchParent(value);
            //第一种情况：要删除的节点是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                //3、确定targetNode是parent的左子节点还是右子节点
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            }
            //第三种情况：要删除的节点有两个子节点
            else if (targetNode.left != null && targetNode.right != null) {
//                int minVal = delRightTreeMin(targetNode.right);
//                targetNode.value=minVal;
                int maxVal = delLeftTreeMax(targetNode.left);
                targetNode.value = maxVal;
            }
            //第二种情况：要删除的节点只有一个子节点
            else {
                //如果要删除的节点有左子节点
                if (targetNode.left != null) {
                    if (parent != null) {
                        //且要删除的节点是父节点的左子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {//要删除的节点是父节点的右子节点
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                }
                //如果要删除的节点有右子节点
                else {
                    //且要删除的节点是父节点的左子节点
                    if (parent.left.value == value) {
                        if (parent != null) {
                            parent.left = targetNode.right;
                        } else {//要删除的节点是父节点的右子节点
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }

                }

            }

        }
    }
}

//创建节点
class Node {
    int value;
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

    private void rightRotate() {
        //复制当前节点
        Node newNode = new Node(value);
        //新节点的右节点等于原右节点
        newNode.right = right;
        //新节点的左节点等于原左节点的右节点
        newNode.left = left.right;
        //当前节点等于做节点
        value = left.value;
        left = left.left;
        right = newNode;
    }

    private void leftRotate() {
        //复制当前节点
        Node newNode = new Node(value);
        //当前节点的左节点等于原节点的左节点
        newNode.left = left;
        //当前节点的右节点等于原来右节点的左节点
        newNode.right = right.left;
        //原来节点等于原节点的右节点
        value = right.value;
        //原来节点的右子树等于原节点柚子树的柚子树
        right = right.right;
        //原节点的左节点等于新节点
        left = newNode;
    }

    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.height();
        }
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.height();
        }
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //添加
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
        if (rightHeight() - leftHeight() > 1) {
            if (right != null && right.leftHeight() > right.rightHeight()) {
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
        }
        if (leftHeight() - rightHeight() > 1) {
            if (left != null && left.rightHeight() > left.leftHeight()) {
                left.leftRotate();
                rightRotate();
            } else {
                rightRotate();
            }
        }
    }


    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 功能：查找到要删除的节点
     *
     * @param value 要删除节点的值
     * @return 如果找到则返回该节点 否则返回null
     */
    public Node search(int value) {
        if (value == this.value) {//传入的value值等于当前节点的value值 即找到
            return this;
        } else if (value < this.value) {//向左子树查找
            //若左子节点为空则找不到
            if (this.left == null) {
                return null;
            } else {
                //向左子树递归查找
                return this.left.search(value);
            }
        } else {//向右子树查找
            //若右子节点为空则找不到
            if (this.right == null) {
                return null;
            } else {
                //向右子树递归查找
                return this.right.search(value);
            }
        }
    }

    /**
     * 功能：查找父节点
     *
     * @param value 要删除节点的值
     * @return 返回要删除节点的父节点 否则返回null
     */
    public Node searchParent(int value) {

        if (this.left != null && this.left.value == value || this.right != null && this.right.value == value) {
            return this;//当前节点即为要删除节点的父节点
        } else {
            if (value < this.value && this.left != null) {
                //递归的向左子树查找
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                //递归的向右子树查找
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

}