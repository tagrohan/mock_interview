package GFG_random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GFG {
   public static void main(String[] args) {
      System.out.println(noOfDistinctPairsToSum(new int[]{1, 2, 1, 2}, 3));
   }

   private static int noOfDistinctPairsToSum(int[] arr, int sum) {
//      System.out.println(noOfDistinctPairsToSum(new int[]{1, 2, 1, 2}, 3));
      Arrays.sort(arr);
      int count = 0;
      int low = 0, high = arr.length - 1;
      while (low < high) {
         if (arr[low] + arr[high] > sum) {
            high -= 1;
         } else if (arr[low] + arr[high] < sum) {
            low += 1;
         } else {
            count += 1;
            low += 1;
            high -= 1;
         }
      }
      return count;
   }


   // leader is some who is greater to it's right
   private static List<Integer> findLeader(int[] arr) {

//        for (Integer i : findLeader(new int[] { 16, 17, 4, 3, 5, 2 })) {
//            System.out.print(i + " ");
//        }

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
