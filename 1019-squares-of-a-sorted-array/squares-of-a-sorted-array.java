import java.util.*;

class Solution {
    public int[] sortedSquares(int[] nums) {

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int sq = nums[i] * nums[i];
            arr.add(sq);
        }

        int[] result = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }

        Arrays.sort(result);
        return result;
    }
}