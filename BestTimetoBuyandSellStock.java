/*
 * This is one of the first tricky/vague LeetCode questions.
 *
 * At first glance, you might think:
 * "I need to find the minimum price and the maximum price,
 * then calculate the maximum profit."
 *
 * But that's not exactly the problem.
 *
 * The important condition is:
 * You MUST buy before you sell.
 *
 * So we cannot simply find the global minimum and global maximum,
 * because the maximum price might occur before the minimum price.
 *
 * The main idea is to go through the array from left to right
 * and keep track of the minimum price seen so far.
 *
 * For every price:
 *
 *     1. Update the minimum buying price.
 *     2. Calculate the profit if we sell today:
 *
 *          profit = current price - minimum price
 *
 *     3. Keep track of the maximum profit found so far.
 *
 * This works because `min` always represents a price from the
 * current day or an earlier day, so we never buy after selling.
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = Math.min(min, prices[i]);
            }

            int tres = prices[i] - min;
            res = Math.max(res, tres);
        }

        return res;
    }
}

/*
 * Core pattern to remember:
 *
 *     Track minimum → calculate current profit → track maximum
 *
 *     min = cheapest price seen so far
 *     tres = today's price - min
 *     res = maximum profit seen so far
 */
