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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //  1-1. 루드 null이면,   
				if(root == null ){
           return null;
        }        
        
        // 2. p,q  (이건 실행해보고 찾은 조건 ... 22)
      	//	다른 조건에서 문제가 되었을 듯  
      	if ((p.val == root.val) || (q.val == root.val)){
            return root;
        }
        
        //  LCA를 찾는 규칙
        //  두 노드 p와 q 사이에서 p와 q를 모두 후손으로 갖는 T에서 가장 낮은 노드로 정의됩니다 (여기서 노드는 자체의 자손이 될 수 있음).
				//	문제에서 LCA의 조건식으로 설명해 준 부분 구현        
        if(((p.val < root.val) && (q.val > root.val)) || ((q.val < root.val) && (p.val > root.val))){
            return root;
        }
        
      
        //  이진탐색 트리: 루트노드의 왼쪽 크기는 루트 노드보다 작고, 루트 노드의 오른쪽 크니는 루트 노드보다 크다
        //  bst의 특성을 이용하면 해결이 됨
        //	둘다 루트보다 값이 작으면, 왼쪽 서브트리 탐색 
      
      //	미리 root.left right 가 null인지 미리 체크해주는 것?
      
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        //	둘다 루트보다 값이 크면, 오른쪽 서브트리 탐색 
        else if(){
            return lowestCommonAncestor(root.right,p,q);
        }
        
    }
            
}
