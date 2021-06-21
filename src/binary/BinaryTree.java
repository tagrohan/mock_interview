package binary;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

   public static class Node {
      int data;
      Node left;
      Node right;

      public Node(int data, Node left, Node right) {
         this.data = data;
         this.left = left;
         this.right = right;
      }
   }

   public static void main(String[] args) {
//             1
      //     /    \
      //   2        7
      //    \      /  \
      //      3   5    6
      //    /           
      //   4            
// 1 2 3 4 5 6 7
      Node root = new Node(1,null,null);
      Node root2 = new Node(2,null,null);
      Node root3 = new Node(3,null,null);
      Node root4 = new Node(4,null,null);
      Node root5 = new Node(5,null,null);
      Node root6 = new Node(6,null,null);
      Node root7 = new Node(7,null,null);
      root.left = root2;
      root.right = root7;
      root2.right = root3;
      root3.left = root4;
      root7.left = root5;
      root7.right = root6;
      List<Integer> bound = getBoundries(root);
      for(Integer i : bound){
         System.out.print(i + " ");
      }
   }

   private static List<Integer> getBoundries(Node root) {
      List<Integer> boundries = new ArrayList<>(); // 1 2 3 4 5 9 6 7
      boundries.add(root.data); // 1
      getBoundriesLeftRight(root.left, true, boundries); // 2
      getLeafs(root, boundries);
      getBoundriesLeftRight(root.right, false, boundries);
     return boundries;
   }

   private static void getBoundriesLeftRight(Node root, boolean isLeft, List<Integer> list) {
      if (root == null) {
         return;
      }
      if (isLeft) {
         if (root.left != null || root.right != null)
            list.add(root.data); // 2 3
         if (root.left != null) {
            getBoundriesLeftRight(root.left, isLeft, list);
         } else if (root.right != null) {
            getBoundriesLeftRight(root.right, isLeft, list);
         }
      } else {
         if (root.right != null) {
            getBoundriesLeftRight(root.right, isLeft, list);
         } else if (root.left != null) {
            getBoundriesLeftRight(root.left, isLeft, list);
         }
         if (root.right != null || root.left != null)
            list.add(root.data);
      }
   }

   private static void getLeafs(Node root, List<Integer> list) {
      if (root == null) {
         return;
      }
      if (root.left == null && root.right == null) {
         list.add(root.data); // 4 5 6
      }
      getLeafs(root.left, list);
      getLeafs(root.right, list);
   }
}
