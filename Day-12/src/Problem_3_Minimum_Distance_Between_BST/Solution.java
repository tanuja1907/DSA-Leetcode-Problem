package Problem_3_Minimum_Distance_Between_BST;

/**
 * this program calculates minimum diff between all the nodes in BST
 * inorder functions  calculates diff here curr variable stores root val and compare with left and right child
 * T.C.-O(n)
 * S.C.-O(log n)
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

    private Integer curr = null;
    private int ans = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return ans;

    }

    void inorder(TreeNode root) {

        if (root == null) return;
        inorder(root.left);
        if (curr != null) {
            ans = Math.min(ans, root.val - curr);
        }
        curr = root.val;
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(6, null, null);
        Solution solution = new Solution();
        System.out.println(solution.minDiffInBST(root));
    }
}