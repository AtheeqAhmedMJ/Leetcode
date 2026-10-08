// The question is asking us to find a duplicate number first,
// then find the difference between the indices of its occurrences
// and check whether that difference satisfies the given condition.
//
// HashMap is useful here because we need to store:
// number -> index
//
// When we see a number:
// 1. If it already exists, we have found a duplicate.
// 2. Get its previous index and check the index difference.
// 3. If the difference is <= k, we found the answer.
//
// We still update the index even when the duplicate is too far away.
// This is important because there can be multiple occurrences of the same number,
// and the latest occurrence is the closest one to any future occurrence.
//
// Example: [1, 2, 3, 1, 1]
// The first 1 is at index 0.
// When we see 1 at index 3, the difference is too large.
// So we update 1 -> 3.
// When we see 1 again at index 4, the difference is now 1, which may satisfy k.
//
// General HashMap pattern:
// Check if the key already exists -> use its stored information ->
// then update/store the current information.

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> maps = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            
            if(maps.containsKey(nums[i])){
                int j = maps.get(nums[i]);

                if(Math.abs(i - j) <= k){
                    return true;
                }
            }

            maps.put(nums[i], i);
        }

        return false;
    }
}
