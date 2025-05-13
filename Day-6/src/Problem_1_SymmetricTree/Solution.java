package Problem_1_SymmetricTree;


class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkSymmetry(root.left, root.right);
    }

    boolean checkSymmetry(TreeNode left, TreeNode right) {
        if (left == right) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val && checkSymmetry(left.left, right.right)
                && checkSymmetry(left.right, right.left));
    }

    public static void main(String[] args) {
        Solution sol=new Solution();
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2,new TreeNode(3),new TreeNode(4));
        treeNode.right=new TreeNode(2,new TreeNode(4),new TreeNode(3));
        boolean result=sol.isSymmetric(treeNode);
        System.out.println("Is tree symmetric? "+result);
    }
}