import java.io.BufferedReader;
import java.io.FileInputStream;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Map {
    private City[] cities;
    private final int mod = 541;

     public Map(String file) {
        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                City city = lookup(row[0]);
                City neighboringCity = lookup(row[1]);
                Integer distance = Integer.valueOf(row[2]);
                city.connect(neighboringCity, distance);
                neighboringCity.connect(city, distance);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public City lookup(String cityName) {
        int hash = hash(cityName);
        int index = hash % mod;

        // Handle collisions by linear probing
        while (cities[index] != null) {
            if (cities[index].getName().equals(cityName)) {
                return cities[index];
            }
            index = (index + 1) % mod;
        }

        City newCity = new City(cityName);
        cities[index] = newCity;
        return newCity;
    }

    private int hash(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }
}
