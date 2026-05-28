class Solution {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for(int i : nums) {
            set.add(i);
        }
        int longest_seq = 0;
        for(int i : nums) {
            if( i == -1000000000 || !set.contains(i - 1)) {
                longest_seq = getLength(nums, i, longest_seq, set);
            } 
        }
        return longest_seq;

    }

    private int getLength(int[] nums, int start, int longest, HashSet<Integer> set) {
        int count = 1;
        while(set.contains(start + 1)) {
            ++start;
            ++count;
        }

        return count > longest ? count : longest;
    }
}
