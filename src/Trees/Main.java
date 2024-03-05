package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static List<String> results = new ArrayList<>();

    public static void main(String[] args) {

    }

    public void BinaryTreeData() {
        BinarySearchTree newBST = new BinarySearchTree();
        newBST.insert(70);
        newBST.insert(50);
        newBST.insert(90);
        newBST.insert(30);
        newBST.insert(60);
        newBST.insert(80);
        newBST.insert(100);
        newBST.insert(20);
        newBST.insert(40);
    }

    public void treeNodeData() {
        TreeNode drinks = new TreeNode("Drinks");
        TreeNode hot = new TreeNode("Hot");
        TreeNode cold = new TreeNode("Cold");
        TreeNode tea = new TreeNode("Tea");
        TreeNode coffee = new TreeNode("Coffee");
        TreeNode wine = new TreeNode("Tea");
        TreeNode beer = new TreeNode("Coffee");
        drinks.addChild(hot);
        drinks.addChild(cold);
        hot.addChild(tea);
        hot.addChild(coffee);
        cold.addChild(wine);
        cold.addChild(beer);
    }

    public static TreeNode constructBinaryTree() {
        /*
                   1
                 /   \
                2     3
               / \   / \
              4   5 6   7
        */
        TreeNode root = new TreeNode("1");
        root.left = new TreeNode("2");
        root.right = new TreeNode("3");
        root.left.left = new TreeNode("4");
        root.left.right = new TreeNode("5");
        root.right.left = new TreeNode("6");
        root.right.right = new TreeNode("7");

        return root;
    }

    public static List<String> postorderTraversal(TreeNode root) {
        if (root == null)
            return results;

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        results.add(root.val);
        return results;
    }

    public static List<String> inorderTraversal(TreeNode root) {
        if (root == null)
            return results;

        inorderTraversal(root.left);
        System.out.println(root.val + "-> ");
        results.add(root.val);
        inorderTraversal(root.right);

        return results;
    }

    public static List<String> preorderTraversal(TreeNode root) {
        if (root == null)
            return results;

        results.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return results;
    }

    public List<List<String>> levelOrder(TreeNode root) {
        // Instantiate list of list
        List<List<String>> results = new ArrayList<>();
        if (root == null)
            return results;

        // Create que data structure
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Create new list for level
            List<String> tempList = new ArrayList<>();

            int size = queue.size();
            int count = 0;

            while (count < size) {

                TreeNode node = queue.poll();
                tempList.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                count++;
            }

            results.add(tempList);
        }

        return results;
    }


}
