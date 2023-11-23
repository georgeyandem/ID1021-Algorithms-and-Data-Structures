public class Connection {
    private City destinationCity;
    private int distance;

    public Connection(City destinationCity, int distance) {
        this.destinationCity = destinationCity;
        this.distance = distance;
    }

    public City getDestinationCity() {
        return destinationCity;
    }

    public int getDistance() {
        return distance;
    }
}