package leetcode;

public class Prob1 {
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
//		int[] nums = { 3, 3 };
//		int target = 6;
		int[] result;
		TwoSum tssl = new TwoSum();
		result = tssl.twoSum(nums, target);
		System.out.println("result : " + result[0] + ", " + result[1]);
	}
}

class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i == j)
					continue;
				else {
					if (target - nums[i] == nums[j]) {
						result[0] = Math.min(i, j);
						result[1] = Math.max(i, j);
					}
				}
			}
		}
		return result;
	}
}