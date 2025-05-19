package Problem_2_Delete_node_in_bst;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * using iterative approach to find and delete key and of not found then return tree root as it as
 *T.C.-O(h),height of the tree
 *S.C.-O(h),height of the tree
 */
class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        return checkKey(root, key);

    }

    /**
     * firstly it checks if the value of key is greater than it checks in right and otherwise in left
     * @param root  root of binary tree
     * @param key   value to be deleted
     * @return      return the updated tree root node
     */
    TreeNode checkKey(TreeNode root, int key) {

        if (root == null) return null;
        if (key > root.val) {
            root.right = checkKey(root.right, key);
        } else if (key < root.val) {
            root.left = checkKey(root.left, key);
        } else {
            // when node value matched it checks whether it has child or not and if yes ,replaces with most left node
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            root.val = node.val;
            root.right = checkKey(root.right, node.val);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3, new TreeNode(2), new TreeNode(4));
        root.right = new TreeNode(6, null, new TreeNode(7));
        Solution solution = new Solution();
        TreeNode updatedRoot = solution.deleteNode(root, 3);
        String output = printTree(updatedRoot);
        System.out.println(output);
    }

    // Level-order traversal that returns string like [5, 4, 6, 2, null, null, 7]
    public static String printTree(TreeNode root) {
        if (root == null) return "[]";

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        // Remove trailing "null"s
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            result.remove(i--);
        }

        return result.toString();
    }


}