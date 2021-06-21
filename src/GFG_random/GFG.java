package GFG_random;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GFG {
    public static void main(String[] args) {
        for (Integer i : findLeader(new int[] { 16, 17, 4, 3, 5, 2 })) {
            System.out.print(i + " ");
        }
    }

    // leader is some who is greater to it's right
    private static List<Integer> findLeader(int[] arr) {
        int len = arr.length;
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            if (stack.isEmpty())
                list.add(arr[i]);
            stack.push(arr[i]);
        }
        return list;
    }

}
