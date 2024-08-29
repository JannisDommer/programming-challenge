package de.exxcellent.challenge;

import de.exxcellent.challenge.connector.CsvDataProvider;
import de.exxcellent.challenge.dtos.FootballDataDto;
import de.exxcellent.challenge.services.ComparatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

public class FootballDataTest {
    @Test
    void testSuccessfulParsingWeatherCsv() {
        CsvDataProvider<FootballDataDto> dataProvider = new CsvDataProvider<>(FootballDataDto.class);
        InputStream footballData = WeatherDataTest.class.getResourceAsStream("football.csv");
        List<FootballDataDto> entries = dataProvider.getAllEntries(footballData);
        Assertions.assertEquals(20, entries.size());
        // Check if entries are filled
        entries.forEach(entry -> Assertions.assertNotEquals("", entry.getTeam()));
    }

    @Test
    void testWeatherDataServiceLowestTempDifference() {
        FootballDataDto dto1 = new FootballDataDto("Team1", 42, 32);
        FootballDataDto dto2 = new FootballDataDto("Team2", 44, 32);
        FootballDataDto dto3 = new FootballDataDto("Team3", 44, 55);

        List<FootballDataDto> entries = List.of(dto1, dto2, dto3);

        FootballDataDto result = ComparatorService.findTeamWithSmallestGoalDistance(entries);

        Assertions.assertEquals("Team1", result.getTeam());
        Assertions.assertEquals(42, result.getGoals());
        Assertions.assertEquals(32, result.getGoalsAllowed());
        Assertions.assertEquals(10, result.getGoalDifference());
    }
}
