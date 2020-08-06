/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
            //  둘다 null 
            if(p == null && q == null){
                return true;
            }
                
            //  null이 들어올 때 케이스를 찾지 못하는 경우가 발생
            if((p== null && q!=null) || (p!=null && q==null)){
                return false;
            }     
        
            if(p.val != q.val){
              return false;
            }
        
            return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        }
    }

    }
}