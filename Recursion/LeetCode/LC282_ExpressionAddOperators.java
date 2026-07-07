package Recursion.LeetCode;

/*
Problem: Expression Add Operators

Idea:
 - Use backtracking to generate all possible expressions by inserting operators between the digits of the input string.
 - Maintain a current expression and evaluate its value as we build it.
 - Handle operator precedence, especially for multiplication, by keeping track of the last operand used in the expression.

Technique Used: Backtracking

Time Complexity: O(4^n), where n is the length of the input string. 
                 In the worst case, we may explore all possible combinations of operators between the digits.
Space Complexity: O(n) for the recursion stack and the current expression string builder, 
                  plus O(k) for the result list where k is the number of valid expressions found.
*/

public class LC282_ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        
        if (num == null || num.length() == 0) return ans;
        solve(num, 0, current, 0, 0, target, ans);
        return ans;
    }

    private void solve(String num, int index, StringBuilder current, long currentValue, long lastOperand, int target, List<String> ans) {
        if (index == num.length()) {
            if (currentValue == target) {
                ans.add(current.toString());
            }
            return;
        }

        for(int end = index; end < num.length(); end++) {
            // Acquire the substring representing the current operand and parse it to a long value
            String operandString = num.substring(index, end + 1);
            long operand = Long.parseLong(operandString);

            // Handle leading zeros: if the current operand has more than one digit and starts with '0', 
            // we skip further processing for this operand to avoid invalid expressions.
            if (end > index && num.charAt(index) == '0') break;

            // Store the length of the current expression before adding a new operand and operator.
            int lenBefore = current.length();

            // If we are at the start of the expression (index == 0), we simply add the operand without any operator.
            if (index == 0) {
                current.append(operandString);
                solve(num, end + 1, current, operand, operand, target, ans);
                current.setLength(lenBefore);
            } 
            else {
                // For subsequent operands, we explore all three operators: '+', '-', and '*'.
                current.append("+").append(operandString);
                solve(num, end + 1, current, currentValue + operand, operand, target, ans);
                current.setLength(lenBefore);

                current.append("-").append(operandString);
                solve(num, end + 1, current, currentValue - operand, -operand, target, ans);
                current.setLength(lenBefore);

                current.append("*").append(operandString);
                solve(num, end + 1, current,
                      currentValue - lastOperand + lastOperand * operand,
                      lastOperand * operand, target, ans);
                current.setLength(lenBefore);
            }
        }
    }   
}