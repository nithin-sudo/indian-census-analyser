package com.bridgelabz.census;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class CsvStateCensusService
{
    String STATE_CODE_CSV_FILE_PATH ;
    public CsvStateCensusService(String STATE_CODE_CSV_FILE_PATH) {
        this.STATE_CODE_CSV_FILE_PATH = STATE_CODE_CSV_FILE_PATH;
    }
    int count = 0;
    /**
     * checking number of records.
     * @return
     * @throws CSVUserException
     */
    public int checkNumberOfRecords() throws CSVUserException {
        try {
                Reader reader = Files.newBufferedReader(Paths.get(STATE_CODE_CSV_FILE_PATH));
            CsvToBean<StateCodeCsvUSer> csvToBean = new CsvToBeanBuilder(reader).withType(StateCensusAnalyser.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<StateCodeCsvUSer> stateCodeCSVUserIterator = csvToBean.iterator();
            while (stateCodeCSVUserIterator.hasNext()) {
                StateCodeCsvUSer stateCodeCSV = stateCodeCSVUserIterator.next();
                System.out.println("SrNo : " + stateCodeCSV.getSrNo());
                System.out.println("State : " + stateCodeCSV.getStateName());
                System.out.println("Name : " + stateCodeCSV.getTIN());
                System.out.println("TIN : " + stateCodeCSV.getStateCode());
                count += 1;
            }
        }
        catch (NoSuchFileException e) {
            throw new CSVUserException(CSVUserException.ExceptionType.FILE_NOT_FOUND, "Such type file doesn't exist", e.getCause());
        }
        catch (RuntimeException e){
            throw new CSVUserException(CSVUserException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME,"binding of file to failed",e.getCause());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) throws CSVUserException {
        CsvStateCensusService csvStateCensusService = new CsvStateCensusService("src/StateCode.csv");
        csvStateCensusService.checkNumberOfRecords();
    }
}
