class Solution {
    public int findJudge(int N, int[][] trust) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer,Integer> citizen = new HashMap<Integer,Integer>();
        int key = 0;
        
        //  배열 길이 0이면 N 바로 리턴하기 
        if(trust.length==0){
            return N;
        }        
        
        for(int[] arr: trust){
            //  나중에 map에 있는데 citizen에서 지목하면 judge가 아니니까 그부분 처리로직
            citizen.put(arr[0],0);
            if(!map.containsKey(arr[1])){
                map.put(arr[1], 1);
                
            }else{
                int val = map.get(arr[1]);
                map.replace(arr[1], val, val+1);
            }
        }

        //  결과 찾기
        for(int result: map.keySet()){             
            int value = map.get(result);
            if(value == N-1 && !citizen.containsKey(result)){
                return result;
            }
        }
        return -1;
    }
}
