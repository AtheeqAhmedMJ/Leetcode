// Recognize the pattern:
// If the problem involves finding duplicates or checking whether a value already exists,
// HashSet should be your go-to option.
//
// Here, we use a loop and a HashSet:
// - HashSet → stores the values we have already seen.
// - Loop → iterates through the array and checks for duplicates.
// If the current value already exists in the set, we found a duplicate.
//
// General HashSet/HashMap pattern:
// First check if the value already exists, then decide whether to add/update/remove it.

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            else{
                set.add(nums[i]);
            }
        }

        return false;
    }
}
