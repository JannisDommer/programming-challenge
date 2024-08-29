package de.exxcellent.challenge.services;

import de.exxcellent.challenge.dtos.WeatherDataDto;

import java.util.Comparator;
import java.util.List;

public class WeatherService {

    private WeatherService() {
        throw new IllegalStateException("Utility class");
    }

    public static WeatherDataDto findDayWithLowestTemperatureDifference(List<WeatherDataDto> weatherData) {
        return weatherData.stream()
                .min(Comparator.comparingInt(WeatherDataDto::getTempDifference))
                .orElseThrow(() -> new IllegalStateException("Unable to determine the day with the least temperature difference"));
    }
}
