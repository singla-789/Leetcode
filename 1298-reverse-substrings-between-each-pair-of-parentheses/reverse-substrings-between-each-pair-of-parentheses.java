class Solution {

    public String reverseParentheses(String s) {

        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder curr = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                // Save current string
                stack.push(curr);

                // Start fresh inside parentheses
                curr = new StringBuilder();

            } 
            else if (ch == ')') {

                // Reverse current part
                curr.reverse();

                // Append to previous string
                StringBuilder prev = stack.pop();
                prev.append(curr);

                curr = prev;

            } 
            else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}