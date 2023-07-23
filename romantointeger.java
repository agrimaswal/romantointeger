import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        // Create a mapping of Roman numeral symbols to their corresponding values
        Map<Character, Integer> romanToInteger = new HashMap<>();
        romanToInteger.put('I', 1);
        romanToInteger.put('V', 5);
        romanToInteger.put('X', 10);
        romanToInteger.put('L', 50);
        romanToInteger.put('C', 100);
        romanToInteger.put('D', 500);
        romanToInteger.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        // Traverse the Roman numeral string from left to right
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentSymbol = s.charAt(i);
            int currentValue = romanToInteger.get(currentSymbol);

            // Check if subtraction is required (e.g., IV, IX, XL, XC, CD, CM)
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }
}



