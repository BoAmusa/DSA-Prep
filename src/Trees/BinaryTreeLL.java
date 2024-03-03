package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {
    BinaryNode root;

    public BinaryTreeLL() {
        this.root = null;
    }

    void preOrder(BinaryNode node) {
        if (node == null) return;

        System.out.print(node.value + "->");
        preOrder(node.left);
        preOrder(node.right);
    }

    void postOrder(BinaryNode node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + "->");
    }

    void inOrder(BinaryNode node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.print(node.value + "->");
        inOrder(node.right);

    }

    // Level Order traversal
    void levelOrder() {

        Queue<BinaryNode> que = new LinkedList<>();
        que.add(this.root);
        int level = 1;

        while (!que.isEmpty()) {
            int size = que.size();
            int count = 0;

            while (count < size) {
                BinaryNode node = que.poll();
                System.out.print(node.value + "->");

                if (node.left != null) {
                    que.add(node.left);
                }

                if (node.right != null) {
                    que.add(node.right);
                }

                count++;
            }

            System.out.println("Level " + level);
            level++;
        }
    }

    public BinaryNode getDeepestNode() {
        BinaryNode deepNode = null;
        Queue<BinaryNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            deepNode = que.poll();

            if (deepNode.left != null) {
                que.add(deepNode.left);
            }
            if (deepNode.right != null) {
                que.add(deepNode.right);
            }
        }
        return deepNode;
    }

    void deleteDeepestNode() {

        Queue<BinaryNode> que = new LinkedList<>();
        que.add(root);

        BinaryNode prevNode = null;
        BinaryNode currNode = null;

        while (!que.isEmpty()) {
            prevNode = currNode;
            currNode = que.poll();

            if (currNode.left == null) {
                prevNode.right = null;
                return;
            } else if (currNode.right == null) {
                currNode.left = null;
                return;
            }

            que.add(currNode.left);
            que.add(currNode.right);
        }
    }

    void deleteNode(String value) {

        Queue<BinaryNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            BinaryNode presentNode = que.poll();
            if (presentNode.value.equals(value)) {
                presentNode.value = getDeepestNode().value;
                deleteDeepestNode();
                System.out.println("The node is deleted!");
                return;
            } else {
                if (presentNode.left != null) {
                    que.add(presentNode.left);
                }

                if (presentNode.right != null) {
                    que.add(presentNode.right);
                }
            }
        }

        System.out.println("Unable to delete");
    }
}
