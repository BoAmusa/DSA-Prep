package CodingPrac;

import java.util.ArrayList;
import java.util.List;

public class GraphProblems {

    public GraphProblems() {
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> results = new ArrayList<>();
        boolean[] visited = new boolean[tickets.size()];

        if (tickets == null) {
            return results;
        }

        DFS(results, tickets, 0, visited);

        return results;
    }

    private void DFS(List<String> results, List<List<String>> tickets, int index, boolean[] visited) {
        if (tickets.get(index) == null) return;
        List<String> currList = tickets.get(index);
        visited[index] = true;
        for (int i = 0; i < currList.size(); i++) {
            String edge = currList.get(i);
            System.out.println("Edge " + edge);
            if (!visited[i]) {
                DFS(results, tickets, index++, visited);
            }
            results.add(edge);
            tickets.remove(i);
        }


    }

}
