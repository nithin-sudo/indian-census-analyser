package com.bridgelabz.census;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusTest {
    @Test
    public void givenNumberOfRecords_ChecksWhetherMatchesOrNot_() {
        CsvStateCensusService csvStateCensusService = new CsvStateCensusService();
        int checkNumberOfRecords = csvStateCensusService.checkNumberOfRecords();
        Assertions.assertEquals(37, checkNumberOfRecords);
    }
}
