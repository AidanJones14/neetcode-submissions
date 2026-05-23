class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<Integer>();
            } 
            bucket[frequency].add(number);
        }
        int[] solution = new int[k];
        int check = 0;
        for(int j = nums.length; j >= 0; j--) {
            if(bucket[j] != null) {
                for(int num : bucket[j]) {
                    if(check < k) {
                        solution[check++] = num;
                    } else {
                        break;
                    }
                    
                }
            }
        } 
        return solution;
    }
}
