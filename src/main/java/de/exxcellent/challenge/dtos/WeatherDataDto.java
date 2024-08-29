package de.exxcellent.challenge.dtos;

import com.opencsv.bean.CsvBindByName;

/**
 * Data transfer object containing temperature information for a day
 */
public class WeatherDataDto extends Dto{
    @CsvBindByName(column = "Day")
    private int day;
    @CsvBindByName(column = "MnT")
    private int minTemp;
    @CsvBindByName(column = "MxT")
    private int maxTemp;

    // Empty constructor as per bean convention
    public WeatherDataDto() {

    }

    public WeatherDataDto(int day, int minTemp, int maxTemp) {
        this.day = day;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public int getDay() {
        return day;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getTempDifference() {
        return Math.abs(maxTemp - minTemp);
    }
}
