package Graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public String name;
    public int index;
    public boolean isVisited = false;
    public GraphNode parent;
    List<GraphNode> neighbors = new ArrayList<>();

    GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }

}
