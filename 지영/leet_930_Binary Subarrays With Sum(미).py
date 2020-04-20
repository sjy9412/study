class Solution(object):
    def numSubarraysWithSum(self, A, S):
        """
        :type A: List[int]
        :type S: int
        :rtype: int
        """
        result = cnt = s = 0
        for i in range(0, len(A)):
            cnt += A[i]
            # cnt > S가 되면 1이 나올때까지 s값을 증가시키며 찾는다
            while cnt > S:
                cnt -= A[s]
                s += 1
            # i == s면 앞에 0일 경우가 없으니 result에 더해주고
            # 그 외에는 앞에 0인 경우가 있으니 1이 나올때까지 탐색하여 더하기
            if i == s and cnt == S:
                result += 1
            elif cnt == S:
                for j in range(s, i + 1):
                    result += 1
                    if A[j]:
                        break
        return result