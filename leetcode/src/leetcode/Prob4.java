package leetcode;

public class Prob4 {
	public static void main(String[] args) {
//		int[] nums1 = {1,3};
//		int[] nums2 = {2};
		
		int[] nums1 = {1,3};
		int[] nums2 = {2,4};
		MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
		System.out.println(m.findMedianSortedArrays(nums1, nums2));
	}
}

class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double result = 0;
		int size = nums1.length + nums2.length;
		int index = -1;
		index = size / 2;

		int count = 0;
		int i = 0;
		int j = 0;

		if (size % 2 == 1) { // odd
			int temp = -1;
			do {
				count++;
				if (i == nums1.length) {
					temp = nums2[j];
					j++;
				} else if (j == nums2.length) {
					temp = nums1[i];
					i++;
				} else if (nums1[i] >= nums2[j]) {
					temp = nums2[j];
					j++;
				} else {
					temp = nums1[i];
					i++;
				}
			} while (count != (size + 1) / 2);
			result = temp;
		} else { // even
			double temp1 = -1;
			double temp2 = -1;
			do {
				count++;
				if (i == nums1.length) {
					if(count == size/2) {
						temp1 = nums2[j];	
					}
					else if(count == size/2 + 1) {
						temp2 = nums2[j];
					}
					j++;
				} else if (j == nums2.length) {
					if(count == size/2) {
						temp1 = nums1[i];	
					}
					else if(count == size/2 + 1) {
						temp2 = nums1[i];
					}
					i++;
				} else if (nums1[i] >= nums2[j]) {
					if(count == size/2) {
						temp1 = nums2[j];	
					}
					else if(count == size/2 + 1) {
						temp2 = nums2[j];
					}
					j++;
				} else {
					if(count == size/2) {
						temp1 = nums1[i];	
					}
					else if(count == size/2 + 1) {
						temp2 = nums1[i];
					}
					i++;
				}
			} while (count != size/2 + 1);
			result = (temp1 + temp2) / 2;
		}

		return result;
	}
}
