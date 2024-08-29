package de.exxcellent.challenge.connector;

import de.exxcellent.challenge.dtos.Dto;
import java.util.List;

public interface DataProvider {
    public List<Dto> getAllEntries();
}
