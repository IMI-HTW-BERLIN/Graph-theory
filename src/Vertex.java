import java.util.ArrayList;
import java.util.List;

public class Vertex<T> implements Comparable<Vertex>{
    private T data;
    private List<Edge<T>> edges;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Vertex<T> previous;

    Vertex(T data) {
        edges = new ArrayList<>();
        this.data = data;
    }
    
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

    boolean addEdge(Vertex<T> to, int weight) {
        if (!this.edgeExists(to)) {
            edges.add(new Edge<>(to, weight));
            return true;
        } else return false;
    }

    void addEdge(Vertex<T> to) {
        this.addEdge(to, 0);
    }

    T getData() {
        return data;
    }
    
    public List<Edge<T>> getEdges(){
    	return edges;
    }

    public String toString() {
        if (edges.size() == 0) return getData().toString();
        StringBuilder sb = new StringBuilder();
        sb.append(getData()).append("->");
        edges.forEach(e -> sb.append("[").append(e.getTo().getData()).append(":").append(e.getWeight()).append("]"));
        return sb.toString();
    }

    private boolean edgeExists(Vertex<T> vertex) {
        for (Edge edge : edges) {
            if (edge.getTo().equals(vertex)) return true;
        }
        return false;
    }
}
