package de.exxcellent.challenge.dtos;

import com.opencsv.bean.CsvBindByName;

public class WeatherDataDto extends Dto{
    @CsvBindByName(column = "Day")
    private int day;
    @CsvBindByName(column = "MnT")
    private int minTemp;
    @CsvBindByName(column = "MxT")
    private int maxTemp;

    public int getDay() {
        return day;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }
}
