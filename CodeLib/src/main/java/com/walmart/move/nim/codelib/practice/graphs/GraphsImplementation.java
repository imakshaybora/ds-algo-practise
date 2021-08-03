package com.walmart.move.nim.codelib.practice.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphsImplementation {
    public HashMap<Integer, Node> nodeLookup = new HashMap<>();

    public void addEdge(int source, int destination) {

    }

    public Node getNode(int id) {
        return nodeLookup.get(id);
    }

    public boolean hasPathDFS(int source, int destination) {
        Node start = getNode(source);
        Node end = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(start, end, visited);
    }

    public boolean hasPathBFS(int source, int destination) {
        Node start = getNode(source);
        Node end = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        Queue<Node> nextToVisit = new LinkedList<>();
        nextToVisit.add(start);
        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();
            if (node == end) {
                return true;
            }
            if (visited.contains(node.id)) {
                continue;
            }

            visited.add(node.id);

            nextToVisit.addAll(node.adjacent);
        }
        return false;
    }


    public boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
        if (visited.contains(source.id)) {
            return false;
        }
        visited.add(source.id);
        if (source == destination) {
            return true;
        }
        for (Node childNode : source.adjacent) {
            if (hasPathDFS(childNode, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    public static class Node {
        int id;
        List<Node> adjacent = new LinkedList<>();

        public Node(int id) {
            this.id = id;
        }
    }
}

