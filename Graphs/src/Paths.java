public class Paths {
    City[] path;
    int sp;

    public Paths() {
        this.path = new City[54];
        this.sp = 0;
    }

    public Integer shortest(City from, City to, Integer max) {
        if ((max != null) && (max < 0)) {
            return null;
        }
        if (from == to) {
            return 0;
        }
        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
                return null;
        }
        path[sp++] = from; // add the city we are in
        Integer shrt = null;
        for (int i = 0; i < from.getNeighbor().length; i++) {// all connecting cities for from
            if (from.getNeighbor()[i] != null) {
                Connection conn = from.getNeighbor()[i];
                Integer distance = shortest(conn.getDestinationCity(), to,
                        (max != null) ? max - conn.getDistance() : null);
                // Integer distance = shortest(conn.getConnectingCity(), to, max -
                // conn.getDistance());
                if ((distance != null) && ((shrt == null) || (shrt > distance + conn.getDistance())))
                    shrt = distance + conn.getDistance();
                // improvement
                if ((shrt != null) && ((max == null) || (max > shrt)))
                    max = shrt;

            }
        }
        path[sp--] = null;
        return shrt;
    }
    public static void main(String[] args) {
        Map map = new Map("C:\\Users\\46768\\Videos\\ID1021\\Assignment 9\\trains.csv");
        Paths paths = new Paths();

        testPath(map, paths, "Malmö", "Göteborg");
        testPath(map, paths, "Göteborg", "Stockholm");
        testPath(map, paths, "Malmö", "Stockholm");
        testPath(map, paths, "Stockholm", "Sundsvall");
        testPath(map, paths, "Stockholm", "Umeå");
        testPath(map, paths, "Göteborg", "Sundsvall");
        testPath(map, paths, "Sundsvall", "Umeå");
        testPath(map, paths, "Umeå", "Göteborg");
        testPath(map, paths, "Göteborg", "Umeå");
    }

    private static void testPath(Map map, Paths paths, String from, String to) {
        System.out.println("Testing path from " + from + " to " + to);
        Integer shortestPath = paths.shortest(map.lookup(from), map.lookup(to), null);
        if (shortestPath != null) {
            System.out.println("Shortest path from " + from + " to " + to + ": " + shortestPath + " min");
        } else {
            System.out.println("No path found from " + from + " to " + to + ".");
        }
    }
}