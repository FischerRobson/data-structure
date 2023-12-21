import java.util.ArrayList;
import java.util.HashMap;

// Can be represented by an Adjacency Matrix or Adjacency List
public class Graph {
    private HashMap<String, ArrayList<String>> adjacencyList = new HashMap<>();

    public boolean addVertex(String vertex) {
        if (adjacencyList.get(vertex) == null) {
            adjacencyList.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }

    public boolean addEdges(String vertex1, String vertex2) {
        if (adjacencyList.get(vertex1) != null && adjacencyList.get(vertex2) != null) {
            adjacencyList.get(vertex1).add(vertex2);
            adjacencyList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdges(String vertex1, String vertex2) {
        if (adjacencyList.get(vertex1) != null && adjacencyList.get(vertex2) != null) {
            adjacencyList.get(vertex1).remove(vertex2);
            adjacencyList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        if (adjacencyList.get(vertex) != null) {
            ArrayList<String> adjacency = adjacencyList.get(vertex);
            for (String adj: adjacency) {
                adjacencyList.get(adj).remove(vertex);
            }
            adjacencyList.remove(vertex);
            return true;
        }
        return false;
    }

}
