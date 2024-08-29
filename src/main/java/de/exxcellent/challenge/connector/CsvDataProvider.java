package de.exxcellent.challenge.connector;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import de.exxcellent.challenge.dtos.Dto;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CsvDataProvider<T extends Dto> implements DataProvider<T> {
    private final Class<T> type;

    public CsvDataProvider(Class<T> type) {
        this.type = type;
    }

    @Override
    public List<T> getAllEntries(InputStream resource) {
        try (CSVReader reader = new CSVReader(new InputStreamReader(resource))) {
            CsvToBean<T> parser = new CsvToBeanBuilder<T>(reader).withType(type).build();
            return parser.parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
