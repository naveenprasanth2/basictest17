package com.symphony.practise2;

import java.util.HashSet;
import java.util.Set;

public class SquareOfNumber {
    static void main() {
        Set<Integer> seen = new HashSet<>();
        int num = 23;
        int sum;
        int count = 0;
        while (num > 2) {
            sum = num;
            int temp = 0;
            while (sum > 0) {
                int rem = sum % 10;
                temp += (rem * rem);
                sum /= 10;
            }
            count++;
            num = temp;
            if (!seen.add(temp)) {
                System.out.println("This number is not an happy number");
                return;
            }
        }
        System.out.println(count);
    }
}
