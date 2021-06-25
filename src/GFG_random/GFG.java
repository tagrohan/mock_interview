package GFG_random;

import java.util.*;

public class GFG {
   public static void main(String[] args) {
//      System.out.println(cSwapping(new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000}));
      System.out.println(cSwapping(new int[]{7, 8, 1, 1, 4, 9, 9, 6, 8, 2, 4, 1, 1, 9, 5, 5, 5, 3, 6, 4}));
      System.out.println(cSwapping(new int[]{1, 7, 1}));

   }

   // https://atcoder.jp/contests/abc206/tasks/abc206_c
   private static int cSwapping(int[] arr) {
      int count = 0;
      Arrays.sort(arr); // O(NLogN)
      System.out.println(Arrays.toString(arr));
      int n = 0;
      for (int i = 0; i < arr.length - 1; i++) {
         if (arr[i] != arr[i + 1]) {
            n += 1;
         }
      }
      n += 1;
      count = n * (n - 1) / 2;
      return count;
   }

   private static int noOfPairToCertainConditionV2(int[] arr) {
//      System.out.println(noOfPairToCertainConditionV2(new int[]{199, 100, 200, 400, 300, 500, 600, 200}));
      Map<Integer, Integer> map = new HashMap<>();
      int count = 0;
      for (int i = 0; i < arr.length; i++) {
         int val = arr[i] % 200;
         if (map.containsKey(val)) {
            count += map.get(val);
            map.put(val, map.get(val) + 1);
         } else {
            map.put(val, 1);
         }
      }
      return count;
   }


   // condition = A[i] - A[j] is multiple of 200 (look like pair sum)
   private static int noOfPairToCertainCondition(int[] arr) {
      Map<Integer, Integer> map = new HashMap<>();
      int count = 0;
      for (int i = 0; i < arr.length - 1; i++) {
         for (int j = i + 1; j < arr.length; j++) {
            if ((arr[i] - arr[j]) % 200 == 0) {
               map.put(i + 1, j + 1);
               count += 1;
            }
         }
      }
      for (int i : map.keySet()) {
         System.out.println(i + " " + map.get(i));
      }
      return count;
   }


   // using hashset in single traversal works fine here
   private static int noOfDistinctPairsToSumV2(int[] arr, int sum) { // work on most cases bit its good to go for V3 approach
//      System.out.println(noOfDistinctPairsToSumV2(new int[]{1, 5, 7, -1}, 6));
      Map<Integer, Integer> map = new HashMap<>();
      int count = 0;
      for (Integer i : arr) {
         if (map.containsKey(sum - i)) {
            if (map.get(sum - i) > 0) {
               count += 1;
               map.put(sum - i, map.get(sum - i) - 1);
            } else map.put(sum - i, 1);
         } else if (map.containsKey(i)) map.put(i, map.get(i) + 1);
         else map.put(i, 1);
      }
      return count;
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
