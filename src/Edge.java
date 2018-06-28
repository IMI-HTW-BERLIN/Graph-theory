class Edge<T> {
    private Vertex to;
    private int weight;

    Edge(Vertex to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    Vertex getTo() {
        return to;
    }

    int getWeight() {
        return weight;
    }

}
