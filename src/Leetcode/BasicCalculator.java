package Leetcode;

import java.util.Stack;

/**
 * Created by vrajp on 4/26/2016.
 */
public class BasicCalculator {

    public static void main(String a[]) {
        BasicCalculator bc = new BasicCalculator();

        System.out.println(bc.calculateI("(1+(10+(5+2))-3"));
        System.out.println(bc.calculateII(" 3/2"));

    }

    public int calculateI(String s) {
        Stack<Integer> st = new Stack<>();

        int eval = 0;
        int sign = 1;

        for (int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);


            int digit = ch - '0';

            if (Character.isDigit(ch)) {
                int number = digit;

                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    ch = s.charAt(++i);
                    digit = ch - '0';
                    number = 10 * number + digit;
                }

                eval += (sign * number);
            } else if (ch == '+') {
               sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                st.push(sign);
                st.push(eval);
                eval = 0;
                sign = 1;
            } else if ( ch == ')') {
                eval = st.pop() + eval * st.pop();
            }
        }

        return eval;
    }
    public int calculateII(String s) {
        Stack<Integer> st = new Stack<>();
        int result = 0;
        char sign = '+';

        for (int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);

            if (ch == ' ')
                continue;

            if (Character.isDigit(ch)) {
                int d = ch - '0';

                int number = d;

                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    ch = s.charAt(++i);
                    d = ch - '0';
                    number = number * 10 + d;
                }

                switch (sign) {
                    case '+':
                        st.push(number);
                        break;
                    case '-':
                        st.push(-1 * number);
                        break;
                    case '*':
                        st.push(st.pop() * number);
                        break;
                    case '/':
                        st.push(st.pop() / number);
                        break;
                }
            } else {
                sign = ch;
            }
        }

        for (int val : st) {
            result += val;
        }

        return result;
    }

}
