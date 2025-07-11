import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate numbers
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right pointers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Triplets: " + threeSum(nums1)); // Expected: [[-1, -1, 2], [-1, 0, 1]]

        // Test Case 2
        int[] nums2 = {0, 1, 1};
        System.out.println("Triplets: " + threeSum(nums2)); // Expected: []

        // Test Case 3
        int[] nums3 = {0, 0, 0};
        System.out.println("Triplets: " + threeSum(nums3)); // Expected: [[0, 0, 0]]
    }
}
