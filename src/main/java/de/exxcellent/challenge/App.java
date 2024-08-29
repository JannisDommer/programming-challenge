package de.exxcellent.challenge;

import de.exxcellent.challenge.connector.CsvDataProvider;
import de.exxcellent.challenge.dtos.FootballDataDto;
import de.exxcellent.challenge.dtos.WeatherDataDto;
import de.exxcellent.challenge.services.ComparatorService;

import java.io.InputStream;
import java.util.List;
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

        CsvDataProvider<WeatherDataDto> weatherDataProvider = new CsvDataProvider<>(WeatherDataDto.class);
        List<WeatherDataDto> weatherData = weatherDataProvider.getAllEntries(weatherStream);


        String footballPath = "football.csv";
        InputStream footballStream = App.class.getResourceAsStream(footballPath);

        if (footballStream == null) {
            throw new MissingResourceException("Unable to load resource for football challenge", App.class.getName(), footballPath);
        }

        CsvDataProvider<FootballDataDto> footballDataProvider = new CsvDataProvider<>(FootballDataDto.class);
        List<FootballDataDto> footballData = footballDataProvider.getAllEntries(footballStream);

        String dayWithSmallestTempSpread = String.valueOf(ComparatorService.findDayWithLowestTemperatureDifference(weatherData).getDay());
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = ComparatorService.findTeamWithSmallestGoalDistance(footballData).getTeam();
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
