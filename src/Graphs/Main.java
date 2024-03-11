package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        nodeList.add(new GraphNode("F", 5));
        nodeList.add(new GraphNode("G", 6));

        GraphList newGraphList = new GraphList(nodeList);
        newGraphList.addUndirectedEdge(0, 1);
        newGraphList.addUndirectedEdge(0, 2);
        newGraphList.addUndirectedEdge(1, 3);
        newGraphList.addUndirectedEdge(1, 6);
        newGraphList.addUndirectedEdge(2, 3);
        newGraphList.addUndirectedEdge(2, 4);
        newGraphList.addUndirectedEdge(3, 5);
        newGraphList.addUndirectedEdge(4, 5);
        newGraphList.addUndirectedEdge(5, 6);
        newGraphList.BFSForShortestPath(nodeList.get(0));


    }

    public static void buildAdjMatrix() {
        List<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        GraphMatrix g = new GraphMatrix(nodeList);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 4);

        g.bfs();
    }

    public static void buildAdjList() {
        List<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        GraphList g = new GraphList(nodeList);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 4);
    }
}
