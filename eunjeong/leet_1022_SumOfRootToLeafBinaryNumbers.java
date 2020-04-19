/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {  
    public int sumRootToLeaf(TreeNode root) {
        //  서브트리에 대해 sum을 구하는 과정 수행하기
        return getSum(root, 0);
    }
    
    private int getSum(TreeNode root, int sum) {
        //  가져온 앞자리수들에 대해 이진수니까 *2 그리고 거기에 이진수로 들어가는 수 더해주기(0or1)
        sum = (sum * 2) + root.val;
        
      	if (root.left == null && root.right == null){
            return sum;
        }
        //  왼쪽 오른쪽 서브트리에 대해 재귀적으로 sum을 구하게끔 dfs 수행
        int left = root.left == null ? 0 :getSum(root.left, sum);
        int right = root.right == null ? 0 :getSum(root.right, sum);
        return left + right;
    }
}
