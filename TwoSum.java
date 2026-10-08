class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int keyval = 0;

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];

            if (map.containsKey(need)) {
                keyval = map.get(need);
                return new int[]{keyval, i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{0, 0};
    }
}

/*
 * Two Sum can be optimised from O(n²) to O(n) using a HashMap.
 *
 * General pattern:
 * If the problem asks you to find a pair, complement, or indices
 * that satisfy a condition, consider using a HashMap for fast lookup.
 *
 * HashMap provides O(1) average-time lookup.
 *
 * The map stores:
 *
 *     Key (number) → Value (index)
 *
 *     2  → 0
 *     7  → 1
 *     11 → 2
 *     15 → 3
 *
 * For every number, calculate the number we need:
 *
 *     need = target - nums[i]
 *
 * Then check whether `need` has already been seen in the HashMap.
 *
 * If it exists:
 *     map.get(need) → gives the index of the previous number
 *     i              → gives the current index
 *
 * So we return both indices.
 *
 * Example:
 *
 *     nums = [2, 7, 11, 15]
 *     target = 9
 *
 *     i = 0:
 *         nums[i] = 2
 *         need = 9 - 2 = 7
 *         7 not found → store 2 → 0
 *
 *     i = 1:
 *         nums[i] = 7
 *         need = 9 - 7 = 2
 *         2 found → map.get(2) = 0
 *
 *         return [0, 1]
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(n)
 *
 * Important:
 * We check the HashMap BEFORE inserting the current number.
 * This prevents using the same element twice.
 *
 * Also, don't use containsValue() here.
 * The number is the KEY, so we need containsKey().
 */
