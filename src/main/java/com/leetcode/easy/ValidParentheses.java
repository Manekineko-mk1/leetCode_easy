package com.leetcode.easy;

import java.util.List;
import java.util.ArrayList;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

    Input: s = "()"
    Output: true

    Input: s = "()[]{}"
    Output: true

    Input: s = "(]"
    Output: false

    Input: s = "([)]"
    Output: false

    Input: s = "{[]}"
    Output: true
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        List<Character> queue = new ArrayList<Character>();


        for (int i = 0; i < s.length(); i++) {
            // Edge cases
            if (s.length() <= 1 || (s.length() % 2 != 0) || s == null) {
                return false;
            }
            
            Character currentSign = s.charAt(i);

            // if it's an opening sign, enqueue (add to the 'queue' arraylist)
            if (currentSign.equals('(') || currentSign.equals('[') || currentSign.equals('{'))
            {
                queue.add(currentSign);
            } else {
                // if it's not an opening sign then it's a closing sign
                // then
                //  1. get reciprocal sign
                //  2. check if the peek @ queue is the same as the recipical sign
                //      A. If yes, dequeue (remove the element at peek)
                //      B. If no, return false (inbalance parenthese)
                Character reciprocal = getReciprocalSign(currentSign);          
                Character peekAtQueue = queue.get(queue.size() - 1);

                if(peekAtQueue.equals(reciprocal)) {
                    queue.remove(queue.size() - 1);               
                } else {
                    return false;
                }
            }
        }

        return true;        
    }
    
    private Character getReciprocalSign (char c) {
        Character result;

        switch (c) {
            case ')':
                result = '(';
                break;
            case ']':
                result = '[';
                break;
            case '}':
                result = '{';
                break;
            default:
                result = null;
        }

		return result;     
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        
        String paraString1 = "()";
        Boolean paraTest1 = vp.isValid(paraString1);
        System.out.println("() | isValid? " + paraTest1);

        // String paraString2 = "()[]{}";   
        // Boolean paraTest2 = vp.isValid(paraString2);
        // System.out.println("()[]{} | isValid? " + paraTest2);

        // String paraString3 = "(]";
        // Boolean paraTest3 = vp.isValid(paraString3);
        // System.out.println("(] | isValid? " + paraTest3);

        // String paraString4 = "([)]";
        // Boolean paraTest4 = vp.isValid(paraString4);
        // System.out.println("([)] | isValid? " + paraTest4);

        // String paraString5 = "{[]}";
        // Boolean paraTest5 = vp.isValid(paraString5);
        // System.out.println("{[]} | isValid? " + paraTest5);
	}
}
