import java.util.Stack;
import java.util.Scanner;

class ValidParenthesis{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        Boolean b = isValid(s);
        System.out.println(b);
    }

    static boolean isValid(String s) {
        
        // optimised code
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}'); 
            else if (c == '[') 
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();

        // Brute force
        // if (s.length() % 2 != 0) {
        //     return false;
        // }

        // Stack<Character> stack = new Stack<>();

        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
            
        //     if (c == ')' || c == '}' || c == ']') {
        //         if (stack.isEmpty()) {
        //             return false;
        //         }

        //         char top = stack.pop(); // Pop the top element to match with current closing bracket

        //         if ((c == ')' && top != '(') || 
        //             (c == '}' && top != '{') || 
        //             (c == ']' && top != '[')) {
        //             return false;
        //         }
        //     } 
        //     else if (c == '(' || c == '{' || c == '[') {
        //         stack.push(c);
        //     } 
        //     // else {
        //     //     continue;
        //     // }
        // }
        // return stack.isEmpty();

        // --------------------------------------------------------------------

        //using array
        // for (char c : s.toCharArray()) {
        //     if (c == '(') arr[++top] = ')';
        //     else if (c == '[') arr[++top] = ']';
        //     else if (c == '{') arr[++top] = '}';
        //     else if (top == -1 || arr[top--] != c) return false;
        // }
        // return top == -1;


    }
}

/*
class Solution {
    public boolean isValid(String s) {
        

        if(s.length() % 2 == 1){
            System.out.println("false");
        } 
        else{
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for( int j = 0 ; j < s.length() ; j ++ ){
                if(s.charAt(j) == '(') stack.push(')');
                else if (s.charAt(j) == '{') stack.push('}');
                else if (s.charAt(j) == '[') stack.push(']');
                else{
                    if(stack.pop() != s.charAt(j)){
                        flag = false;
                        break;
                    }
                }

            }
            if(flag) {
                    System.out.println("true");
                }
                else {
                    System.out.println("false");
                }
        }

        return 

    }
}

*/
