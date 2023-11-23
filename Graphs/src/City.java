public class City {
    private String name;
    private Connection[] neighbors;
    private int connectionCount;

    public City(String name) {
        this.name = name;
        neighbors = new Connection[10]; // Initial size of the connections array
        connectionCount = 0;
    }

    public void connect(City nextCity, int distance) {
        if (connectionCount == neighbors.length) {
            // If the connections array is full, resize it
            Connection[] newConnections = new Connection[neighbors.length * 2];
            System.arraycopy(neighbors, 0, newConnections, 0, neighbors.length);
            neighbors = newConnections;
        }

        neighbors[connectionCount] = new Connection(nextCity, distance);
        connectionCount++;
    }

    public String getName() {
        return name;
    }

    public Connection[] getNeighbor() {
        return neighbors;
    }
}
