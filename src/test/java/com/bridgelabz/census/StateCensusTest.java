package com.bridgelabz.census;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusTest {
    @Test
    public void givenNumberOfRecords_ChecksWhetherMatchesOrNot_() throws CSVUserException {
        CsvStateCensusService csvStateCensusService = new CsvStateCensusService("/IdeaProjects/Indian-Census-Analyser/src/main/resources/StateCensusData.csv");
        int checkNumberOfRecords = csvStateCensusService.checkNumberOfRecords();
        Assertions.assertEquals(37, checkNumberOfRecords);
    }
    @Test
    public void givenWrongFileName_ShouldThrowFileNotFoundException() {
        try {
            CsvStateCensusService csvStateCensusService = new CsvStateCensusService("/IdeaProjects/Indian-Census-Analyser/src/main/resources/StateCensusData.csv");
            int checkNumberOfRecords = csvStateCensusService.checkNumberOfRecords();
        } catch (CSVUserException e) {
            Assertions.assertEquals("Such type file doesn't exist", e.getMessage());
        }
    }
    @Test
    public void givenWrongFileType_ShouldThrowFileNotFoundException() {
        try {
            CsvStateCensusService csvStateCensusService = new CsvStateCensusService("/IdeaProjects/Indian-Census-Analyser/src/main/resources/Basic Programs.pdf");
            int checkNumberOfRecords = csvStateCensusService.checkNumberOfRecords();
        } catch (CSVUserException e) {
            Assertions.assertEquals("binding of file to failed", e.getMessage());
        }
    }
}
