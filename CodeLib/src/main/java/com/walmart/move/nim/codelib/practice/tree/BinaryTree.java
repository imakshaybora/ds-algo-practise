package com.walmart.move.nim.codelib.practice.tree;

//Java implementation to find lowest common ancestor of
// n1 and n2 using one traversal of binary tree


import java.util.Map;
import java.util.TreeMap;

import kotlin.Pair;

public class BinaryTree {
    //Root of the Binary Tree
    Node root;
    static int maxLevel = -1;

    Node findLCA(int n1, int n2) {
        return findLCA(root, n1, n2);
    }

    // This function returns pointer to LCA of two given
    // values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
    Node findLCA(Node node, int n1, int n2) {
        // Base case
        if (node == null)
            return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node.data == n1 || node.data == n2)
            return node;

        // Look for keys in left and right subtrees
        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
            return node;

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }

    static void leftViewBinaryTree(Node node) {

        // Starts with 0 level as that is start level of node
        leftViewBinaryTreeRecur(node, 0);
    }

    private static void leftViewBinaryTreeRecur(Node node, int level) {
        if (node == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.println(node.data);
            maxLevel = level;
        }

        leftViewBinaryTreeRecur(node.left, level + 1);
        leftViewBinaryTreeRecur(node.right, level + 1);
    }

    static void rightViewBinaryTree(Node node) {
        rightViewBinaryTreeRecur(node, 0);
    }

    private static void rightViewBinaryTreeRecur(Node node, int level) {
        if (node == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.println(node.data);
            maxLevel = level;
        }
        rightViewBinaryTreeRecur(node.right, level + 1);
        rightViewBinaryTreeRecur(node.left, level + 1);
    }

    static void topViewBinaryTree(Node node) {
        TreeMap<Integer, Pair<Node, Integer>> map = new TreeMap<Integer, Pair<Node, Integer>>();
        topViewBinaryTreeRecur(node, map, 0, 0);

        for (Map.Entry<Integer, Pair<Node, Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().getFirst().data);
        }
    }

    private static void topViewBinaryTreeRecur(Node node, Map<Integer, Pair<Node, Integer>> distLevelMap, int dist, int level) {
        if (node == null) {
            return;
        }
        Pair<Node, Integer> pair = distLevelMap.get(dist);
        if (pair == null || pair.getSecond() > level) {
            distLevelMap.put(dist, new Pair<>(node, level));
        }

        topViewBinaryTreeRecur(node.left, distLevelMap, dist - 1, level + 1);
        topViewBinaryTreeRecur(node.right, distLevelMap, dist + 1, level + 1);
    }

    static void bottomViewBinaryTree(Node node) {
        TreeMap<Integer, Pair<Node, Integer>> map = new TreeMap<Integer, Pair<Node, Integer>>();
        bottomViewBinaryTreeRecur(node, map, 0, 0);

        for (Map.Entry<Integer, Pair<Node, Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().getFirst().data);
        }
    }

    private static void bottomViewBinaryTreeRecur(Node node, Map<Integer, Pair<Node, Integer>> distLevelMap, int dist, int level) {
        if (node == null) {
            return;
        }
        Pair<Node, Integer> pair = distLevelMap.get(dist);
        if (pair == null || pair.getSecond() < level) {
            distLevelMap.put(dist, new Pair<>(node, level));
        }

        bottomViewBinaryTreeRecur(node.left, distLevelMap, dist - 1, level + 1);
        bottomViewBinaryTreeRecur(node.right, distLevelMap, dist + 1, level + 1);
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = " +
                tree.findLCA(4, 5).data);
        System.out.println("LCA(4, 6) = " +
                tree.findLCA(4, 6).data);
        System.out.println("LCA(3, 4) = " +
                tree.findLCA(3, 4).data);
        System.out.println("LCA(2, 4) = " +
                tree.findLCA(2, 4).data);
    }
}