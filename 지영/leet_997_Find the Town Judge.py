class Solution(object):
    def findJudge(self, N, trust):
        """
        :type N: int
        :type trust: List[List[int]]
        :rtype: int
        """
        judge = dict()
        people = set()
        result = -1
        for a, b in trust:
            people.add(a)
            if judge.get(b, 0):
                judge[b] += 1
            else:
                judge[b] = 1
            if a in judge.keys():
                judge.pop(a)
        for key in judge:
            if judge[key] == N - 1 and key not in people:
                result = key
                break
        return result if N != 1 else 1