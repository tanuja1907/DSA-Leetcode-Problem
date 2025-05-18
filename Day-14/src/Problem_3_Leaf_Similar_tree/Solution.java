package Problem_3_Leaf_Similar_tree;

/**
 * This class provides a method to check whether two binary trees are leaf-similar.
 * Two binary trees are considered leaf-similar if their leaf value sequences are the same.
 * S.C.-O(n+m) where,n is the no. of nodes in tree1  and m is the no of nodes in tree2
 * T.C.-O(h1+h2)height of tree1 h1 and tree2 h2
 */
public class Solution {
    /**
     * Definition for a binary tree node
     */
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

    /**
     * for both tree leaf nodes are stored in two string build and compare them later
     *
     * @param root1 is the root node of binary tree
     * @param root2 is the root node of another binary tree
     * @return boolean whether two trees have same leaf nodes or not
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return true;
        }
        StringBuilder leaves1 = new StringBuilder();
        getLeaf(root1, leaves1);
        StringBuilder leaves2 = new StringBuilder();
        getLeaf(root2, leaves2);
        return leaves1.toString().contentEquals(leaves2);

    }

    void getLeaf(TreeNode root, StringBuilder leaves) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaves.append(root.val).append("_");
        }
        getLeaf(root.left, leaves);
        getLeaf(root.right, leaves);
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        tree1.right = new TreeNode(1, new TreeNode(9), new TreeNode(8));

        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(5, new TreeNode(6), new TreeNode(7));
        tree2.right = new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(9), new TreeNode(8)));

        Solution solution = new Solution();
        System.out.println(solution.leafSimilar(tree1, tree2));

    }
}
