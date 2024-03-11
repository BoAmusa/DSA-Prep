package Graphs;

import java.util.*;

public class GraphList {
    List<GraphNode> nodeList = new ArrayList<>();

    public GraphList(List<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    public String print() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j = 0; j < nodeList.get(i).neighbors.size(); j++) {
                if (j == nodeList.get(i).neighbors.size() - 1) {
                    s.append((nodeList.get(i).neighbors.get(j).name));
                } else {
                    s.append((nodeList.get(i).neighbors.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }


    public void BFS(GraphNode root) {
        if (root == null) return;

        Queue<GraphNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            GraphNode tempNode = que.poll();
            tempNode.isVisited = true;
            System.out.print(tempNode.name + " ");
            for (GraphNode children : tempNode.neighbors) {
                if (!children.isVisited) {
                    que.add(children);
                    children.isVisited = true;
                }

            }
        }

    }

    public void DFS(GraphNode root) {
        if (root == null) return;

        Stack<GraphNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            GraphNode tempNode = stack.pop();
            System.out.print(tempNode.name + " ");
            tempNode.isVisited = true;

            for (GraphNode children : tempNode.neighbors) {
                if (!children.isVisited) {
                    stack.push(children);
                    children.isVisited = true;
                }

            }
        }

    }

    public static void pathPrint(GraphNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }

        System.out.print(node.name + " ");
    }

    public void BFSForShortestPath(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.poll();
            currentNode.isVisited = true;
            System.out.print("Printing path for node " + currentNode.name + ": ");
            pathPrint(currentNode);
            System.out.println();
            for (GraphNode neighbor : currentNode.neighbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                    neighbor.parent = currentNode;
                }
            }
        }
    }
}
