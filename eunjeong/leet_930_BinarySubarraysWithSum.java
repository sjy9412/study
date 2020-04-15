class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int[] subsetCounts = new int[A.length+1];
        int answer = 0, sum = 0;
        
        //  0부터 시작인 경우를 고려
        subsetCounts[0] = 1;
        
        for(int i: A){
            sum += i;
            if(sum >= S){
                //  가능한 경우의 수를 더하는 과정
                //  sum-S: for-loop을 돌며 sum이 증가 그러므로 타겟으로 하는(S)만큼 전으로 돌아가서 해당 상태부터의 경우의수를 체크해야함
                answer += subsetCounts[sum - S];
            }
            // 이걸 하는이유는 1다음에 0이 오게되는 케이스 때문
            subsetCounts[sum]++;
        }
        
        return answer;
    }
}
