package com.symphony.practise1;

public class FindSecondLargestAndSmallest {
    static void main() {
        int[] nums = {12, 35, 1, 10, 34, 6};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : nums) {
            if (largest < num) {
                secondLargest = largest;
                largest = num;
            } else if (secondLargest < num) {
                secondLargest = num;
            }
        }

        for (int num : nums) {
            if (smallest > num) {
                secondSmallest = smallest;
                smallest = num;
            } else if (secondSmallest > num) {
                secondSmallest = num;
            }
        }

        System.out.println(secondLargest);
        System.out.println(secondSmallest);
    }
}
