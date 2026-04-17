package Basic_MathLevel;

/*
Problem: 728. Self Dividing Numbers

Statement:
 - A self-dividing number is divisible by every digit it contains.
 - It cannot contain the digit 0.
 - Given two integers left and right, return all self-dividing numbers in [left, right].

Technique Used:
Digit iteration + divisibility check

Time Complexity: O(n * d)  (n = range size, d = digits per number)
Space Complexity: O(1) extra (excluding output list)
*/

public class SelfDividingNumber {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            if (isSelfDividing(num)) {
                result.add(num);
            }
        }
        return result;
    }

    private boolean isSelfDividing(int num) {
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || num % digit != 0) return false;
            temp /= 10;
        }
        return true;
    }
}