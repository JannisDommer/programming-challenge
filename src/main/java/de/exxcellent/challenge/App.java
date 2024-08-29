package de.exxcellent.challenge;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.MissingResourceException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     *
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        String weatherFilePath = "weather.csv";
        InputStream weatherStream = App.class.getResourceAsStream(weatherFilePath);

        if (weatherStream == null) {
            throw new MissingResourceException("Unable to load resource for weather challenge", App.class.getName(), weatherFilePath);
        }

        try (CSVReader reader = new CSVReader(new InputStreamReader(weatherStream))) {
            reader.readAll().forEach(System.out::println);

        } catch (CsvException | IOException e) {
            throw new RuntimeException(e);
        }


        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
