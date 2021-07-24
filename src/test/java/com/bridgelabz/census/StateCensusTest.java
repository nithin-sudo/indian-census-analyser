package com.bridgelabz.census;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class StateCensusTest {
    @Test
    public void givenNumberOfRecords_ChecksWhetherMatchesOrNot_() throws CSVUserException {
        CsvStateCensusService csvStateCensusService = new CsvStateCensusService("src/StateCensusData.csv");
        int checkNumberOfRecords = csvStateCensusService.checkNumberOfRecords();
        Assertions.assertEquals(37, checkNumberOfRecords);
    }
    @Test
    public void givenWrongFileName_ShouldThrowFileNotFoundException() {
        try {
            CsvStateCensusService csvStateCensusService = new CsvStateCensusService("src/StateCensusData.csv");
            int checkNumberOfRecords = csvStateCensusService.checkNumberOfRecords();
        } catch (CSVUserException e) {
            Assertions.assertEquals("Such type file doesn't exist", e.getMessage());
        }
    }
    @Test
    public void givenWrongFileType_ShouldThrowFileNotFoundException() {
        try {
            CsvStateCensusService csvStateCensusService = new CsvStateCensusService("src/Basic Programs.pdf");
            int checkNumberOfRecords = csvStateCensusService.checkNumberOfRecords();
        } catch (CSVUserException e) {
            Assertions.assertEquals("binding of file to failed", e.getMessage());
        }
    }
    @Test
    public void givenWrongDelimer_ShouldThrowRunTimeException() {
        try {
            CsvStateCensusService csvStateCensusService = new CsvStateCensusService("src/delimeter.csv");
            int checkNumberOfRecords = csvStateCensusService.checkNumberOfRecords();
        } catch (CSVUserException e) {
            Assertions.assertEquals("delimeter problem", e.getMessage());
        }
    }
    @Test
    public void givenWrongheaders_ShouldThrowRunTimeException() {
        try {
            CsvStateCensusService csvStateCensusService = new CsvStateCensusService("src/delimeter.csv");
            int checkNumberOfRecords = csvStateCensusService.checkNumberOfRecords();
        } catch (CSVUserException e) {
            e.printStackTrace();
            Assertions.assertEquals("delimeter problem or file type problem or header not found or binding data issue", e.getMessage());
        }
    }
}
