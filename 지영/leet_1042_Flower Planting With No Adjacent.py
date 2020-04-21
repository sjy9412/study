class Solution(object):
    def gardenNoAdj(self, N, paths):
        """
        :type N: int
        :type paths: List[List[int]]
        :rtype: List[int]
        """
        garden = [[] for _ in range(N + 1)]
        for x, y in paths:
            garden[x].append(y)
            garden[y].append(x)
        answer = [0] * (N + 1)
        for i in range(1, N + 1):
            tmp = set()
            for j in garden[i]:
                tmp.add(answer[j])
            for k in range(1, 5):
                if k not in tmp:
                    answer[i] = k
                    break
        return answer[1:]