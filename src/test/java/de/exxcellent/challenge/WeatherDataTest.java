package de.exxcellent.challenge;

import de.exxcellent.challenge.connector.CsvDataProvider;
import de.exxcellent.challenge.dtos.WeatherDataDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.InputStream;
import java.util.List;

class WeatherDataTest {

    @Test
    void testSuccessfulParsingWeatherCsv() {
        CsvDataProvider<WeatherDataDto> dataProvider = new CsvDataProvider<>(WeatherDataDto.class);
        InputStream weatherData = WeatherDataTest.class.getResourceAsStream("weather.csv");
        List<WeatherDataDto> entries = dataProvider.getAllEntries(weatherData);
        Assertions.assertNotEquals(0, entries.size());
    }
}
