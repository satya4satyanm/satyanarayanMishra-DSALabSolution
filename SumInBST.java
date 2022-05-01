package com.gl.satya4satyanm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumInBST {
    // convert tree to list to find sum
    static List<Integer> ArrList = new ArrayList<>();

    // BST node
    static class Node {
        int key;
        com.gl.satya4satyanm.SumInBST.Node left, right;

        Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    static com.gl.satya4satyanm.SumInBST.Node insert(com.gl.satya4satyanm.SumInBST.Node root, int key) {
        com.gl.satya4satyanm.SumInBST.Node newnode = new com.gl.satya4satyanm.SumInBST.Node(key);
        com.gl.satya4satyanm.SumInBST.Node x = root;
        com.gl.satya4satyanm.SumInBST.Node current_parent = null;
        while (x != null) {
            current_parent = x;
            if (key < x.key) x = x.left;
            else if (key > x.key) x = x.right;
            else {
                System.out.println("Value already exists!!!");
                return newnode;
            }
        }
        // If the root is null, the tree is empty.
        if (current_parent == null) current_parent = newnode;
            // assign new node node to the left child
        else if (key < current_parent.key)
            current_parent.left = newnode;
            // assign the new node to the right child
        else current_parent.right = newnode;
        // return pointer to new node
        return current_parent;
    }

    static void Inorder(com.gl.satya4satyanm.SumInBST.Node root) {
        if (root == null) return;
        else {
            Inorder(root.left);
            System.out.print(root.key + " ");
            ArrList.add(root.key);
            Inorder(root.right);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int value;
        boolean status;
        com.gl.satya4satyanm.SumInBST.Node root = null;
        int[] arr = {40, 20, 60, 10, 30, 50, 70};
        for (int i = 0; i < arr.length; i++) {
            value = arr[i];
            if (root == null) {
                root = insert(root, value);
            } else {
                insert(root, value);
            }
        }

        Inorder(root);

        System.out.println();
        System.out.println("Enter Sum to find :");
        int target = sc.nextInt();

        int start = 0;
        int end = ArrList.size() - 1;
        while (start < end) {
            if (ArrList.get(start) + ArrList.get(end) == target)
            {
                System.out.println("Pair is (" + ArrList.get(start) + "," + ArrList.get(end) + ")");
                return;
            }
            if (ArrList.get(start) + ArrList.get(end) > target) end--;
            if (ArrList.get(start) + ArrList.get(end) < target) start++;
        }
        System.out.println("nodes are not found.");
        sc.close();
    }
}
