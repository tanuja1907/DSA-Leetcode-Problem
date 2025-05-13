package Problem_1_Binary_Tree_Preorder;

import java.util.ArrayList;
import java.util.List;

//S.C.-O(h)
//T.C.-O(n)
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

        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            preorder(root, result);
            return result;

        }

        void preorder(TreeNode root, List<Integer> result) {
            if (root == null) return;
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
        }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left= null;
        node.right=new TreeNode(2,null,new TreeNode(3));
        Solution solution=new Solution();
        List<Integer> result=solution.preorderTraversal(node);
        result.forEach(System.out::println);
    }
    }