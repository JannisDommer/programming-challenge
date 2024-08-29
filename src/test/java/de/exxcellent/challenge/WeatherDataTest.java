package de.exxcellent.challenge;

import de.exxcellent.challenge.connector.CsvDataProvider;
import de.exxcellent.challenge.dtos.WeatherDataDto;
import de.exxcellent.challenge.services.WeatherService;
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
        Assertions.assertEquals(30, entries.size());
        // Check if entries are filled
        entries.forEach(entry -> Assertions.assertNotEquals(0, entry.getMaxTemp()));
    }

    @Test
    void testWeatherDataServiceLowestTempDifference() {
        WeatherDataDto dto1 = new WeatherDataDto(0, 40, 42);
        WeatherDataDto dto2 = new WeatherDataDto(5, 10, 80);
        WeatherDataDto dto3 = new WeatherDataDto(10, 71, 75);
        List<WeatherDataDto> entries = List.of(dto1, dto2, dto3);

        WeatherDataDto result = WeatherService.findDayWithLowestTemperatureDifference(entries);

        Assertions.assertEquals(40, result.getMinTemp());
        Assertions.assertEquals(42, result.getMaxTemp());
        Assertions.assertEquals(2, result.getTempDifference());
        Assertions.assertEquals(0, result.getDay());
    }
}
