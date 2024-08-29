package de.exxcellent.challenge.connector;

import de.exxcellent.challenge.dtos.Dto;

import java.io.InputStream;
import java.util.List;

public interface DataProvider<T extends Dto> {
    public List<T> getAllEntries(InputStream resource);
}
