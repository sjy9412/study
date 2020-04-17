# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 최소 공통 조상 : dp를 이용하여 같은 위치를 만들고, 동시에 부모로 이동
# 이진탐색 트리: 루트노드의 왼쪽 크기는 루트 노드보다 작고, 루트 노드의 오른쪽 크니는 루트 노드보다 크다
# 이진탐색 트리의 특성을 이용항여 문제 해결
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        while root:
            if root.val < p.val and root.val < q.val:
                root = root.right
            elif root.val > p.val and root.val > q.val:
                root = root.left
            else:
                return root

