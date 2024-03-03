package CodingPrac;

import java.util.ArrayList;
import java.util.List;

public class ItineraryFinder {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> results = new ArrayList<>();
        boolean[] visited = new boolean[tickets.size()];

        if (tickets == null || tickets.isEmpty()) {
            return results;
        }

        // Sort tickets lexicographically
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));

        DFS(results, tickets, tickets.get(0).get(0), visited);

        return results;
    }

    private void DFS(List<String> results, List<List<String>> tickets, String source, boolean[] visited) {
        for (int i = 0; i < tickets.size(); i++) {
            if (!visited[i] && tickets.get(i).get(0).equals(source)) {
                visited[i] = true;
                String destination = tickets.get(i).get(1);
                DFS(results, tickets, destination, visited);
                results.add(0, destination); // Add the destination to the front of the list
            }
        }
    }
}