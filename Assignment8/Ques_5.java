
import java.util.*;
class Graph {
    private int vertices;
    private ArrayList<ArrayList<Integer>> adj;

    public Graph(int vertices) {
        this.vertices = vertices;
        adj = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : adj.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        System.out.println();
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[vertices];

        System.out.print("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adj.get(vertex)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited);
            }
        }
    }


}

public class Ques_5 {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        graph.BFS(0);
        graph.DFS(0);
    }

}
