import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lookup = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (lookup.containsKey(target - nums[i])) {
                res = new int[] { lookup.get(target - nums[i]), i };
                break;
            } else {
                lookup.put(nums[i], i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sum = solution.twoSum(new int[]{1, 2, 3, 4, 8}, 9);
        System.out.println(Arrays.toString(sum));
        Solution2 solution2 = new Solution2();
        int[] sum1 = solution2.twoSum(new int[]{1, 2, 3, 4, 8}, 9);
        System.out.println(Arrays.toString(sum1));
    }
}

class Solution2{
    public int[] twoSum(int[] arr,int target){
        int[] res=new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (target == arr[j] + arr[i]){
                    res[0]=j;
                    res[1]=i;
                }
            }
        }
        return res;
    }
}