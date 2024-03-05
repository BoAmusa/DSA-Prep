package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }

    private BinaryNode insert(BinaryNode currentNode, int value) {
        if (currentNode == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.intValue = value;
            System.out.println("The Value successfully inserted");
            return newNode;
        } else if (value <= currentNode.intValue) {
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    void insert(int value) {
        root = insert(root, value);
    }

    public void preOrder(BinaryNode node) {
        if (node == null) return;

        System.out.print(node.intValue + " ->");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(BinaryNode node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.print(node.intValue + " ->");
        inOrder(node.right);
    }

    public void postOrder(BinaryNode node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.intValue + " ->");
    }

    public void levelOrder(BinaryNode node) {
        if (node == null) return;

        Queue<BinaryNode> que = new LinkedList<>();
        que.add(node);

        while (!que.isEmpty()) {
            BinaryNode tempNode = que.poll();
            System.out.println(tempNode.intValue + " -> ");

            if (tempNode.left != null) {
                que.add(tempNode.left);
            }

            if (tempNode.right != null) {
                que.add(tempNode.right);
            }
        }
    }

    public void stackOrder(BinaryNode node) {
        System.out.print("Stack---");
        if (node == null) return;
        Stack<BinaryNode> nodeStack = new Stack<>();
        nodeStack.push(node);

        while (!nodeStack.isEmpty()) {

            BinaryNode tempNode = nodeStack.pop();

            System.out.print(tempNode.intValue + "->");

            if (tempNode.right != null) {
                nodeStack.push(tempNode.right);
            }

            if (tempNode.left != null) {
                nodeStack.push(tempNode.left);
            }
        }

    }

    public BinaryNode search(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("Value: " + value + " not found in BST");
            return null;
        } else if (node.intValue == value) {
            System.out.println("Value: " + value + " found in BST");
            return node;
        } else if (value < node.intValue) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    // Minimum node
    public static BinaryNode minimumNode(BinaryNode root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    // Delete node
    public BinaryNode deleteNode(BinaryNode root, int value) {
        if (root == null) {
            System.out.println("Value not found in BST");
            return null;
        }
        if (value < root.intValue) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.intValue) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left != null && root.right != null) {
                BinaryNode temp = root;
                BinaryNode minNodeForRight = minimumNode(temp.right);
                root.value = minNodeForRight.value;
                root.right = deleteNode(root.right, minNodeForRight.intValue);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }

        return root;

    }
}
