package org.example;

public class StringCalculator {

    public static int Add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] nums = numbers.split(",");
        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num.trim());
        }
        return sum;
    }
}