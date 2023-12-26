package December;

import July.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main26 {
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        helper(list,root);
        TreeNode cur = root;
        for (int i = 1; i < list.size(); i++) {
            cur.right = list.get(i);
            cur = cur.right;
        }
    }

    static List<TreeNode> list = new ArrayList<>();

    public void helper(List<TreeNode> list, TreeNode root) {
        // 如果当前节点为空，直接返回
        if (root == null) {
            return;
        }
        // 将当前节点的值存入列表中
        list.add(root);
        helper(list, root.left);
        helper(list, root.right);
    }


    /**
     * 返回二叉树每一层最右边的节点值组成的列表
     *
     * @param root 二叉树根节点
     * @return 每一层最右边的节点值组成的列表
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // 存储结果的列表
        if (root == null) { // 如果根节点为空，直接返回空列表
            return result; // 返回结果列表
        }
        int val = 0; // 当前节点的值
        Queue<TreeNode> queue = new LinkedList<>(); // 存储节点的队列
        queue.offer(root); // 将根节点入队
        while (!queue.isEmpty()) { // 当队列不为空时
            int size = queue.size(); // 获取当前队列的长度
            List<Integer> list = new ArrayList<>(); // 存储当前层的节点值
            for (int i = 0; i < size; i++) { // 遍历当前层的所有节点
                TreeNode node = queue.poll(); // 从队列中取出一个节点
                list.add(node.val); // 将节点的值添加到当前层的节点值列表中
                if (node.left != null) { // 如果左子节点不为空，将其入队
                    queue.offer(node.left);
                }
                if (node.right != null) { // 如果右子节点不为空，将其入队
                    queue.offer(node.right);
                }
            }
            result.add(list.get(list.size() - 1)); // 将当前层最右边的节点值添加到结果列表中
        }
        return result; // 返回结果列表
    }

}
