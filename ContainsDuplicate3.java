// Straightforward question:
// If the problem is about the difference between indices,
// think about a sliding window.
//
// We need to find two different indices i and j such that:
// 1. The index difference is <= indexDiff.
// 2. The value difference is <= valueDiff.
//
// The i != j condition is just a distraction here.
// Since j starts from i + 1, i and j are automatically different.
//
// Brute-force approach:
// - Pick an index i.
// - Check every index j within the allowed index difference.
// - If both the index difference and value difference conditions match,
//   we found our answer.
//
// Note: This approach is O(n²), so it works logically but is too slow
// for the maximum constraints. The next step is to optimize the sliding window, The optimized approach is Sliding Window + TreeSet, but that is for the next episode!
// stay tuned

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){

                if(Math.abs(i - j) <= indexDiff){
                    if(Math.abs(nums[i] - nums[j]) <= valueDiff){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
