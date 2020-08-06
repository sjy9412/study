class Solution{
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
		//boolean flag = false;
		for (int i = 0; i < nums.length; i++) {
			for(int j = i+1; j< nums.length; j++) {
				if(nums[i]+ nums[j]  == target) {
					//flag = true;
					result[0] = i;
					result[1] = j; 
					return result;
				}
				
				// if(nums[i]+ nums[j] > target) {
				// 	break;
				// }
					
			}
//
		}
		throw new IllegalArgumentException("No two sum solution");
}	
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			//	와 target에서 빼고 남은 수가 map에 있으면 바로 리턴시키기
			if(map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement)};
			}	
		
		return nums;
		
		}
		
		throw new IllegalArgumentException("no answer");
	}


}