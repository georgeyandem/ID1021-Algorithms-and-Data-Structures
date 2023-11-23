public class Naive {
    public static void main(String[] args) {
        Map map = new Map("C:\\Users\\46768\\Videos\\ID1021\\Assignment 9\\trains.csv");

        runBenchmark(map, "Malmö", "Göteborg", 400); // Adjust the max time as needed
        runBenchmark(map, "Göteborg", "Stockholm", 400);
        runBenchmark(map, "Malmö", "Stockholm", 400);
        runBenchmark(map, "Stockholm", "Sundsvall", 400);
        runBenchmark(map, "Stockholm", "Umeå", 400);
        runBenchmark(map, "Göteborg", "Sundsvall", 400);
        runBenchmark(map, "Sundsvall", "Umeå", 400);
        runBenchmark(map, "Umeå", "Göteborg", 400);
        runBenchmark(map, "Göteborg", "Umeå", 400);
    }


    private static void runBenchmark(Map map, String from, String to, int max) {
        long startTime = System.nanoTime();
        Integer shortestPath = shortest(map.lookup(from), map.lookup(to), max);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        if (shortestPath != null) {
            System.out.println("Shortest path from " + from + " to " + to + ": " + shortestPath + " min (" + elapsedTime + " ms)");
        } else {
            System.out.println("No path found from " + from + " to " + to + " within the specified max time.");
        } 
    }       

    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0) {
            return null;
        }
        if (from == to) {
            return 0;
        }
        Integer shrt = null;
        for (int i = 0; i < from.getNeighbor().length; i++) {
            Connection conn = from.getNeighbor()[i];
            if (conn != null) {
                Integer distance = shortest(conn.getDestinationCity(), to, max - conn.getDistance());
                if ((distance != null) && ((shrt == null) || (shrt > distance + conn.getDistance()))) {
                    shrt = distance + conn.getDistance();
                }
                if ((shrt != null) && (max > shrt)) {
                    max = shrt;
                }
            }
        }
        return shrt;
    }

}
