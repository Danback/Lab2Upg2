package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int Add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf("\n");
            String delimiterPart = numbers.substring(2, delimiterEnd);
            if (delimiterPart.startsWith("[")) {
                Matcher m = Pattern.compile("\\[(.*?)\\]").matcher(delimiterPart);
                List<String> delimiters = new ArrayList<>();
                while (m.find()) {
                    delimiters.add(Pattern.quote(m.group(1)));
                }
                delimiter = String.join("|", delimiters);
            } else {
                delimiter = Pattern.quote(delimiterPart);
            }
            numbers = numbers.substring(delimiterEnd + 1);
        }

        String[] nums = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
        for (String num : nums) {
            if (!num.trim().isEmpty()) {
                int number = Integer.parseInt(num.trim());
                if (number < 0) {
                    negatives.add(number);
                } else if (number <= 1000) {
                    sum += number;
                }
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives.toString().replaceAll("[\\[\\]]", ""));
        }

        return sum;
    }
}




