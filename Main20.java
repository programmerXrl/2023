package December;

import July.TreeNode;

import java.util.*;

public class Main20 {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }
    public void helper(TreeNode root,List<Integer> list) {
        if (root == null) return;
        if (root.left != null) helper(root.left,list);
        list.add(root.val);
        if (root.right != null) helper(root.right,list);
    }
}
