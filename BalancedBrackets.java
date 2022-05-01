package com.gl.satya4satyanm;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedBrackets {

    static String testBalancedBrackets(String str) {

        String CURLY_START = "{";
        String CURLY_END = "}";
        String SQUARE_START = "[";
        String SQUARE_END = "]";
        String CIRCLE_START = "(";
        String CIRCLE_END = ")";

        List<String> arr = Arrays.asList(str.split(" "));

        Stack charStack = new Stack<String>();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(CURLY_START) ||
                    arr.get(i).equals(SQUARE_START) ||
                    arr.get(i).equals(CIRCLE_START)
            ) {
                charStack.add(arr.get(i));
            } else if (
                    charStack.size() > 0 &&
                            ((arr.get(i).equals(CURLY_END) && charStack.peek().equals(CURLY_START)) ||
                                    (arr.get(i).equals(SQUARE_END) && charStack.peek().equals(SQUARE_START)) ||
                                    (arr.get(i).equals(CIRCLE_END) && charStack.peek().equals(CIRCLE_START)))
            ) {
                charStack.pop();
            } else if (i == 0) {
                charStack.add(arr.get(i));
            } else {
                charStack.add(arr.get(i));
            }
        }
        // System.out.println("character stack contains: " + charStack);
        if (charStack.size() == 0)
            return "The entered String has Balanced Brackets";
        return "The entered Strings do not contain Balanced Brackets";
    }

    public static void main(String[] args) {
        System.out.println(testBalancedBrackets("( [ [ { } ] ] )"));
        System.out.println(testBalancedBrackets("( [ [ { } ] ] ) )"));
    }
}
