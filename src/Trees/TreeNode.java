package Trees;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    List<TreeNode> children;
    String val;
    TreeNode left;
    TreeNode right;

    public TreeNode(String val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode node) {
        this.children.add(node);
    }

    public String print(int level) {
        StringBuilder results;

        results = new StringBuilder("\t".repeat(level) + val + "\n");

        for (TreeNode node : this.children) {
            results.append(node.print(level + 1));
        }

        return results.toString();
    }
}
