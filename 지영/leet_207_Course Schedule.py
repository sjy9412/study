class Solution(object):
    def dfs(self, i):
        for j in range(len(node[i])):
            if visit[node[i][j]]:
                result.append(0)
                return 
            else:
                if chk[node[i][j]]:
                    continue
                chk[node[i][j]] = 1
                visit[node[i][j]] = 1
                self.dfs(node[i][j])
                visit[node[i][j]] = 0
        return 
            
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        global node, visit, result, chk
        node = [[] for _ in range(numCourses)]
        result = []
        chk = [0] * numCourses
        for course in prerequisites:
            x, y = course
            node[y].append(x)
        for i in range(numCourses):
            visit = [0] * numCourses
            visit[i] = 1
            self.dfs(i)
            if result:
                break
            else:
                chk[i] = 1
        return True if not result else False
        