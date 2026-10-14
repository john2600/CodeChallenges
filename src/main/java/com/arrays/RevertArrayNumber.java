package com.arrays;

public class RevertArrayNumber {

    // this is the algorithm that reverses the input array (nums)
    public int[] solve(int[] nums) {

        int i = 0;
        int e = nums.length - 1;
        while (i < e) {
            int temp = nums[i];
            nums[i] = nums[e];
            nums[e] = temp;
            i++;
            e--;
        }

        return nums;
    }

    public static void main(String[] args) {
        RevertArrayNumber revertArrayNumber = new RevertArrayNumber();
        int[] nums = {1, 2, 3, 4, 5};
        int[] reversed = revertArrayNumber.solve(nums);
        System.out.print("Reversed array: ");
        for (int num : reversed) {
            System.out.print(num + " ");
        }
    }
}
