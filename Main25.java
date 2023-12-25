package December;

import July.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main25 {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        Main25 tool = new Main25();
        System.out.println(tool.kthSmallest(node1, 1));
    }

    public int kthSmallest(TreeNode root, int k) {
        helper(list,root);
        return list.get(k - 1);
    }
    public void helper(List<Integer> list,TreeNode root) {
        if (root == null) {
            return;
        }
        helper(list,root.left);
        list.add(root.val);
        helper(list,root.right);
    }
    int pre = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }
}
